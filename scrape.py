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

SAMPLE_STAR_LINK = "https://www.thesmackdownhotel.com/wwe2k17/roster/aj-styles"

SUPERSTAR_SOUP = BeautifulSoup(requests.get(SAMPLE_STAR_LINK).text, "html.parser")

#print SUPERSTAR_SOUP.prettify()

print SUPERSTAR_SOUP.find(class_='contentheading').get_text().strip()


print "DONE"
