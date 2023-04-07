N = int(input())
arr1, arr2 = list(), list()

for _ in range(N):
    x, y = map(int, input().split())
    arr1.append(x)
    arr2.append(y)

if len(arr1) == 1:
    print(0)
else:
    print((max(arr1)-min(arr1))*(max(arr2)-min(arr2)))
