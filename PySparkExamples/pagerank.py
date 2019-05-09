#from __future__ import print_function #uncomment if python 2
import re
import sys
from operator import add
from pyspark.sql import SparkSession

"""
Example program for implementing the PageRank algorithm using pyspark.
Call program: pagerank.py <text file> <# interations>
"""

# The following is a generator (way out of scope for this class)
# Generators return individual results on the fly instead of storing in mem
# More correctly: they are a function that acts like an interable
def compContrib(urls, rank):
    #compute the contributions of urls to rank of other urls
    total_urls = len(urls)
    for u in urls:
        #yield "returns" the current value of the generator
        yield (u, rank / total_urls)


def parseNeighbors(n_urls):
    #Split url pairs into url and neighbor
    piece = n_urls.split(",")
    return piece[0], piece[1]

""" 
Main Program: 
sys.argv are the passed arguments - this is a fairly common call
method if Spark is ran from the command line or through a pipe
"""

if len(sys.argv) != 3:
# Not enough arguments - exit with error
  print("Usage: pagerank.py <text file> <# interations>", file=sys.stderr)
  exit(-1)

#sys.argv[0] is the name of the program
url_file = sys.argv[1]
try:
  inter = int(sys.argv[2])
except:
  print("# interations must be an integer", file=sys.stderr)
  print("Usage: pagerank.py <text file> <# interations>", file=sys.stderr)
  exit(-1)

session = SparkSession \
        .builder \
        .appName("PythonPageRank") \
        .getOrCreate()

# Loads input file into rdd
lines = session.read.text(url_file).rdd.map(lambda x: x[0])

# Load urls and initiate neighbors - would assign to tuple (url, (url1,...,urlN)
links = lines.map(lambda us: parseNeighbors(us)).distinct().groupByKey().cache()

# Set url ranks to 1 as float (cause if we have one the count is at least 1)
# Need float for percents (and makes this backwards compatable with Py2)
ranks = links.map(lambda u_neighbor: (u_neighbor[0], 1.0))

"""
This would be the main loop that:
Computes & updates the ranks repeatedly based on Larry Page's PageRank
  links.join would give a tuple (cur_link, (neighbor links, rank))
  Algo calculates url contributions of cur_rank to its neighbors then
    re-calcs that rank based on neighbors contribution to it
"""
for i in range(inter):
  contributes = links.join(ranks).flatMap(lambda (link, (neighbors, rank)):
      compContribs(neighbors, rank))

  #Note use of add operator for our reduce
  ranks = contributes.reduceByKey(add).mapValues(lambda r: r * .85 + .15)

for (l, r) in ranks.collect():
  print("{} has a rank of {}".format(l, r))

session.stop()
