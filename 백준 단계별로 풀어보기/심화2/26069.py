N = int(input())
count = set()
count.add('ChongChong')
for i in range(N):
    A, B = map(str, input().split())

    if A in count:
        count.add(B)
    elif B in count:
        count.add(A)

print(len(count))
