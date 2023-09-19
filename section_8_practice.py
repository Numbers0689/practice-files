class IntSet(object):
    """"An IntSet is a set of integers"""

    # value of the set is represented by a list of ints, self.vals
    # each int in the set occurs in self.vals exactly once.

    def __init__(self):
        """"creates an empty set of ints"""
        self.vals = []

    def insert(self, e):
        if e not in self.vals:
            self.vals.append(e)

    def member(self, e):
        return e in self.vals

    def remove(self, e):
        try:
            self.vals.remove(e)
        except ValueError:
            raise ValueError(str(e) + " not found")

    def get_members(self):
        return self.vals[:]

    def __str__(self):
        self.vals.sort()
        result = ''

        for e in self.vals:
            result += str(e) + ","
        return '{' + result[:-1] + '}'
