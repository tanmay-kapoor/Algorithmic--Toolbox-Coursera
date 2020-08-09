# Uses python3
import sys

def fibonacci_sum(n):

    n = n%60        #pp of 10 = 60

    if n==0:
        return 0
    if n==1:
        return 1

    f=0
    s=1
    term=2
    sum=1

    while term<=n:
        t=(f+s)%10
        sum= (sum+t)%10
        f=s
        s=t
        term+=1
    return sum

if __name__ == '__main__':
    n = int(input())
    print(fibonacci_sum(n))
