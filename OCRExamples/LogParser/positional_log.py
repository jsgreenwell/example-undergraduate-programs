'''
This will show an example of "postional" processing of text files. This is 
the most basic way to process a simple text file or log file. It is fragile
and does not scale well (every change would require a new parser). But, it is
used in combination with later OCR options so is where we will start.

Note, for this one - using split() will work extremely well over position
(as we will see later).
'''
log_dict = {}

with open('sample_log.txt', 'r') as log:
  '''
  So after looking at the log this is set at a specific positional setting.
  With the headings: 
   - link index (where is it in the click map)
   - base directory
   - primary key (really just a auto-increment it looks like)
   - sub directory path & page
   - time spent on page

   So we'll start by just opening the file, reading each line, and assign these
   fields to a dictionary based on their position in the page. Then we will 
   discuss the flaws in this design and come up with a better solution.
  '''

  for line in log:
    # Every line is a string which is the same as a char array: position = idx
    # Fun note about Python - we don't need substr - it allows for slices
    log_dict[line[23:25].strip()] = {"l_idx": line[0:1].strip(), 
        "base": line[7:20].strip(), "path": line[28:63].strip(), 
        "time": line[-7:].strip()}


for l in log_dict.items():
  print("We have {}".format(l))
  # Still can't see an issue? Add 100 to the primary key field or 1000
  # Or change the admissions to a new base (its not the same as currently used)
