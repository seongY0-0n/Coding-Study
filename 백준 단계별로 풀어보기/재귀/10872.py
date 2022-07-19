N = int(input())

def pact(N):
    if N == 0:
        return 1
    return N * pact(N-1)

print(pact(N))