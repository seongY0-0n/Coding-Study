def solution(n):
    ans = 0

    while True:
        if n == 1:
            break
        if n % 2 == 1:
            ans += 1
        n = n//2

    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    return ans+1


N = int(input())
solution(N)
