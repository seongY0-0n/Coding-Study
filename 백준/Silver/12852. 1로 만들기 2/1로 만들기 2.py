N = int(input())

dp = [0] * 1000001
pre = [0] * 1000001
for i in range(2, N + 1):
    if i % 3 == 0:
        if i % 2 == 0:
            dp[i] = min(dp[i // 3], dp[i // 2], dp[i - 1]) + 1
            if dp[i // 3] == min(dp[i // 3], dp[i // 2], dp[i - 1]):
                pre[i] = i // 3
            elif dp[i // 2] == min(dp[i // 3], dp[i // 2], dp[i - 1]):
                pre[i] = i // 2
            else:
                pre[i] = i - 1
        else:
            dp[i] = min(dp[i // 3], dp[i - 1]) + 1
            if dp[i // 3] == min(dp[i // 3], dp[i - 1]):
                pre[i] = i // 3
            else:
                pre[i] = i - 1
    elif i % 2 == 0:
        dp[i] = min(dp[i // 2], dp[i - 1]) + 1
        if dp[i // 2] == min(dp[i // 2], dp[i - 1]):
            pre[i] = i // 2
        else:
            pre[i] = i - 1
    else:
        dp[i] = dp[i - 1] + 1
        pre[i] = i - 1

print(dp[N])
while N != 1:
    print(N, end=' ')
    N = pre[N]
print(1)