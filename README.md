# Sorting Algorithms Analysis (ADA Lab - Unit 1)

This project implements and analyzes three sorting algorithms:

- Bubble Sort
- Selection Sort
- Insertion Sort

The performance of each algorithm is analyzed using the Step-Count Method.

----------------------------------------------------

## Objective

- Sort numbers in ascending and descending order.
- Count key operations (comparisons and swaps).
- Analyze Best, Average, and Worst cases.
- Compare performance for input sizes:
  10, 20, 30, 40.
- Plot graphs for Input Size vs Step Count.

----------------------------------------------------

## Step-Count Method

We count:
- 1 comparison = 1 step
- 1 swap = 3 steps (assignment operations)

This helps measure time complexity practically.

----------------------------------------------------

## Cases Analyzed

1. Best Case → Already sorted input
2. Average Case → Randomized input
3. Worst Case → Reverse sorted input

----------------------------------------------------

## How to Run

1. Install matplotlib:

   pip install matplotlib

2. Run the program:

   python sorting_analysis.py

3. Graphs will be automatically saved inside:

   screenshots_of_graphs/

----------------------------------------------------

## Files Included

- sorting_analysis.py → Main implementation
- sample_output.txt → Example output
- screenshots_of_graphs/ → Generated graphs

----------------------------------------------------

## Expected Learning

- Understanding sorting algorithm behavior
- Comparing time complexities
- Practical analysis using step counting
- Graphical performance comparison
