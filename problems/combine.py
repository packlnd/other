import sys

def rec_help(i,n):
    if i < 1 or i > n:
        return ''
    s = ('' if n%2==0 and i+1==n or n%2!=0 and i==n else ', ') + str(i*i)
    return s + rec_help(i-2 if not i%2 is 0 else i+2,n)
def rec(n):
    print rec_help(n if not n%2 is 0 else n-1,n) + rec_help(2,n)

rec(5)
rec(1)
rec(8)
