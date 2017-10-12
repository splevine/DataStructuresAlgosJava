package randombstgen;

import java.util.ArrayList;
import java.util.Collections;

public class RandomBSTGen {

    public static BST<Integer> generateRandomBST(int N) {
        ArrayList<Integer> list = new ArrayList<>(N);
        for (int i = 1; i <= N; i++)
            list.add(i);
        Collections.shuffle(list);
        BST<Integer> tree = new BST<>();
        for (int i : list)
            tree.insert(i);
        return tree;
    }

    public static void main(String[] args) {
        generateRandomBST(10).print();
    }
}

class BST<T extends Comparable<? super T>> {
    private BinaryTreeNode<T> root;

    public void print() {
        print(root);
    }

    private void print(BinaryTreeNode<T> node) {
        if (node == null)
            System.out.print("# ");
        else {
            System.out.print(node.data + " ");
            print(node.left);
            print(node.right);
        }
    }

    public void insert(T t) {
        root = insert(t, root);
    }

    private BinaryTreeNode<T> insert(T t, BinaryTreeNode<T> node) {
        if (node == null)
            return new BinaryTreeNode<>(t, null, null);
        int compareResult = t.compareTo(node.data);
        if (compareResult < 0)
            node.left = insert(t, node.left);
        else if (compareResult > 0)
            node.right = insert(t, node.right);
        return node;
    }

    private static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left, right;

        BinaryTreeNode(T t, BinaryTreeNode<T> l, BinaryTreeNode<T> r) {
            data = t;
            left = l;
            right = r;
        }
    }
}
