def solution(citations):
    citations.sort(reverse = True) #논문 인용 횟수 리스트를 역정렬
    answer = 0
    for i in range(len(citations)): #가장 인용횟수가 많은 논문부터 돌게 됨
        if citations[i] > answer: #만약 i번째로 인용횟수가 많은 논문의 횟수가 현재 h-index보다 많다면
            answer = i+1
#index는 지금까지 돈 논문의 갯수로 고친다. 반복하다보면 그 이하의 논문들은 알아서 밑에 깔리게 된다(역정렬 했으므로)
        else:
            break
    return answer
    
    