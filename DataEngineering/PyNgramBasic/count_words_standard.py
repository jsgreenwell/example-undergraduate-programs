from collections import defaultdict
from operator import itemgetter
'''
Lets count some words
Using a very famous poem from Lewis Carol's "Through the looking glass"

This will use the method from last week and then print out some counts
add all the words to a single default dictionary (the first & standard algo).

These are also the first steps towards MapReduce - so keep them in mind as we
move to that.
'''

word_counts = defaultdict(int)

## STOP words are words we do not want to count
STOP = ["the", "and", "in", "to", "a", "of", "at", "it", "but", "its",  
    "it's", "that", "was", "with", "as", "are", "i", "this", "for", "if"]

#So open a file (with opens then closes when finished)
#read loads the line as string, split defaults on all whitespace
#if the token is not in the STOP words then add one to counter
with open("jabberwocky.txt") as f:
  for token in f.read().split():
    if token.lower() not in STOP:
      word_counts[token.lower()] += 1

#Lets also get the total counts (by using sum on dict values)
total = sum(word_counts.values())

#AND then sort same as last time
#Also this will switch our dictionary to a tuple of sets
word_counts = sorted(word_counts.items(),
    key=itemgetter(1), 
    reverse=True)

#now lets just print off the top 10 and a few values
print(word_counts[:10])
print("Total words - minus stop words = {}".format(total))
for word, freq in word_counts[:10]:
  print("'{}' occured {} times or {:.2f} percent".format(
    word,freq,(freq/total)*100))
