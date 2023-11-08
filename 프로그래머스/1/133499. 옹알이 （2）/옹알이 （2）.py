def solution(babbling):
    answer = 0
    
    for b in babbling:
        flag = True
        temp = ""
        while b:
            if len(b)<2:
                flag = False
                break
            elif b[:2] == "ye" and temp != "ye":
                temp = "ye"
                b=b[2:]
            elif b[:2] == "ma" and temp !="ma":
                temp = "ma"
                b=b[2:]
            elif b[:3] == "aya" and temp != "aya":
                temp = "aya"
                b=b[3:]
            elif b[:3] == "woo" and temp != "woo":
                temp = "woo"
                b=b[3:]
            else:
                flag = False
                break
        if flag:
            answer+=1
    return answer