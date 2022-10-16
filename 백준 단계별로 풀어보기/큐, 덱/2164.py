import collections
import queue
a = int(input())
queue = collections.deque([i for i in range(1, a+1)])

while len(queue) > 1:
    queue.popleft()  
    queue.rotate(-1) 

print(queue[0])