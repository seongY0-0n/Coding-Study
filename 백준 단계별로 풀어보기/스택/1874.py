n = int(input())
stack = list()
result = list()
cnt = 1
temp = 0

for i in range(n):
    num = int(input())
    while cnt <= num:
        stack.append(cnt)
        cnt+=1
        result.append('+')
    if stack[-1] == num:
        stack.pop()
        result.append('-')
    else:
        temp = 1
        break

if temp == 0:
    for i in result:
        print(i)
else:
    print('NO')