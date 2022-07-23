N = int(input())
arr = list()
for i in range(N):
    arr.append(int(input()))

for i in range(N):
    print(sorted(arr)[i])