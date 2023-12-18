def solution(arr):
    answer = []
    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    temp = 10
    while arr:
        a = arr.pop()
        if temp != a:
            answer.append(a)
            temp = a
    answer.reverse()
    return answer