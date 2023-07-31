
spam = ['apples', 'bananas', 'tofu', 'cats', "taeri", "sohee"]


def list_str(list_1):
    string_1 = ""
    for i in range(len(list_1)):
        if i == 0:
            string_1 = list_1[i]
        elif i == (len(list_1) - 1):
            string_1 = string_1 + " and " + list_1[i] + "."
        else:
            string_1 += ", " + list_1[i]

    print(string_1)


list_str(spam)
