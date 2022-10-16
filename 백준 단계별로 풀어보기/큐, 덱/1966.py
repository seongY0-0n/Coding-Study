import collections
import sys
from collections import deque

n = int(input())
for i in range(n):
    n, m = map(int, sys.stdin.readline().split())
    queue = deque(map(int, sys.stdin.readline().split()))
    index = deque([i for i in range(n)])
    
    count = 0
    while True:
        if queue[0] == max(queue):
            count+=1
            if index[0] == m:
                print(count)
                break
            else:
                queue.popleft()
                index.popleft()
        else:
            queue.rotate(-1)
            index.rotate(-1)
            
            