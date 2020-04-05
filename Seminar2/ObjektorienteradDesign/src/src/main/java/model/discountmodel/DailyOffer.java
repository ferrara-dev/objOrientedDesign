package model.discountmodel;
import integration.DiscountRegestry;
import integration.RegestryCreator;
import integration.productdb.Item;
import model.Calendar;
import model.customermodel.CustomerId;
import model.itemmodel.ItemModel;
import model.salemodel.SaleDetail;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class DailyOffer {
    DiscountRules rules;
    private static java.time.DayOfWeek currentDay;
    double priceReduction = 0.0;

    public DailyOffer(DiscountRules rules) {
        currentDay = Calendar.getDayOfTheWeek();
        this.rules = rules;

    }

    public double getDailyOffer(){

        return 0;
    }
}
