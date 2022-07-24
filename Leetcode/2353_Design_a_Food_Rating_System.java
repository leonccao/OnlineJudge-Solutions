class FoodRatings {
    
    class Food {
        String name;
        String cuisine;
        int rating;
        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }
    
    Map<String, Food> foodMap;
    Map<String, Queue<Food>> cuisineMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            
            Food foodObj = new Food(food, cuisine, rating);
            foodMap.put(food, foodObj);
            Queue<Food> cuisineQueue = cuisineMap.getOrDefault(cuisine, 
                new PriorityQueue<>((Food a, Food b) -> 
                    a.rating == b.rating ? 
                    a.name.compareTo(b.name) : b.rating - a.rating
                )
            );
            cuisineQueue.add(foodObj);
            cuisineMap.put(cuisine, cuisineQueue);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food foodObj = foodMap.get(food);
        Queue<Food> cuisineQueue = cuisineMap.get(foodObj.cuisine);
        cuisineQueue.remove(foodObj);
        foodObj.rating = newRating;
        cuisineQueue.add(foodObj);
    }
    
    public String highestRated(String cuisine) {
        Queue<Food> cuisineQueue = cuisineMap.get(cuisine);
        return cuisineQueue.peek().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */