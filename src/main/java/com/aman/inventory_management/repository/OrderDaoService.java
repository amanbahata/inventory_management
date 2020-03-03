package com.aman.inventory_management.repository;

import com.aman.inventory_management.model.Order;
import com.aman.inventory_management.util.Util;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class OrderDaoService {

    private static List<Order> orders = new ArrayList<>();
    private static int orderCount = 7;

    private static Util util = new Util();

    static {
        orders.add(new Order(1,"","Suzy","","Customer",3,10, util.convertDateFromString("2014-04-01")));
        orders.add(new Order(2,"","Suzy","","Customer",3,20, util.convertDateFromString("2014-04-22")));
        orders.add(new Order(3,"","Ben","","Thomas",1,5, util.convertDateFromString("2014-04-11")));
        orders.add(new Order(4,"","Johnny","","Test",3,10, util.convertDateFromString("2014-04-02")));
        orders.add(new Order(5,"","Steve","","Smith",1,20, util.convertDateFromString("2014-04-15")));
        orders.add(new Order(6,"","Steve","","Palmer",3,3, util.convertDateFromString("2014-02-22")));
        orders.add(new Order(7,"","Tim","","Scott",3,5, util.convertDateFromString("2014-03-22")));
        orders.add(new Order(8,"","Dave","","Boyd",3,10,util.convertDateFromString("2014-01-22")));
        orders.add(new Order(9,"","Suzy","","Customer",2,30,util.convertDateFromString("2014-01-21")));
        orders.add(new Order(10,"","Dylan","","Test",3,5,util.convertDateFromString("2014-04-23")));
        orders.add(new Order(11,"","Betty","","Fryar",3,12,util.convertDateFromString("2014-04-22")));
        orders.add(new Order(12,"","Jerry","","Sellers",2,124,util.convertDateFromString("2014-04-22")));
        orders.add(new Order(13,"","BOB","","SMITH",2,500,util.convertDateFromString("2014-05-11")));
        orders.add(new Order(14,"","Suzy","","Customer",5,5,util.convertDateFromString("2015-04-07")));
        orders.add(new Order(15,"","Suzy","","Customer",9,50,util.convertDateFromString("2015-04-07")));
        orders.add(new Order(16,"","Suzy","","Customer",3,1,util.convertDateFromString("2015-04-07")));
        orders.add(new Order(17,"","Suzy","","Customer",10,5,util.convertDateFromString("2015-09-09")));
        orders.add(new Order(18,"","john","","lemeasure",10,12,util.convertDateFromString("2016-02-05")));
        orders.add(new Order(19,"","Suzy","","Customer",9,2,util.convertDateFromString("2017-02-25")));
        orders.add(new Order(20,"","","","",9,1,util.convertDateFromString("2017-01-15")));
        orders.add(new Order(21,"","llkjh","","kjlkh",11,250,util.convertDateFromString("2017-02-15")));
        orders.add(new Order(22,"","Suzy","","Customer",16,14,util.convertDateFromString("2017-04-05")));
        orders.add(new Order(23,"","Suzy","","Customer",11,50,util.convertDateFromString("2017-06-05")));
        orders.add(new Order(24,"","Suzy","","Customer",9,200,util.convertDateFromString("2017-06-05")));
        orders.add(new Order(25,"","Test","","Cowley",14,12,util.convertDateFromString("2017-11-05")));
        orders.add(new Order(26,"","Elvis","","P",17,900,util.convertDateFromString("2017-04-05")));
        orders.add(new Order(27,"","Elvis","","P",18,9000,util.convertDateFromString("2017-06-05")));
        orders.add(new Order(28,"","","","",4,0,util.convertDateFromString("2017-04-05")));
    }

    public List<Order> findAll(){
        return orders;
    }

    public Order save(Order order){
        if (order.getOrderId() == 0){
            order.setOrderId(++orderCount);
        }
        orders.add(order);
        return order;
    }

    public Order findOne(long id){
        for (Order order: orders){
            if (order.getOrderId() == id){
                return order;
            }
        }
        return null;
    }

    public Order deleteById(long id){
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()){
            Order purchase = iterator.next();
            if (purchase.getOrderId() == id){
                iterator.remove();
                return purchase;
            }
        }
        return null;
    }

    public Order updateById(Order order, long id) {
        int index = IntStream.range(0, orders.size())
                .filter(i -> orders.get(i).getOrderId() == id)
                .findFirst()
                .orElse(-1);

        if (index != -1 ){
            orders.set(index, order);
            return order;
        }
        return null;
    }
}
