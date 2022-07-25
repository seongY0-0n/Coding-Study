W, H, X, Y, P = map(int,input().split())

player = list()
count = 0
for i in range(P):
    player.append(list(map(int,input().split())))
    d1 = ((X - player[i][0])**2 + ((Y+(H/2))-player[i][1])**2)**(1/2)
    d2 = (((X + W) - player[i][0])**2 + ((Y+(H/2))-player[i][1])**2)**(1/2)
    if player[i][0] >= X and player[i][1] >= Y and player[i][0] <= X+W and player[i][1] <= Y+H:
        count+=1
    elif player[i][0] < X and d1 <= H/2:
        count+=1
    elif player[i][0] > X+W and d2 <= H/2:
        count+=1
    
print(count)
