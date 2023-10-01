#! python3
# password manager program, 1st chapter project of ABSP

import sys
import pyperclip

PASSWORDS = {'email': 'F7minlBDDuvMJuxESSKHFhTxFtjVB6',
             'blog': 'VmALvQyKAxiVH5G8v01if1MLZF3sdt',
             'luggage': '12345'}

if len(sys.argv) < 2:
    print("Usage: python pw.py [account] - copies password")
    sys.exit()

account = sys.argv[1]

if account in PASSWORDS:
    pyperclip.copy(PASSWORDS[account])
    print("password for " + account + " has been copied to the clipboard")

else:
    print("this account has not been added to the password manager")
