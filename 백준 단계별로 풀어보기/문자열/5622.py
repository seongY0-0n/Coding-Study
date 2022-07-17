S = input()
result =0
A ='ABC DEF GHI JKL MNO PQRS TUV WXYZ'

arr = A.split()
for s in S:
    for i in range(len(arr)):
        if s in arr[i]:
            result += (i+3)

print(result)