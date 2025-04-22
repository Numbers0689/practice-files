getint = lambda: int(input())
getints = lambda: map(int, input().split())

def serval():
    n, k = getints()
    s = input().strip()

    if s < s[::-1] or (k >= 1 and (max(s) != min(s))):
        print("YES")
    else:
        print("NO")

t = getint()
for _ in range(t):
	serval()