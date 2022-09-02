import java.util.HashMap;
import java.util.Map;

public class ton {
    static String defaultUnit = "ton";

    static boolean check(String unitIn){
        if(defaultUnit.equalsIgnoreCase(unitIn))
            return true;
        else
            return false;
    }

    Map<String, Float> conversationFull(float value){
        Float pud = new Float(61.05);
        Float ounce = new Float(35273.96);
        Map<String, Float> units = new HashMap<>();
        units.put("kg", value * 1000);
        units.put("gr", value * 1000000);
        units.put("pud", value * pud);
        units.put("ounce", value * ounce);
        return units;
    }
}
