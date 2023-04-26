def solution(dirs):
    answer = 0
    pre = [0, 0]
    next = [0, 0]
    road = list()
    for i in dirs:
        if i == 'U':
            if pre[1] + 1 == 6:
                continue
            next[1] = pre[1]+1
        elif i == 'D':
            if pre[1] - 1 == -6:
                continue
            next[1] = pre[1]-1
        elif i == 'R':
            if pre[0] + 1 == 6:
                continue
            next[0] = pre[0]+1
        elif i == 'L':
            if pre[0] - 1 == -6:
                continue
            next[0] = pre[0]-1
        road.append(pre + next)
        road.append(next+pre)
        pre[0], pre[1] = next[0], next[1]

    result = []
    for i in road:
        if i not in result:
            result.append(i)

    answer = len(result)//2
    return answer


dirs = input()
solution(dirs)
