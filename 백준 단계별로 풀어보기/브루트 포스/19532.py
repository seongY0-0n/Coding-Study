a, b, c, d, e, f = map(int, input().split())


print(int((c*e-f*b)/(a*e-d*b)),
      int((d*c-a*f)/(b*d-e*a)))
