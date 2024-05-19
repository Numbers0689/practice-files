def merges(arr):
    mid = int(len(arr)/2)
    left, right = arr[:mid], arr[mid:]

    if len(left) > 1:
        left = merges(left)
    if len(right) > 1:
        right = merges(right)

    res=[]
    while left and right:
        if left[-1] >= right[-1]:
            res.append(left.pop())
        else:
            res.append(right.pop())

    res.reverse()

    return (left or right) + res

arr= list(map(int, input("enter arr: ").split()))
print(merges(arr))
