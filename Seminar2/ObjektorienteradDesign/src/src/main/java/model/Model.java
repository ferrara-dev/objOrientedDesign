package model;


public interface Model{
    String [] CATEGORIES= new String[]{"Viand","Misc","literature"};
    String registerItem(int itemId, int quantity);
    void startSale();
    String endSale();
}
