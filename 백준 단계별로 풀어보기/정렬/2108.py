from operator import index
import sys
from collections import Counter
N = int(sys.stdin.readline())

arr=list()

for i in range(N):
    arr.append(int(sys.stdin.readline()))

print(round(sum(arr)/N))
arr.sort()
nums_s = Counter(arr).most_common()
print(arr[int(N/2)])

if len(nums_s) > 1:
    if nums_s[0][1] == nums_s[1][1]:
        print(nums_s[1][0])
    else:
        print(nums_s[0][0])
else:
    print(nums_s[0][0])
print(max(arr)-min(arr))