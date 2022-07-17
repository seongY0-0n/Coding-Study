N = int(input())
arr = list()

error = 0
result = 0
for i in range(N):
    arr.append(input())


for s in arr:
    unq_N = list(set(s))
    for j in range(len(s)-1):
        if s[j] != s[j+1]:
            if s[j] in unq_N:
                unq_N.remove(s[j])
            else: 
                error += 1
    if s[-1] not in unq_N:
        error +=1
    
    if error == 0:
        result +=1
    error = 0
        
print(result)    
                    
                
        
        