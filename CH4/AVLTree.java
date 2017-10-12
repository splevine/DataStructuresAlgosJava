public class AVLTree<T extends Comparable<? super T>> {
    private AVLNode<T> root;

    public AVLTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T t) {
        return contains(t, root);
    }

    private boolean contains(T t, AVLNode<T> root) {
        if (root == null) return false;
        int compareResult = t.compareTo(root.data);
        if (compareResult < 0)
            return contains(t, root.left);
        else return compareResult == 0 || contains(t, root.right);
    }

    public T findMin() {
        return findMin(root);
    }

    private T findMin(AVLNode<T> root) {
        if (root == null) return null;
        while (root.left != null)
            root = root.left;
        return root.data;
    }

    public T findMax() {
        return findMax(root);
    }

    private T findMax(AVLNode<T> root) {
        if (root == null) return null;
        while (root.right != null)
            root = root.right;
        return root.data;
    }

    public void insert(T t) {
        insert(t, root);
    }

    private AVLNode<T> insert(T t, AVLNode<T> root) {
        if (root == null) return new AVLNode<>(t, null, null);
        int compareResult = t.compareTo(root.data);
        if (compareResult < 0) {
            root.left = insert(t, root.left);
            if (getHeight(root.left) - getHeight(root.right) == 2) {
                if (t.compareTo(root.left.data) < 0)
                    root = singleRotateLeftChild(root);
                else
                    root = doubleRotateLeftChild(root);
            }
        } else if (compareResult > 0) {
            root.right = insert(t, root.right);
            if (getHeight(root.right) - getHeight(root.left) == 2) {
                if (t.compareTo(root.right.data) < 0)
                    root = doubleRotateRightChild(root);
                else
                    root = singleRotateRightChild(root);
            }
        }

        root.height = (byte) (Math.max(getHeight(root.left), getHeight(root.right)) + 1);
        return root;
    }

    private AVLNode<T> doubleRotateRightChild(AVLNode<T> k2) {
        k2.right=singleRotateLeftChild(k2.right);
        return singleRotateRightChild(k2);
    }

    private AVLNode<T> doubleRotateLeftChild(AVLNode<T> k2) {
        AVLNode<T> k1 = k2.left;
        assert k1 != null;
        AVLNode<T> k3 = k1.right;
        assert k3 != null;
        k1.right = k3.left;
        k2.left = k3.right;
        k3.left = k1;
        k3.right = k2;
        k1.height = (byte) (Math.max(getHeight(k1.left), getHeight(k1.right)) + 1);
        k2.height = (byte) (Math.max(getHeight(k2.left), getHeight(k2.right)) + 1);
        k3.height = (byte) (Math.max(getHeight(k1), getHeight(k2)) + 1);
        return k3;
    }

    private AVLNode<T> singleRotateRightChild(AVLNode<T> k2) {
        AVLNode<T> k1 = k2.right;
        k1.right = k2;
        k2.right = k1.left;
        k2.height = (byte) (Math.max(getHeight(k2.left), getHeight(k2.right)) + 1);
        k1.height = (byte) (Math.max(getHeight(k2), getHeight(k1.right)) + 1);
        return k1;
    }

    private AVLNode<T> singleRotateLeftChild(AVLNode<T> k2) {
        AVLNode<T> k1 = k2.left;
        k1.right = k2;
        k2.left = k1.right;
        k2.height = (byte) (Math.max(getHeight(k2.left), getHeight(k2.right)) + 1);
        k1.height = (byte) (Math.max(getHeight(k1.left), getHeight(k2)) + 1);
        return k1;
    }

    private byte getHeight(AVLNode<T> node) {
        return node == null ? -1 : node.height;
    }

    public void remove(T t) {
        remove(t, root);
    }

    private AVLNode<T> remove(T t, AVLNode<T> root) {
        //todo
        return null;
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(AVLNode<T> root) {
        if (root == null)
            System.out.print("# ");
        else {
            System.out.print(root.data + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }

    private static class AVLNode<T> {
        T data;
        AVLNode<T> left, right;
        byte height;

        AVLNode(T t, AVLNode<T> l, AVLNode<T> r) {
            data = t;
            left = l;
            right = r;
        }
    }
}
