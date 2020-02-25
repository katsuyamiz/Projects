package MiniProject1;

import java.io.*;
import java.util.*;

public class ReadFile {



    public static void main(String[] args) throws Exception {
        // We need to provide file path as the parameter:
        // double backquote is to avoid compiler interpret words
        // like \test as \t (ie. as a escape sequence)
        Scanner in = new Scanner(new File("/Users/kmiz/Projects/cities.txt"));
        ArrayList<String> list = new ArrayList<>();

        while (in.hasNext()) {
            list.add(in.next());
        }
        System.out.println(list);
        in.close();

    }






    }


