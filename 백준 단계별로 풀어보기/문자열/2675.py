T = int(input())

for i in range(T):
    P=''
    S = list(map(str, input().split()))
    for s in S[1]:
        P+=(s*int(S[0])) 
    
    print(P)
    
