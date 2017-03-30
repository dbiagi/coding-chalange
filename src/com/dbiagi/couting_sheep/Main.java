package com.dbiagi.couting_sheep;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
import com.dbiagi.InputReader;

/**
 * Counting sheep problem.
 *
 * @see <a href="https://code.google.com/codejam/contest/6254486/dashboard">Problem link</a>
 */
public class Main {

    private static String OUT_FILE_NAME = "couning_sheeps.out";

    public static void main(String[] args) throws IOException {
        File file = null;

        if (args.length > 0) {
            file = new File(args[0]);
        }

        InputReader in;
        PrintWriter out;

        if (file != null && file.exists() && !file.isDirectory()) {
            in = new InputReader(new FileInputStream(file));
            out = new PrintWriter(new BufferedWriter(new FileWriter(OUT_FILE_NAME + ".out")));
        } else {
            in = new InputReader(System.in);
            out = new PrintWriter(System.out, true);
        }

        int n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            String result = countSheeps(in.nextInt());

            out.println(String.format("Case #%d: %s", i, result));
        }

        out.close();
    }


    private static String countSheeps(int n) {
        if (n == 0) {
            return "INSOMNIA";
        }

        Integer current = 0;
        boolean seenAll = true;
        HashSet<Integer> seen = new HashSet<>();

        do {
            current += n;

            int aux = current;

            while(aux > 0){
                seen.add(aux%10);
                aux /= 10;
            }

            seenAll = true;

            for (int i = 0; i < 10; i++) {
                if(!seen.contains(i)){
                    seenAll = false;
                    break;
                }
            }
        } while (!seenAll);

        return current.toString();
    }

}
