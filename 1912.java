class MovieRentingSystem {
    Map<String, Integer> priceMap;
    Map<Integer, TreeSet<int[]>> unrented;
    TreeSet<int[]> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new HashMap<>();
        unrented = new HashMap<>();

        Comparator<int[]> cmpUnrented = (a, b) -> {             //for unrented movies
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        };

        Comparator<int[]> cmpRented = (a, b) -> {                   //for rented movies
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        };

        rented = new TreeSet<>(cmpRented);

        for (int[] entry : entries) {
            int shop = entry[0], movie = entry[1], price = entry[2];
            priceMap.put(key(shop, movie), price);
            unrented.computeIfAbsent(movie, k -> new TreeSet<>(cmpUnrented)).add(new int[]{price, shop});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!unrented.containsKey(movie)) return result;
        int count = 0;
        for (int[] arr : unrented.get(movie)) {
            result.add(arr[1]);
            if (++count == 5) break;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));
        unrented.get(movie).remove(new int[]{price, shop});
        rented.add(new int[]{price, shop, movie});
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));
        rented.remove(new int[]{price, shop, movie});
        unrented.get(movie).add(new int[]{price, shop});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for (int[] arr : rented) {
            result.add(Arrays.asList(arr[1], arr[2]));
            if (++count == 5) break;
        }
        return result;
    }

    private String key(int shop, int movie) {
        return shop + "#" + movie;
    }
}
