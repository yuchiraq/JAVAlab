public class kg {
    static String defaultUnit = "kg";

    static boolean check(String unitIn){
        if(defaultUnit.equalsIgnoreCase(unitIn))
            return true;
        else
            return false;
    }

    static void conversationFull(float value){
        float ton = value / 1000;
        float gr = value * 1000;
        System.out.println(ton + "ton | " + gr + "gr" );
    }
}
