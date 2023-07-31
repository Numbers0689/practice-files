a = 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10
b = "abcdefghijklmnopqrstuvwxyz"
dict1 = dict(zip(b, a))


def compute_score(word):
    count_sum = 0
    for x in word.lower():
        count_sum += dict1[x]
    return count_sum


word_1 = input("player_1: ")
word_2 = input("player_2: ")

score_1 = compute_score(word_1)
score_2 = compute_score(word_2)

if score_1 > score_2:
    print("player_1 wins")
else:
    print("player_2 wins")
