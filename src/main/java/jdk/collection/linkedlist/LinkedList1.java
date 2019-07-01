package jdk.collection.linkedlist;

public class LinkedList1 {

    private int size;//链表节点的个数
    private Node head;//头节点
    private Node tail;//tail 为 永远存储最后一个节点的地址

    static class Node {
        Object data;
        Node next;

        public Node(Object data){
            this.data = data;
        }
    }

    //尾部追加节点
    public Node addTail(Object obj) {
        Node newTail = new Node(obj);//创建一个新的临时节点

        if (head == null)  //判断链表是否是第一次赋值
            head = newTail;
        else
            tail.next = newTail;//将新节点连接到链表的尾部
        tail = newTail;  //永远的储存最后一个节点的地址

        size++;
        return head;
    }


    //头部追加节点
    public Node addHead(Object obj){
        Node newHead = new Node(obj);

        if(size != 0)
            newHead.next = head;
        head = newHead;

        size++;
        return head;
    }

    public static void main(String[] args) {
        LinkedList1 linkedList1 = new LinkedList1();
//        linkedList1.addHead("111");
//        linkedList1.addHead("222");
//        linkedList1.addHead("333");
//        Node node = linkedList1.addHead("444");

        linkedList1.addTail("111");
        linkedList1.addTail("222");
        linkedList1.addTail("333");
        Node node = linkedList1.addTail("444");

        //遍历链表
        while (null != node) {
            System.out.print(node.data+"  ");//打印第一个数的值；
            node = node.next;//将下一个数my.next值赋给xx后，下一轮xx.data就相当于这个数的值；
        }

    }
}
