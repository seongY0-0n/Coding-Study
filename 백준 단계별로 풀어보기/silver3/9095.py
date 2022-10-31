t = int(input())
def num_count(n):
    if n == 1:
        return 1
    elif n == 2:
        return 2
    elif n == 3:
        return 4
    
    return num_count(n-1) + num_count(n-2) + num_count(n-3)

for i in range(t):
    n = int(input())
    print(num_count(n))
    

