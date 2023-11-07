def solution(s):
    same = 1
    other = 0
    flag = True
    answer = 0
    for i in s:
        if flag:
            fst = i
            flag = False
        else:
            if i == fst:
                same += 1
            else:
                other += 1

            if same == other:
                same=1
                other=0
                answer += 1
                flag = True
    if not flag:
        answer+=1
    return answer