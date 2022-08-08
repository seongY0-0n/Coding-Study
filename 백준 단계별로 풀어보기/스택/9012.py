from os import remove
import sys

T = int(input())
result = list
for i in range(T):
    arr = str(input())
    count = 0
    b=0
    for j in range(len(arr)):
        a = arr[-1]
        arr = arr[:-1]
        if a ==')':
            count+=1
        else:
            if count == 0:
                b=1
                break
            else:
                count-=1
    if count == 0 and b==0:
        print('YES')
    elif b==1:
        print('NO')
    else:
        print('NO')
    
            
                
        
        
    
    