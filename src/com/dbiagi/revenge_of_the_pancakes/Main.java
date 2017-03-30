package com.dbiagi.revenge_of_the_pancakes;

import com.dbiagi.InputReader;

import java.io.*;
import java.util.LinkedList;

/**
 * Revenge of the pancakes challenge.
 *
 * @see <a href="https://code.google.com/codejam/contest/6254486/dashboard#s=p1">Challenge link</a>
 */
public class Main {
    public static void main(String args[]) throws IOException {
        File file = null;
        InputReader in = null;
        PrintWriter out = null;

        if (args.length > 0) {
            file = new File(args[0]);
        }

        if (file != null && file.exists() && !file.isDirectory()) {
            in = new InputReader(new FileInputStream(file));
            out = new PrintWriter(new BufferedWriter(new FileWriter("revenge_of_the_pancakes.out")));
        } else {
            in = new InputReader(System.in);
            out = new PrintWriter(System.out, true);
        }

        int n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            int result = organize(in.next());

            out.println(String.format("Case #%d: %d", i, result));
        }

        out.close();
    }

    private static int organize(String input) {
        LinkedList<Boolean> stack = new LinkedList<>();

        int count = 0;

        char[] chars = input.toCharArray();
        for (int i = chars.length-1; i >= 0; i--) {
            stack.push(chars[i] == '+');
        }

        while (stack.contains(false)) {
            LinkedList<Boolean> aux = new LinkedList<>();
            int last = stack.lastIndexOf(false);

            if (last != 0 && stack.get(0)) {
                stack.set(0, false);
                count++;
            }

            for (int i = 0; i <= last; i++) {
                aux.add(!stack.pop());
            }

            for (boolean value : aux){
                stack.addFirst(value);
            }

            count++;
        }

        return count;
    }

}
