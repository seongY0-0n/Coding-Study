from collections import deque


def solution(cards1, cards2, goal):
    dq1 = deque(cards1)
    dq2 = deque(cards2)
    answer = ''

    prev1 = dq1.popleft()
    prev2 = dq2.popleft()

    for word in goal:
        if word == prev1:
            if dq1:
                prev1 = dq1.popleft()
        elif word == prev2:
            if dq2:
                prev2 = dq2.popleft()
        else:
            return 'No'
    return 'Yes'
