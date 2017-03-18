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

print "DONE"
