N = int(input())

for i in range(N):
    print("{}{}".format(" "*(N-i-1), "*"*(i+1)))