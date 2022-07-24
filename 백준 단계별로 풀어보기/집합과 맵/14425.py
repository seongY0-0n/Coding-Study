import sys

N, M = map(int, sys.stdin.readline().split())
count = 0
s = set()
for i in range(N):
    s.add(sys.stdin.readline())
    
s_ = list()
for i in range(M):
    s_.append(sys.stdin.readline())

for i in s_:
    if i in s: count+=1

print(count)