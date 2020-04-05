package integration;

import integration.customerdb.Customer;
import integration.productdb.Item;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DiscountDescription {
    public String type;
    public String description;
    public ItemDetail discountItem;


    public DiscountDescription(int id) {
        discountItem = RegestryCreator.getItemRegestry().getItemDetail(id);
    }

}
