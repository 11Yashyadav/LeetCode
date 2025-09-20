class Router {

    private Queue<DataPacket> dpQueue; 
    private Set<String> dpSet ;
    private final int memoryLimit;
    private Map<Integer, List<Integer>> counts;
    public Router(int memoryLimit) {
        dpQueue = new ArrayBlockingQueue<>(memoryLimit);
        dpSet = new HashSet<>();
        this.memoryLimit = memoryLimit;
        this.counts = new HashMap<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        String  uniqueKey = source + " " + destination + " " + timestamp;
        DataPacket dp = new DataPacket(source, destination, timestamp, uniqueKey);
    
        if(dpSet.contains(uniqueKey)) {
            return false;
        }
        if(dpQueue.size() == this.memoryLimit) {
            forwardPacket();
        }
        dpQueue.add(dp);
        dpSet.add(uniqueKey);
        counts.putIfAbsent(destination, new ArrayList<>());
        counts.get(destination).add(timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        if(dpQueue.isEmpty()) {
            return new int[] {};
        }
       
        DataPacket dp = dpQueue.poll();
        dpSet.remove(dp.uniqueKey);
        List<Integer>  lst = counts.get(dp.destination);
        lst.remove(0);
        int[] fwpacket =  new int[] {dp.source, dp.destination, dp.timestamp};

        return fwpacket;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> lst = counts.get(destination);
        if(lst == null || lst.size() == 0) {
            return 0;
        }
        int start = lowerBound(lst, startTime);
        int end = upperBound(lst, endTime);
        return end - start;
    }

    private int lowerBound(List<Integer> lst, int target) {
        int low =0, high = lst.size();

        while(low < high) {
            int mid = low + ( high-low) / 2 ;
            if(lst.get(mid) < target) low = mid+1;
            else high = mid;
        }
        return low;
    }

    private int upperBound(List<Integer> lst, int target) {
        int low =0, high = lst.size();

        while(low < high) {
            int mid = low + ( high-low) / 2 ;
            if(lst.get(mid) <= target) low = mid+1;
            else high = mid;
        }
        return low;
    }
   
       
}

class DataPacket {
    int source;
    int destination;
    int timestamp;
    String uniqueKey;
    public DataPacket(int source, int destination, int timestamp,String uniqueKey) {
        this.source = source;
        this.destination =  destination;
        this.timestamp = timestamp;
        this.uniqueKey = uniqueKey;
    }

}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
