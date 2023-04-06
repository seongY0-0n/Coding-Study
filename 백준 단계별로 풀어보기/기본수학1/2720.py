T = int(input())


for _ in range(T):
  arr =list()
  N = int(input())
  arr.append(N//25)
  N = N % 25
  arr.append(N//10)
  N = N % 10
  arr.append(N//5)
  N = N % 5
  arr.append(N//1)
  print(*arr)
  
