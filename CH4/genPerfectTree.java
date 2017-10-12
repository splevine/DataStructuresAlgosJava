public BSTNode genPerfectTree (int h) {
    return genPefectTree (1, Math.pow(2, h + 1) - 1);
}

private BSTNode genPerfectTree (int low, int high){
    if (low==high)
        return new BSTNode(low, null, null);

    int root = (low + high) / 2;
    BSTNode left = genPerfectTree (low, root - 1);
    BSTNode right = genPerfectTree (root + 1, high);
    return new BSTNode(root, left, right);
}
