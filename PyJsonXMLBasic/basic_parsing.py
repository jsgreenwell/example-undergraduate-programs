from bs4 import BeautifulSoup
import csv

"""
Using xml data from JAXB files. For Java Implementation see:
  http://www.vogella.com/articles/JAXB/article.html
  Using this as it was the basis for last year's course
More information on BeautifulSoup (an HTML/XML scrapper):
  https://www.crummy.com/software/BeautifulSoup/bs4/doc/#parsing-xml
"""

"""
## Basic Example of using soup to parse an XML file

First we will load the file into memory and send that information 
to BeautifulSoup for parsing. Then we will use the prettify function
to print out the report with spacing.

Note: We could just do this in one line, as such:
  soup = BeautifulSoup(open('bookstore.xml', 'r').read(), "lxml")
"""

xml_report = open('bookstore.xml', 'r').read()
soup = BeautifulSoup(xml_report, "lxml")

# Typically we wouldn't just print this out (we'd do something with it)
# However, its good for sanity checks
print("----Start XML--------")
print(soup.prettify())
print("----END XML--------\n\n") 


'''
Now let us find some data...all the titles? maybe each isbn?
  - We should use FindALL() for the title tags (find() for just 1st one)
    - Then just get_text() to get the text of the tag
  - isbn is an attribute so we first have to select the parent tag (findAll)
    - Then "get" the attribute from there
'''

titles = soup.findAll('title') 
for title in titles:
    print("Title is {}".format(title.get_text()))

isbns = soup.findAll("book") 
for isbn in isbns:
    print("isbn is {}".format(isbn.get("isbn")))
