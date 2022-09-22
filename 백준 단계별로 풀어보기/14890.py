N, L = map(int, input().split())

Map = list()

for i in range(N):
    Map.append(list(map(int,input().split())))

count = 0

def check(arr):
    visited = [False]*N
    for i in range(N-1):
        if arr[i] == arr[i+1]:
            continue
        
        if abs(arr[i] - arr[i+1])>1:
            return False
        
        if arr[i] > arr[i+1]:
            
            for j in range(i+1, i+1+L):
                if j<N:
                    if arr[j] != arr[i] -1:
                        return False
                    if visited[j] == True:
                        return False
                    visited[j] = True
                else:
                    return False
        else:
            for j in range(i, i-L,-1):
                if 0 <= j :
                    if arr[j] != arr[i]:
                        return False
                    if visited[j] == True: 
                        return False
                    visited[j] = True
                else:
                    return False
    return True

for i in Map:
    if check(i):
        count +=1

for i in range(N):
    temp = list()
    for j in range(N):
        temp.append(Map[j][i])
    if check(temp):
        count+=1
print(count)
