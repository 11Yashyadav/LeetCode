class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        int emptyBottles = numBottles;

        while (emptyBottles >= numExchange) {
            int newBottles = emptyBottles / numExchange;
            count += newBottles;
            emptyBottles = newBottles + (emptyBottles % numExchange);
        }

        return count;
    }
}
