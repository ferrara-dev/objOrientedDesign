package model.itemmodel;

import java.util.HashMap;
import java.util.Map;

public class Tax {
    private static final Map<String, Double> taxRates =
            Map.of("Misc",0.25,"Viand",0.125,"Literature",0.06);

     static double getTax(String key){
        return taxRates.get(key);
    }

}