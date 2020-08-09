# Uses python3

def get_fibonacci_last_digit_naive(n):
    
    f = 0
    s = 1
    if n<=0:
        return 0
    elif n==1:
        return 1
    term = 2
    while term<=n:
        t = (f+s)%10
        f=s
        s=t
        term+=1
    return t

if __name__ == '__main__':
    n = int(input())
    print(get_fibonacci_last_digit_naive(n))
