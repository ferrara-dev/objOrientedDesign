package integration.productdb;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ProductDB {

    public static final int HEADERS_POSITION = 0;
    public static final int HEADER_VALUES_START_POSITION = 0;
    public static final int PRODUCTS_START_POSITION = 1;
    private static final String SEMICOLON = ";";


    private final String FILENAME = "dbtest.csv";
    private List<String> rows;
    private List<String> headers;
    static Map<String,List<String>> products;



    public void load() throws Exception {
        rows = Files.readAllLines(Paths.get(this.getClass().getClassLoader().getResource(FILENAME).toURI()), Charset.forName("UTF-8"));
        headers = extractHeaders(rows);
        products = extractProducts(rows);
    }

    private List<String> extractHeaders(final List<String> rows) {
        final List<String> headers = new ArrayList<>();
        List<String> arr = Arrays.asList(rows.get(HEADERS_POSITION).split(SEMICOLON));
        IntStream.range(HEADER_VALUES_START_POSITION,  arr.size()).forEach(index-> headers.add(arr.get(index)));
        return headers;
    }

    private Map<String,List<String>> extractProducts(final List<String> rows) {
        final Map<String,List<String>> products = new HashMap<>();
        IntStream.range(PRODUCTS_START_POSITION, rows.size()).forEach(index-> {
            String[] row = rows.get(index).split(SEMICOLON);

            String key = row[0];
            //System.out.println("key: " + key);
            String[] values = Arrays.copyOfRange(row, 0, 7);
            List<String> listOfValues = Arrays.asList(values);
            List<String> modifiedList = new ArrayList<>();
            listOfValues.forEach(value->{
                modifiedList.add(value.replace(",", "."));
            });
            //System.out.println("values: " + listOfValues);
            products.put(key,  modifiedList);
        });
        return products;
    }

    public List<Item> createProductList() {
        List<Item> searchResult = new ArrayList<>();
        products.keySet().forEach(product->{
            Item product1 = new Item(product);
            product1.itemDetail.setPrice(Double.parseDouble(products.get(product).get(3)));
            product1.itemDetail.setCategory(products.get(product).get(4));
            product1.itemDetail.setItemId(Integer.parseInt(products.get(product).get(5)));
            product1.itemDetail.setStockStatus(Integer.parseInt(products.get(product).get(6)));

            searchResult.add(product1);
        });
        return searchResult;
    }

    public void printResult(List<String> result) {
        System.out.println("Search result: " + result);
        result.forEach(key->{
            System.out.println("======================================================");
            System.out.println("Product: " + key);
            System.out.println("======================================================");
            IntStream.range(0, 5).forEach(index-> {
                String nutritionKey = headers.get(index);
                //System.out.println( products.get(key).size());
                if(index<products.get(key).size() && products.containsKey(key)) {
                    System.out.println(nutritionKey + ": " + products.get(key).get(index));
                }
            });
        });
    }
}

