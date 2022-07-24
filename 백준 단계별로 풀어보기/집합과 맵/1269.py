N,M = map(int, input().split())

a = set(map(int, input().split()))

b = set(map(int, input().split()))
result = len(list((a-b).union(b-a)))
print(result)
