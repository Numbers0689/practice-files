r = int(input("enter row: "))
c = int(input("enter col: "))
print("enter matrix1: ")
mat1 = [[int(input()) for x in range(c)] for y in range(r)]

mat2=mat1
res = [[0 for x in range(c)] for y in range(r)]

for i in range(len(mat1)):
    for j in range(len(mat2[0])):
        for k in range(len(mat2)):
            res[i][j] += mat1[i][k] * mat2[k][j]

for row in res:
    print(row)