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

    // print list
    public static void print() {
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
        
        // Get N (1 <= N <= 5 x 10e4), the number of anymies:
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 0; i < N; i++) {
            insert(in.nextInt()); // insert the initial nodes
        }

        // get Q, number of operations:
        int Q = in.nextInt();
        for(int i = 0; i < Q; i++) {
            // get the type of operation
            char operation = in.next().charAt(0);
            // for each type do something
            switch (operation) {
                case 'I':
                    //TODO call the insertion()
                    break;
                case 'R':
                    //TODO call the remove()
                    break;
                case 'Q':
                    //TODO call the between()
                    break;
                default:
            }
        }

        //print for test
        print();
    }
}