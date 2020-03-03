package com.aman.inventory_management.repository;

import com.aman.inventory_management.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class ProductDaoService {

    private static List<Product> products = new ArrayList<>();
    private static long productCount = 8;
    

    static {
        products.add(new Product(1,"Dell Server","XP 2000",
                "Dell Server- XP 2000",100007,35,25,100017,15));
        products.add(new Product(2,"Google Chromebooks","1",
                "Google Chromebooks- 1.0",100,75,654,-479,20));
        products.add(new Product(3,"Cisco Router",
                "10X","Cisco Router- 10X",45,143,76,86,88));
        products.add(new Product(4,"sadasd",
                "21","sadasd- 21",25,0,0,25,10));
        products.add(new Product(5,"Semih",
                "37","Semih- 37",1,12,5,8,5));
        products.add(new Product(6,"crazy horse router",
                "123DF5","crazy horse router- 123DF5",5,23,0,28,1));
        products.add(new Product(7,"Monitors",
                "","Monitors - 999",0,0,0,0,0));
        products.add(new Product(8,"TEST",
                "123","TEST- 123",10,0,0,10,10));
        products.add(new Product(9,"bob","bob-1",
                "bob- bob-1",500,412,267,6450,400));
        products.add(new Product(10,"Multimeter","c345",
                "Multimeter- c345",3,28,29,2,4));
        products.add(new Product(11,"dfgdf","54334",
                "dfgdf- 54334",0,0,300,-300,0));
        products.add(new Product(12,"UniBox","1",
                "UniBox- 1",200,0,0,200,300));
        products.add(new Product(13,"Test 1","123456",
                "Test 1- 123456",50,1234,0,1284,10));
        products.add(new Product(14,"Toby","57456",
                "Toby- 57456",567,22,12,577,56467));
        products.add(new Product(15,"sdsad","sdsdsad",
                "sdsad- sdsdsad",12,0,0,12,12));
        products.add(new Product(16,"test","55555",
                "test- 55555",500,12,0,512,25));
        products.add(new Product(17,"Firewalls","362436",
                "Firewalls- 362436",5,33,900,-862,10));
        products.add(new Product(18,"Cables","7734",
                "Cables- 7734",9,475,9000,16,100));
        products.add(new Product(19,"Test","1",
                "Test- 001",25,0,0,25,222));
    }

    public List<Product> findAll(){
        return products;
    }

    public Product save(Product product){
        if (product.getProductId() == 0){
            product.setProductId(++productCount);
        }
        products.add(product);
        return product;
    }

    public Product findOne(long id){
        for (Product product: products){
            if (product.getProductId() == id){
                return product;
            }
        }
        return null;
    }

    public Product deleteById(long id){
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()){
            Product product = iterator.next();
            if (product.getProductId() == id){
                iterator.remove();
                return product;
            }
        }
        return null;
    }

    public Product updateById(Product product, java.lang.Long id) {
        int index = IntStream.range(0, products.size())
                .filter(i -> products.get(i).getProductId() == id)
                .findFirst()
                .orElse(-1);

        if (index != -1 ){
            products.set(index, product);
            return product;
        }
        return null;
    }
}
