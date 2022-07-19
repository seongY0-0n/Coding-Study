T = int(input())


for i in range(T):
    H, W, N = map(int, input().split())
    Y = N % H
    if Y == 0: Y = H
    Y *=100
    
    X = (N -1) // H
    
    print(Y+X+1)