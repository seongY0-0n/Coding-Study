TC = int(input())

for tc in range(TC):
    N = int(input())
    S = input()
    if N % 2 == 1:
        print(f'#{tc+1} No')
    else:
        if S[:N//2]==S[N//2:]:
            print(f'#{tc + 1} Yes')
        else:
            print(f'#{tc + 1} No')