word = input().upper()
word_list = list(set(word))
count_list = list()

for s in word_list:
    count = word.count(s)
    count_list.append(count)

if count_list.count(max(count_list)) > 1:
    print('?')
else:
    print(word_list[count_list.index(max(count_list))])