package model.discountmodel;


import integration.DiscountRegestry;
import integration.RegestryCreator;
import model.itemmodel.ItemModel;
import model.salemodel.SaleDetail;

public class DiscountEngine {
    DiscountRegestry discountRegestry;

    private final String TWENTY_OF = "20% price reduction";
    private final String THREE_FOR_TWO = "3-for-2";
    private  double discountRate = 0.0;
    private DailyOffer dailyOffer;

    public DiscountEngine(RegestryCreator creator) {
        discountRegestry = creator.getDiscountRegestry();
    }

    public boolean getDiscounts(SaleDetail saleDetail, String dayOfWeek, String customerId) {
        if (isEligible(customerId)) {
            processDailyProductOffers(saleDetail, dayOfWeek);
            return true;

        }

        return false;
    }

    private void processDailyProductOffers(SaleDetail saleDetail, String dayOfWeek){
        DailyOffer dailyOffer = new DailyOffer(new DiscountRules(discountRegestry.getDiscountOffer(dayOfWeek).rule));
        if (dailyOffer.rules.type.equals(TWENTY_OF)) {
            discountRate = 0.2;
            applyProductDiscount(saleDetail, dailyOffer);
        } else if (dailyOffer.rules.type.equals(THREE_FOR_TWO)) {
            applyQuantityDiscount(saleDetail, dailyOffer);
        }
    }

    private void applyProductDiscount(SaleDetail saleDetail, DailyOffer dailyOffer) {
        if (saleDetail.getProcessedGoods().contains(dailyOffer.rules.dailyItem.itemId)) {
            saleDetail.applyDiscount((discountRate) * dailyOffer.rules.dailyItem.totalPrice * saleDetail.getProcessedGoods().getItem(dailyOffer.rules.dailyItem.itemId).quantity);
        }
    }

    private void applyQuantityDiscount(SaleDetail saleDetail, DailyOffer dailyOffer) {
        if (saleDetail.getProcessedGoods().contains(dailyOffer.rules.dailyItem.itemId)) {
            for (int i = 0; i < saleDetail.getProcessedGoods().getItem(dailyOffer.rules.dailyItem.itemId).quantity; i++) {
                if (i % 3 == 0)
                    saleDetail.applyDiscount(dailyOffer.rules.dailyItem.totalPrice);
            }
        }
    }

    private boolean isEligible(String customerId) {
        if (integration.customerdb.CustomerDB.find(customerId)) {
            return true;
        }
        return false;
    }

    public double getPriceDiscount(SaleDetail saleDetail) {


        return 0;
    }

    private ItemModel getDailyOffer(String dayOfTheWeek) {
        return new ItemModel(discountRegestry.getDiscountOffer(dayOfTheWeek).rule.discountItem, 1);
    }


}
