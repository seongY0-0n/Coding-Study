n = int(input())

arr = list()

for i in range(n):
    arr.append(list(map(int, input().split())))
    
for i in range(1,n):
    for j in range(len(arr[i])):
        if j==0:
            arr[i][0] += arr[i-1][0]
        elif j==i:
            arr[i][j] += arr[i-1][j-1]
        else:
            arr[i][j] += max(arr[i-1][j],arr[i-1][j-1])
print(max(arr[n-1]))