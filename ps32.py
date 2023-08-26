import math
import random
import string

VOWELS = 'aeiou'
CONSONANTS = 'bcdfghjklmnpqrstvwxyz'
HAND_SIZE = 7

SCRABBLE_LETTER_VALUES = {
    'a': 1, 'b': 3, 'c': 3, 'd': 2, 'e': 1, 'f': 4, 'g': 2, 'h': 4, 'i': 1, 'j': 8, 'k': 5, 'l': 1, 'm': 3, 'n': 1,
    'o': 1, 'p': 3, 'q': 10, 'r': 1, 's': 1, 't': 1, 'u': 1, 'v': 4, 'w': 4, 'x': 8, 'y': 4, 'z': 10
}

wordlist_filename = 'words.txt'


def load_words(filename):
    print("Loading word list from file .......")
    wordlist = []
    input_file = open(filename, 'r')
    for line in input_file:
        wordlist.append(line.strip().lower())

    print("   " + str(len(wordlist)) + " words loaded.")
    return wordlist


def get_frequency_dict(sequence):
    freq = {}
    for x in sequence:
        freq[x] = freq.get(x, 0) + 1
    return freq


def get_word_score(word, n):
    x = 0
    for i in str.lower(word):
        x += SCRABBLE_LETTER_VALUES[i]

    y = 1
    z = 7*len(word) - 3*(n - len(word))
    if z > 1:
        y = z

    return x*y


def display_hand(hand):
    for letter in hand.keys():
        for j in range(hand[letter]):
             print(letter, end=' ')
    print()


def deal_hand(n):
    hand = {}
    num_vowels = int(math.ceil(n / 3))

    for i in range(num_vowels):
        x = random.choice(VOWELS)
        hand[x] = hand.get(x, 0) + 1

    for i in range(num_vowels, n):
        x = random.choice(CONSONANTS)
        hand[x] = hand.get(x, 0) + 1

    return hand

def update_hand(hand, word):
