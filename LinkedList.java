// Layon Martins

// Implementing a LindedList reference: https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/

import java.io.*;
import java.util.Scanner;

public class LinkedList {

    static LinkedList list;
    static Node head; // head of list

    // Node structure
    static class Node {

        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    

    // Method to insert a new node
    public static LinkedList insert(int data) {

        // Create a new node with given data
        Node new_node = new Node(data);

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        return list;
    }

    // Method to print the LinkedList.
    public static void printList() {

        Node currNode = list.head;
        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }

    // Driver code
    public static void main(String[] args) {
        
        // Start with the empty list.
        LinkedList list = new LinkedList();

        System.out.print("Type a number -> ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        for (int i = 0; i < num; i++) {
            insert(in.nextInt());
        } 

        // Print the LinkedList
        printList();

    }
}