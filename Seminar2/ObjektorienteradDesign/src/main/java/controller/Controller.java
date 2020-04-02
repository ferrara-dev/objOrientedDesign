package controller;

import model.ProcessedGoods;
import model.SaleModel;

public class Controller {
    model.Model salemodel;

    public String startSale(){
        salemodel = SaleModel.startSale();
        String startConfirmation = "Sale Started";
        return startConfirmation;
    }

    public String registerItem(int itemId, int quantity){
        String displayMessage = salemodel.registerItem(itemId,quantity);
        return displayMessage;
        //call to model
    }

}
