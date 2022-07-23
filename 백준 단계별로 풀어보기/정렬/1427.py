N = int(input())
arr = list()
for i in str(N):
    arr.append(i)

arr.sort(reverse=True)
a = ''
for i in arr:
    a+=str(i)

print(a)

