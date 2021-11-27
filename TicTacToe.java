package org.alex.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    private static List<Integer> all = new ArrayList<>();

    private static List<Integer> steps1 = new ArrayList<>();

    private static List<Integer> steps2 = new ArrayList<>();

    private static String playing;

    private static boolean hasWinner = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!hasWinner) {
            int input = scanner.nextInt();
            if (all.contains(input)) {
                System.err.printf("%s has already been played.%n", input);
                continue;
            }
            all.add(input);
            if (all.size() % 2 > 0) {
                playing = "Player 1";
                steps1.add(input);
                hasWinner = win(steps1);
            } else {
                playing = "Player 2";
                steps2.add(input);
                hasWinner = win(steps2);
            }
            System.out.printf("%s plays at %s.%n", playing, input);
        }
        System.out.printf("%s wins!%n", playing);
    }

    private static boolean win(List<Integer> steps) {
        int score;
        if (steps.size() == 3) {
            score = steps.stream().reduce(Integer::sum).get();
            return score % 3 == 0;
        }
        if (steps.size() == 4) {
            score = steps.stream().reduce(Integer::sum).get();
            int tmp;
            for (int i = 0; i < 3; i++) {
                tmp = score - steps.get(i);
                if (tmp % 3 == 0) {
                    return true;
                }
            }
        }
        if (steps.size() == 5) {
            return true;
        }
        return false;
    }
}
