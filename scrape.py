"""
Script to scrape 2K17 data
"""

from bs4 import BeautifulSoup
import requests



"""
TODO:
Figure out db design
Figure out json with mysql
https://scotch.io/tutorials/working-with-json-in-mysql
"""




ROSTERLINK = "https://www.thesmackdownhotel.com/wwe2k17/roster/"



ROSTER_DATA = requests.get(ROSTERLINK).text

ROSTER_SOUP = BeautifulSoup(ROSTER_DATA, "html.parser")

#print roster_soup.prettify()
"""
for superstar in ROSTER_SOUP.find_all(class_='aidanews_arttitle'):
    #print superstar.prettify()
    superstar_link = superstar.find("a")
    print superstar_link
"""

SAMPLE_STAR_LINK = "https://www.thesmackdownhotel.com/wwe2k17/roster/alberto-del-rio"

SUPERSTAR_SOUP = BeautifulSoup(requests.get(SAMPLE_STAR_LINK).text, "html.parser")

#print SUPERSTAR_SOUP.prettify()

print SUPERSTAR_SOUP.find(class_='contentheading').get_text().strip()

superstar_info = SUPERSTAR_SOUP.find(class_='rosterbio')
print superstar_info
print type(superstar_info)


for attribute in superstar_info.children:
    print attribute,"1"

useful = superstar_info.contents[4:]
print useful
print "DONE"
