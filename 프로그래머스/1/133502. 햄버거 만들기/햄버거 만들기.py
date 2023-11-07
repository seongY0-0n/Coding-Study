def solution(ingredient):
    answer=0
    hbg = list()
    for i in ingredient:
        hbg.append(i)
        if len(hbg) > 3:
            if hbg[-4:] == [1,2,3,1]:
                answer+=1
                del hbg[-4:]

    return answer
