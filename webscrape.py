from selenium import webdriver
from random import random
from urllib.request import urlopen
from bs4 import BeautifulSoup
import pandas as pd
import time
import matplotlib.pyplot as plt
import numpy as np
import mplcursors



class webscrape():
        
        




    def performCalculation(int):
        url = "https://www.basketball-reference.com/leagues/NBA_{}_totals.html".format(year);
        html = urlopen(url);

        soup = BeautifulSoup(html);
        soup.findAll('tr', limit =2);
        headers = [th.getText() for th in soup.findAll('tr', limit=2)[0].findAll('th')]
        print("1");

        headers = headers[1:];
        rows = soup.findAll('tr')[1:]
        player_stats = [[td.getText() for td in rows[i].findAll('td')] for i in range(len(rows))]

        print("2");

        stats2 = pd.DataFrame(player_stats, columns = headers);
        stats2.head(10);

        stats = stats


        stats.to_csv(r"C:\Users\Liam\Documents\NBA_{}.csv".format(year), index = False)
        print("3");

    
driver = webdriver.Chrome(executable_path=r'C:\Users\Liam\Documents\chromedriver.exe');


year = int(input("Enter a year: "))
webscrape.performCalculation(year);
stats = pd.read_csv(r"C:\Users\Liam\Documents\NBA_{}.csv".format(year))
'''t = stats.PTS/stats.G
r = stats.STL/stats.G
#Shows points per game, need to make it where it shows the names when hovered over

fig, ax = plt.subplots()
lines = ax.scatter(t, r)
ax.set_title("PPG for Players")
cursor = mplcursors.cursor(lines, hover=True)
cursor.connect("add", lambda sel: sel.annotation.set_text(stats.loc[sel.target.index].Player))

plt.show()
'''

    
