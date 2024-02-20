import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class assignment_3 {
    public static pokemon spawn() {
        Random r1 = new Random();
        int levelGen = r1.nextInt(21);
        int spawnNum = r1.nextInt(4);

        pokemon newPokemon;
        if (spawnNum == 1) {
            newPokemon = new bulbasaur(levelGen);
            System.out.println("You encountered a level " + spawnNum + " bulbasaur");
        } else if (spawnNum == 2) {
            newPokemon = new charmander(levelGen);
            System.out.println("You encountered a level " + spawnNum + " charmander");
        } else {
            newPokemon = new caterpie(levelGen);
            System.out.println("You encountered a level " + spawnNum + " caterpie");
        }
        return newPokemon;
    }

    public static float throwBall() {
        System.out.println("what type of ball do you wish to use \n1.Pokeball \n2.Great Ball \n3.ultraball");
        Scanner s2 = new Scanner(System.in);
        int ballChoise = s2.nextInt();
        float ballMultiplier = 0;
        float berryMultiplier = 0;
        float curveMultiplier = 0;

        if (ballChoise == 1) {
            ballMultiplier = 1f;
        } else if (ballChoise == 2) {
            ballMultiplier = 1.5f;
        } else {
            ballMultiplier = 2f;
        }

        System.out.println("what type of berry do you wish to use \n1.none \n2.Razz \n3.SilverPinap \n4.GoldenRazz");
        int berryChoice = s2.nextInt();
        if (berryChoice == 2) {
            berryMultiplier = 1.5f;
        } else if (berryChoice == 3) {
            berryMultiplier = 1.8f;
        } else if (berryChoice == 4) {
            berryMultiplier = 2.5f;
        } else {
            berryMultiplier = 1f;
        }

        System.out.println("would you like to use a curveball (Y or N)");
        String curveChoice = s2.nextLine();
        if (Objects.equals(curveChoice, "Y")) {
            curveMultiplier = 1.7f;
        } else {
            curveMultiplier = 1f;
        }

        return curveMultiplier * berryMultiplier * ballMultiplier;
    }


    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        pokedex myDex = new pokedex();

        char userChoice = 0;
        do {
            pokemon newPokemon = spawn();
            boolean isCaught = false;
            while (!isCaught) {
                double cpm = 0.49985844;
                double multiplier = throwBall();
                //math powers https://www.geeksforgeeks.org/math-pow-method-in-java-with-example/
                double catchProbability = 1 - Math.pow((1 - (newPokemon.getBaseCatchRate() / (2 * cpm))), multiplier);

                Random r1 = new Random();
                int randNum = r1.nextInt(2);
                if (randNum < catchProbability) {
                    myDex.addToDex(newPokemon);
                    System.out.println("A level " + newPokemon.getLvl() + " " + newPokemon.getClass().getName() + " has been caught");
                    isCaught = true;
                } else {
                    System.out.println("oops a level " + newPokemon.getLvl() + " " + newPokemon.getClass().getName() + " jumped out, try again!");
                }
                System.out.println("Do you wish to continue?");
                userChoice = s1.next().charAt(0);
            }
        } while (userChoice == 'Y');
        System.out.println("Current pokemon:\n " +  myDex);
    }
}

class pokemon{
    private int lvl;
    private double baseCatchRate;

    public pokemon(int lvl, double baseCatchRate){
        lvl = 0;
        baseCatchRate = 0;
    }
    //getters
    public double getBaseCatchRate() {
        return baseCatchRate;
    }
    public int getLvl() {
        return lvl;
    }
    //setters
    public void setBaseCatchRate(double baseCatchRate) {
        this.baseCatchRate = baseCatchRate;
    }
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
}

class bulbasaur extends pokemon {
    public bulbasaur(int lvl) {
        super(lvl,0.2);
    }
    @Override
    public String toString(){
        return "a level " + super.getLvl() + " bulbasaur";
    }
}

class caterpie extends pokemon {
    public caterpie(int lvl) {
        super(lvl,0.5);
    }
    @Override
    public String toString(){
        return "a level " + super.getLvl() + " caterpie";
    }
}

class charmander extends pokemon {
    public charmander(int lvl) {
        super(lvl,0.2);
    }
    @Override
    public String toString(){
        return "a level" + super.getLvl() + " charmander";
    }
}

class pokedex {
    private ArrayList<pokemon> myPokedex = new ArrayList<pokemon>();

    public void addToDex(pokemon newPokemon){
        myPokedex.add(newPokemon);
    }

    @Override
    public String toString() {
       StringBuilder allCaught = new StringBuilder();
       for(int i = 0; i< myPokedex.size(); i++){
           allCaught.append(myPokedex.get(i).toString());
       }
       return allCaught.toString();
    }

}

