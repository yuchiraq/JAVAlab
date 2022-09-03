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
                    task1 = null;
                    break;
                case 1:
                    Arithmetic task2 = new Arithmetic();
                    task2.start();
                    task2 = null;
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

    class Arithmetic {

        String units;
        Float[] values;
        String[] action;

        String task;


        void start() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Ex: 15 kg + 45 ton" + '\n' + "only kg/ton");
            System.out.print("Enter ur task > ");
            task = scan.nextLine();
            if (!this.checkUnits())
                return;
            System.out.println(" Start conv");
            if (!conversion())
                return;
            logic();
            //System.out.println("gmkfgd");
            System.out.println("= " + values[values.length - 1] + " " + units);
        }

        boolean checkUnits() {
            if (this.task.split(" ")[1].equalsIgnoreCase("kg"))
                this.units = "kg";
            else if (this.task.split(" ")[1].equalsIgnoreCase("ton"))
                this.units = "ton";
            else {
                System.out.println("Error > only kg or ton");
                return false;
            }
            return true;
        }

        boolean conversion() {
            String[] task_splited = task.split(" ");

            int count_values = (int) (task_splited.length / 3);

            Float[] values_here;
            values_here = new Float[count_values + 1];

            if (units.equalsIgnoreCase("kg")) {
                int i = 0, j = 0;
                for (; i <= task_splited.length; ) {
                    if (task_splited[i + 1].equalsIgnoreCase("kg")) {
                        values_here[j] = Float.parseFloat(task_splited[i]);
                    } else if (task_splited[i + 1].equalsIgnoreCase("ton")) {
                        ton ton_task = new ton();
                        Map<String, Float> map;
                        map = ton_task.conversationFull(Float.parseFloat(task_splited[i]));
                        values_here[j] = map.get("kg");
                    } else {
                        System.out.println("Incorrect units!" + '\n' + "Only ton/kg");
                        return false;
                    }
                    i += 3;
                    j++;
                }
            } else if (units.equalsIgnoreCase("ton")) {
                int i = 0, j = 0;
                for (; i <= task_splited.length; ) {
                    if (task_splited[i + 1].equalsIgnoreCase("ton")) {
                        values_here[j] = Float.parseFloat(task_splited[i]);
                    } else if (task_splited[i + 1].equalsIgnoreCase("kg")) {
                        kg kg_task = new kg();
                        Map<String, Float> map;
                        map = kg_task.conversationFull(Float.parseFloat(task_splited[i]));
                        values_here[j] = map.get("ton");
                    } else {
                        System.out.println("Incorrect units!" + '\n' + "Only ton/kg");
                        return false;
                    }
                    i += 3;
                    j++;
                }
            } else {
                System.out.println("Incorrect units!" + '\n' + "Only ton/kg");
                return false;
            }

            String[] action_here = new String[++count_values];
            int i = 2;
            int j = 0;
            while(i < task_splited.length){
                action_here[j] = task_splited[i];
                i +=3;
                j++;
            }

            this.action = action_here;
            this.values = values_here;
            return true;
        }

        void logic(){
            System.out.print(values[0] + " " + units + " " + action[0] + " " + values[1] + " " + units + " " );
            int action_count = action.length - 1, i = 0;
            while(i < action_count){
                if(action[i].equalsIgnoreCase("+")){
                    values[i + 1] = values[i] + values[i + 1];
                } else if (action[i].equalsIgnoreCase("-")) {
                    //System.out.println(" zolupa");
                    values[i + 1] = values[i] - values[i + 1];
                }
                i++;
            }
        }
    }


    void convertOut(Map<String, Float> outMap){
        for(Map.Entry entry: outMap.entrySet()) {
            System.out.print("= " + entry.getValue() + " " + entry.getKey() + " ");
        }
        System.out.println();
    }
}