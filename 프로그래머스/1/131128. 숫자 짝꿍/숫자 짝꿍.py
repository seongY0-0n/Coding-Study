def solution(X, Y):
    answer = ""
    inter_list = list(set(X)&set(Y))
    for s in inter_list:
        x_num = X.count(s)
        y_num = Y.count(s)
        if x_num > y_num:
            answer += s * y_num
        else:
            answer += s * x_num
    answer = list(answer)
    answer.sort(reverse = True)
    answer = "".join(answer)
    if answer == "":
        answer = "-1"
    elif len(answer) == answer.count("0"):
        answer ="0"
    return answer