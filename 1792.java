class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(
                ((b[0] + 1) / (b[1] + 1)) - (b[0] / b[1]),
                ((a[0] + 1) / (a[1] + 1)) - (a[0] / a[1])
            )
        );

        for (int[] cls : classes) {
            pq.add(new double[]{cls[0], cls[1]});
        }

        while (extraStudents-- > 0) {
            double[] cls = pq.poll();
            cls[0]++;
            cls[1]++;
            pq.add(cls);
        }

        double total = 0;
        while (!pq.isEmpty()) {
            double[] cls = pq.poll();
            total += cls[0] / cls[1];
        }

        return total / classes.length;
    }
}

//*************************** Alternative Solution *******************************

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for(int[] cls: classes) {
            double pass = cls[0], total = cls[1];
            double gain = calculateGains(pass, total);
            queue.offer(new double[] {gain, pass, total});
        }   
        while(--extraStudents >= 0) {
            double[] curr = queue.poll();
            curr[1] += 1;
            curr[2] += 1;
            curr[0] = calculateGains(curr[1], curr[2]);
            queue.offer(curr);
        }
        double totalAvg = 0;
        while(!queue.isEmpty()) {
            double[] curr = queue.poll();
            totalAvg +=  curr[1] / curr[2];
        }
        return totalAvg / classes.length;
    }
    private double calculateGains(double pass, double total) {
        return (double)((pass+1)/(total+1)) - (double) (pass/total);
    }
}
