N, K = map(int, input().split())

temp = 0
anw=False
for i in range(1,N+1):
  if N%i==0:
    temp+=1
  if temp == K:
    print(i)
    anw=True
    break

if anw == False:
  print(0)