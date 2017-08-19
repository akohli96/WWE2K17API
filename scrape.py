"""
Script to scrape 2K17 data
"""

from bs4 import BeautifulSoup
import requests
import re

"""
TODO:
Refactor into functions
Use functional programming techniques
Log instead of print
"""
ROSTERLINK = "https://www.thesmackdownhotel.com/wwe2k17/roster/"
ROSTER_SOUP = BeautifulSoup(requests.get(ROSTERLINK).text, "html.parser")

PATTERN="PROFILE(Height:)(.*)(Weight:)([0-9]+).*(From:?)(.*)(Signature Move.*:)(.*)(First WWE Game:)(.*)"

for superstar_subset in ROSTER_SOUP.find_all(class_='roster_section'):
    #print superstar_subset
    for individual in superstar_subset:
        #print individual
        individual_link = "https://www.thesmackdownhotel.com/" + individual.get('href')

        SUPERSTAR_SOUP = BeautifulSoup(requests.get(individual_link).text, "html.parser")
        print SUPERSTAR_SOUP.find(class_="contentheading").get_text().strip()
        text_found=SUPERSTAR_SOUP.find(class_="rosterbio").get_text(strip=True)

        try:
            #print text_found
            for number,pattern in enumerate(re.search(PATTERN,text_found).groups()):
                print number,pattern
            print "\n"
        except Exception as e:
            print e
        

