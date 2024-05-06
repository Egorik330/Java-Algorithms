package com.task_3_4_9;

public class Main {
    public static void main(String[] args) {
        SeparateChainHashST<String, Integer> st = new SeparateChainHashST<>(10);

        st.put("apple", 1);
        st.put("banana", 2);
        st.put("orange", 3);
        st.put("grape", 4);
        st.put("apple", 5); 

        System.out.println("Get values:");
        System.out.println("apple: " + st.get("apple"));
        System.out.println("banana: " + st.get("banana"));
        System.out.println("orange: " + st.get("orange"));
        System.out.println("grape: " + st.get("grape"));
        System.out.println("kiwi: " + st.get("kiwi")); 

        st.delete("banana");
        st.delete("grape");

        System.out.println("Get values after deletion:");
        System.out.println("apple: " + st.get("apple"));
        System.out.println("banana: " + st.get("banana"));
        System.out.println("orange: " + st.get("orange"));
        System.out.println("grape: " + st.get("grape"));

        System.out.println("Size: " + st.size());
        System.out.println("Is empty: " + st.isEmpty());

        st = new SeparateChainHashST<>(10);
        System.out.println("Size after clearing: " + st.size());
        System.out.println("Is empty after clearing: " + st.isEmpty());
    }
}