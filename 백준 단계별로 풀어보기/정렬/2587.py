# 2587 대표값2
arr = list()
for i in range(5):

    arr.append(int(input()))

arr.sort()

print(int(sum(arr)/5))
print(arr[2])
