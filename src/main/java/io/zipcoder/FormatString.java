package io.zipcoder;

import java.util.*;

public class FormatString {



    public Map<String, Map<Double,Integer>> itemMap (ArrayList<Item> items){
        Map<String, Map<Double,Integer>> itemMap = new HashMap<String, Map<Double,Integer>>();
        for(Item item : items){
            Map<Double,Integer> priceList = itemMap.getOrDefault(item.getName(),new HashMap<Double,Integer>());
            priceList.put(item.getPrice(),priceList.getOrDefault(item.getPrice(),0)+1);
            itemMap.put(item.getName(),priceList);
        }
        return itemMap;
    }

    public void format(Map<String, Map<Double,Integer>> items, int errors){
        for(String name : items.keySet()){
            int count = 0;
            System.out.println("--------------                --------------");
            for(Double price : items.get(name).keySet()){
                System.out.println("price: " + price + "               seen: " + items.get(name).get(price) + " times");
                count+=items.get(name).get(price);
            }
            System.out.println("==============               ==============");
            System.out.print("name: ");
            for(int i = 0; i < 7-name.length();i++) {
                System.out.print(" ");
            }
            System.out.println(name + "          seen: " + count + " times\n");
        }
        System.out.println("Errors            seen: " + errors + " times");


    }
}
