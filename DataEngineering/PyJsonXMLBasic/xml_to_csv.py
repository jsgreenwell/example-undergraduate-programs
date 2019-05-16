from bs4 import BeautifulSoup
import csv

"""
## Example program for processing an xml and saving information as a csv
Typically if we had an XML file already, we'd just process it and not convert.

However, serialization is a key part of Data Engineering & the ETL process,
so we will use this to help expand our ability to process one of the many
file formats available (XML/HTML) and our ability to create another (CSV).
"""

"""
### Tools/Acknowledgements
Using xml data from JAXB files. For Java Implementation see:
  http://www.vogella.com/articles/JAXB/article.html
More information on BeautifulSoup (an HTML/XML scrapper):
  https://www.crummy.com/software/BeautifulSoup/bs4/doc/#parsing-xml

Note - use of bookstore2.xml which has three book stores
"""

"""
### Steps (Algorithm):
----------------------
1. Load xml file into memory and pass to BeautifulSoup
2. Open a csv file for writing
3. Then write the header row
4. Then walk through the top_level items and pass as list to the
   csv writer
"""

xml_report = open('bookstores2.xml', 'r').read()
soup = BeautifulSoup(xml_report, "lxml")

#Open a csv for writing (not appending)
with open('bookstore_report.csv', 'w', newline='') as outfile:
  report = csv.writer(outfile, delimiter=",", quoting=csv.QUOTE_ALL)

  #write the header row
  report.writerow(['isbn', 'title', 'author', 'publisher', 
                   'store', 'location'])
  #parse bookstore, create list of books, write to csv
  for bookstore in soup.findAll("bookstore"):
    books = bookstore.booklist
    for book in books:
      if book.name == "book": #i.e. don't write if no books
        report.writerow([
          book.get("isbn"),
          book.title.get_text(),
          book.author.get_text(),
          bookstore.publisher.get_text(), 
          bookstore.store.get_text(), 
          bookstore.location.get_text()])
