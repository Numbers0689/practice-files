strr = input("enter a string: ")


def isPalin(strr):
    sl = len(strr)
    for i in range(sl):
        if strr[i] != strr[sl-i-1]:
            print("not palindrome")
            return
    print("yea palin")


def isSym(strr):
    half = int(len(strr)/2)
    if strr[:half] == strr[half:]:
        print("yes symmetrical")
        return
    print("not symmetrical")

isPalin(strr)
isSym(strr)