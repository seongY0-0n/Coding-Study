import math
A, B, V = map(int, input().split())

start = 0
day = 0

print(math.ceil((V-A)/(A-B))+1)