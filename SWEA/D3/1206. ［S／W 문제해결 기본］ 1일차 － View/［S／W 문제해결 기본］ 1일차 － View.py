for tc in range(1, 11):
    N = int(input())
    result = 0
    building = list(map(int, input().split()))
    for i in range(2, N - 2):
        if max(building[i - 2:i + 3]) == building[i]:
            result += building[i] - max(max(building[i - 2], building[i - 1]), max(building[i + 1], building[i + 2]))

    print(f'#{tc} {result}')
