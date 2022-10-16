from collections import deque
from operator import index

N,M = map(int, input().split())

queue = deque([i for i in range(1, N+1)])

arr = list(map(int, input().split()))
count = 0

for i in arr:
    while True:
        if queue[0] == i:
            queue.popleft()
            break
        elif queue.index(i) - len(queue)//2 > 0:
            queue.rotate(1)
            count+=1
        else:
            queue.rotate(-1)
            count+=1

print(count)