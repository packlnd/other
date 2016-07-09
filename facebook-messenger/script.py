from bs4 import BeautifulSoup as BS
import sys

with open('messages.htm', 'r') as f:
    content = f.read()
with open('vanliga', 'r') as f:
    common = f.read().split()
soup = BS(content, "lxml")
all_threads = soup.find_all('div',class_='thread')
thread = [thread for thread in all_threads
            if sys.argv[1] in thread.find(text=True, recursive=False)][0]
messages = [p.find(text=True, recursive=False) for p in thread.find_all('p')]
words = []
for message in messages:
    try:
        w = message.split()
    except:
        continue
    words.extend(w)
wc = sorted([(words.count(x), x) for x in set(words) if x not in common], reverse=True)
print ', '.join([z[1] for z in wc[50:60]])
