package com.patika.onlinealisveris;

import com.patika.onlinealisveris.datamanager.BillManager;
import com.patika.onlinealisveris.datamanager.CustomerManager;
import com.patika.onlinealisveris.datamanager.OrderManager;
import com.patika.onlinealisveris.datamanager.ProductManager;
import com.patika.onlinealisveris.enums.CategoryType;
import com.patika.onlinealisveris.model.Bill;
import com.patika.onlinealisveris.model.Customer;
import com.patika.onlinealisveris.model.Order;
import com.patika.onlinealisveris.model.Product;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
public class MainApplication {

    private static final String LINE_SEPERATOR = "*********************************************************";

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        CustomerManager customerManager = new CustomerManager();
        BillManager billManager = new BillManager(customerManager);
        OrderManager orderManager = new OrderManager();


        Customer batuhan =
                new Customer("Batuhan", "Akbaş", LocalDate.of(1997, 11, 11), "Izmir");

        Customer cem =
                new Customer("Cem", "Dırman", LocalDate.of(1995, 1, 1), "Istanbul");

        customerManager.addCustomerToDatabase(batuhan);
        customerManager.addCustomerToDatabase(cem);

        Product mouse = new Product("Logitech Mouse", BigDecimal.valueOf(200), 30, CategoryType.ELECTRONICS);
        Product keyboard = new Product("Logitech Keyboard", BigDecimal.valueOf(500), 12, CategoryType.ELECTRONICS);
        Product macbookAir = new Product("Apple Macbook Air", BigDecimal.valueOf(20000), 5, CategoryType.ELECTRONICS);
        Product sofa = new Product("Sofa", BigDecimal.valueOf(400), 80, CategoryType.FURNITURE);
        Product carpet = new Product("Carpet", BigDecimal.valueOf(100), 147, CategoryType.FURNITURE);
        Product tie = new Product("Black Tie", BigDecimal.valueOf(20), 64, CategoryType.CLOTHING);
        Product earrings = new Product("Earrings", BigDecimal.valueOf(40), 31, CategoryType.ACCESSORY);

        productManager.addProducts(List.of(mouse, keyboard, macbookAir, sofa, carpet, tie, earrings));

        Order order1 = new Order(batuhan, batuhan.getAddress());
        order1.addProductToOrder(new Product("Logitech Mouse", BigDecimal.valueOf(200), 5, CategoryType.ELECTRONICS));
        order1.addProductToOrder(new Product("Apple Macbook Air", BigDecimal.valueOf(20000), 1, CategoryType.ELECTRONICS));

        Order order2 = new Order(cem, cem.getAddress());
        order2.addProductToOrder(new Product("Black Tie", BigDecimal.valueOf(20), 4, CategoryType.CLOTHING));
        order2.addProductToOrder(new Product("Apple Macbook Air", BigDecimal.valueOf(20000), 2, CategoryType.ELECTRONICS));

        Order order3 = new Order(cem, cem.getAddress());
        order3.addProductToOrder(new Product("Earrings", BigDecimal.valueOf(200), 4, CategoryType.ACCESSORY));

        batuhan.setOrderList(List.of(order1));
        cem.setOrderList(List.of(order2, order3));

        orderManager.addOrdersToDatabase(List.of(order1, order2, order3));

        Bill bill1 = new Bill(order1);
        Bill bill2 = new Bill(order2);

        billManager.addBillToDatabase(bill1);
        billManager.addBillToDatabase(bill2);


        log.info(String.valueOf(customerManager.getCustomerAmount()));

        log.info(LINE_SEPERATOR);

        log.info(String.valueOf(billManager.calculateTotalBillAmountOfGivenCustomerNameBetweenAgeOf25And30(cem.getName())));

        log.info(LINE_SEPERATOR);

        log.info(String.valueOf(billManager.findBillsThatTotalOverGivenAmount(BigDecimal.valueOf(1500))));

        log.info(LINE_SEPERATOR);

        log.info(String.valueOf(billManager.calculateTotalProductSoldToGivenCustomerName(cem.getName())));
    }
}
