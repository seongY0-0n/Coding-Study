def solution(keymap, targets):
    answer = []
    for target in targets:
        result = 0
        for t in target:
            possible = False
            temp = 101
            for key in keymap:
                if t in key:
                    temp = min(key.index(t)+1, temp)
                    possible = True
            if not possible:
                result = -1
                break
            result += temp

        answer.append(result)

    return answer
