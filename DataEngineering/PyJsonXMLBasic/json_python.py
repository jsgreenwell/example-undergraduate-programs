import json

"""
## Example program to show processing JSON with Python

#### Steps (Algorithm)
------------------------
First we will build a dictionary that will function in the same manner
as the class we built in Java. We use dictionaries with Python as they
are extremely similar to JSON objects (so easy to serialize)

As we are focusing on functional programming with Python in this class,
this will functionally do everything our Java version does (i.e. not OOP):
  build a dictionary which will function as our classes
  set each value in the dictionary using the functions (think "setter")
  Then print our json object and write it to a file
We will move to more into FP as we progress to Big Data & analysis

For more info on json check the python docs (it is a built-in):
  https://docs.python.org/3/library/json.html
"""

def set_name(n):
  #split without an argument defaults to '\s+' (any length of spaces)
  fulln = n.split()
  return {"first": fulln[0], "last": fulln[1]}

def set_role(r):
  # 'in' allows us to just check if a value is in an object (just like SQL IN)
  # in this case if the passed string is in our set (set - think Discrete Math)

  if r.lower() in ("teacher", "student", "staff", "admin"):
    return r
  return "student"

def set_userLocation(l):
  # This is a list comprehension which breaks our passed string up
  # Then returns a byte representation of each as elements in a new list
  # Real world we might validate a set of GPS coordinate or location names here
  return [hex(ord(c)) for c in ''.join(l)]

json_dict = {
  "role": "",
  "name": {"first": "", "last": ""},
  "isVerified": False,
  "userLocation": 0,
}

json_dict["name"] = set_name("My Name")
json_dict["role"] = set_role("Teacher")
json_dict["isVerified"] = True
json_dict["userLocation"] = set_userLocation("ad3h12dh")

# print out the json (for validating) - dumps = dump string
# think of it as an overriden toString (which is not far off)
print(json.dumps(json_dict, sort_keys=True, indent=4))

#https://docs.python.org/3/tutorial/inputoutput.html#reading-and-writing-files
with open('User.json', 'a') as json_file:
    json_file.write(json.dumps(json_dict, sort_keys=True, indent=4))
