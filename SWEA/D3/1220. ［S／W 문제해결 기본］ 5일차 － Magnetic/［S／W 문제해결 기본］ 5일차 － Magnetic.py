for tc in range(1, 11):
    N = int(input())

    NS = [list(map(int, input().split())) for _ in range(N)]

    result = 0
    for i in range(N):
        flag = False
        for j in range(N):
            if NS[j][i] == 1:
                flag = True
            if flag and NS[j][i] == 2:
                result +=1
                flag = False

    print(f'#{tc} {result}')
