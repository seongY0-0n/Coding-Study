def solution(survey, choices):
    dict={"A":0,"N":0, "R":0, "T":0, "C":0, "F":0, "J":0, "M":0}
    answer = ''
    for s, c in zip(survey, choices):
        if c > 4:
            dict[s[1]] += c-4
        elif c<4:
            dict[s[0]] += 4-c
    
        
    if dict["R"]>=dict["T"]:
        answer += "R"
    else:
        answer += "T"
        
    if dict["C"]>=dict["F"]:
        answer += "C"
    else:
        answer += "F"
        
    if dict["J"]>=dict["M"]:
        answer += "J"
    else:
        answer += "M"
        
    if dict["A"]>=dict["N"]:
        answer += "A"
    else:
        answer += "N"
    return answer