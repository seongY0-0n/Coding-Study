import sys 
from collections import deque


n = int(input())
a = deque()
for i in range(n):
    order = list(map(str, sys.stdin.readline().split()))
    if order[0] == 'push_front':
        a.appendleft(int(order[1]))
    elif order[0] == 'push_back':
        a.append(int(order[1]))
    elif order[0] == 'pop_front':
        if a:
            print(a.popleft())
        else:
            print(-1)
    elif order[0] == 'pop_back':
        if a:
            print(a.pop())
        else:
            print(-1)
    elif order[0] == 'size':
        print(len(a))
    elif order[0] == 'empty':
        if a:
            print(0)
        else:
            print(1)
    elif order[0] == 'front':
        if a:
            print(a[0])
        else:
            print(-1)
    else:
        if a:
            print(a[-1])
        else:
            print(-1)