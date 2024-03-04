import sys
a1, b1 = map(int, sys.stdin.readline().split())
a2, b2 = map(int, sys.stdin.readline().split())

def gcd(a,b):
    while b > 0:
        a, b = b, a % b
    
    return a

lem = b1 * b2 // gcd(b1,b2)

a3 = a1*lem//b1+a2*lem//b2
b3 = lem

result = gcd(a3,b3)
print(a3//result, b3//result)