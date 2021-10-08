package tictactoe;
import java.util.Scanner ;

public class TicTacToeGame {
    static char [] ch = { '1','2','3','4','5','6','7','8','9'};
    static char turn = 'X';
    public static  void display()
    {
        System.out.println("        "+ch[0]+"   |"+"    "+ch[1]+"   |"+"    "+ch[2]);
        System.out.println("       _______________________");
        System.out.println("        "+ch[3]+"   |"+"    "+ch[4]+"   |"+"    "+ch[5]);
        System.out.println("       _______________________");
        System.out.println("        "+ch[6]+"   |"+"    "+ch[7]+"   |"+"    "+ch[8]);

    }
    public static void insertingTheValues()
    {
        Scanner ob = new Scanner(System.in);
        System.out.print(turn+" TURN : PLEASE ENTER THE " + turn+" Symbol : at specified numbers  " );
        int num = ob.nextInt();
        if(turn == 'X' && !(ch[num-1] == 'X' || ch[num-1] == 'O') )
        {

            ch[num-1] = turn;
            System.out.println("\n");
            turn ='O';
        }
        else if(turn == 'O' && !(ch[num-1] == 'X' || ch[num-1] == 'O') )
        {
            ch[num-1] = turn;
            System.out.println("\n");
            turn = 'X';
        }
        else
        {
            System.out.println("the given specified number is already filled");
        }

    }
    public static boolean isFilled()
    {
        int count = 0 ;
        for(int i = 0 ; i < ch.length ; i++)
        {
            if(ch[i] == 'X' || ch[i] == 'O')
            {
                ++count;

            }
        }
        if(count == 9 )
        {
            display();
            System.out.println("The table is completely Filled !!  So the match is drawn ");
            return true;
        }



        return  false;
    }
    public static boolean winning()
    {
        boolean condition =  conditions();
        if(ch[0] == ch[3] && ch[3]== ch[6]
         ||ch[0] ==  ch[1] && ch[1] ==ch[2]
         ||ch[3] ==  ch[4]   && ch[4]==ch[5]
         ||ch[6] ==  ch[7]  && ch[7] == ch[8]
         ||ch[1] ==  ch[4]  && ch[4] == ch[7]
         ||ch[2] == ch[5]  && ch[5]== ch[8]
         ||ch[0] ==  ch[4] && ch[4] == ch[8]
         ||ch[2] ==  ch[4]  && ch[4] == ch[6] )
        {

            display();
            System.out.println("The "+ch[0] + " is Winner !! ");
            return false;
        }
        return  condition ;

    }
    public static boolean conditions()
    {
       if(!isFilled())
       {
           System.out.println("\n");
           display();
           System.out.println();
           insertingTheValues();
           return  true;
       }

       return false;

    }

    public static void main(String[] args) {
        while(winning());
    }
}
