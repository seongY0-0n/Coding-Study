A,B = map(int, input().split())

a = set()
b = set()
for i in range(1,A+1):
    if A%i==0:
        a.add(i)
        
for i in range(1,B+1):
    if B%i==0:
        b.add(i)
result1 = max(list(a&b))
print(result1)
print(result1*(A//result1)*(B//result1))