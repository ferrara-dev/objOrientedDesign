package controller;

import integration.ItemRegestry;
import integration.RegestryCreator;
import model.Calendar;
import model.discountmodel.DiscountEngine;
import model.salemodel.SaleModel;


public class Controller {
    private static SaleModel salemodel;
    private DiscountEngine discountEngine;
    private ItemRegestry itemRegestry;
    private RegestryCreator creator;

    public Controller(RegestryCreator creator){
        this.creator = creator;
        itemRegestry = creator.getItemRegestry();
        discountEngine = new DiscountEngine(creator);
        salemodel = new SaleModel(creator);
    }

    public String startSale(){
        salemodel.startSale();
        String startConfirmation = "Sale Started";
        return startConfirmation;
    }

    public String registerItem(int itemId, int quantity) {
        //call to model
        String displayMessage = salemodel.registerItem(itemId,quantity);
        return displayMessage;
    }

    public String endSale(){
        // call to Salemodel
        return salemodel.endSale();
    }

    public String signalDiscountRequest(String customerId){
        double temp =salemodel.saleDetail.getRunningTotal();
        String priceBeforeDiscount = Double.toString(salemodel.saleDetail.getRunningTotal());

        boolean result = discountEngine.getDiscounts(salemodel.saleDetail, Calendar.getDayOfTheWeek().name(), customerId);
        if(result)
            return "Total discount of :" + (temp-salemodel.saleDetail.getRunningTotal()) + "\n" +
                    "Price before : " + temp + "\n" +
                    "Price after : " +  salemodel.saleDetail.getRunningTotal() + "\n";
        return "No discount available";
    }
}
