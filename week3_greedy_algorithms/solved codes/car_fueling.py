# python3
import sys


def compute_min_refills(distance, tank, stops):
    # write your code here
    n = len(stops)
    stops.insert(0,0)
    stops.append(distance)
    currentRefill, numRefills = 0, 0

    while currentRefill<=n:
        lastRefill = currentRefill

        while currentRefill<=n and (stops[currentRefill+1] - stops[lastRefill] <= tank):
            currentRefill += 1

        if lastRefill==currentRefill:
            return -1
        if currentRefill<=n:
            numRefills += 1

    return numRefills

if __name__ == '__main__':
    d = int(input())
    m = int(input())
    n = int(input())
    stops = list(map(int, input().split()))
    print(compute_min_refills(d, m, stops))
