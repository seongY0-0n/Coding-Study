def solution(wallpaper):
    i_list = list()
    j_list = list()
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[0])):
            if wallpaper[i][j] == '#':
                i_list.append(i)
                j_list.append(j)
    return [min(i_list), min(j_list), max(i_list)+1, max(j_list)+1]