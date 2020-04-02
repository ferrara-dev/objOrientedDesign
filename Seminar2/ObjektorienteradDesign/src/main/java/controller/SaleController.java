package controller;

import model.SaleModel;

public class SaleController {
    private static model.Model saleModel;

    public String startSale(){
        saleModel = SaleModel.startSale();
        String startConfirmation = "Sale Started";
        return startConfirmation;
    }

     static model.Model getModel(){
        return saleModel;
    }
}
