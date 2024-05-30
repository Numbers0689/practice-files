py=[]

for i in range(4):
    py.append([])
    for j in range(i+1):
        if j==0 or j==i:
            py[i].append(1)
        else:
            py[i].append(sum(py[i-1][j-1:j+1]))
