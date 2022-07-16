C = int(input())

for i in range(C):
    sum = 0
    avg = 0
    count = 0
    result = 0
    arr = list(map(int, input().split()))
    for j in range(1,len(arr)):
        sum += arr[j]
    avg = sum / arr[0]
    for j in range(1,len(arr)):
        if arr[j] > avg:
            count += 1
    result = round(count/arr[0]*100,3)
    print("{:.3f}%".format(result))
    
