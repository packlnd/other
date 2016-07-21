# -*- coding: utf-8 -*-

from bs4 import BeautifulSoup as BS
import csv

with open('messages.htm', 'r') as f:
    content = f.read()
print 'read raw file..'
soup = BS(content, "lxml")
print 'soupified..'
tfs = set()
all_threads = soup.find_all('div',class_='thread')
print 'got all threads..'
N = float(len(all_threads))
n=1
for thread in all_threads:
    print '%.2f%%' % (100*(n/N))
    name = thread.find(text=True, recursive=False).lower().split(', ')[0].replace(' ', '_')
    messages = [p.find(text=True, recursive=False) for p in thread.find_all('p')]
    words = []
    for message in messages:
        try:
            w = message.split()
        except:
            continue
        words.extend(w)
    wc = {x: words.count(x) for x in set(words) if not x.startswith('http')}
    with open('tfs/%s.csv' % name, 'w') as f:
        w = csv.writer(f)
        for key, val in wc.items():
            try:
                w.writerow([key.encode('utf8'), val])
            except:
                import pdb;pdb.set_trace()
    n += 1
