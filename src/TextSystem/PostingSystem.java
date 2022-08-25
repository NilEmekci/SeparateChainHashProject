
package TextSystem;


import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class PostingSystem {


    SeparateChainHash hashTable;


    public PostingSystem() {
        this.hashTable = new SeparateChainHash(45);
    }

    public void reader() throws FileNotFoundException {


        int count = 1;
        while (count <= 10) {
            String fileName = count + ".txt";
            Scanner sc;


            sc = new Scanner(new BufferedReader(new FileReader(fileName)));


            int i = 0;
            while (sc.hasNext()) {
                String name = sc.next().toLowerCase(Locale.ROOT);

                int hashedValue = hasher(name);


                hashTable.table[hashedValue].insertForNode(name, fileName);

            }
            sc.close();


            count++;

        }
    }


    public void displaySystem() {

        System.out.println("Table" + hashTable.displayAll());

    }

    public String search(String word) throws NoSuchFieldException {
        String s = "";
        s += hashTable.searchForWordInTxt(word);

        return s;
    }

    public int hasher(String t) {
        return ((t.hashCode() & 0x7ffffff) % 45);
    }

}
