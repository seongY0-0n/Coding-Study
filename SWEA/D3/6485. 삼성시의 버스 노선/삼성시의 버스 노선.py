tc = int(input())

for t in range(1, tc + 1):
    N = int(input())
    arr = list()
    result = []
    for _ in range(N):
        a, b = map(int, input().split())
        arr.append([a, b])

    P = int(input())
    arr2 = list()
    for _ in range(P):
        c = int(input())
        arr2.append(c)

    for i in arr2:
        temp = 0
        for j in arr:
            if j[0] <= i <= j[1]:
                temp += 1
        result.append(temp)

    print(f'#{t} ', end='')
    print(*result)