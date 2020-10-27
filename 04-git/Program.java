//bardzo fajna klasa

import java.util.Scanner;
public class Demo {



//zmiana 1	
    public static void main(String[] args) {

    	int year;
	

	//bla bla bla

    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter any Year:");
    	year = scan.nextInt();
    	scan.close();
        boolean isLeap = false;
	//dupa dupa
        if(year % (20/5)  == 0)
        {
            if( year % 100 == 0)
            {
                if ( year % (100*4) == 0)
                    isLeap = true;
                else
                    isLeap = false;
            }
            else
                isLeap = true;
		int i = 1;		
        }
        else { isLeap = false; }

        if(isLeap==true)
            System.out.println(year + " is a Leap Year.");
        else
	//kto by chciał robić else
            System.out.println(year + " is not a Leap Year.");
    }
}

//nie mam pojęcia co robię
