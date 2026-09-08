package com.example;

import java.util.*;

public class ItemManager {

    // 1. One-dimensional Array 
    public void demonstrateArray() {
        String[] categories = {"Electronics", "Home", "Office"}; 
        System.out.println("=== 1D Array ===");
        for (String cat : categories) {
            System.out.println("Category: " + cat);
        }
    }

    // 2. Two-dimensional Array 
    public void demonstrate2DArray() {
        double[][] itemData = {
            {101, 500},
            {102, 700},
            {103, 25000},
            {104, 7000}
        }; 
        System.out.println("\n=== 2D Array ===");
        for (double[] row : itemData) {
            System.out.println("Item ID: " + (int)row[0] + " | Price: $" + row[1]); 
        }
    }

    // 3. ArrayList (Dynamic List implementation)
    public void demonstrateArrayList() {
        List<Item> catalog = new ArrayList<>(); 
        catalog.add(new Item(101, "Mouse", 500));
        catalog.add(new Item(102, "Keyboard", 700));

        System.out.println("\n=== ArrayList ===");
        for (Item item : catalog) {
            System.out.println(item);
        }
    }

    // 4. LinkedList 
    public void demonstrateLinkedList() {
        LinkedList<String> recentViews = new LinkedList<>(); 
        recentViews.add("Item 101"); 
        recentViews.addFirst("Start Banner"); 
        recentViews.addLast("Footer Ad");     
        recentViews.removeLast();              

        System.out.println("\n=== LinkedList ===");
        System.out.println("History: " + recentViews);
    }

    // 5. HashSet 
    public void demonstrateHashSet() {
        Set<String> categories = new HashSet<>(); 
        categories.add("Electronics"); 
        categories.add("Electronics"); 
        categories.add("Laptops");

        System.out.println("\n=== HashSet ===");
        System.out.println("Unique Categories (Size " + categories.size() + "): " + categories); 
    }

    // 6. HashMap 
    public void demonstrateHashMap() {
        Map<Integer, Item> itemMap = new HashMap<>(); 
        itemMap.put(101, new Item(101, "Mouse", 500));
        itemMap.put(103, new Item(103, "Laptop", 25000)); 

        System.out.println("\n=== HashMap ===");
        System.out.println("Retrieved Key 103: " + itemMap.get(103));
    }

    // 7. Iterator 
    public void demonstrateIterator() {
        List<String> items = new ArrayList<>(Arrays.asList("ItemA", "ItemB", "ItemC")); 
        Iterator<String> iter = items.iterator(); 

        System.out.println("\n=== Iterator Modifying Collection ===");
        while (iter.hasNext()) { 
            if (iter.next().equals("ItemB")) {
                iter.remove(); 
            }
        }
        System.out.println("Remaining items: " + items);
    }
}