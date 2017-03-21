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


for superstar in ROSTER_SOUP.find_all(class_='roster_section'):
    superstar_link = superstar.find("a")
    print superstar_link.text
    print superstar_link.get('href')

    s_link= "https://www.thesmackdownhotel.com/" + superstar_link.get('href')
    print s_link
    SUPERSTAR_SOUP = BeautifulSoup(requests.get(s_link).text, "html.parser")
    #SUPERSTAR_SOUP.find(class_='contentheading').get_text().strip()

    #print SUPERSTAR_SOUP
    #print SUPERSTAR_SOUP.prettify()
    for strong_tag in SUPERSTAR_SOUP.find_all('strong', limit=6)[1:]:
        print  strong_tag.text, strong_tag.next_sibling


SAMPLE_STAR_LINK = "https://www.thesmackdownhotel.com/wwe2k17/roster/alberto-del-rio"

SUPERSTAR_SOUP = BeautifulSoup(requests.get(SAMPLE_STAR_LINK).text, "html.parser")

#print SUPERSTAR_SOUP.prettify()

print SUPERSTAR_SOUP.find(class_='contentheading').get_text().strip()

#http://stackoverflow.com/questions/23380171/using-beautifulsoup-extract-text-without-tags
for strong_tag in SUPERSTAR_SOUP.find_all('strong', limit=6)[1:]:
    print  strong_tag.text, strong_tag.next_sibling


ATTRIBUTES = {"Name":None,
              "Height":None,
              "Weight":None,
              "From":None,
              "Signatures":[],
              "Debut Game":None}

print "DONE"
