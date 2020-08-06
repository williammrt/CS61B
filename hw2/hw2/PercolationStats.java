package hw2;

import edu.princeton.cs.introcs.StdStats;
import edu.princeton.cs.introcs.StdRandom;

import java.lang.Math;

public class PercolationStats {
    private Percolation[] experiments;
    private int[] results;
    private int[] openSequences;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        experiments = new Percolation[T];
        results = new int[T];
        openSequences = new int[N * N];

        for (int i = 0; i < T; i += 1) {
            experiments[i] = pf.make(N);
            results[i] = 0;
        }
        for (int i = 0; i < N; i += 1) {
            openSequences[i] = i;
        }


        // start experiments

        for (int i = 0; i < T; i += 1) {
            StdRandom.shuffle(openSequences);
            int countSequence = 0;
            while (!experiments[i].percolates()) {
                experiments[i].open(openSequences[countSequence] / N, openSequences[countSequence] % N);
                countSequence += 1;
            }
            results[i] = countSequence;


        }


    }   // perform T independent experiments on an N-by-N grid


    public double mean() {
        return StdStats.mean(results);
    }                                           // sample mean of percolation threshold

    public double stddev() {
        return StdStats.stddev(results);
    }                                         // sample standard deviation of percolation threshold

    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(experiments.length);
    }                                  // low endpoint of 95% confidence interval

    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(experiments.length);
    }

}
