k, n = map(int, input().split())

arr = list()
for i in range(k):
    lan = int(input())
    arr.append(lan)

arr.sort()

low , high = 1, arr[-1]

while low <= high:
    sum = 0
    mid = (low+high)//2
    for i in arr:
        sum+= i//mid
    
    if sum < n:
        high = mid -1
    else:
        low = mid + 1

print(high)
    