package model;


import dbhandler.ItemDetail;

public interface Model{
    dbhandler.ItemRegestry itemRegestry = new dbhandler.RegestryCreator().createProductList();

    String registerItem(int itemId, int quantity);
}
