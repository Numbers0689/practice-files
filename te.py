import tkinter as tk

r = tk.Tk()
r.title("blah blah")
r.geometry("800x450")


def display():
    total = 0
    mapE()


def mapE(E, ro, c, marks, credit):
    if E.get() == 'A':
        tk.Label(r, text=str(marks)).grid(row=ro, column=c)
        total += marks
    if E.get() == 'B':
        tk.Label(r, text=str(marks - (credit))).grid(row=ro, column=c)
        total += marks - (credit)
    if E.get() == 'C':
        tk.Label(r, text=str(marks - (credit * 2))).grid(row=ro, column=c)
        total += marks - (credit * 2)
    if E.get() == 'D':
        tk.Label(r, text=str(marks - (credit * 3))).grid(row=ro, column=c)
        total += marks - (credit * 3)

r.mainloop()