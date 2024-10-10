#include <stdio.h>

#define N 9

void print_board(int board[N][N]) {
    for (int row = 0; row < N; row++) {
        for (int col = 0; col < N; col++) {
            printf("%d  ", board[row][col]);
        }
        printf("\n");
    }
}

int is_valid(int board[N][N], int row, int col, int num) {
    for (int x = 0; x < N; x++) {
        if (board[row][x] == num) {
            return 0;
        }
    }
    for (int x = 0; x < N; x++) {
        if (board[x][col] == num) {
            return 0;
        }
    }
    int startRow = row - row % 3, startCol = col - col % 3;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i + startRow][j + startCol] == num) {
                return 0;
            }
        }
    }
    return 1;
}

int solve_sudoku(int board[N][N]) {
    int row, col;
    int found_empty = 0;

    for (row = 0; row < N; row++) {
        for (col = 0; col < N; col++) {
            if (board[row][col] == 0) {
                found_empty = 1;
                break;
            }
        }
        if (found_empty) break;
    }

    if (!found_empty) return 1;

    for (int num = 1; num <= 9; num++) {
        if (is_valid(board, row, col, num)) {
            board[row][col] = num;

            if (solve_sudoku(board)) {
                return 1;
            }

            board[row][col] = 0;
        }
    }

    return 0; 
}

int main() {
    int board[N][N] = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };
    printf("unsolved sukodu: \n");
    print_board(board);
    printf("\n");
    if (solve_sudoku(board)) {
        printf("solved sudoku:\n");
        print_board(board);
    } else {
        printf("No solution exists\n");
    }
    return 0;
}
