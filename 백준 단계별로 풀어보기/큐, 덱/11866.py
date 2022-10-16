import sys
from collections import deque
input = sys.stdin.readline
n, k = map(int,input().split())
circle = deque([x for x in range(1,n+1)])
removed = []
while circle:
    circle.rotate(-(k-1))
    removed.append(circle.popleft())
print(f'<{", ".join(map(str,removed))}>')