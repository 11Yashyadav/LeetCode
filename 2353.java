class FoodRatings {

    Map<String, Pair<String, Integer>> foodMap = new HashMap<>();
    Map<String, TreeSet<Pair<String, Integer>>> cuisineMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        
        // Obtain the length of the array
        int len = foods.length;

        // Fill the foodMap
        for (int i = 0; i < len; i++) {
            this.foodMap.put(foods[i], new Pair<>(cuisines[i], ratings[i]));
        }

        // Fill the cuisineMap
        for (int i = 0; i < len; i++) {
            this.cuisineMap.putIfAbsent(cuisines[i], new TreeSet<>(
                (a, b) -> {
                    Integer valueOfA = a.getValue(), valueOfB = b.getValue();
                    if (!valueOfB.equals(valueOfA)) {
                        return Integer.compare(valueOfB, valueOfA);
                    } else {
                        return a.getKey().compareTo(b.getKey());
                    }
                }
            ));
            this.cuisineMap.get(cuisines[i]).add(new Pair<>(foods[i], ratings[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        Pair<String, Integer> oldPair = foodMap.get(food);
        String cuisine = oldPair.getKey();
        Integer oldRating = oldPair.getValue();
        foodMap.put(food, new Pair<>(cuisine, newRating));
        cuisineMap.get(cuisine).remove(new Pair<>(food, oldRating));
        cuisineMap.get(cuisine).add(new Pair<>(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        return this.cuisineMap.get(cuisine).first().getKey();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
