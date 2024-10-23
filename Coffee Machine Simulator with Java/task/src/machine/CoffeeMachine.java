package machine;

import java.util.Scanner;


public class CoffeeMachine {


    private int waterAmount;
    private int milkAmount;
    private int beansAmount;
    private int availableCups;
    private int moneyAmount;
    private int cupsMade;
    private boolean needsCleaning;

    public CoffeeMachine(int waterAmount, int milkAmount, int beansAmount, int availableCups, int moneyAmount) {
        this.waterAmount = waterAmount;
        this.milkAmount = milkAmount;
        this.beansAmount = beansAmount;
        this.availableCups = availableCups;
        this.moneyAmount = moneyAmount;
        this.cupsMade = 0;
        this.needsCleaning = false;
    }

    @Override
    public String toString() {

        return String.format("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money", this.waterAmount, this.milkAmount, this.beansAmount, this.availableCups, this.moneyAmount);
    }

    public void buy(CoffeeType coffeeType) {
        if (needsCleaning) {
            System.out.println("I need cleaning!");
            return;
        }

        if (!haveEnoughResources(coffeeType)) {
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        this.waterAmount -= coffeeType.getNeededWater();
        this.milkAmount -= coffeeType.getNeededMilk();
        this.beansAmount -= coffeeType.getNeededBeans();
        this.availableCups--;
        this.moneyAmount += coffeeType.getPrice();
        this.cupsMade++;

        if (this.cupsMade >= 10) {
            needsCleaning = true;
        }

    }

    public boolean haveEnoughResources(CoffeeType coffeeType) {
        if (this.waterAmount < coffeeType.getNeededWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (this.milkAmount < coffeeType.getNeededMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (this.beansAmount < coffeeType.getNeededBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (this.availableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return true;
    }

    public void fillCoffeeMachine(int water, int milk, int beans, int cups){
        this.waterAmount += water;
        this.milkAmount += milk;
        this.beansAmount += beans;
        this.availableCups += cups;
    }

    public void take() {
        System.out.printf("I gave you $%d%n", this.moneyAmount);
        this.moneyAmount = 0;
    }

    public void clean() {
        this.cupsMade = 0;
        needsCleaning = false;
        System.out.println("I have been cleaned!");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);

        boolean running = true;
        while (running) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            String action = scanner.nextLine();
            switch (action) {
                case "buy" -> handleBuyAction(scanner, coffeeMachine);
                case "fill" -> handleFillAction(scanner, coffeeMachine);
                case "take" -> handleTakeAction(coffeeMachine);
                case "remaining" -> displayRemaining(coffeeMachine);
                case "clean" -> coffeeMachine.clean();
                case "exit" -> {
                   running = false;
                }
                default -> System.out.println("Incorrect command");
            }
            System.out.println();
        }
    }

    private static void handleBuyAction(Scanner scanner, CoffeeMachine coffeeMachine) {
        System.out.println();

        boolean buying = true;
        while (buying) {
            if (coffeeMachine.needsCleaning) {
                System.out.println("I need cleaning!");
                return;  // If it needs cleaning, return from the method
            }

            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            String coffeeType = scanner.nextLine();

            switch (coffeeType) {
                case "1" -> {
                    coffeeMachine.buy(CoffeeType.ESPRESSO);
                    buying = false;
                }
                case "2" -> {
                    coffeeMachine.buy(CoffeeType.LATTE);
                    buying = false;
                }
                case "3" -> {
                    coffeeMachine.buy(CoffeeType.CAPPUCCINO);
                    buying = false;
                }
                case "back" -> {
                    buying = false;
                }
                default -> System.out.println("Incorrect command");
            }
        }

    }

    private static void handleFillAction(Scanner scanner, CoffeeMachine coffeeMachine) {
        System.out.println();
        System.out.println("Write how many ml of water you want to add:");
        int addWater = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk you want to add:");
        int addMilk = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addBeans = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups you want to add:");
        int addCups = Integer.parseInt(scanner.nextLine());

        coffeeMachine.fillCoffeeMachine(addWater, addMilk, addBeans, addCups);
    }

    private static void handleTakeAction(CoffeeMachine coffeeMachine) {
        System.out.println();
        coffeeMachine.take();
    }

    private static void displayRemaining(CoffeeMachine coffeeMachine) {
        System.out.println();
        System.out.println(coffeeMachine);
    }
}