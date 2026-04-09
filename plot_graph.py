import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("results.csv", names=["Algo","Size","Steps"])

for algo in df["Algo"].unique():
    subset = df[df["Algo"] == algo]
    plt.plot(subset["Size"], subset["Steps"], marker='o', label=algo)

plt.xlabel("Input Size")
plt.ylabel("Steps")
plt.title("Sorting Analysis")
plt.legend()
plt.grid()
plt.savefig("graphs/sorting_analysis.png")
plt.close() 
