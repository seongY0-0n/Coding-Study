N = int(input())
x = list()
rank = list()
for i in range(N):
    x.append(list(map(int,input().split())))
    
for i in range(N):
    count = 1
    for j in range (N):
        if x[i][0] < x[j][0] and x[i][1] < x[j][1]:
            count +=1 
    
    rank.append(count)
    
print(*rank)