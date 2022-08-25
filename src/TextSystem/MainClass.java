
package TextSystem;



import java.util.Locale;
import java.util.Scanner;

public class MainClass {

    

    static PostingSystem postingSystem = new PostingSystem();


    public static void main(String[] args) throws Exception {


        Scanner input = new Scanner(System.in);

        postingSystem.reader();

        System.out.println("\nHello Welcome Text Posting System\n\n" +
                " Press 1 to See all the texts with txt names\n" +
                " Press 2 to Search for a text\n" +
                " Press 0 to Exit from system");
        String option = input.nextLine();


        while (!option.equals("0")) {


            switch (option) {


                case "1":

                    postingSystem.displaySystem();
                    break;
                case "2":
                    String searchedWord = "";
                    while (!searchedWord.equals("0")) {
                        System.out.println("Please enter the word");
                        searchedWord = input.nextLine();
                        System.out.println(postingSystem.search(searchedWord.toLowerCase(Locale.ROOT)) + "\n");

                        System.out.println("Press 0) Back to main menu" + "\nPress 1) To continue searching");
                        searchedWord = input.nextLine();

                        if (!searchedWord.equals("1") && !searchedWord.equals("0")) {
                            throw new Exception("You entered wrong number exception");
                        }
                    }
                    break;
                default:
                    throw new Exception("YouEnteredWrongNumberException " + option);
            }
            System.out.println("\n\nPlease continue with following options");
            System.out.println("\nHello Welcome Text Posting System\n\n" +
                    " Press 1 to See all the texts with txt names\n" +
                    " Press 2 to Search for a text\n" +
                    " Press 0 to Exit from system");
            System.out.println();
            option = input.nextLine();

        }


    }


}

