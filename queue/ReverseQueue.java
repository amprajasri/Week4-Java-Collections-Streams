import java.util.*;

public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) return;
        int item = queue.remove();
        reverseQueue(queue);
        queue.add(item);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        reverseQueue(queue);
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
}
