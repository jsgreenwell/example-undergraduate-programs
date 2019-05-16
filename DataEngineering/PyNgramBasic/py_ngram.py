"""
This will create an ngram application using standard python and libraries.
Start with same program from last week but we'll change the text up a bit.
Adding a more functional example (or at least an example of functional tools).
Using a very famous poem from Lewis Carol's "Through the looking glass"
"""
from nltk.corpus import stopwords
from collections import Counter
from itertools import chain

def get_m_2_ngrams(input_list):
    for s in chain(*[get_ngrams(input_list, k) for k in range(2, 3)]):
        yield ' '.join(s)

def get_ngrams(input_list, n):
    return zip(*[input_list[i:] for i in range(n)])

word_bag = [token.lower() for token in 
  open("jabberwocky.txt", "r").read().split()
  if token.lower() not in stopwords.words("english")]

ngram = Counter([s for s in get_m_2_ngrams(word_bag)])

print(ngram.most_common(10))
