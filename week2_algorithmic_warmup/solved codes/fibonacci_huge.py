# Uses python3
import sys

def pisanoPeriod(m):
    previous=0
    current=1
    pisano=-1

    for i in range(0, m*m):
        temp = previous
        previous = current
        current = (temp+current)%m

        if previous==0 and current==1:
            pisano = i+1
            break

    return pisano

def get_fibonacci_huge_naive(n, m):
    pisano = pisanoPeriod(m)
    n = n%pisano

    if n==0:
        return 0
    if n==1:
        return 1
    f=0
    s=1
    term=2
    while term<=n:
        t=f+s
        f=s
        s=t
        term+=1
    return t%m

if __name__ == '__main__':
    n, m = map(int, input().split())
    print(get_fibonacci_huge_naive(n, m))
