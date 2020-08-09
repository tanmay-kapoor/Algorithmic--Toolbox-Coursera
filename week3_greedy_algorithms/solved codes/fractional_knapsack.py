# Uses python3
import sys

def get_optimal_value(capacity, weights, values):
    value = 0.
    # write your code here
    n = len(weights)
    r = list()

    for i in range(n):
        ans = values[i]/weights[i]
        r.append(ans)
    ratio = sorted(r, reverse=True)

    for i in range(n):
        index = 0           #ratio order and weights order is different so index finds corresponding value in weights
        if capacity==0:
            return value
        for temp in range(len(ratio)):
            if r[temp]==ratio[i]:
                index = temp
                break
        a = capacity if capacity < weights[index] else weights[index]
        value = value + a*ratio[i]
        weights[index] -= a
        capacity -= a

    return value


if __name__ == "__main__":
    data = list(map(int, sys.stdin.read().split()))
    n, capacity = data[0:2]
    values = data[2:(2 * n + 2):2]
    weights = data[3:(2 * n + 2):2]
    opt_value = get_optimal_value(capacity, weights, values)
    print("{:.10f}".format(opt_value))
