package com.example;

public class TestTree {
    static int index = 0;
    static boolean found = false;
    static Node mRoot;
    static int aa = -1;

    static class Node {
        int value;
        Node leftNode;
        Node rightNode;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void preOrder(Node node) {
        System.out.println(node.value + ",");
        if (null != node.leftNode) {
            preOrder(node.leftNode);
        }
        if (null != node.rightNode) {
            preOrder(node.rightNode);
        }
    }

    public static void midOrder(Node node) {
        if (null != node.leftNode) {
            midOrder(node.leftNode);
        }
        System.out.println(node.value + ",");
        if (null != node.rightNode) {
            midOrder(node.rightNode);
        }
    }

    public static void afterOrder(Node node) {
        if (null != node.leftNode) {
            afterOrder(node.leftNode);
        }
        if (null != node.rightNode) {
            afterOrder(node.rightNode);
        }
        System.out.println(node.value + ",");
    }

    /**
     * 插入到整个树中
     *
     * @param data
     */
    public static void insert(int data) {
        searchAndInsert(null, mRoot, data);     //根节点的父亲为 null

    }

    /**
     * 两步走：查找、插入
     *
     * @param parent 要绑定的父节点
     * @param node   当前比较节点
     * @param data   数据
     */
    private static Node searchAndInsert(Node parent, Node node, int data) {
        if (node == null) {  //当前比较节点为 空，说明之前没有这个数据，直接新建、插入
            node = new Node(data);
            if (parent != null) {    //父节点不为空，绑定关系
                if (data < parent.value) {
                    parent.leftNode = node;
                } else {
                    parent.rightNode = node;
                }
            }
            return node;
        }
        //对比的节点不为空
        if (node.value == data) {    //已经有了，不用插入了
            return node;
        } else if (data < node.value) {   //比节点小，从左子树里查找、插入
            return searchAndInsert(node, node.leftNode, data);
        } else {
            return searchAndInsert(node, node.rightNode, data);
        }
    }

    //    static int search(Node node, int value) {
//        if (node == null || node.value == value) {    //节点为空或者相等，直接返回该节点
//            return index;
//        }
//        index++;
//        if (value > node.value) {
//            search(node.rightNode, value);
//        } else if (value < node.value) {
//            search(node.leftNode, value);
//        }
//        return index;
//    }
    static int search(Node node, int value) {
        if (null != node.leftNode) {
            search(node.leftNode, value);
        }
        System.out.println(node.value + "," + " found=" + found + ", aa=" + aa);
        if (value >= aa && value <= node.value) {
//            search(node.leftNode, value);
            found = true;
            return index;
        }
        aa = node.value;
//        if (value == node.value) {
//            found = true;
//            return index;
//        }
        if (!found) {
            index++;
        }
        if (null != node.rightNode) {
            search(node.rightNode, value);
        }
        return index;
    }

    public static void main(String[] args) {
        mRoot = new Node(5);
        insert(4);
        insert(7);
        insert(3);
        insert(1);
        insert(6);
        insert(8);
        insert(12);
        insert(18);
        insert(15);
//        node.leftNode = new Node(4);
//        node.leftNode.leftNode = new Node(3);
//        node.leftNode.rightNode = new Node(1);
//        node.leftNode.rightNode.leftNode = new Node(6);
//        node.leftNode.rightNode.rightNode = new Node(8);
//
//
//        node.rightNode = new Node(7);
//        node.rightNode.leftNode = new Node(12);
//        node.rightNode.rightNode = new Node(15);
//        node.rightNode.rightNode.rightNode = new Node(18);
//        System.out.println("preOder:");
//        preOrder(mRoot);
        System.out.println("midOder:");
        midOrder(mRoot);
//        System.out.println("afterOder:");
//        afterOrder(mRoot);
        System.out.println("sear 7=:" + search(mRoot, 7));
        index = 0;
        found = false;
        System.out.println("sear 1=:" + search(mRoot, 1));
        index = 0;
        found = false;
        System.out.println("sear 999=:" + search(mRoot, 9));
//        index = -1;
//        System.out.println("sear 10=:" + search(mRoot, 10));
//        Node node3 = new Node(3);
//        Node node4 = new Node(1);
//        node1.leftNode = node3;
//        node1.RightNode = node4;
//        Node node5 = new Node(5);
//        Node node6 = new Node(5);
//        Node node7 = new Node(5);
//        Node node8 = new Node(5);
//        Node node9 = new Node(5);
//        Node node10 = new Node(5);
    }
}
