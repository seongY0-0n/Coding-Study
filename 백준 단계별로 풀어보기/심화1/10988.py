word = input()
arr = list(word)
temp = ''
for i in range (len(arr)):
  temp += arr.pop()


if(word == temp) :
  print(1)
else:
  print(0)


