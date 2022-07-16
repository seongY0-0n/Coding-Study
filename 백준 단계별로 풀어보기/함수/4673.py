def d(n):
    sum = 0
    for i in str(n):
        sum += int(i)
    
    return sum + n

arr = list(range(1,10001))
for i in range(1,10001):
    try:
        arr.remove(d(i))
    except:
        continue

for i in arr:
    print(i)
        
    
