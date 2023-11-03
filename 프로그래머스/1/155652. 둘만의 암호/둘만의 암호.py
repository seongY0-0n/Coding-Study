def solution(s, skip, index):
    alpha = 'abcdefghijklmnopqrstuvwxyz'
    answer = ''
    alpha_num = 26 - len(skip)

    for i in skip:
        alpha = alpha.replace(i, '')

    for i in s:
        temp = alpha.index(i)
        temp = temp + index
        temp = temp % alpha_num
        answer+=alpha[temp]

    return answer
