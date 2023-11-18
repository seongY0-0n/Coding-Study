T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    price = [list(map(int, input())) for _ in range(N)]
    result = 0
    for i in range(N // 2 -1, -1, -1):
        result += sum(price[i][N // 2 - i: N // 2 + i + 1])
        result += sum(price[N -1 -i][N//2-i:N//2 + i+1])

    result += sum(price[N//2])
    print(f'#{tc} {result}')