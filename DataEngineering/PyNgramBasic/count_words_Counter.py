from collections import Counter
## Lets count some words
## Using a very famous poem from Lewis Carol's "Through the looking glass"

#Now put it all together with a more functional (at least pythonic) method
#Making use of a list comprehension & Counter

STOP = ["the", "and", "in", "to", "a", "of", "at", "it", "but", "its",  
    "it's", "that", "was", "with", "as", "are", "i", "this", "for", "if"]

word_bag = Counter([token.lower() for token in 
  open("jabberwocky.txt", "r").read().split()
  if token.lower() not in STOP])

#Still get totals the same way
total = sum(word_bag.values())

print("Total words - minus stop words = {}".format(total))
for word, freq in word_bag.most_common(10):
  print("'{}' occured {} times or {:.2f} percent".format(
    word,freq,(freq/total)*100))
