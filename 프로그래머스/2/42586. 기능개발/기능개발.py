def solution(progresses, speeds):
    answer = []
    complete = []
    for i in range(len(speeds)):
        day = (100 - progresses[i]) // speeds[i]
        if (100 - progresses[i]) % speeds[i] != 0:
            day += 1
        complete.append(day)
    complete.reverse()
    c = complete.pop()
    d = 1
    while complete:
        n = complete.pop()
        if c < n:
            answer.append(d)
            c = n
            d = 1
        else:
            d += 1
    answer.append(d)
        
    return answer