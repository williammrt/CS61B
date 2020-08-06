package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int numOfOpenedSite;
    private int bound;
    private WeightedQuickUnionUF poSystem;
    private boolean[][] openness;
    private int top;
    private int bottum;


    public Percolation(int N) {
        if (N <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        numOfOpenedSite = 0;
        bound = N;
        top = N * N;
        bottum = N * N + 1;
        poSystem = new WeightedQuickUnionUF(N * N + 2);

        openness = new boolean[bound][bound];
        for (int i = 0; i < bound; i += 1) {
            for (int j = 0; j < bound; j += 1) {
                openness[i][j] = false;
            }
            poSystem.union(xyToN(0, i), top);
            poSystem.union(xyToN(bound - 1, i), bottum);
        }


    }                // create N-by-N grid, with all sites initially blocked

    private int xyToN(int row, int col) {
        return row * bound + col;
    }

    public void open(int row, int col) {
        if (row < 0 || row > (bound - 1) || col < 0 || col > (bound - 1)) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (openness[row][col]) {
            return;
        }
        openness[row][col] = true;

        if (col < (bound - 1) && isOpen(row, col + 1)) {
            poSystem.union(xyToN(row, col), xyToN(row, col + 1));
        }
        if (col > 0 && isOpen(row, col - 1)) {
            poSystem.union(xyToN(row, col), xyToN(row, col - 1));
        }
        if (row < (bound - 1) && isOpen(row + 1, col)) {
            poSystem.union(xyToN(row, col), xyToN(row + 1, col));
        }
        if (row > 0 && isOpen(row - 1, col)) {
            poSystem.union(xyToN(row, col), xyToN(row - 1, col));
        }

        numOfOpenedSite += 1;
    }       // open the site (row, col) if it is not open already

    public boolean isOpen(int row, int col) {
        if (row < 0 || row > (bound - 1) || col < 0 || col > (bound - 1)) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return openness[row][col];
    }  // is the site (row, col) open?

    public boolean isFull(int row, int col) {
        if (row < 0 || row > (bound - 1) || col < 0 || col > (bound - 1)) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return poSystem.connected(xyToN(row, col), top) && isOpen(row, col);
    }  // is the site (row, col) full?

    public int numberOfOpenSites() {
        return numOfOpenedSite;
    }        // number of open sites

    public boolean percolates() {
        return poSystem.connected(top, bottum);
    }              // does the system percolate?

    public static void main(String[] args) {
        /* Percolation test1 = new Percolation(10);
        for (int i = 0; i < 10; i += 1) {
            test1.open(i, 5);
            System.out.println(i);
            System.out.println(test1.percolates());
            System.out.println(test1.isFull(i,5));
            System.out.println(test1.isFull(i,6));
        }

        Percolation test2=new Percolation(10);
        */
    }  // use for unit testing (not required)

}
