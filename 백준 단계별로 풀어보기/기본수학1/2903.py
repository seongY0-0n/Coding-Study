N = int(input())

temp = 2

plus = 1 

for i in range(N):
  temp += plus
  plus *= 2
  
print(temp*temp)