x, y, w, h = map(int, input().split())
arr = list()
arr.append(x)
arr.append(y)
arr.append(w-x)
arr.append(h-y)
print(min(arr))