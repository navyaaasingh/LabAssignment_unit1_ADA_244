# Algorithm Design & Analysis – Unit 1-4 Lab (Java Implementation)

## Overview

This repository contains Java implementations of fundamental algorithms from Algorithm Design & Analysis (ADA), along with empirical analysis of sorting algorithms. The project demonstrates core paradigms including **Greedy, Dynamic Programming, Divide & Conquer, and Backtracking**, and includes performance evaluation using step counts and graphical visualization.

---

## Implemented Algorithms

### 1. Sorting Algorithms

* Bubble Sort
* Selection Sort
* Insertion Sort

Each algorithm is implemented with:

* Ascending and descending order support
* Step count tracking (comparisons + swaps)
* Analysis across best, average, and worst cases

---

### 2. Searching Algorithms

* Linear Search
* Binary Search

---

### 3. Greedy Algorithms

* Fractional Knapsack
* Dijkstra’s Shortest Path Algorithm

---

### 4. Dynamic Programming

* 0/1 Knapsack
* Longest Common Subsequence (LCS)
* Bellman-Ford Algorithm

---

### 5. Divide & Conquer

* Merge Sort
* Quick Sort
* Matrix Multiplication

---

### 6. Backtracking

* N-Queens Problem

---

## Sorting Analysis

The project includes an empirical analysis of sorting algorithms:

### Input Cases

* Best Case (sorted)
* Average Case (random)
* Worst Case (reverse sorted)

### Metrics

* Step count (basic operations)
* Input sizes: 10, 20, 30, 40

### Output

* Console output showing sorted arrays and step counts
* CSV file (`results.csv`) storing:

  ```
  Algorithm, Input Size, Steps
  ```

---

## Graph Visualization

Graphs are generated using Python (matplotlib).

### Steps to Generate Graphs

1. Run Java program:

   ```bash
   javac sorting_analysis.java
   java sorting_analysis
   ```

2. Ensure `results.csv` is created

3. Run Python script:

   ```bash
   python plot_graph.py
   ```

4. Output:

   * Graph displayed OR
   * Saved as `.png` file in project folder

---

## Project Structure

```
├── sorting_analysis.java
├── Knapsack01.java
├── FractionalKnapsack.java
├── MatrixMultiplication.java
├── LCS.java
├── Dijkstra.java
├── BellmanFord.java
├── NQueens.java
├── results.csv
├── plot_graph.py
└── README.md
```

---

## Key Concepts Demonstrated

* Time complexity vs empirical analysis
* Greedy vs Dynamic Programming trade-offs
* Recursion and backtracking
* Data structures (arrays, lists, maps, priority queues)
* Algorithm optimization techniques

---

## Requirements

### Java

* JDK 8 or higher

### Python (for graphs)

* Python 3.x
* Libraries:

  ```bash
  pip install matplotlib pandas
  ```

---

## Observations

* Bubble and Selection Sort show **O(n²)** growth
* Insertion Sort performs better on nearly sorted data
* Step count increases significantly with input size
* Graphs clearly illustrate performance differences

---

## Future Improvements

* Add Merge Sort and Quick Sort to analysis
* Include runtime benchmarking (`System.nanoTime`)
* Separate graphs for best/average/worst cases
* Use advanced visualization (Seaborn / JFreeChart)
* Implement space optimization techniques

---

## Author

Navya Singh

---

## License

This project is for academic and educational purposes.
