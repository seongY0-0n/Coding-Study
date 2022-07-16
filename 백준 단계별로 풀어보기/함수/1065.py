def hansu(N):
    if N <100:
        return N
    elif N < 1000:
        result = 99
        for i in range(100, N+1):
            s = list(str(i))
            if (int(s[0])+int(s[2]))/2 == int(s[1]):
                result += 1
        
        return result
    else :
        return hansu(999)


N = int(input())
print(hansu(N))