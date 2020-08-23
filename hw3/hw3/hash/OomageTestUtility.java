package hw3.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        int[] buckets = new int[M];
        for (int i = 0; i < M; i += 1) {
            buckets[i] = 0;
        }

        for (Oomage o : oomages) {
            int bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            buckets[bucketNum] += 1;
        }

        double lowerBound = oomages.size() / 50;
        double upperBound = oomages.size() / 2.5;
        for (int i = 0; i < M; i += 1) {
            if (buckets[i] < lowerBound || buckets[i] > upperBound) {
                return false;
            }
        }
        return true;
    }
}
