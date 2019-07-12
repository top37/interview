package jdk.collection.linkedlist;

import java.util.Random;

public class LinkedList_My {

    private int size;//链表节点的个数
    private Node head;//头节点
    private Node storage;//storage 为 永远存储最后一个节点的地址

    public Node addTail1(Object obj) {
        Node tail = new Node(obj);//创建一个新的临时节点
        if (head ==null){  //判断链表是否是第一次赋值
            head = storage = tail;
        }else {
            storage.next = tail;//将新节点连接到链表的尾部
            storage = tail;  //永远的储存最后一个节点的地址
        }
        size++;
        return head;
    }

    public Node addTail2(Object obj) {
        Node tail = new Node(obj);//创建一个新的临时节点

        if (head ==null)  //判断链表是否是第一次赋值
            head = tail;
        else
            storage.next = tail;//将新节点连接到链表的尾部
        storage = tail;  //永远的储存最后一个节点的地址

        size++;
        return head;
    }


    //在链表头添加元素
    public Object addHead(Object obj){
        Node newHead = new Node(obj);
        if(size == 0){
            head = newHead;
        }else{
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }

    public Node addTail(Object obj) {
        Random r = new  Random();//随机对象
        Node head,storage,last;  //定义三个对象，head 为 永远存储第一个节点的地址
        //storage 为 永远存储最后一个节点的地址
        //last 为  新的临时节点
        head = storage  = null;
        for (int i = 0; i <10 ; i++) {
//            int temp = i;
            last = new Node();//创建一个新的临时节点
            last.data = i;  //为属性赋值
            if (head ==null){  //判断链表是否是第一次赋值
                head = storage = last;
            }else {
                storage.next = last;//将新节点连接到链表的尾部
                storage = last;  //永远的储存最后一个节点的地址
            }
            size++;
        }
        return head;
    }

    public Node addTailForMap(Object obj) {
        Random r = new  Random();//随机对象
        Node head,storage,last;  //定义三个对象，head 为 永远存储第一个节点的地址
        //storage 为 永远存储最后一个节点的地址
        //last 为  新的临时节点
        head = storage  = null;
        for (int i = 0; i <10 ; i++) {
//            int temp = i;
            last = new Node();//创建一个新的临时节点
            last.data = i;  //为属性赋值
            if (head ==null){  //判断链表是否是第一次赋值
                head = storage = last;
            }else {
                storage.next = last;//将新节点连接到链表的尾部
                storage = last;  //永远的储存最后一个节点的地址
            }
            size++;
        }
        return head;
    }



    //显示节点信息
    public void showNode(){
        if(size >0){
            Node node = head;
            int tempSize = size;
            if(tempSize == 1){//当前链表只有一个节点
                System.out.println("["+node.data+"]");
                return;
            }
            while(tempSize>0){
                if(node.equals(head)){
                    System.out.print("["+node.data+"->");
                }else if(node.next == null){
                    System.out.print(node.data+"]");
                }else{
                    System.out.print(node.data+"->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        }else{//如果链表一个节点都没有，直接打印[]
            System.out.println("[]");
        }

    }

    static class Node {
        Object data;
        Node next;

        public Node(Object data){
            this.data = data;
        }
        public Node(){

        }
    }


    public static void main(String[] args) {
        LinkedList_My linkedList_my = new LinkedList_My();
//        linkedList_my.addHead("111");
//        linkedList_my.addHead("222");
//        linkedList_my.addHead("333");


//        linkedList_my.addTail1("111");
//        linkedList_my.addTail1("222");
//        linkedList_my.addTail1("333");

        linkedList_my.addTail2("111");
        linkedList_my.addTail2("222");
        linkedList_my.addTail2("333");
        Node node = linkedList_my.addTail2("444");

        System.out.println(linkedList_my.storage.next);

//        linkedList_my.storage.next = null;

        for (int i = 0; i <10 ; i++) {
            if(null != node){
                System.out.print(node.data+"  ");//打印第一个数的值；
                node = node.next;//将下一个数my.next值赋给xx后，下一轮xx.data就相当于这个数的值；
            }

        }

        linkedList_my.showNode();
    }
}
