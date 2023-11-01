def solution(n, m, section):
    limit = section[0] + m - 1
    answer = 1
    for i in range(len(section)):
        if section[i] >limit:
            limit = section[i] + m - 1
            answer+=1

    return answer