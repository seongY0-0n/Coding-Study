A=int(input())
B=int(input())
C=int(input())

D=A*B*C
strnum = list(str(D))

for i in range(10):
    print(strnum.count(str(i)))