
package TextSystem;


public class Node<Item>{

    Item data;
    Node next;


    LinkedList txtLinkedList;

    public Node(Item data) {
        this.data = data;
        next = null;
        txtLinkedList = new LinkedList<>();
    }

    public String toString(){
        return (""+data.toString());
    }
}