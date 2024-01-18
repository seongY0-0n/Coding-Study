n = int(input())
data = list()
dataSum = {}

for i in range(n):
  num = input()
  temp = 0
  data.append(num)
  for n in num:
    if n in "123456789":
      temp += int(n)
  dataSum[num] = temp
  
data.sort(key = lambda x : (len(x), dataSum[x], x))
for i in data:
  print(i)