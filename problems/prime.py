def isPrime(n):
    lst = [False if i in [0,1] else True for i in range(n+1)]
    for p in range(2, n+2):
        for i in range(p*2,n+1,p):
            lst[i] = False
        while p<n+1 and lst[p] is False:
            p+=1
    return "yes" if lst[n] else "no"

print isPrime(123833)
print isPrime(5)
print isPrime(222222)
