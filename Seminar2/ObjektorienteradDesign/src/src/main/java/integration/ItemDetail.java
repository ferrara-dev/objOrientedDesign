package integration;

public class ItemDetail {
    private String name;
    private String category;
    private double price;
    private int stockStatus;
    private int itemId;

    public ItemDetail(String name) {
        this.name = name;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setStockStatus(int stockStatus) {
        this.stockStatus = stockStatus;
    }

    public int getStockStatus() {
        return stockStatus;
    }

    public String getName() {
        return name;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemDetail{" +
                "name='" + name + '\'' +
                ", id=" + itemId +
                ", price=" + price +
                ", Stock status=" + stockStatus +
                '}';
    }
}

