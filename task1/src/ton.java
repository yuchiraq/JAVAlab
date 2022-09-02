public class ton {
    static String defaultUnit = "ton";

    static boolean check(String unitIn){
        if(defaultUnit.equalsIgnoreCase(unitIn))
            return true;
        else
            return false;
    }

    static void conversationFull(float value){
        float kg = value * 1000;
        float gr = value * 1000000;
        System.out.println(kg + "kg | " + gr + "gr" );
    }
}
