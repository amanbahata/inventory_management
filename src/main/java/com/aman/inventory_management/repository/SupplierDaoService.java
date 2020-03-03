package com.aman.inventory_management.repository;

import com.aman.inventory_management.model.Supplier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class SupplierDaoService {

    private static List<Supplier> suppliers = new ArrayList<>();
    private static long supplierCount = 8;


    static {
        suppliers.add(new Supplier(1,"ShockWave Tech"));
        suppliers.add(new Supplier(2,"CDW"));
        suppliers.add(new Supplier(3,"ACME Tech Supplies"));
    }

    public List<Supplier> findAll(){
        return suppliers;
    }

    public Supplier save(Supplier supplier){
        if (supplier.getSupplierId() == 0){
            supplier.setSupplierId(++supplierCount);
        }
        suppliers.add(supplier);
        return supplier;
    }

    public Supplier findOne(long id){
        for (Supplier supplier: suppliers){
            if (supplier.getSupplierId() == id){
                return supplier;
            }
        }
        return null;
    }

    public Supplier deleteById(long id){
        Iterator<Supplier> iterator = suppliers.iterator();
        while (iterator.hasNext()){
            Supplier supplier = iterator.next();
            if (supplier.getSupplierId() == id){
                iterator.remove();
                return supplier;
            }
        }
        return null;
    }

    public Supplier updateById(Supplier supplier, long id) {
        int index = IntStream.range(0, suppliers.size())
                .filter(i -> suppliers.get(i).getSupplierId() == id)
                .findFirst()
                .orElse(-1);

        if (index != -1 ){
            suppliers.set(index, supplier);
            return supplier;
        }
        return null;
    }
}
