package peakval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Peakval {

    public static int[] peaks(int[] arr) {
        int[] peakval = new int[arr.length];

        Arrays.sort(arr);

        for (int i = 0; i < peakval.length; i++) {
            if (i % 2 == 0) {
                peakval[i] = arr[i];

            } else {
                peakval[i] = arr[arr.length - i];
            }
        }
        return peakval;
    }

    public static char[] arrange(char[] build) {
        ArrayList<String> order = new ArrayList<>();
        for (int i = 0; i < build.length; i++) {
            switch (build[i]) {
                case 'a':
                    if (findChar(build, 'd')) {
                        if (order.contains("d")) {
                            order.remove("d");
                            order.add("d");
                            order.add("a");
                        } else {
                            order.add("d");
                            order.add("a");
                        }
                    } else {
                        return null;
                    }
                    break;
                case 'b':
                    if (findChar(build, 'd')) {
                        if (order.contains("d")) {
                            order.remove("d");
                            order.add("d");
                            order.add("b");
                        } else {
                            order.add("d");
                            order.add("b");
                        }
                    } else {
                        return null;
                    }
                    break;
                case 'c':
                    if (!order.contains("c")) {
                        order.add("c");
                    }
                    break;
                case 'd':
                    if (findChar(build, 'c')) {
                        if (order.contains("c")) {
                            order.remove("c");
                            order.add("c");
                            order.add("d");
                        } else {
                            order.add("c");
                            order.add("d");
                        }
                    } else {
                        return null;
                    }
                    break;
                case 'e':
                    order.add("e");
                    break;
                case 'f':
                    if (findChar(build, 'a')) {
                        if (order.contains("a")) {
                            order.remove("a");
                            order.add("a");
                            order.add("f");
                        } else {
                            order.add("a");
                            order.add("f");
                        }
                    } else {
                        return null;
                    }
                    break;
            }
        }

        System.out.println(order.toString());
        return null;
    }

    public static boolean findChar(char[] build, char look) {
        boolean found = false;
        for (int i = 0; i < build.length; i++) {
            if (build[i] == look) {
                found = true;
                break;
            }
        }
        return found;

    }

    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random random = new Random();

        System.out.println("Original Array:");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(numbers.length - 1) + 1;
            System.out.print(numbers[i] + ", ");
        }

        int[] peak = peaks(numbers);

        System.out.println("\nArray sorted into peaks and vally");
        for (int i = 0; i < peak.length; i++) {
            System.out.print(peak[i] + ", ");
        }
        System.out.println("\n");
        //BUILD ORDER
        char[] projects = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[][] dep = {{'a', 'd'}, {'f', 'b'}, {'b', 'd'}, {'f', 'a'}, {'d', 'c'}};
        char[] ordered = arrange(projects);
    }

}
