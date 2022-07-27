import math
N = int(input())

r = "".join(reversed(str(math.factorial(N))))
count = 0
for i in r:
    if i=='0':
        count+=1
    else:
        break

print(count)