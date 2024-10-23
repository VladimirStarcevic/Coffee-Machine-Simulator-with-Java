package machine;

public class CoffeeType{
    private String typeOfCoffee;
    private int neededWater;
    private int neededMilk;
    private int neededBeans;
    private int price;

    public CoffeeType(int neededWater, int neededMilk, int neededBeans, int price) {
        this.neededWater = neededWater;
        this.neededMilk = neededMilk;
        this.neededBeans = neededBeans;
        this.price = price;
    }

    public String getTypeOfCoffee() {
        return typeOfCoffee;
    }

    public void setTypeOfCoffee(String typeOfCoffee) {
        this.typeOfCoffee = typeOfCoffee;
    }

    public int getNeededWater() {
        return neededWater;
    }

    public void setNeededWater(int neededWater) {
        this.neededWater = neededWater;
    }

    public int getNeededMilk() {
        return neededMilk;
    }

    public void setNeededMilk(int neededMilk) {
        this.neededMilk = neededMilk;
    }

    public int getNeededBeans() {
        return neededBeans;
    }

    public void setNeededBeans(int neededBeans) {
        this.neededBeans = neededBeans;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static final CoffeeType ESPRESSO = new CoffeeType(250, 0, 16, 4);
    public static final CoffeeType LATTE = new CoffeeType(350, 75, 20, 7);
    public static final CoffeeType CAPPUCCINO = new CoffeeType(200, 100, 12, 6);
}
