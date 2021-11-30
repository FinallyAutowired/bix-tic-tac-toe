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
        while (!hasWinner && all.size() < 9) {
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
        if (hasWinner) {
            System.out.printf("%s wins!%n", playing);
        } else {
            System.out.println("Draw.");
        }
    }

    private static boolean win(List<Integer> steps) {
        return hasWinningSteps(steps);
    }

    private static boolean hasWinningSteps(List<Integer> steps) {
        return (steps.contains(1) && steps.contains(2) && steps.contains(3))
                || (steps.contains(4) && steps.contains(5) && steps.contains(6))
                || (steps.contains(7) && steps.contains(8) && steps.contains(9))
                || (steps.contains(1) && steps.contains(4) && steps.contains(7))
                || (steps.contains(2) && steps.contains(5) && steps.contains(8))
                || (steps.contains(3) && steps.contains(6) && steps.contains(9))
                || (steps.contains(1) && steps.contains(5) && steps.contains(9))
                || (steps.contains(3) && steps.contains(5) && steps.contains(7));
    }
}
