from bs4 import BeautifulSoup as BS
from collections import defaultdict
import sys
from operator import itemgetter
import random
import pickle
import os.path

PICKLE_FILE='messages.pickle'

N_GRAM='0'
TF_IDF='1'


if os.path.isfile(PICKLE_FILE):
    with open(PICKLE_FILE) as f:
        all_messages = pickle.load(f)
else:
    with open('messages.htm', 'r') as f:
        content = f.read()
    print 'read html file'
    soup = BS(content, "lxml")
    print 'soupify'
    all_threads = soup.find_all('div',class_='thread')
    print 'got all threads'
    all_messages = {}
    for thread in all_threads:
        name = thread.find(text=True, recursive=False).split(', ')[0]
        messages = [str(p.find(text=True, recursive=False).encode('utf8'))
                for p in thread.find_all('p')
                if p.find(text=True, recursive=False) is not None]
        all_messages[name] = messages
    with open(PICKLE_FILE, 'wb') as f:
        pickle.dump(all_messages, f)
messages = all_messages[sys.argv[1]]
print 'got messages'

tc = defaultdict(lambda: defaultdict(lambda: defaultdict(lambda: 0)))
START,STOP='<MESSAGE>','</MESSAGE>'
K=3
for message in messages:
    p,pp=START,START
    w = message.split()
    if len(w) < K:
        continue
    for e in w:
        tc[pp][p][e]+=1
        pp,p=p,e
    tc[pp][p][STOP]+=1
print 'got trigram counts'
message = []
#pp,p = START,START
pp = random.choice(tc.keys())
p = random.choice(tc[pp].keys())
c=max(tc[pp][p].iteritems(), key=itemgetter(1))[0]
while c != STOP:
    pp,p = p,c,
    message.append(c)
    c = max(tc[pp][p].iteritems(), key=itemgetter(1))[0]
print ' '.join(message)
