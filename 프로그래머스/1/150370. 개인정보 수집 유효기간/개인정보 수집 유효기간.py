def solution(today, terms, privacies):
    ty, tm, td = today.split('.')

    dict = {}
    answer = []
    for t in terms:
        a, b = t.split(' ')
        dict[a] = b

    for idx, p in enumerate(privacies):
        type = p[-1]
        p = p[:-2]
        y, m, d = p.split('.')
        y = int(y) + (int(m) + int(dict[type])-1)//12
        m = (int(m) + int(dict[type])) % 12
        if m == 0:
            m = 12

        if int(y) > int(ty):
            continue
        elif int(y) == int(ty):
            if int(m) > int(tm):
                continue
            elif int(m) == int(tm):
                if int(d) > int(td):
                    continue
        answer.append(idx+1)
    return answer
