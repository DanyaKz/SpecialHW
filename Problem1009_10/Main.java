package Problem1009_10;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    static LinkedList<Character> queue = new LinkedList<Character>();
    static List<Character> available = new LinkedList<Character>(Arrays.asList('{', '[', '('));

    public static void main(String[] args) {
        System.out.println(inputNCheckFile() ? "VALID" : "ИНВАЛИД");
    }

    static boolean inputNCheckFile() {
        try (FileInputStream ois = new FileInputStream("src/Problem1009_10/input.txt")) {
            ByteArrayInputStream bais = new ByteArrayInputStream(ois.readAllBytes());

            for (byte b : bais.readAllBytes()) {
                char parenthesis = (char) b;
                if (available.contains(parenthesis)) {
                    queue.add((char) b);
                } else {
                    if (queue.isEmpty()) return false;
                    if (!isAvailable(parenthesis)) {
                        return false;
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return queue.isEmpty();
    }

    static boolean isAvailable(char p) {
        Character last = queue.removeLast();
        return (last == '{' && p == '}') ||
                (last == '(' && p == ')') ||
                (last == '[' && p == ']');
    }


}
