temp = 0
Average = 0
Ratings = {'A+':4.5, 'A0':4.0,'B+':3.5, 'B0':3.0,'C+':2.5, 'C0':2.0,'D+':1.5, 'D0':1.0,'F':0.0}

for _ in range(20):
  Subject, Grade, Rating = map(str, input().split())
  if Rating == 'P':
    continue
  Average += int(Grade[0]) * Ratings[Rating]
  temp += int(Grade[0])

print(Average/temp)

