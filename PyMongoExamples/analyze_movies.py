from pymongo import MongoClient
from collections import Counter
import os
import json

"""
One more BOW - This time using mongoDB.
See commands used to see how it was run.

Will load our collection, run through the documents (tables),  find the
critics consensue & title from the movies (provided by an old dataset 
from IMDB), then....well that's the question I ask students: What does
the rest of this code do?
"""

STOP = [word for word in open("stopwords.txt").read().split()]
client = MongoClient("mongodb://localhost:27017/")
db = client['reviews']
unfiltered = ""

collections = db.list_collection_names()

for document in collections:
  # find is similar as: SELECT critics_consensus, title FROM movies.page[1..n];
  for s in db[document].find({}, {"_id": 0, "critics_consensus": 1, "title": 1}):
    try:
      unfiltered += s["critics_consensus"]
      # Will fail on the very few empty ones
      ###and we just want to continue on those anyway
      # If there were more failures expected - use if/else
    except:
      continue

word_bag = Counter(
  filter(lambda word: word.lower()
    not in STOP,
  unfiltered.split()
  )
)

total = sum(word_bag.values())
print("Total words - minus stop words = {}".format(total))
for word, freq in word_bag.most_common(10):
  print("'{}' occured {} times or {:.2f} percent".format(
    word,freq,(freq/total)*100))
