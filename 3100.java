class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int count = numBottles;
        int emp = numBottles;

        while (emp >= numExchange) {
            count++;
            emp = 1+ (emp - numExchange);
            numExchange++;
        }

        return count;
    }
}
