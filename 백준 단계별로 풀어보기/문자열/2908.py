A,B = map(str ,input().split())

A_list = list(A)
B_list = list(B)

A_list.reverse()
B_list.reverse()

A = ''.join(A_list)
B = ''.join(B_list)

print(max(int(A),int(B)))