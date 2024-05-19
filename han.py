def han(n, s, d, a):
    if n == 1:
        print("move disk 1 from source", s, " to destination", d)
        return
    han(n-1, s, a, d)
    print("move disk", n, "from source", s, " to destination", d)
    han(n-1, a, d, s)

han(2, 'A', 'B', 'C')