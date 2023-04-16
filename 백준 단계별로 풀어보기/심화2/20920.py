N, M = map(int, input().split())
memo = dict()
for i in range(N):
    word = input()
    if len(word) < M:
        continue
    if word in memo:
        memo[word] += 1
    else:
        memo[word] = 1


memo_list = sorted(memo.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))

for i in memo_list:
    print(i[0])
