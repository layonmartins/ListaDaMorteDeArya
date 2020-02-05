/**
 * Class based on a LinkdList to solve the problem: A Lista da Morte de Arya
 * from https://www.urionlinejudge.com.br/judge/pt/problems/view/1856
 * 
 * @author Layon Martins Fonseca
 */

public class AryaList {

    // create a LinkedList class
    // a head of the list
    static Node head;
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

    AryaList(){

    }
    // constructor
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
        System.out.println("Hello Arya");
        int[] array = {1,2,3,4};
        AryaList aryaList = new AryaList(array);
        print();
    }
}