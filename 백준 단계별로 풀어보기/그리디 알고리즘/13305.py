N = int(input())
length = list(map(int, input().split()))
price = list(map(int,input().split()))

min_price = price[0]
sum = price[0]*length[0]

for i in range(1,N-1):
    if min_price > price[i]:
        min_price = price[i]
    sum += min_price*length[i]
    
print(sum)