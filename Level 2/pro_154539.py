numbers = [9, 1, 5, 3, 6, 2]


def solution(numbers):
    answer = []

    for i in range(len(numbers)):
        a = numbers[i]
        for j in numbers[i:]:
            if j > a:
                answer.append(j)
                break
        else:
            answer.append(-1)

    return answer


solution(numbers)
