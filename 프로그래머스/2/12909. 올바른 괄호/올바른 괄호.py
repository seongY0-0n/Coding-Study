def solution(s):
    answer = True
    
    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    num = 0
    for i in s:
        if i == '(':
            num += 1
        else:
            if num == 0 :
                return False
            else:
                num -= 1
    if num == 0:
        return True
    else:
        return False