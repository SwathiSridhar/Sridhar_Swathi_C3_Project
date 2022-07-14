import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        return (this.getCurrentTime().compareTo(this.openingTime) >= 0 && (this.closingTime.compareTo(this.getCurrentTime()) >= 0));
        //return (this.getCurrentTime().isAfter(this.openingTime) && this.closingTime.isAfter(this.getCurrentTime()));
    }

    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    public List<Item> getMenu() {

        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
        return this.menu;
    }

    private Item findItemByName(String itemName) {
        for (Item item : menu) {
            if (item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public void displayDetails() {
        System.out.println("Restaurant:" + name + "\n"
                + "Location:" + location + "\n"
                + "Opening time:" + openingTime + "\n"
                + "Closing time:" + closingTime + "\n"
                + "Menu:" + "\n" + getMenu());

    }

    public String getName() {
        return name;
    }
    public int getAllItemsPrice(ArrayList<String>itemsList) {
        int total_price = 0;
        List<Item> storeItems = new ArrayList<>();
        for (String item : itemsList) {
            storeItems.add(findItemByName(item));
        }
        for (Item one_item : storeItems) {
            total_price += one_item.getItemPrice();
        }
        return total_price;
    }
}
