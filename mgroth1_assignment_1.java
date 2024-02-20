import javax.swing.text.FieldView;

public class mgroth1_assignment1 {
    
    public static void main(String[] args) {
        Notes Twenties = new Notes(20);
        Notes Tens = new Notes(10);
        Notes Fives = new Notes(5);
        Notes Ones = new Notes(1);
        
        Coin Quarters = new Coin(0.25f, 0.2f);
        Coin Dimes = new Coin(0.1f, 0.08f);
        Coin Nickles = new Coin(0.05f, 0.176f);
        Coin Pennies = new Coin(0.01f, 0.088f);
        
        Dimes.increaseQuantity(41);
        Nickles.increaseQuantity(17);
        Pennies.increaseQuantity(132);
        Ones.increaseQuantity(33);
        Fives.increaseQuantity(12);
        Tens.increaseQuantity(2);
        Twenties.increaseQuantity(5);

    }
}
class Notes{
    private int quantityOnHand;
    private int denomination;

    public Notes(int denomination){
        this.denomination = denomination;
    }

    public int getTotalValue(){
        return this.denomination * this.quantityOnHand;
    }
    public void increaseQuantity(int quantity){
        this.quantityOnHand+= quantity;
    }
    public void decreaseQuantity(int quantity){
        this.quantityOnHand -= quantity;

        if (this.quantityOnHand < 0){
            this.quantityOnHand = 0;
        } 
    }

    public int getQuantityOnHand(){
        return this.quantityOnHand;
    }
    public String printPretty(float amount){
        return ("$"+ String.format("%4.2f",amount));
    }

    @Override
    public String toString(){
        return ("$" + printPretty((this.getTotalValue(denomination, quantityOnHand) + "in" + this.denomination)));
    }
}


class Coin{
    private int quantityOnHand;
    private float denomination;
    private float weight;

    public Coin(float weight,  float denomination) {
        quantityOnHand = 0;
        this.weight = weight;
        this.denomination = denomination;
    }

    public  float getTotalWeight(float weight, int quantityOnHand){
        float toatlWeight = weight * quantityOnHand;
        return toatlWeight;
    }
    
    public float getTotalValue(float denomination, int quantityOnHand){
        flaot totalValue = denomination * quantityOnHand;
        return totalValue;
    }
    
    public void increaseQuantity(int quantity){
        this.quantityOnHand += quantity;
    }
    
    public void decreaseQuantity(int quantityOnHand){
        
       this.quantityOnHand -= quantityOnHand;
        
        if (this.quantityOnHand < 0){
            this.quantityOnHand = 0;
        }
    }
    
    public int getQuantityOnHand(){
        return this.quantityOnHand;
    }
    
    public String printPretty(float amount){
        return ("$"+String.format("%4.2f",amount));
    }

    @Override
    public String toString(){
        return ("$" + printPretty(this.getTotalValue + "in"  + this.getQuantityOnHand()));
    }

}
