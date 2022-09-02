import java.util.Map;
import java.util.Scanner;


public class Main {

    static String input;
    static float count;
    static String inputUnit;

    public static void main(String[] args) {
        System.out.println("пиздец ебалова!");
        convertOne();
    }

    static void inputOne(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the initial mass units > ");
        input = in.nextLine();
    }

    static boolean setUnit(){
        String[] inputArr = input.split(" ");
        if(inputArr.length != 2){
            System.out.println("Error, check your input!");
            return false;
        }else{
            count = Float.parseFloat(inputArr[0]);
            inputUnit = inputArr[1];
            return true;
        }
    }

    static void convertOne(){
        inputOne();
        if(!setUnit())
            return;
        if(ton.check(inputUnit)){
            ton.conversationFull(count);
            return;
        } else if (kg.check(inputUnit)) {
            kg.conversationFull(count);
        }else {
            System.out.println("Error, check units!");
        }
    }
}