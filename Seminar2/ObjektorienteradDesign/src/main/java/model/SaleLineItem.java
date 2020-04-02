package model;


import dbhandler.ItemDetail;

public class SaleLineItem{
        public int itemId;
        public double price;
        public int quantity;
        public double totalPrice;

        public SaleLineItem(ItemDetail itemDetail, int quantity){
                setPrice(itemDetail.price);
                setQuantity(quantity);
                setItemId(itemDetail.itemId);
                calcTotalPrice();
        }

        public String toString(){
                return "Price : " + this.totalPrice +"\n" +
                        "Quantity : " + this.quantity + "\n";
        }

        private void setPrice(double price){
                this.price = price;
        }

        private void setQuantity(int quantity){
                this.quantity = quantity;
        }

        private void setItemId(int itemId){
                this.itemId = itemId;
        }

        private void calcTotalPrice(){
                totalPrice = quantity*price;
        }
}
