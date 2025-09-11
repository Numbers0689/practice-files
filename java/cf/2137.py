import sys
input = sys.stdin.readline
for _ in range(int(input())):
    b,a = map(int,input().split())
    sol = -1
    if (a + b) & 1 == 0: sol = a + b
    if a % 2 == 1 and b % 2 == 1: sol = max(sol, a * b + 1)
    elif a % 2 == 0 and (a % 4 == 0 or b % 2 == 0): sol = max(sol, 2 + (a * b) // 2)
    print(sol)