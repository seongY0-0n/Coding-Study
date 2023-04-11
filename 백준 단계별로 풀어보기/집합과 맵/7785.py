n = int(input())
dic = dict()
arr = list()

for i in range(n):
    name, state = map(str, input().split())
    dic[name] = state

for key, val in dic.items():
    if val == 'enter':
        arr.append(key)

arr.sort()

while arr:
    print(arr.pop())
