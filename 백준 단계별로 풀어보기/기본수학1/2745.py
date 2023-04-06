
num = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
N, B = map(str, input().split())

L = list(N)
anw = 0
T = 1
for i in range(len(L)):
  temp = L.pop()
  if (temp in num):
    temp = num.index(temp)+10
  anw += T * int(temp)
  T = T * int(B)
  
print(anw)
