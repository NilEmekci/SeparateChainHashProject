
package TextSystem;


public class SeparateChainHash<Item> {

    int M;
    LinkedList<Item>[] table;
    int N;


    public SeparateChainHash(int M) {
        table = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            table[i] = new LinkedList<Item>();
        }
        N = 0;
        this.M = M;

    }

    public int hash(Item t) {
        return ((t.hashCode() & 0x7ffffff) % M);
    }


    public String searchForWordInTxt(Item word) throws NoSuchFieldException {


        int hashedValue = hash(word);


        Node tmp = table[hashedValue].first;


        if (tmp == null) {
            return "No text files includes this word.";
        }


        boolean isFounded = false;

        String s = "This word has been appeared in the following text files: " + word+"\n";
        while (tmp != null) {


            if (word.equals(tmp.data)) {
                Node textTmp = tmp.txtLinkedList.first;
                isFounded = true;
                while (textTmp != null) {
                    if (textTmp.next == null){
                        s+=textTmp.data;
                        break;
                    }
                    s += textTmp.data + "->";
                    textTmp = textTmp.next;
                }
            }
            tmp = tmp.next;
        }

        if (!isFounded) {
            return "No text files includes this word.";

        }


        return s;
    }


    public String displayAll() {


        String s = "";

        for (int i = 0; i < table.length; i++) {
            s += "\n" + table[i].displayMainLinkedList();
        }
        return s;
    }



    public String toString() {
        String s = "";
        for (int ix = 0; ix < M; ix++) {
            if (table[ix] != null) {
                s += ix + "th " + table[ix].toString() + "\n";
            }
        }
        return s;
    }
}

