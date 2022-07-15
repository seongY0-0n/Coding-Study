N = int(input())
count = 0
a = N

while True:
    a = (a%10)*10 + (a//10 + a%10)%10
    count += 1
    if a == N:
        break
    
print(count)