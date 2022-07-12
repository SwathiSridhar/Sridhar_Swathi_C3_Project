import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();
    private Restaurant Exception;

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        for (Restaurant restaurant_name: restaurants){
            if (restaurant_name.getName().equals(restaurantName)){
                return restaurant_name;
            }
        }
        throw new restaurantNotFoundException("Restaurant name does not exist in the given list");
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
