import sys

num = int(input())

dic = {}

for i in range(num):
    dic[i+1] = set()

m = int(input())

for i in range(m):
    a,b = map(int, sys.stdin.readline().split())
    dic[a].add(b)
    dic[b].add(a)

visited = list()

def dfs(i,dic):
    for j in dic[i]:
        if j not in visited:
            visited.append(j)
            dfs(j,dic)

dfs(1,dic)
print(len(visited)-1)