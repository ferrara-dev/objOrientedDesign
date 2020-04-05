package model.itemmodel;


import integration.ItemDetail;

public class ItemModel {
        private String itemDescription;
        public String name;
        public int itemId;
        public double price;
        public int quantity;
        public double totalPrice;
        public String category;
        public double taxRate;

        public ItemModel(ItemDetail itemDetail, int quantity){
                price = itemDetail.getPrice();
                this.quantity = quantity;
                itemId = itemDetail.getItemId();
                name = itemDetail.getName();
                category = itemDetail.getCategory();
                taxRate = Tax.getTax(category);
                calcTotalPrice();

                itemDescription = "Item name : " + name + "\n" +
                        "price/item : " + price + "\n" +
                        "Tax-Rate : " + taxRate + "\n" +
                        "Stock status : " + itemDetail.getStockStatus() +
                        "\n";

        }

        public String toString(){
                return  itemDescription + "\n\n" + "Quantity : " + this.quantity + "\n" +
                        "Total price : " + this.totalPrice + "\n" +
                        "Which of tax : " + taxRate*totalPrice;

        }

        private void calcTotalPrice(){
                totalPrice = quantity*price*(taxRate + 1);
        }

        public void setName(String name) {
                this.name = name;
        }
}
