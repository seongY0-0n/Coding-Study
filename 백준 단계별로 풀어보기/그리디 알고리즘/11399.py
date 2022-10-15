N = int(input())
arr = list(map(int,input().split()))
arr.sort()

arr_sum = list()
temp = 0
for i in arr:
    temp += i
    arr_sum.append(temp)
    
print(sum(arr_sum))