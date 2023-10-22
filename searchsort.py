# linear search where the order of growth is linear, O(n) where n is len(L) 
def linear_search(L, e):
    found = False
    for i in range(len(L)):
        if e == L[i]:
            found = True

    return found
        

#linear search on sorted list, worst case still linear.
def search(L,e):
    for i in range(len(L)):
        if L[i] == e:
            return True
        elif L[i] > e:
            return False

    return False
    

#bisectional search. its log linear, O(log n) where n is len(L) 
def bisectional_search(L, e):
    def bisectional_search_helper(L, e, low, high):
        if high == low:
            return L[low] == e
        mid = (low + high) // 2

        if L[mid] == e:
            return True
        elif L[mid] > e:
            if low == mid: #nothing left to search
                return False
            else:
                return bisectional_search_helper(L, e, low, mid-1)
        else:
            return bisectional_search_helper(L, e, mid+1, high)    

    if len(L) == 0:
        return False
    else:
        return bisectional_search_helper(L, e, 0, len(L)-1)


# sorting is linear complexity too and often the no. searches done on a sorted list cover for that.

#bubble sort - O(n**2)    

def bubble_sort(L):
    swap = False
    while not swap:
        swap = True
        for j in range(1, len(L)):
            if L[j-1] > L[j]:
                swap = False
                temp = L[j]
                L[j] = L[j-1]
                L[j-1] = temp



test = [5, 4, 2, 7, 11, 6, 1]

print(bubble_sort(test))
print(test)
