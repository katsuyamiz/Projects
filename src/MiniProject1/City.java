package MiniProject1;

import java.io.*;
import java.util.*;


public class City {

    private ArrayList<String> list;


    public Random r = new Random();

    private int index = r.nextInt(101);

    public static final int MAX_ERRORS = 10;

    private String wordToFind;

    private char[] wordFound;

    private int nbErrors;

    private ArrayList<String> wordWrong = new ArrayList<>();

    private ArrayList<String> letters = new ArrayList<>();

    private String newWordToFind() {
        return list.get(index);
    }





    public void readFile() throws Exception {
        list = new ArrayList<String>();
        Scanner in = new Scanner(new File("/Users/kmiz/Projects/cities.txt"));


        while (in.hasNextLine()) {
            list.add(in.nextLine());
        }
        //System.out.println(list);


        in.close();

    }

    public void newGame() {
        nbErrors = 0;
        letters.clear();
        wordToFind = newWordToFind();

        wordFound = new char[wordToFind.length()];

        for (int i = 0; i < wordFound.length; i++) {
            wordFound[i] = '_';
        }
    }

    public boolean wordFound() {
        return wordToFind.contentEquals(new String(wordFound));
    }


    private void enter(String s) {

            if (wordToFind.contains(s)) {
                int index0 = wordToFind.indexOf(s);

                while (index0 >= 0) {
                    wordFound[index0] = s.charAt(0);
                    index0 = wordToFind.indexOf(s, index0 + 1);
                }
            } else {
                nbErrors++;
                wordWrong.add(s);
            }
        letters.add(s);
    }



    private String wordFoundContent() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < wordFound.length; i++) {
            builder.append(wordFound[i]);
            if (i < wordFound.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }






    public void play() {

        System.out.println("\nHere's the question.");
        try (Scanner input = new Scanner(System.in)) {


            while (nbErrors < MAX_ERRORS) {
                System.out.print("Guess a letter : ");
                String str =  input.next();

                if (str.length() > 1) {
                    str = str.substring(0, 1);
                }
                enter(str);
                System.out.println("Your guessing: " + wordFoundContent());

            if (wordFound()) {
                System.out.println("\nYou win!");
                break;
            } else {
                System.out.println("You have guessed (" + (nbErrors) + ") wrong letters: " + wordWrong);
            }
        }

        if (nbErrors == MAX_ERRORS) {
            System.out.println("\nYou lose!");
            System.out.println("The correct word was : '" + wordToFind + "'");
        }
    }

}


}





