def solution(park, routes):
    N = len(park)
    M = len(park[0])
    for i in range(N):
        for j in range(M):
            if park[i][j] == 'S':
                x,y = j,i
                break

    for i in routes:
        ex ,ey = x,y
        
        for s in range(int(i[2])):
            if i[0] == 'E' and ex != M-1 and park[ey][ex+1] != 'X':
                ex+=1
                if s == int(i[2])-1:
                    x=ex
            elif i[0] == 'W' and ex != 0 and park[ey][ex-1] != 'X':
                ex-=1
                if s == int(i[2])-1:
                    x=ex
            elif i[0] == 'S' and ey != N-1 and park[ey+1][ex] != 'X':
                ey+=1
                if s == int(i[2])-1:
                    y=ey
            elif i[0] == 'N' and ey != 0 and park[ey-1][ex] != 'X':
                ey-=1
                if s == int(i[2])-1:
                    y=ey
        
    return [y,x]