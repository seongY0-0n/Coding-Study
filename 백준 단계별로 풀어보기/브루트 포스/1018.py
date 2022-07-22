n,m = map(int, input().split(' '))
board = []
for _ in range(n):
    board.append(input())

cnt = 8*8
for i in range(n):
    if n-i>=8:
        for j in range(m):
            chk1 = 0
            chk2 = 0
            if m-j>=8:
                no = 0
                for n1 in range(i,i+8):
                    for n2 in range(j,j+8):
                        if no%2==0:
                            if board[n1][n2] != 'W':
                                chk1+=1
                            if board[n1][n2] != 'B':
                                chk2+=1
                        else:
                            if board[n1][n2] != 'B':
                                chk1+=1
                            if board[n1][n2] != 'W':
                                chk2+=1
                        no+=1
                    no+=1   

                cnt = min(cnt,chk1,chk2)
print(cnt)
