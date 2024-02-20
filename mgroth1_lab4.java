import java.util.Scanner;
class Account {
    private int accNumber;
    private double balance;
    private static int accNumCount = 1001;
    public Account() {
        this.accNumber = accNumCount++;
        this.balance = 0;
    }
    public Account(double balance) {
        this.accNumber = accNumCount++;
        this.balance = balance;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public double getBal() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void withdraw(double amount){
        balance -= amount;
    }
    public void deposit(double amount){
        balance += amount;
    }
}

class Checking extends Account{


    public Checking(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount); //To change body of generated methods, choose Tools | Templates.
        if(getBal() <= 0)
        {
            System.out.println("account balance is now below $0 charging $20");
            setBalance(getBal()-20);
        }
    }

}

class Savings extends Account  {
    public int depositCount=0;
    public Savings(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        if(getBal() >= amount){
            super.withdraw(amount);
            if(getBal()<500)
            {
                System.out.println("Charging a fee of $10 because you are below $500");
                setBalance(getBal() - 10);
            }
        }else
            System.out.println("Insufficient Funds in Account...");

    }

    @Override
    public void deposit(double amount) {

        super.deposit(amount);
        this.depositCount++;
        System.out.println("This is deposit #" + this.depositCount );
        if(this.depositCount >= 5)
        {
            System.out.println("Charging a fee of $10");
            setBalance(getBal() - 10);
        }
    }
    public void addInterest(){
        double interest=getBal()*1.5/100;
        System.out.println("Customer earned " + interest + " in interest ");
        setBalance(getBal() + interest);
    }

}

public class mgroth1_lab4 {

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        double bal;

        System.out.print("Enter the Initial Balance of Checking Account");
        bal = Double.parseDouble(s1.nextLine());
        Checking c1 = new Checking(bal);
        System.out.print("Enter the Initial Balance of Savings Account");
        bal = Double.parseDouble(s1.nextLine());
        Savings s = new Savings(bal);

        int userSelect;
        double Amount;
        do {
            System.out.println ("what would you like to do \n1.Withdraw from Checking \n2.Withdraw from savings \n3.Deposit to Checking \n4.Deposit to Savings \n5.Balance of Checking\n6.Balance of Savings \n7.Award Interest to savings now \n8.Quit");
            userSelect = s1.nextInt();
            if (userSelect == 1) {
                System.out.println("how much would you like to withdrawal from checking account #" + c1.getAccNumber());
                Amount = s1.nextDouble();
                c1.withdraw(Amount);
            } else if (userSelect == 2) {
                System.out.println("how much would you like to withdrawal from savings account #" + s.getAccNumber());
                Amount = s1.nextDouble();
                s.withdraw(Amount);
            } else if (userSelect == 3) {
                System.out.println("how much would you like to deposit into checking account #" + c1.getAccNumber());
                Amount = s1.nextDouble();
                c1.deposit(Amount);
            } else if (userSelect == 4) {
                System.out.println("how much would you like to deposit into savings account #" + s.getAccNumber());
                Amount = s1.nextDouble();
                s.deposit(Amount);
            } else if (userSelect == 5) {
                System.out.println("Balance of accounts #" + c1.getAccNumber() + " is " + c1.getBal());
            } else if (userSelect == 6) {
                System.out.println("Balance of accounts #" + s.getAccNumber() + " is " + s.getBal());
            } else if (userSelect == 7) {
                s.addInterest();
            } else if (userSelect == 8) {
                //do nothing
            }
        } while (userSelect != 8);


    }
}
