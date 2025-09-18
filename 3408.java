class TaskManager {
    private TreeMap<Integer, TreeSet<Integer>> priorityMap;
    // Map: taskId -> [userId, priority]
    private HashMap<Integer, int[]> taskInfo;

    public TaskManager(List<List<Integer>> tasks) {
        priorityMap = new TreeMap<>();
        taskInfo = new HashMap<>();

        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            add(userId, taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskInfo.put(taskId, new int[]{userId, priority});
        priorityMap.computeIfAbsent(priority, k -> new TreeSet<>()).add(taskId);
    }

    public void edit(int taskId, int newPriority) {
        int[] info = taskInfo.get(taskId);
        int oldPriority = info[1];

        // remove from old priority set
        TreeSet<Integer> set = priorityMap.get(oldPriority);
        set.remove(taskId);
        if (set.isEmpty()) priorityMap.remove(oldPriority);

        // update info
        info[1] = newPriority;
        taskInfo.put(taskId, info);

        // add to new priority set
        priorityMap.computeIfAbsent(newPriority, k -> new TreeSet<>()).add(taskId);
    }

    public void rmv(int taskId) {
        int[] info = taskInfo.get(taskId);
        int priority = info[1];

        // remove from priorityMap
        TreeSet<Integer> set = priorityMap.get(priority);
        set.remove(taskId);
        if (set.isEmpty()) priorityMap.remove(priority);

        // remove from taskInfo
        taskInfo.remove(taskId);
    }

    public int execTop() {
        if (priorityMap.isEmpty()) return -1;

        // highest priority
        int maxPriority = priorityMap.lastKey();
        TreeSet<Integer> tasks = priorityMap.get(maxPriority);

        // highest taskId for that priority
        int taskId = tasks.last();
        tasks.remove(taskId);
        if (tasks.isEmpty()) priorityMap.remove(maxPriority);

        int[] info = taskInfo.remove(taskId);
        return info[0]; // return userId
    }
}
