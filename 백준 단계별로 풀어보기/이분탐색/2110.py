n, c = map(int, input().split())

home = list()

for i in range(n):
    home.append(int(input()))
    
home.sort()

print(home)