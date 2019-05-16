import re

'''
This will show the basic version of OCR processing of a text file. This is 
introduces regex for parser building. Again, still used quite often as it
is a fairly cheap way to just make something more parsable (if not perfect):
  Think of this as if you have data entry and changing "type all 200 pages" of
  this file to copy & paste them (and then automate that and data entry becomes
  quality assurance)
'''

def line_parser(l):
  # As we have the base directory - we don't need to duplicate it in path
  # So lets use that positional to remove the base from the path (dynamicly)
  headers = ["l_idx", "base", "pk", "path", "time"]
  fields = {}
  pk = 0

  for i, value in enumerate(l):
    if i == 1:
      fields[headers[3]] = l[3][len(value):]
      fields[headers[i]] = value
    elif i == 2:
      pk = value
    elif i == 3:
      continue
    else:
      fields[headers[i]] = value
  return pk, fields

with open('sample_text.txt', 'r') as text:
  '''
  Now this is a very nice version of a pdf to text, for practice.
  To parse we need to:
  1. Identify patterns which help us determine if something is text (lexer)
  2. Identify any grammer rules needed (syntax of the data)
  3. Search for patterns using grammer rules (using Tree model usually)

  For 1: ... seems a pattern
  # Finish annotating after & seperate out parser logic
  '''
  dots = re.compile(r'\.\.+')
  for line in text:
    if re.search('\w\.\.+', line):
      # There is a letter followed by 2 or more .. = data
      cur_data = re.split('\|', line)

      # cur_data = 3 element list of data (lets remove those dots ".....")
      # then remove the \n from date/time and split those into date & time
      cur_data = [dots.sub("", match) for match in cur_data]
      cur_data.extend(cur_data[2].rstrip().split())
      del cur_data[2]
      print(cur_data)

