x, y, n = 10, 40, 5


def solution(x, y, n):
    answer = 0
    dp = set()
    dp.add(x)

    while dp:
        if y in dp:
            return answer
        else:
            nxt = set()
            for i in dp:
                if i + n <= y:
                    nxt.add(i+n)
                if i * 2 <= y:
                    nxt.add(i*2)
                if i * 3 <= y:
                    nxt.add(i*3)
        answer += 1
        dp = nxt
    return -1


solution(10, 40, 30)
