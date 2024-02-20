import java.util.Scanner;
//int maxValue = input.nextInt(); (might need)

public class mgroth1_lab2 {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int menuOption,menuQuant;
        float price;

        StockItem milk = new StockItem("1 Gallon of Milk", 3.60f, 15);
        StockItem bread = new StockItem("1 load of bread", 1.98f, 30);

        do{
        System.out.println("option: \n1. Sold one milk \n2.sold one bread  \n3.change price of Milk \n4.change price of Bread \n5.add Milk to inventory \n6.add Bread to inventory\n7.See Inventory \n8.quit");
        menuOption = s1.nextInt();
        
        if (menuOption == 1){
            milk.lowerQuantity(1);
        }

        else if(menuOption == 2){
            bread.lowerQuantity(1);
        }

        else if(menuOption == 3){
            System.out.println("Enter new Milk Price");
            price = s1.nextFloat();
            milk.setPrice(price);
        }
        else if(menuOption == 4){
            System.out.println("Enter new bread Price");
            price = s1.nextFloat();
            bread.setPrice(price);
        }
        else if(menuOption == 5){
            System.out.println("how many more milk gallons did you recieve?");
            menuQuant = s1.nextInt();
            milk.raiseQuantity(menuQuant);

        }
        else if(menuOption == 6){
            System.out.println("how many more loafs of bread did you recieve?");
            menuQuant = s1.nextInt();
            bread.raiseQuantity(menuQuant);
        }
        else if(menuOption == 7){
            System.out.println("milk: " + milk);
            System.out.println("bread: " + bread);
        }
        else{
            // do nothing exit statements
        }
    }while(menuOption != 8);

    }
}
 
class StockItem {

    private String description;
    private int id;
    private float price;
    private int quantity;
    private static int newID = 0; 

    //getter
    public StockItem() {
        description = "";
        id = newID;
        newID++;
        price = 0.0f;
        quantity = 0;
    }
    public StockItem(String descriptionPram, float pricePram, int quantPram){
        this.description = descriptionPram;
        this.price = pricePram;
        this.quantity = quantPram;
        id = newID;
        newID++;
    }

    public String getDescription() {
        return this.description;
    }
    public int getId() {
        return this.id;
    }
    public float getPrice() {
        return this.price;
    }
    public int getQuantity() {
        return this.quantity;
    }
        
    //setter
    public void setPrice(float newPrice){
        this.price = newPrice;
    }
    public void lowerQuantity(int newQuantity){
        if(this.quantity <= 0){
            System.out.println("ERROR CANNOT BE LESS THAN 0 OF AN ITEM");
            this.quantity = 0;
        }
        else {
            this.quantity -= newQuantity;
        }
    }
    public void raiseQuantity(int newQuantity){
        this.quantity += newQuantity;
    }

    @Override
    public String toString() {
        return ("Item ID: " + this.id + " is " + this.description + " has Price:" + this.price + " Number of item in Stock: " +  this.quantity);
    }

}