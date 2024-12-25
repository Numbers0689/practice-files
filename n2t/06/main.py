import sys
import re

def main():
    filename = sys.argv[1]
    file = open(filename, 'r')
    lines = file.read().split('\n')
    
    for line in lines:
        re.sub(r"\s+\t", "", line) 
        print(line)
        



main()