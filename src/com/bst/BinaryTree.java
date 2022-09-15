package com.bst;
import org.w3c.dom.Node;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.Queue;


public class BinaryTree<K extends Comparable<K>>{

        private INode<K> root;

        public void add(K key) {
            this.root = this.addRecursively(root, key);
        }

        private INode<K> addRecursively(INode<K> current, K key) {
            if (current == null)
                return new INode<>(key);
            int compareResult = key.compareTo(current.key);
            if (compareResult == 0)
                return current;
            if (compareResult < 0) {
                current.left = addRecursively(current.left, key);

            } else {
                current.right = addRecursively(current.right, key);
            }
            return current;
        }

        public int getSize() {
            return this.getSizeRecursively(root);
        }

        private int getSizeRecursively(INode<K> current) {
            return current == null ? 0 : 1 + this.getSizeRecursively(current.left) + this.getSizeRecursively(current.right);
        }

        public void print() {
            printRec(root);
        }

        void printRec(INode root) {
            if (root != null) {
                printRec(root.left);
                System.out.println(root.key);
                printRec(root.right);
            }
        }
// for searching Uc3
    public void search(K value) {
        int counter = 0;
        INode<K> temp = root;
        if (temp != null) {
            while (temp.key.compareTo(value) < 0) {
                System.out.println(temp.key);
                temp = temp.right;
            }
            if (root.key == value)
                counter++;
            while (temp.key.compareTo(value) > 0) {
                temp = temp.left;
            }
            if (temp.key == value) {
                counter++;
            }
            if (counter > 0) {
                System.out.println(true);
                System.out.println("Element is present");
            } else {
                System.out.println(false);
                System.out.println("Element is not present");
            }
        }
    }

    public void levelPrint() {
        if(root == null) {
            return;
        }
        Queue<INode> mq = new ArrayDeque<>();
        mq.add(root);
        while(mq.size() > 0) {
            int count = mq.size();
            for(int i =0; i<count; i++) {
                INode node = mq.remove();
                System.out.print(node.key+ " ");

                if(node.left != null) {
                    mq.add(node.left);
                }

                if(node.right != null) {
                    mq.add(node.right);
                }
            }
            System.out.println();

        }

    }
    @Override
    public String toString() {
        return "BinaryTree [root=" + root + ", getSize()=" + getSize() + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + ", toString()=" + super.toString() + "]";
    }

}


