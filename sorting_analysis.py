import random
import matplotlib.pyplot as plt
import copy
import os

def generate_best_case(n):
    return list(range(1, n + 1))


def generate_worst_case(n):
    return list(range(n, 0, -1))


def generate_average_case(n):
    arr = list(range(1, n + 1))
    random.shuffle(arr)
    return arr


def bubble_sort(arr, ascending=True):
    steps = 0
    n = len(arr)

    for i in range(n - 1):
        swapped = False
        for j in range(n - i - 1):
            steps += 1

            if (ascending and arr[j] > arr[j + 1]) or \
               (not ascending and arr[j] < arr[j + 1]):
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                steps += 3 
                swapped = True

        if not swapped:
            break

    return arr, steps



def selection_sort(arr, ascending=True):
    steps = 0
    n = len(arr)

    for i in range(n - 1):
        idx = i

        for j in range(i + 1, n):
            steps += 1 

            if (ascending and arr[j] < arr[idx]) or \
               (not ascending and arr[j] > arr[idx]):
                idx = j

        if idx != i:
            arr[i], arr[idx] = arr[idx], arr[i]
            steps += 3 

    return arr, steps



def insertion_sort(arr, ascending=True):
    steps = 0
    n = len(arr)

    for i in range(1, n):
        key = arr[i]
        steps += 1 
        j = i - 1

        while j >= 0:
            steps += 1 

            if (ascending and arr[j] > key) or \
               (not ascending and arr[j] < key):
                arr[j + 1] = arr[j]
                steps += 1
                j -= 1
            else:
                break

        arr[j + 1] = key
        steps += 1

    return arr, steps



def analyze_sorting():
    sizes = [10, 20, 30, 40]

    algorithms = {
        "Bubble": bubble_sort,
        "Selection": selection_sort,
        "Insertion": insertion_sort
    }

    cases = {
        "Best": generate_best_case,
        "Average": generate_average_case,
        "Worst": generate_worst_case
    }

    results = {}

    for order in ["Ascending", "Descending"]:
        ascending = True if order == "Ascending" else False
        results[order] = {}

        for case_name, case_func in cases.items():
            results[order][case_name] = {algo: [] for algo in algorithms}

            for n in sizes:
                original = case_func(n)

                print(f"\nInput Size: {n} | {case_name} Case | {order}")

                for algo_name, algo_func in algorithms.items():
                    arr_copy = copy.deepcopy(original)
                    sorted_arr, steps = algo_func(arr_copy, ascending)

                    print(f"{algo_name} Sorted Output: {sorted_arr}")
                    print(f"{algo_name} Step Count: {steps}")

                    results[order][case_name][algo_name].append(steps)

    return sizes, results


def plot_graphs(sizes, results):
    folder_name = "screenshots_of_graphs"

    # Create folder if it doesn't exist
    if not os.path.exists(folder_name):
        os.makedirs(folder_name)

    for order in results:
        for case in results[order]:
            plt.figure()

            for algo in results[order][case]:
                plt.plot(
                    sizes,
                    results[order][case][algo],
                    marker='o',
                    label=algo
                )

            plt.title(f"{order} Order - {case} Case")
            plt.xlabel("Input Size")
            plt.ylabel("Step Count")
            plt.legend()
            plt.grid()

            filename = f"{folder_name}/{order.lower()}_{case.lower()}.png"
            plt.savefig(filename)
            plt.close()




if __name__ == "__main__":
    sizes, results = analyze_sorting()
    plot_graphs(sizes, results)
