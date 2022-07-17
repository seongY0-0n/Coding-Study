list = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]
count = 0
S = input()
for s in list:
    if s in S:
        S = S.replace(s,'123')

count = S.count('123')
S = S.replace('123', '')
print(count + len(S))