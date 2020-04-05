package model.discountmodel;

import integration.DiscountDescription;
import model.itemmodel.ItemModel;

public class DiscountRules {
    ItemModel dailyItem;
    String type;
    String description;
    public DiscountRules(DiscountDescription description){
        dailyItem = new ItemModel(description.discountItem,1);
        this.type = description.type;
        this.description = description.description;
    }
}
