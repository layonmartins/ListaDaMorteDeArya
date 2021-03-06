/**
 * Class based on a LinkdList to solve the problem: A Lista da Morte de Arya
 * from https://www.urionlinejudge.com.br/judge/pt/problems/view/1856
 * 
 * @author Layon Martins Fonseca
 */

 import java.util.Scanner;

public class AryaList {

    // create a LinkedList class
    // a head of the list
    static Node head;
    // a tail of the list
    static Node tail;
    // a static instance of the list
    static AryaList list;

    // a object to represent the Node
    static class Node {
        int data;
        Node next;

        // constructor of the node
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // constructor 1
    AryaList () {}

    // constructor 2
    AryaList(int[] numbers) {
        // create a head of the list
        Node node_head = new Node(numbers[0]);
        head = node_head;
        Node cursor = head;
        // iterating through the following list items:
        for (int i = 1; i < numbers.length; i++) {
            Node node = new Node(numbers[i]);
            cursor.next = node;
            cursor = node;
        }
        //set tail
        tail = cursor;

        //print(); //to test

    }

    // insert in tail
    public static void insert(int data) {
        //create a Node
        Node newNode = new Node(data);
        //if the list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // insert I p e (1 <= e, p <= 10^9): Insert the person 'p' after the enemy 'e' in the list.
    public static void insert(int p, int e) {
        // create the cursor starting in head
        Node cursor = head;
        // find the Node of the element 'e'
        while(cursor.data != e) {
            cursor = cursor.next;
        }
        // insert 'p'
        // create a node p
        Node newNode = new Node(p);
        newNode.next = cursor.next;
        cursor.next = newNode;
        //if the newNode is the tail, update the static variable tail
        if(newNode.next == null) {
            tail = newNode;
        }

        //print();
    }

    // remove R e (1 <= e <= 10^9) remove the enemy 'e' of the list
    public static void remove(int e) {

        // if the 'e' is the head
        if (head.data == e) {
            head = head.next;
            //print(); //test
            return;
        }
        // create the cursor starting in head
        Node cursor = head;
        // find the previous node data
        while (cursor.next.data != e) {
            cursor = cursor.next;
        }
        // check if the 'e' is the tail
        if (cursor.next == tail){
            tail = cursor; // update
        }
        // to remove just jump to next node
        cursor.next = cursor.next.next;

        //print(); //test
    }

    // distance Q a b  (1 <= a, b <= 10^9) determine the distance between the enimeis 'a' and 'b' excluing both.
    // [1]->[2]->[3]->[4]
    public static int distance(int a, int b) {
        // create the counter and cursor
        int count = 0;
        Node cursor = head;
        // find 'a'
        while (cursor.data != a){
            cursor = cursor.next;
        }
        // count util 'b'
        cursor = cursor.next;
        while (cursor.data != b){
            count++;
            cursor = cursor.next;
        }
        return count;
    }


    // print list
    public static void print() {
        // if the list is empty
        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        System.out.print("[" + head.data + "]");
        Node cursor = head.next;
        while(cursor != null){
            System.out.print("->[" + cursor.data + "]");
            cursor = cursor.next;
        }
        System.out.println();
    }

    public static void main(final String[] args) {
        // System.out.println("####### The Arya's List of Death ######");
        
        // To get inputs
        Scanner in = new Scanner(System.in);

        // Get N (1 <= N <= 5 x 10e4), the number of anymies:
        int N = in.nextInt();
        for(int i = 0; i < N; i++) {
            insert(in.nextInt()); // insert the initial nodes
        }
        

        //Create the list to test
        //int[] array = {1,2,3,4};
        //AryaList aryaList = new AryaList(array);

        
        // get O, number of operations:
        int O = in.nextInt();
        for(int i = 0; i < O; i++) {
            // get the type of operation
            char operation = in.next().charAt(0);
            // for each type do something
            switch (operation) {
                case 'I':
                    //TODO call the insertion()
                    insert(in.nextInt(), in.nextInt());
                    break;
                case 'R':
                    //TODO call the remove()
                    remove(in.nextInt());
                    break;
                case 'Q':
                    //TODO call the between()
                    int distance = distance(in.nextInt(), in.nextInt());
                    System.out.println(distance);
                    break;
                default:
            }
        }

        //print for test
        //print();
    }
}