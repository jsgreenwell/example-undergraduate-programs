'''
This will show the basic version of OCR processing of a log file. This is 
the most basic way to process a simple log file before we move to more 
complicated versions using regex. It is still used quite often as its a fairly
common use-case. It scales okay and can be used with positional - we will once.
'''
log_dict = {}

with open('sample_log.txt', 'r') as log:
  '''
  Same idea as last time:
  So after looking at the log this is set at a specific positional setting.
  With the headings: 
   - link index (where is it in the click map)
   - base directory
   - primary key (really just a auto-increment it looks like)
   - sub directory path & page
   - time spent on page

   So we'll start by just opening the file, reading each line, and assign these
   fields to a dictionary based on the spacing in between them. Then we will 
   discuss the flaws in this design and where we might need a more 
   robust solution.
  '''

  for line in log:
    '''
    Two notes: 
    - split() defaults to any whitespace 
    - this gives a list which you can use, depending on need, instead of dict
    '''
    cur_line = line.split()
    log_dict[cur_line[2]] = {"l_idx": cur_line[0], "base": cur_line[1], 
        "path": cur_line[3], "time": cur_line[-1]}

for l in log_dict.items():
  print("We have {}".format(l))
  # Oh, much better. But there are still a few issues and scaling situations
  # What do you think those are?
