package machine;

import java.util.Scanner;

public class Management {
    private CoffeeMachine machine;
    private Scanner scanner;

    public Management(Scanner scanner) {
        this.scanner = scanner;
        this.machine = new CoffeeMachine();
    }

    public void start() {
        while (true) {
            String command = chooseAction();
            if (isExit(command)) {
                break;
            }
            if(isRemaining(command)) {
                actualState();
            }

            if (isBuy(command)) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String which = scanner.nextLine();
                if (which.equals("back")) {
                    continue;
                }
                if (which.equals("1")) {
                    this.machine.makeEspresso();
                }
                if (which.equals("2")) {
                    this.machine.makeLatte();
                }
                if (which.equals("3")) {
                    this.machine.makeCappuccino();
                }
            }
            if (isFill(command)) {
                System.out.println("Write how many ml of water you want to add:");
                this.machine.increaseWater(Integer.parseInt(scanner.nextLine()));

                System.out.println("Write how many ml of milk you want to add:");
                this.machine.increaseMilk(Integer.parseInt(scanner.nextLine()));

                System.out.println("Write how many grams of coffee beans you want to add:");
                this.machine.increaseCoffeeBeans(Integer.parseInt(scanner.nextLine()));

                System.out.println("Write how many cups disposable cups you want to add:");
                this.machine.increaseCups(scanner.nextInt());
            }
            if (isTake(command)) {
                System.out.println("I gave you $" + this.machine.getMoney());
                this.machine.setMoney(0);
            }

        }
    }

    public void actualState() {
        System.out.println("The coffee machine has:");
        System.out.println(this.machine.getAmountOfWater() + " ml of water");
        System.out.println(this.machine.getMilk() + " ml of milk");
        System.out.println(this.machine.getCoffeeBeans() + " g of coffee beans");
        System.out.println(this.machine.getDisposableCup() + " disposable cups");
        System.out.println("$" + this.machine.getMoney() + " of money");

    }

    public String chooseAction() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        return scanner.nextLine();
    }

    public boolean isBuy(String x) {
        return x.equals("buy");
    }

    public boolean isFill(String x) {
        return x.equals("fill");
    }

    public boolean isTake(String x) {
        return x.equals("take");
    }
    public boolean isExit(String x) {
        return x.equals("exit");
    }
    public boolean isRemaining(String x) {
        return x.equals("remaining");
    }

}
