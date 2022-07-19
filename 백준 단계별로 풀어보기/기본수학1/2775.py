T = int(input())

for _ in range(T):
    k = int(input())
    n = int(input())
    num_list = [ x for x in range (1,n+1)]
    for i in range(k):
        for j in range(1,n):
            num_list[j] = num_list[j] + num_list[j-1]
    print(num_list[-1])