# Uses python3
import sys

def get_change(m):
    #write your code here
    coins = 0
    sum = 0
    while m>0:
        if m>=10:
            denomination = 10
        elif m>=5:
            denomination = 5
        else:
            denomination = 1
        sum += denomination
        m -= denomination
        coins += 1
    return coins

if __name__ == '__main__':
    m = int(sys.stdin.read())
    print(get_change(m))
