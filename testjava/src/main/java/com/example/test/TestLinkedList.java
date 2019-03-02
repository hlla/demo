package com.example.test;

public class TestLinkedList {
    static class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int i = 1;
        Node headNode = new Node(0);
        Node nodeCopyHead = headNode;
        while (i < 10) {
            Node node = new Node(i);
            nodeCopyHead.next = node;
            nodeCopyHead = node;
            i++;
        }
        Node nodeCopyHead1 = headNode;
        while (true) {
            System.out.println(nodeCopyHead1.value);
            if (nodeCopyHead1.next == null) {
                break;
            }
            nodeCopyHead1 = nodeCopyHead1.next;
        }
        Node pre = headNode;
        Node cur = headNode.next;
        Node nodeCopyHead2 = headNode;
        Node temp = headNode;
        Node temp1 = headNode.next;
        temp.next = null;
        Node temp2;
        while (temp1 != null) {
            temp2 = temp1.next;
            temp1.next = temp;
            temp = temp1;
            temp1 = temp2;
//            if (temp1.next == null) {
//                break;
//            }
//            temp1.next = temp;
//            temp = temp2;
        }
        System.out.println("ggggggggggggggggg");
//        System.out.println(temp.value);
//        System.out.println(temp.next.value);
        while (true) {
            System.out.println(temp.value);
            if (temp.next == null) {
                break;
            }
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            temp = temp.next;
        }
//        while (cur != null) {
////            temp2 = temp1.next;
////            temp1.next = temp;
////            temp1 = temp2;
////            temp = temp1;
////            temp = temp1.next;
////            temp1.next = temp2;
////            temp1 = temp.next;
//            nodeCopyHead = temp;
//
//            temp = cur.next;
//            cur.next = pre;
//            cur = temp;
//            pre = cur;
//        }
    }
}
