N = int(input())
rgb = []

for _ in range(N):
    rgb.append(list(map(int, input().split())))

dp = list([0, 0, 0] for _ in range(1001))

dp[1][0] = rgb[0][0]
dp[1][1] = rgb[0][1]
dp[1][2] = rgb[0][2]

for i in range(2, N + 1):
    dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + rgb[i - 1][0]
    dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + rgb[i - 1][1]
    dp[i][2] = min(dp[i - 1][1], dp[i - 1][0]) + rgb[i - 1][2]

print(min(dp[N]))