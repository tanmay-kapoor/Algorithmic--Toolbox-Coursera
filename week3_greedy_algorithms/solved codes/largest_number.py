#Uses python3

def is_greater_or_equal(a, b):
    a = str(a)+str(b)
    b = str(b)+str(a)
    if a>=b:    
        return True
    return False

def largest_number(nums):
    #write your code here
    ans = ""
    for temp in range(len(nums)):
        maxNum = 0
        for i in range(len(nums)):
            if nums[i]==0:
                continue
            if is_greater_or_equal(nums[i], maxNum):
                maxNum = nums[i]
                index = i
        ans += str(maxNum)
        nums[index] = 0
    return ans

if __name__ == '__main__':
    n = int(input())
    a = list(map(int, input().split()))
    print(largest_number(a))
    
