"""
Script to scrape 2K17 data
"""

from bs4 import BeautifulSoup
import requests



"""
TODO:
Refactor and reorganise code into classes
Study pymongo and store locally
"""


ATTRIBUTES = {"Name":None,
              "Height":None,
              "Weight":None,
              "From":None,
              "Signatures":[],
              "Debut Game":None}


ROSTERLINK = "https://www.thesmackdownhotel.com/wwe2k17/roster/"



ROSTER_DATA = requests.get(ROSTERLINK).text

ROSTER_SOUP = BeautifulSoup(ROSTER_DATA, "html.parser")


for superstar in ROSTER_SOUP.find_all(class_='roster_section'):
    superstar_link = superstar.find("a")
    superstar_dict={}
    print superstar_link.text, "SUPERSTAR"
    superstar_dict['Name'] = superstar_link.text.strip("\n")
    print superstar_link.get('href')

    s_link= "https://www.thesmackdownhotel.com/" + superstar_link.get('href')
    print s_link
    SUPERSTAR_SOUP = BeautifulSoup(requests.get(s_link).text, "html.parser")
    #SUPERSTAR_SOUP.find(class_='contentheading').get_text().strip()

    #print SUPERSTAR_SOUP
    #print SUPERSTAR_SOUP.prettify()

    tags = [(strong_tag.text.strip(":").strip(),strong_tag.next_sibling.strip()) for strong_tag in SUPERSTAR_SOUP.find_all('strong', limit=6)[1:]]

    for tag in tags:
        print tag
    """
    for strong_tag in SUPERSTAR_SOUP.find_all('strong', limit=6)[1:]:
        print strong_tag.text.strip(":").strip()
        print strong_tag.next_sibling.strip()
    """
    print superstar_dict



print "DONE"
