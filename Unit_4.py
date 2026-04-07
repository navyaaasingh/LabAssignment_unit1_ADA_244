N = 4

def print_board(board):
    for i in range(N):
        for j in range(N):
            print(board[i][j], end=" ")
        print()


def is_valid(board, row, col):
    # check left row
    for i in range(col):
        if board[row][i]:
            return False

    # upper diagonal
    i, j = row, col
    while i >= 0 and j >= 0:
        if board[i][j]:
            return False
        i -= 1
        j -= 1

    # lower diagonal
    i, j = row, col
    while i < N and j >= 0:
        if board[i][j]:
            return False
        i += 1
        j -= 1

    return True


def solve_n_queen(board, col):
    if col >= N:
        return True

    for i in range(N):
        if is_valid(board, i, col):
            board[i][col] = 1

            if solve_n_queen(board, col + 1):
                return True

            board[i][col] = 0  # backtrack

    return False


def check_solution():
    board = [[0]*N for _ in range(N)]

    if not solve_n_queen(board, 0):
        print("Solution does not exist")
        return False

    print_board(board)
    return True


# main
check_solution()