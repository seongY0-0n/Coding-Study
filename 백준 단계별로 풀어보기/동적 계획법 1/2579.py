n = int(input())

arr = []

for i in range(n):
    arr.append(int(input()))
    
print(arr)
arr2 = [0] *n
arr2[0] = arr[0]
count = 1
for i in range(1, n):
    
    if i == 1:
        arr2[1] = arr[0] + arr[1]
        count += 1
    else:
        m = max(arr2[i-1],arr2[i-2])
        if count == 2:
            m = arr[i-2]
        if m == arr[i-1]:
            count += 1
            arr[i] += m
        else:
            count = 0
            arr[i] += m
            
    
print(arr)