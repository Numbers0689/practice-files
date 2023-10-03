#! python3
# bulletinadder.py - adds bulletins to a list

import pyperclip

text = pyperclip.paste()
lines = text.split('\n')
print(lines)

for i in range(len(lines)):
    lines[i] = '*' + lines[i]

text = '\n'.join(lines)
pyperclip.copy(text)
