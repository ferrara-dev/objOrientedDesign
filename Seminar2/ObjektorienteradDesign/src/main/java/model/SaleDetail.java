package model;

public class SaleDetail {
    private ProcessedGoods processedGoods;
    private SaleLineItem saleLineItem;
    private int saleId = 0;
    public static boolean active;
    public boolean completed;
    private double runningTotal = 0;

    public SaleDetail(){
        saleId ++;
        completed = false;
        active = true;
        processedGoods = new ProcessedGoods();
    }

    public double getRunningTotal() {
        return runningTotal;
    }

    public void setRunningTotal(double runningTotal) {
        this.runningTotal = runningTotal;
    }

    public void recaluclateRunningTotal(double numb){
        this.runningTotal += numb;
    }

    public SaleLineItem getSaleLineItem() {
        return saleLineItem;
    }

    public void setSaleLineItem(SaleLineItem saleLineItem) {
        this.saleLineItem = saleLineItem;
    }

    public ProcessedGoods getProcessedGoods() {
        return processedGoods;
    }

    public void setProcessedGoods(ProcessedGoods processedGoods) {
        this.processedGoods = processedGoods;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }
}
