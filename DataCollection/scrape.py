"""
Script to scrape 2K17 data
"""
import json
import re
from constants import CONSTANTS
from superstar import SuperStar
import requests
from bs4 import BeautifulSoup
import uuid


"""
TODO:
Refactor into functions
Use functional programming techniques
Log instead of print
"""

ROSTERLINK = CONSTANTS['ROSTERLINK']
DATAPATTERN = CONSTANTS['DATAPATTERN']
NUMBERPATTERN = CONSTANTS['NUMBERPATTERN']
INCH_TO_METER = CONSTANTS['INCH_TO_METER']

def imperial_to_metric(imperial_measurements):
    feet, inches = re.search(NUMBERPATTERN, imperial_measurements).groups()
    return round((float(inches) + (float(feet) * 12)) * INCH_TO_METER, 2)

def process_superstar_data(superstar_tuple):
    """
    Height:,6'7", Weight:,331,From:,Boston, Massachusetts,Signature Move:,Albert Bomb,First WWE Game:,WWF WrestleMania 2000 (As Prince Albert)
    """
    superstar_values = [element for element in superstar_tuple[1::2]]
    superstar_values[-2] = [element.strip() for element in superstar_values[-2].split(";")]
    superstar_values[1] = int(superstar_values[1])
    superstar_values[0] = imperial_to_metric(superstar_values[0])
    return superstar_values

def process_superstar_html(roster_soup):
    superstar_list = []
    for superstar_subset in roster_soup.find_all(class_='roster_section'):
        for individual in superstar_subset:
            individual_link = "https://www.thesmackdownhotel.com/" + individual.get('href')
            superstar_soup = BeautifulSoup(requests.get(individual_link).text, "html.parser")
            text_found = superstar_soup.find(class_="rosterbio").get_text(strip=True)
            try:
                superstar_name = superstar_soup.find(class_="contentheading").get_text().strip()
                superstar_processed_info = process_superstar_data(re.search(DATAPATTERN, text_found).groups())
                new_star = SuperStar(superstar_name, superstar_processed_info[0], superstar_processed_info[1], superstar_processed_info[2], superstar_processed_info[3], superstar_processed_info[4],str(uuid.uuid4()))
                superstar_list.append(new_star.__dict__)
            except AttributeError as attribute_error:
                print attribute_error,superstar_name
    return superstar_list

def prepare_all_superstar_data():
    return process_superstar_html(BeautifulSoup(requests.get(ROSTERLINK).text, "html.parser"))

def main():
    with open('superstar.json', 'w') as superstar_file_pointer:
        json.dump(prepare_all_superstar_data(), superstar_file_pointer)

if __name__ == "__main__":
    print main()
