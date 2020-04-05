package integration;

import integration.discountdb.DiscountDB;
import integration.discountdb.DiscountOffer;


import java.util.List;

public class DiscountRegestry {
   public static List<DiscountOffer> discountList;

    public DiscountRegestry(){
        discountList = DiscountDB.createDiscountList();
    }

    public DiscountOffer getDiscountOffer(String dayOfTheWeek){
        for(DiscountOffer offer: discountList){
            if(offer.rule.description.equals(dayOfTheWeek)){
                return offer;
            }
        }
        return null;
    }



}
