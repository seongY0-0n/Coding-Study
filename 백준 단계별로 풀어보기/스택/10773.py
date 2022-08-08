import sys
K = int(input())
arr = list()

for i in range(K):
    a = int(sys.stdin.readline())
    if a == 0:
        arr.pop()
    else:
        arr.append(a)

print(sum(arr))
    