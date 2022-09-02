import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main{

    public final static void clearConsole() {
        try
        {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    public static void main(String[] args) {
        System.out.println("пиздец ебалова!");
        Main conversion = new Main();
        conversion.menu();
    }

    void menu(){
        Scanner scan = new Scanner(System.in);
        int key = 0;
        while(true){
            clearConsole();
            System.out.println("Choose smth:");
            System.out.println("0 - Convert 1 unit;");
            System.out.println("1 - Arithmetic;");
            System.out.println("3 - exit");
            key = scan.nextInt();
            switch (key){
                case 0:
                    One task1 = new One();
                    task1.convertOne();
                    break;
                case 1:
                    Arithmetic task2 = new Arithmetic();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Check menu!");
            }
        }
    }

    class One{

        String input;
        float count;
        String inputUnit;

        void inputOne(){
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the initial mass units > ");
            input = in.nextLine();
        }

        boolean setUnit(){
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

        void convertOne(){
            Map<String, Float> outMap = new HashMap<>();
            inputOne();
            if(!setUnit())
                return;
            if(ton.check(inputUnit)){
                ton tonClass = new ton();
                outMap = tonClass.conversationFull(count);
            } else if (kg.check(inputUnit)) {
                kg kgClass = new kg();
                outMap = kgClass.conversationFull(count);
            }else {
                System.out.println("Error, check units!");
            }
            if(!outMap.isEmpty())
                convertOut(outMap);
        }

    }

    class Arithmetic{

    }

    void convertOut(Map<String, Float> outMap){
        for(Map.Entry entry: outMap.entrySet()) {
            System.out.print("= " + entry.getValue() + " " + entry.getKey() + " ");
        }
        System.out.println();
    }
}