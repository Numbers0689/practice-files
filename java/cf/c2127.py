def mex(triple):
    s = set(triple)
    i = 0
    while True:
        if i not in s:
            return i
        i += 1

def solve_case_fast(a):
    n = len(a)
    for i in range(n - 2):
        triple = a[i:i+3]
        if -1 not in triple:
            mn = min(triple)
            mx = max(triple)
            m = mex(triple)
            if m != mx - mn:
                return "NO"
    return "YES"

t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    print(solve_case_fast(a))
