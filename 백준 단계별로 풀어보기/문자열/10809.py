S = list(map(str, input()))
arr = list()

for i in range(97,123):
    if chr(i) in S:
        arr.append(S.index(chr(i)))
    else:
        arr.append(-1)
        
print(*arr)