import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class GraphGenerator {

    public static void main(String[] args) throws Exception {

        Map<String, Map<Integer, Integer>> data = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader("results.csv"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");

            String algo = parts[0];
            int size = Integer.parseInt(parts[1]);
            int steps = Integer.parseInt(parts[2]);

            data.putIfAbsent(algo, new HashMap<>());
            data.get(algo).put(size, steps);
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (String algo : data.keySet()) {
            for (int size : data.get(algo).keySet()) {
                dataset.addValue(data.get(algo).get(size), algo, String.valueOf(size));
            }
        }

        JFreeChart chart = ChartFactory.createLineChart(
                "Sorting Analysis",
                "Input Size",
                "Steps",
                dataset
        );

        JFrame frame = new JFrame("Graph");
        frame.setContentPane(new ChartPanel(chart));
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}