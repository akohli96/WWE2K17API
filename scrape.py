"""
Script to scrape 2K17 data
"""

from bs4 import BeautifulSoup
import requests
import re
from constants import CONSTANTS
import superstar

"""
TODO:
Refactor into functions
Use functional programming techniques
Log instead of print
"""
ROSTERLINK = CONSTANTS['ROSTERLINK']
PATTERN = CONSTANTS['PATTERN']


ROSTER_SOUP = BeautifulSoup(requests.get(ROSTERLINK).text, "html.parser")

SUPERSTAR_LIST=[]

def process_superstar(superstar_tuple):
    superstar_values=[element for element in superstar_tuple[1::2]]
    superstar_values[-2]=[element.strip() for element in superstar_values[-2].split(";")]
    return superstar_values

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
            #print (type(re.search(PATTERN,text_found).groups()))
            print(process_superstar(re.search(PATTERN,text_found).groups()))
 #           for number,pattern in enumerate(re.search(PATTERN,text_found).groups()):
 #               print number,pattern
                
            print "\n"
        except Exception as e:
            print e
        

