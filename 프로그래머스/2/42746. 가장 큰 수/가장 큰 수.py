def solution(numbers):
    answer = ''
    numbers = [str(number)*3 for number in numbers]
    numbers.sort(reverse = True)
    for n in numbers:
        answer+= n[0:len(n)//3]
    
    return str(int(answer))