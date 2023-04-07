while True:
    n = int(input())
    if n == -1:
        break
    temp = 0
    arr = list()
    for i in range(1, n):
        if n % i == 0:
            temp += i
            arr.append(str(i))
    anw = ''
    if temp == n:
        anw += str(n) + ' = ' + ' + '.join(arr)
    else:
        anw += str(n) + ' is NOT perfect.'
    print(anw)
