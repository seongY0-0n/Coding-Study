# 25192번 인사성 밝은 곰곰이

N = int(input())
anw = 1
count = set()
for i in range(N):
    word = input()
    if word == 'ENTER':
        anw += len(count) - 1
        count = set()
    count.add(word)
anw += len(count) - 1
print(anw)
