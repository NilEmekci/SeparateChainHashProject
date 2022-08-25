
package TextSystem;

public class LinkedList<Item> {

    Node<Item> first, last;
    int size = 0;


    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }



    public String toString() {
        Node tmp = first;
        String str = "List with " + size + " elements: ";

        while (tmp != null) {
            str += tmp.toString() + "->";
            tmp = tmp.next;
        }
        str += ".";
        return str;
    }


    public void insertLast(Item x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void insertForNode(Item name, String txtNumber) {

        Node tmp = first;


        if (tmp == null) {
            insertLast(name);
            first.txtLinkedList.insertLast(txtNumber);
            return;
        }


        while (tmp.next != null) {

            if (name.equals(tmp.data)) {
                Node tmpText = tmp.txtLinkedList.first;
                while (tmpText != null) {
                    if (tmpText.data.toString().contains(txtNumber)) {
                        return;
                    }
                    tmpText = tmpText.next;




                }
                tmp.txtLinkedList.insertLast(txtNumber);
                return;
            }
            tmp = tmp.next;

        }



        if (last.data.equals(name)) {
            Node tmpText = tmp.txtLinkedList.first;
            while (tmpText != null) {

                while (tmpText != null) {
                    if (tmpText.data.toString().contains(txtNumber)) {
                        return;
                    }
                    tmpText = tmpText.next;
                }

                tmp.txtLinkedList.insertLast(txtNumber);
                return;

            }
        } else {
            insertLast(name);
            tmp = tmp.next;
            tmp.txtLinkedList.insertLast(txtNumber);
            return;
        }



    }

    public String displayMainLinkedList() {
        Node tmp = first;
        String s = "";

        while (tmp != null) {

            s += "\n" + tmp.data + "\n";


            Node tmpTxt = tmp.txtLinkedList.first;

            while (tmpTxt != null) {
                if (tmpTxt.next == null) {
                    s += tmpTxt.data;
                    break;
                }
                s += tmpTxt.data + "->";
                tmpTxt = tmpTxt.next;

            }


            tmp = tmp.next;
        }


        return s;
    }



}



