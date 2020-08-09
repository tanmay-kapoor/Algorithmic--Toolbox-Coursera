# Uses python3

def optimal_summands(n):
    summands = []
    sum = 0
    #write your code here
    i = 1
    while sum<n:
        if (sum+i) <=n:
            sum += i
            summands.append(i)
            i += 1
        else :
            i -= 1
            last_value = n-sum+i
            sum += last_value
            summands.pop()
            summands.append(last_value)

    return summands

if __name__ == '__main__':
    n = int(input())
    summands = optimal_summands(n)
    print(len(summands))
    for x in summands:
        print(x, end=' ')
