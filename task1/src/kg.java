import java.util.HashMap;
import java.util.Map;

public class kg {
    static String defaultUnit = "kg";

    static boolean check(String unitIn){
        if(defaultUnit.equalsIgnoreCase(unitIn))
            return true;
        else
            return false;
    }

    Map<String, Float> conversationFull(Float value){
        Float pud = new Float(0.061);
        Float ounce = new Float(35.27);
        Map<String, Float> units = new HashMap<>();
        units.put("ton", value / 1000);
        units.put("gr", value * 1000);
        units.put("pud", value * pud);
        units.put("ounce", value * ounce);
        return units;
    }
}
