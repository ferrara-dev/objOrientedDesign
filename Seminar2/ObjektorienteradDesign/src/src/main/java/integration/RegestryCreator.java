package integration;

import integration.ItemRegestry;
import integration.discountdb.DiscountDB;
import integration.discountdb.DiscountOffer;
import integration.productdb.ProductDB;

public class RegestryCreator {
    static ItemRegestry itemRegestry;
    static DiscountRegestry discountRegestry;
    static final String [] DISCOUNT_TYPES = {"2-for-1","10% off", ""};

    public void createItemRegestry() throws Exception {
        ProductDB db = new ProductDB();
        db.load();
        itemRegestry = new ItemRegestry(db.createProductList());

    }

    static public ItemRegestry getItemRegestry() {
        return itemRegestry;
    }

    public DiscountRegestry getDiscountRegestry(){
        return discountRegestry;
    }

    public void createDiscountRegestry() throws Exception {
        DiscountDB db = new DiscountDB();
        db.load();
        //DiscountOffer ProductDiscount1 = new DiscountOffer("product",1,{})
       discountRegestry = new DiscountRegestry();
    }


}
