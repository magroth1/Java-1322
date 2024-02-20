public class mgroth1_lab1 {

    public static char[][] make_foward()
    {
        char[][] pixel = new char[4][13];
        pixel[0][0]=' ';
        pixel[0][1]=' '; 
        pixel[0][2]='_';
        pixel[0][3]='_';
        pixel[0][4]='_';
        pixel[0][5]='_';
        pixel[0][6]='_';
        pixel[0][7]='_'; 
        pixel[0][8]=' '; 
        pixel[0][9]=' ';
        pixel[0][10]=' ';
        pixel[0][11]=' ';
        pixel[0][12]=' ';
        pixel[1][0]=' ';
        pixel[1][1]='/';
        pixel[1][2]='|'; 
        pixel[1][3]='_'; 
        pixel[1][4]='|'; 
        pixel[1][5]='|';
        pixel[1][6]='_'; 
        pixel[1][7]='\\';
        pixel[1][8]='\''; 
        pixel[1][9]='.';
        pixel[1][10]='_';
        pixel[1][11]='_'; 
        pixel[1][12]=' '; 
        pixel[2][0]='('; 
        pixel[2][1]=' '; 
        pixel[2][2]=' '; 
        pixel[2][3]=' '; 
        pixel[2][4]='_';
        pixel[2][5]=' ';
        pixel[2][6]=' ';
        pixel[2][7]=' '; 
        pixel[2][8]=' ';
        pixel[2][9]='_'; 
        pixel[2][10]=' ';
        pixel[2][11]='_';
        pixel[2][12]='\\';
        pixel[3][0]='=';
        pixel[3][1]='\''; 
        pixel[3][2]='-'; 
        pixel[3][3]='(';
        pixel[3][4]='_';
        pixel[3][5]=')';
        pixel[3][6]='-'; 
        pixel[3][7]='-'; 
        pixel[3][8]='('; 
        pixel[3][9]='_';
        pixel[3][10]=')';
        pixel[3][11]='-'; 
        pixel[3][12]='\'';
        return pixel;
        
    }
    
    public static void printArray(char[][] arrayCar){
        for (int row = 0; row < arrayCar.length; row++)
        {
            for (int col = 0; col < arrayCar[row].length; col++)
            {
                System.out.print(arrayCar[row][col]);
                
            }
       System.out.println(); 
        }
    }
            
    public static char[][] make_mirror(char[][] mirrored) {   
        char[][] backwardsArray = new char[4][13];
        for(int row = 0; row < mirrored.length; row++ ){
            int k = 0;
            for(int col = mirrored[row].length-1; col >= 0; col--){
                backwardsArray[row][k] = mirrored[row][col];
                k++;
            }
        }
        for (int row = 0; row < mirrored.length; row++)
        {
            for (int col = 0; col < mirrored[row].length; col++)
            {
                if (backwardsArray[row][col] == '(')
                    {
                        backwardsArray[row][col] = ')';
                    }
                else if (backwardsArray[row][col] == ')') 
                    {
                        backwardsArray[row][col] = '(';  
                    }
                else if (backwardsArray[row][col] == '/') 
                    {
                        backwardsArray[row][col] = '\\';
                    }
                else if (backwardsArray[row][col] == '\\') 
                    {
                        backwardsArray[row][col] = '/';
                    }
                else {
                    //do nothing
                }
            }
        }
        return backwardsArray;
        /*
        char[][] backwardsArray = new char[4][13];
        backwardsArray[0][12] = mirrored[0][1];
        backwardsArray[0][11] = mirrored[0][2];
        backwardsArray[0][10] = mirrored[0][3];
        backwardsArray[0][9] = mirrored[0][4];
        backwardsArray[0][8] = mirrored[0][5];
        backwardsArray[0][7] = mirrored[0][6];
        backwardsArray[0][6] = mirrored[0][7];
        backwardsArray[0][5] = mirrored[0][8];
        backwardsArray[0][4] = mirrored[0][9];
        backwardsArray[0][3] = mirrored[0][10];
        backwardsArray[0][2] = mirrored[0][11];
        backwardsArray[0][1] = mirrored[0][12];
        backwardsArray[0][0] = mirrored[0][12];
        backwardsArray[1][12] = mirrored[1][1];
        backwardsArray[1][11] = mirrored[1][2];
        backwardsArray[1][10] = mirrored[1][3];
        backwardsArray[1][9] = mirrored[1][4];
        backwardsArray[1][8] = mirrored[1][5];
        backwardsArray[1][7] = mirrored[1][6];
        backwardsArray[1][6] = mirrored[1][7];
        backwardsArray[1][5] = mirrored[1][8];
        backwardsArray[1][4] = mirrored[1][9];
        backwardsArray[1][3] = mirrored[1][10];
        backwardsArray[1][2] = mirrored[1][11];
        backwardsArray[1][1] = mirrored[1][12];

        return backwardsArray;
         */
    }

    public static char[][] doubleArray(char[][] backwards, char[][] normal){
        char[][] BIG = new char[4][26];
        int row = 0;
int col = 0;
while (row < 4)
{
    while (col < 26) {
        if(col < 13){
            BIG[row][col] = normal[row][col];
        }
        else{
            BIG[row][col] = backwards[row][col-normal[row].length];
        }
        col++;
    }
    row++;
    col=0;
}
        return BIG;
    }
  
    public static void main(String[] args) {
        char[][] artArray = make_foward();
        char[][] arrayMirror = make_mirror(artArray);
        char[][] BIG = doubleArray(arrayMirror, artArray);

        printArray(artArray);
        printArray(arrayMirror);
        printArray(BIG);
    }
}

