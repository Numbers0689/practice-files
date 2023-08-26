# Problem Set 4A
# Name: <your name here>
# Collaborators:
# Time Spent: x:xx

def get_permutations(sequence):
    """
    Enumerate all permutations of a given string

    sequence (string): an arbitrary string to permute. Assume that it is a
    non-empty string.

    You MUST use recursion for this part. Non-recursive solutions will not be
    accepted.

    Returns: a list of all permutations of sequence

    Example:
    >>> get_permutations('abc')
    ['abc', 'acb', 'bac', 'bca', 'cab', 'cba']

    Note: depending on your implementation, you may return the permutations in
    a different order than what is listed here.
    """
    permutations = []
    if len(sequence) == 1:
        permutations.append(sequence)
        return permutations
    else:
        permutations = get_permutations(sequence[1:])
        permutations_new = []
        for element in permutations:
            for pos in range(0, len(element)+1):
                new_p = element[:pos] + sequence[0] + element[pos:]
                permutations_new.append(new_p)
        return permutations_new


if __name__ == '__main__':
    # EXAMPLE
    example_input = 'abc'
    print('Input:', example_input)
    print('Expected Output:', ['abc', 'acb', 'bac', 'bca', 'cab', 'cba'])
    print('Actual Output:', get_permutations(example_input))
