import java.util.Scanner;

public class Input {
    public static int getInteger(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        while(!sc.hasNextInt()){
            System.err.println("Error, not an integer");
            sc.next();
        }
        return sc.nextInt();
    }

    public static String getString(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.next();
    }
}