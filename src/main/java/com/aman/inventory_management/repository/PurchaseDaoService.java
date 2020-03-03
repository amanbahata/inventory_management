package com.aman.inventory_management.repository;

import com.aman.inventory_management.model.Purchase;
import com.aman.inventory_management.util.Util;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class PurchaseDaoService {

    private static List<Purchase> purchases = new ArrayList<>();
    private static long productCount = 8;

    private static Util util = new Util();

    static {
        purchases.add(new Purchase(1,2,2,50,util.convertDateFromString("2014-11-02")));
        purchases.add(new Purchase(2,2,1,15,util.convertDateFromString("2014-09-02")));
        purchases.add(new Purchase(3,3,3,10,util.convertDateFromString("2014-11-12")));
        purchases.add(new Purchase(5,2,3,20,util.convertDateFromString("2014-02-22")));
        purchases.add(new Purchase(6,1,1,5,util.convertDateFromString("2015-11-02")));
        purchases.add(new Purchase(7,3,3,3,util.convertDateFromString("2014-01-02")));
        purchases.add(new Purchase(8,1,3,20,util.convertDateFromString("2015-11-11")));
        purchases.add(new Purchase(9,2,1,0,util.convertDateFromString("2014-11-02")));
        purchases.add(new Purchase(10,1,1,5,util.convertDateFromString("2016-11-02")));
        purchases.add(new Purchase(11,2,5,12,util.convertDateFromString("2016-11-02")));
        purchases.add(new Purchase(12,2,3,90,util.convertDateFromString("2016-11-02")));
        purchases.add(new Purchase(13,1,6,23,util.convertDateFromString("2016-08-02")));
        purchases.add(new Purchase(14,2,10,25,util.convertDateFromString("2017-11-02")));
        purchases.add(new Purchase(15,2,10,3,util.convertDateFromString("2017-11-02")));
        purchases.add(new Purchase(16,1,10,0,util.convertDateFromString("2017-01-02")));
        purchases.add(new Purchase(17,1,2,0,util.convertDateFromString("2017-02-22")));
        purchases.add(new Purchase(18,2,1,10,util.convertDateFromString("2017-03-02")));
        purchases.add(new Purchase(19,2,9,12,util.convertDateFromString("2017-03-03")));
        purchases.add(new Purchase(20,2,13,1234,util.convertDateFromString("2017-05-12")));
        purchases.add(new Purchase(21,1,12,0,util.convertDateFromString("2017-05-22")));
        purchases.add(new Purchase(22,1,13,0,util.convertDateFromString("2017-06-12")));
        purchases.add(new Purchase(23,2,3,0,util.convertDateFromString("2017-08-02")));
        purchases.add(new Purchase(24,3,9,400,util.convertDateFromString("2017-10-02")));
        purchases.add(new Purchase(25,1,14,0,util.convertDateFromString("2017-11-02")));
        purchases.add(new Purchase(26,2,16,12,util.convertDateFromString("2017-11-30")));
        purchases.add(new Purchase(27,1,3,0,util.convertDateFromString("2017-07-02")));
        purchases.add(new Purchase(28,3,17,33,util.convertDateFromString("2017-07-12")));
        purchases.add(new Purchase(29,1,18,453,util.convertDateFromString("2017-07-23")));
        purchases.add(new Purchase(30,2,18,22,util.convertDateFromString("2017-11-02")));
    }

    public List<Purchase> findAll(){
        return purchases;
    }

    public Purchase save(Purchase purchase){
        if (purchase.getPurchaseId() == 0){
            purchase.setPurchaseId(++productCount);
        }
        purchases.add(purchase);
        return purchase;
    }

    public Purchase findOne(long id){
        for (Purchase purchase: purchases){
            if (purchase.getPurchaseId() == id){
                return purchase;
            }
        }
        return null;
    }

    public Purchase deleteById(long id){
        Iterator<Purchase> iterator = purchases.iterator();
        while (iterator.hasNext()){
            Purchase purchase = iterator.next();
            if (purchase.getPurchaseId() == id){
                iterator.remove();
                return purchase;
            }
        }
        return null;
    }

    public Purchase updateById(Purchase purchase, long id) {
        int index = IntStream.range(0, purchases.size())
                .filter(i -> purchases.get(i).getPurchaseId() == id)
                .findFirst()
                .orElse(-1);

        if (index != -1 ){
            purchases.set(index, purchase);
            return purchase;
        }
        return null;
    }
}
