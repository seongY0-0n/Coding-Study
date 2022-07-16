T = int(input())
arr = list()
score = 1
result = 0

output = list()
for i in range(T):
    arr=input()
    for j in range(len(arr)):
        if arr[j] == 'O' :
            result += score
            score += 1
        else:
            score = 1
    output.append(result)
    score = 1
    result = 0
    
for i in range(len(output)):
    print(output[i])
