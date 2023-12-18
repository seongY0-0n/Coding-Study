def solution(priorities, location):
    answer = 1
    pointer = priorities.index(max(priorities))
    priorities[pointer] = 0
    if pointer == location:
        return answer
    while True:
        pointer += 1
        if pointer == len(priorities):
            pointer = 0
        if priorities[pointer] == max(priorities):
            answer += 1
            priorities[pointer] = 0
            if pointer == location:
                break
        
        
    return answer