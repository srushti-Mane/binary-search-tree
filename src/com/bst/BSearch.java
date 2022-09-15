package com.bst;

public class BSearch {
    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(56);
        tree.add(30);
        tree.add(70);
        tree.add(22);
        tree.add(40);
        tree.add(11);
        tree.add(3);
        tree.add(16);
        tree.add(60);
        tree.add(95);
        tree.add(65);
        tree.add(63);
        tree.add(67);

        tree.levelPrint();
        int size = tree.getSize();
        System.out.println(size);
        tree.search(30);
        tree.print();

    }
}
