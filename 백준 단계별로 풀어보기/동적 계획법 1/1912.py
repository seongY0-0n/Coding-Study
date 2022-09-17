n = int(input())

arr = list(map(int, input().split()))

arr2 = [arr[0]]
for i in range(n-1):
    arr2.append(max(arr2[i] + arr[i+1], arr[i+1]))

print(max(arr2))