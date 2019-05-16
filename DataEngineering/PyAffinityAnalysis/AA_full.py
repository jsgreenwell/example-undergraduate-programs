from numpy import array
from collections import defaultdict
from operator import itemgetter

'''
This is just focused on the Affinity Analysis algo - so we will assume the 
array was given to you from a Graph DB (we'll look at using Python for that
at a later date). See the "for loop explained" powerpoint for an explaination
of that portion of code.

This will be the first and basic form of the algorithm. We will improve on it
in class as we cover more advance concepts in functional programming & data 
analytic algorithms.
'''


def print_rule(premise, conclusion, support, confidence, features):
  '''
  Print function for displaying our results
  '''
  premise_name = features[premise] #so if 0 = football, 1 = ...
  conclusion_name = features[conclusion]
  print("rule: if someone likes {} they will also like {}".format(premise_name, conclusion_name))
  print("confidence: {0:.3f} : idx {1} vs. idx {2}".format(
    confidence[(premise, conclusion)], premise, conclusion))
  print("support:{}".format(support[(premise, conclusion)]))
 
'''
Using your personal graph (that we made last week): 
We started by querying to see if a person that liked your favorite hobby 
also liked your 2nd favorite hobby. I used my own with Soccer & Video Games.

Now we will build a ML program that determines each premise based on our 
features and calculates the confidence.
'''
# Start by building our data (given from graph on online portion)
###fyi, capital X as in quantity, fans is a counter, and rules we'll see

X = array([
  [1,1,1,-1,1],
  [1,0,0,1,-1],
  [-1,1,1,1,-1],
  [1,0,0,1,-1],
  [1,0,0,0,1],
  [1,-1,1,0,0],
  [1,0,0,1,1],
  [1,1,-1,-1,1],
  [0,1,0,0,-1],
  [0,0,0,1,-1],
  [1,0,0,1,1],
  [1,1,1,-1,1],
  [1,1,1,-1,1],
  [1,1,1,-1,1],
  [1,1,1,-1,1],
  [1,1,-1,-1,1],
  [1,0,0,1,-1],
  [0,1,0,0,-1],
  [0,1,0,0,-1],
  [1,-1,1,0,0],
  [0,1,0,0,-1],
  [0,1,0,0,-1],
  [0,1,0,0,-1],
  [0,1,0,0,-1],
  [0,1,0,0,-1],
  [0,1,0,0,-1],
  [-1,1,1,1,-1],
  [1,1,1,-1,1],
  [1,1,1,-1,1],
  [1,1,-1,-1,1],
  [1,1,-1,-1,1],
  [1,0,0,1,-1],
  [1,1,-1,-1,1],
  [1,1,-1,-1,1],
  [1,1,-1,-1,1],
  [1,0,0,1,-1],
  [0,0,0,0,0],
  [1,1,-1,-1,1],
  [1,1,1,-1,1],
  [1,1,1,-1,1],
  [0,1,0,0,-1],
  [1,1,1,-1,1]
])

features = ["football", "reading", "chess", "sketching", "video games"]
n_features = len(features) 
#our headers and a variable for the length of that list of features

valid_rules = defaultdict(int) #count of completed rules
num_occurances = defaultdict(int) #count of any premise

for sample in X:
  for premise in range(n_features):
    if sample[premise] == 1: #We are only looking at likes right now
      num_occurances[premise] += 1 
      for conclusion in range(n_features):
        if premise == conclusion: continue
          #i.e. if we are looking at the same idx move to next
        if sample[conclusion] == 1:
          valid_rules[(premise, conclusion)] +=1
          #conlusion shows "Like" or 1 so valid rule

### time to calculate the confidence of our rules

support = valid_rules
## two indexes (0,4) compared as the key: count of matching 1s (likes) as value
# The key is actually a set

confidence = defaultdict(float)
for (premise, conclusion) in valid_rules.keys():
  rule = (premise, conclusion)
  confidence[rule] = valid_rules[rule] / num_occurances[premise]
## set of indexes as key: # of valid occurances / total occurances as value

# Let's find the top 7 rules (by occurance not confidence)
sorted_support = sorted(support.items(),
    key=itemgetter(1), # sort in the order of the values of the dictionary
    reverse=True)      # Descending
sorted_confidence = sorted(confidence.items(), 
    key=itemgetter(1), reverse=True) # Now these dicts are in same order

# Now just print out the top 7
for i in range(7):
  print("Associated Rule {}".format(i + 1))
  premise, conclusion = sorted_support[i][0]
  print_rule(premise, conclusion, support, confidence, features)
