package integration.discountdb;

import integration.DiscountDescription;

public class DiscountOffer {
    public DiscountDescription rule;
    public DiscountOffer(int id){
        rule = new DiscountDescription(id);
    }

}
