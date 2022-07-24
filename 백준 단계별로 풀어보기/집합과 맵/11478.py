s = input()

a = set()
for i in range(len(s)+1):
    for j in range(len(s)+1):
        if(i+j>len(s)): break
        else:
            a.add(s[i:i+j])
a = list(a)

print(len(a)-1)