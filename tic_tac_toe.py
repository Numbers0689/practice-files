the_board = {'top-L': ' ', 'top-M': ' ', 'top-R': ' ',
             'mid-L': ' ', 'mid-M': ' ', 'mid-R': ' ',
             'low-L': ' ', 'low-M': ' ', 'low-R': ' '}


def print_board(board_dict):
    print(board_dict['top-L'] + ' | ' + board_dict['top-M'] + ' | ' + board_dict['top-R'])
    print('--+---+--')
    print(board_dict['mid-L'] + ' | ' + board_dict['mid-M'] + ' | ' + board_dict['mid-R'])
    print('--+---+--')
    print(board_dict['low-L'] + ' | ' + board_dict['low-M'] + ' | ' + board_dict['low-R'])


turn = 'X'
for i in range(9):
    print_board(the_board)
    print("Turn for " + turn + ". Move to which space?")
    move = input()
    the_board[move] = turn
    if turn == 'X':
        turn = 'O'
    else:
        turn = 'X'


print_board(the_board)
