import random
import string


def load_words(filename):
    print("Loading word list from a file")
    words = []
    input_file = open(filename, 'r')
    for line in input_file:
        words = line.split()

    print("  " + str(len(words)) + " words loaded")
    print()
    return words


def choose_word(words):
    return random.choice(words)


def is_word_guessed(secret_word, letters_guessed):
    for i in range(len(secret_word)):
        if secret_word[i] not in letters_guessed:
            return False

    return True


def get_guessed_word(secret_word, letters_guessed):
    output = ""
    for i in range(len(secret_word)):
        if secret_word[i] in letters_guessed:
            output += secret_word[i]
        else:
            output += "_ "

    return output


def get_available_letters(letters_guessed):
    alpha = string.ascii_lowercase
    letter_list = []
    for i in range(len(alpha)):
        letter_list.append(alpha[i])
    for i in letters_guessed:
        if i in letter_list:
            letter_list.remove(i)
    final = ""
    for i in letter_list:
        final += i

    return final


def warning_message(warnings):
    if warnings < 0:
        print("Oops that's not a valid letter. You have no warnings left. so you lose a guess.")
    else:
        print("Oops that's not a valid letter. You have " + str(warnings) + " warnings left.")
    return


def warning_message2(warnings):
    if warnings < 0:
        print("You have no warnings left. so you lose a guess.")
    else:
        print("You have " + str(warnings) + " warnings left.")
    return


def vowels(word):
    vowel_list = []
    for i in "aeiou":
        if i not in word:
            vowel_list.append(i)

    return vowel_list


def consonants(word):
    con_list = []
    for i in "bcdfghjklmnpqrstvwxyz":
        if i not in word:
            con_list.append(i)

    return con_list


def unique(word):
    unique_count = 0
    for i in string.ascii_lowercase:
        if i in word:
            unique_count += 1

    return unique_count


def hangman(secret_word):
    print("Welcome to the game of Hangman!!")
    print("I'm thinking of a word that is " + str(len(secret_word)) + " letters long.")
    print("You've 3 warnings left.")
    print("-------------------")
    guesses = 6
    warnings = 3

    while True:
        print("You have " + str(guesses) + " guesses left.")
        print("Available letters: " + get_available_letters(letters__guessed))
        guess = input("Please guess a letter: ")

        if str.isalpha(guess):
            if guess in letters__guessed:
                print("Oops! you have already guessed that letter: " + get_guessed_word(secret_word, letters__guessed))
                guesses += 1
                warnings -= 1
                if warnings < 0:
                    guesses -= 1
                warning_message2(warnings)
            elif (guess not in letters__guessed) and (guess in secret_word):
                letters__guessed.append(str.lower(guess))
                print("Good guess: " + get_guessed_word(secret_word, letters__guessed))
                if is_word_guessed(secret_word, letters__guessed):
                    print("-------------------")
                    print("Congratulations! You won!")
                    total = guesses * unique(secret_word)
                    print("Your total score for this game is:", total)
                    break
                guesses += 1
            else:
                print("Oops, the letter's not in the word: " + get_guessed_word(secret_word, letters__guessed))
                if guess in vowels(secret_word):
                    guesses -= 1
                letters__guessed.append(guess)

        else:
            warnings -= 1
            guesses += 1
            if warnings < 0:
                guesses -= 1
            warning_message(warnings)

        guesses -= 1
        print("-------------------")

        if guesses <= 0:
            print("Sorry, you ran out of guesses. The word was:", secret_word)
            break

    return


def match_with_gaps(my_word, other_word):
    output = ""
    for i in my_word:
        if i == " ":
            pass
        else:
            output += i

    if len(output) != len(other_word):
        return False
    else:
        for i in range(len(output)):
            if output[i] != "_" and output[i] != other_word[i]:
                return False
            elif other_word[i] in output and output[i] == "_":
                return False

    return True


def show_possible_matches(my_word):
    possible = []
    for word in wordlist:
        if match_with_gaps(my_word,word):
            possible.append(word)
    if len(possible) == 0:
        print("No possible matches")
    else:
        print(possible)
    return


def hangman_with_hints(secret_word):
    print("Welcome to the game of Hangman!!")
    print("I'm thinking of a word that is " + str(len(secret_word)) + " letters long.")
    print("You've 3 warnings left.")
    print("-------------------")
    guesses = 6
    warnings = 3

    while True:
        print("You have " + str(guesses) + " guesses left.")
        print("Available letters: " + get_available_letters(letters__guessed))
        guess = input("Please guess a letter: ")

        if str.isalpha(guess):
            if guess in letters__guessed:
                print("Oops! you have already guessed that letter: " + get_guessed_word(secret_word, letters__guessed))
                guesses += 1
                warnings -= 1
                if warnings < 0:
                    guesses -= 1
                warning_message2(warnings)
            elif (guess not in letters__guessed) and (guess in secret_word):
                letters__guessed.append(str.lower(guess))
                print("Good guess: " + get_guessed_word(secret_word, letters__guessed))
                if is_word_guessed(secret_word, letters__guessed):
                    print("-------------------")
                    print("Congratulations! You won!")
                    total = guesses * unique(secret_word)
                    print("Your total score for this game is:", total)
                    break
                guesses += 1
            else:
                print("Oops, the letter's not in the word: " + get_guessed_word(secret_word, letters__guessed))
                if guess in vowels(secret_word):
                    guesses -= 1
                letters__guessed.append(guess)

        elif guess == "*":
            show_possible_matches(get_guessed_word(secret_word, letters__guessed))
            guesses += 1

        else:
            warnings -= 1
            guesses += 1
            if warnings < 0:
                guesses -= 1
            warning_message(warnings)

        guesses -= 1
        print("-------------------")

        if guesses <= 0:
            print("Sorry, you ran out of guesses. The word was:", secret_word)
            break

    return


if __name__ == "__main__":
    wordlist = load_words('words.txt')
    secret__word = choose_word(wordlist)
    letters__guessed = []
    # print(match_with_gaps("a_ ple", "ample"))
    # hangman(secret__word)
    hangman_with_hints(secret__word)
