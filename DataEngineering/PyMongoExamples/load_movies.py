from pymongo import MongoClient
import os
import json

client = MongoClient("mongodb://localhost:27017/")
db = client['reviews']
"""
  Now lets add a whole bunch of movies from json
  Luckly mongoDB is based on json so all we have to do is load it
    ....well we would if it was 100% correctly formed
        But you have a better chance of catching a Unicorn
  Anyway, just get to individual Jsons (or bjson - covering next week)
  MongoDB does the rest (no classes, no nothing - just load)
"""

m_path = "./movies"
result = []
"""
1. Load all the filenames with os.listdir
2. Load Json files - each one is split into a ton of different fields
   2a. Load the JSON array of JSON objects under the "movies" key
   2b. Load each JSON object (as dict) using for loop
3. insert each to MongoDB on localhost as reviews.whateverIMDBpagethiswas
"""

for filename in os.listdir(m_path):
  f_path = "{}/{}".format(m_path, filename)
  with open(f_path) as f:
    data = json.load(f)
    for field in data['movies']:
      result.append(db[filename[:-5]].insert_one(field).inserted_id)
    #not using insert_many cause I kept having to remove fields for errors
    #Well-formatted, follows the actual standard Json - ah, 'tis to dream
 
"""
Just print the new collections we added (like tables)
Then print out the first 5 ids we inserted
Could do a quick .find() with the {"_id": asdf12234234jkl} to check values
"""

print(db.list_collection_names())
print("---------------------------------------")
wait = input("press any key to continue")

print(result[:5])
### We could use the results to perform searches on or other things
### but will ignore it for now
print("---------------------------------------")
wait = input("press any key to continue")
