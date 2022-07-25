a = list()
b = list()

for i in range(3):
    A,B = map(int, input().split())
    a.append(A)
    b.append(B)
    
for i in a:
    if a.count(i)==1:
        print(i,end=' ')

for i in b:
    if b.count(i)==1:
        print(i,end=' ')