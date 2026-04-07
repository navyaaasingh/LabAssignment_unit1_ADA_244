#0/1 Knapsack problem 
def knapsack(W, wt, val, n):
    dp = [[0]*(W+1) for _ in range(n+1)]

    for i in range(1, n+1):
        for w in range(1, W+1):
            if wt[i-1] <= w:
                dp[i][w] = max(val[i-1] + dp[i-1][w-wt[i-1]], dp[i-1][w])
            else:
                dp[i][w] = dp[i-1][w]

    return dp[n][W]


#wxample
wt = [1, 3, 4, 5]
val = [1, 4, 5, 7]
W = 7
print(knapsack(W, wt, val, len(wt)))


#fractional knapsack problem 
def fractional_knapsack(W, items):
    items.sort(key=lambda x: x[1]/x[0], reverse=True)  # value/weight
    total = 0

    for wt, val in items:
        if W >= wt:
            W -= wt
            total += val
        else:
            total += val * (W / wt)
            break

    return total


#example 
items = [(10, 60), (20, 100), (30, 120)]
print(fractional_knapsack(50, items))


#matrix multiplication problem 
def matrix_multiply(A, B):
    result = [[0]*len(B[0]) for _ in range(len(A))]

    for i in range(len(A)):
        for j in range(len(B[0])):
            for k in range(len(B)):
                result[i][j] += A[i][k] * B[k][j]

    return result


# Example
A = [[1,2], [3,4]]
B = [[5,6], [7,8]]
print(matrix_multiply(A, B))


#Longest Common Subsequence (LCS) problem
def lcs(X, Y):
    m, n = len(X), len(Y)
    dp = [[0]*(n+1) for _ in range(m+1)]

    for i in range(1, m+1):
        for j in range(1, n+1):
            if X[i-1] == Y[j-1]:
                dp[i][j] = 1 + dp[i-1][j-1]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])

    return dp[m][n]


# Example
print(lcs("ABCBDAB", "BDCAB"))
