package hw2;

import edu.princeton.cs.introcs.StdStats;
import edu.princeton.cs.introcs.StdRandom;


public class PercolationStats {
    private Percolation[] experiments;
    private double[] results;
    private int[] openSequences;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        experiments = new Percolation[T];
        results = new double[T];
        openSequences = new int[N * N];

        for (int i = 0; i < T; i += 1) {
            experiments[i] = pf.make(N);
            results[i] = 0;
        }
        for (int i = 0; i < N*N; i += 1) {
            openSequences[i] = i;
        }


        // start experiments

        for (int i = 0; i < T; i += 1) {
            StdRandom.shuffle(openSequences);
            int countSequence = 0;
            while (!experiments[i].percolates() && countSequence < openSequences.length) {
                int row = openSequences[countSequence] / N;
                int col = openSequences[countSequence] % N;
                experiments[i].open(row, col);
                countSequence += 1;
            }
            results[i] = countSequence * 1.0 / N;


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
