package machine;

public class CoffeeMachine {

    private int amountOfWater;
    private int milk;
    private int coffeeBeans;
    private int money;
    private int disposableCup;

    public CoffeeMachine(int w, int m, int coffeeBeans, int money, int disposableCup) {
        this.disposableCup = disposableCup;
        this.money = money;
        this.amountOfWater = w;
        this.milk = m;
        this.coffeeBeans = coffeeBeans;
    }

    public CoffeeMachine() {
        this(400, 540, 120, 550, 9);
    }

    public void makeCoffee() {
        System.out.println("Starting to make a coffee\nGrinding coffee beans");
        System.out.println("Boiling water\nMixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup\nPouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    public void makeAmountOfCoffee(int amount) {
        System.out.println("For " + amount + " cups of coffee you will need:");
        int water = 200 * amount;
        int milk = 50 * amount;
        int coffeeBeans = 15 * amount;
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
    }

    public int howManyCups() {
        int cupsForTheWater = this.amountOfWater / 200;
        int cupsForTheMilk = this.milk / 50;
        int coffeeBeans = this.coffeeBeans / 15;

        int numOfCups = cupsForTheWater;

        if (numOfCups < cupsForTheMilk) {
            numOfCups = cupsForTheMilk;
        }
        if (numOfCups < coffeeBeans) {
            numOfCups = coffeeBeans;
        }
        return numOfCups;
    }

    public void iCanMakeCoffee(int cups) {
        int c = howManyCups() - cups;

        if (howManyCups() < cups) {
            System.out.println("No, I can make only " + howManyCups() + " cup(s) of coffee");
        } else {
            if (howManyCups() - cups > 0) {
                System.out.println("Yes, I can make that amount of coffee (and even " + c + " more than that");
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        }

    }

    public int getMilk() {
        return this.milk;
    }

    public int getCoffeeBeans() {
        return this.coffeeBeans;
    }

    public int getAmountOfWater() {
        return this.amountOfWater;
    }


    public void makeEspresso() {
        if (this.amountOfWater >= 250) {
            if (this.coffeeBeans >= 16) {
                if (this.disposableCup > 0) {
                    this.disposableCup--;
                    this.amountOfWater -= 250;
                    this.coffeeBeans -= 16;
                    sellEspresso();
                }else{
                    System.out.println("Sorry, not enough disposable cups!\n");
                }
            }else{
                System.out.println("Sorry, not enough coffee beans!\n");
            }
        }else{
            System.out.println("Sorry, not enough water!\n");
        }
    }

    public void sellEspresso() {
        this.money += 4;
    }

    public void makeLatte() {
        if (this.amountOfWater >= 350) {
            if (this.milk >= 75) {
                if (this.coffeeBeans >= 20) {
                    if (this.disposableCup > 0) {
                        this.disposableCup--;
                        this.milk -= 75;
                        this.amountOfWater -= 350;
                        this.coffeeBeans -= 20;
                        sellLatte();
                    }else{
                        System.out.println("Sorry, not enough disposable cups!\n");
                    }
                }else{
                    System.out.println("Sorry, not enough coffee beans!\n");
                }
            }else{
                System.out.println("Sorry, not enough milk!\n");
            }
        } else {
            System.out.println("Sorry, not enough water!\n");
        }
    }

    public void sellLatte() {
        this.money += 7;
    }

    public void makeCappuccino() {
        if (this.amountOfWater >= 200) {
            if(this.milk >= 100) {
                if(this.coffeeBeans >= 12) {
                    if(this.disposableCup > 0) {
                        this.disposableCup--;
                        this.milk -= 100;
                        this.amountOfWater -= 200;
                        this.coffeeBeans -= 12;
                        sellCappuccino();
                    }else{
                        System.out.println("Sorry, not enough disposable cups!\n");
                    }
                }else{
                    System.out.println("Sorry, not enough coffee beans!\n");
                }
            }else{
                System.out.println("Sorry, not enough milk!\n");
            }
        } else {
            System.out.println("Sorry, not enough water!\n");
        }
    }

    public void sellCappuccino() {
        this.money += 6;
    }

    public int getMoney() {
        return this.money;
    }

    public int getDisposableCup() {
        return this.disposableCup;
    }

    public void increaseWater(int amount) {
        this.amountOfWater += amount;
    }

    public void increaseMilk(int amount) {
        this.milk += amount;
    }

    public void increaseCoffeeBeans(int amount) {
        this.coffeeBeans += amount;
    }

    public void increaseCups(int amount) {
        this.disposableCup += amount;
    }

    public void setMoney(int amount) {
        this.money = amount;
    }



}
