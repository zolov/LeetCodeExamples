package bfs;

import bfs.structs.Tree;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

public class TreeBfs {
    public static void main(String[] args) {
        Tree<Integer> root = Tree.of(10);
        Tree<Integer> rootFirstChield = root.addChild(2);
        Tree<Integer> depthMostChild = rootFirstChield.addChild(3);
        Tree<Integer> rootSecondChield = root.addChild(4);

        search(4, root)
                .ifPresent(it -> System.out.printf("Result: %s", it));
    }

    public static <T> Optional<Tree<T>> search(T value, Tree<T> root) {
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree<T> currentNode = queue.remove();
            System.out.printf("Visited node with value: %s %n", currentNode.getValue());

            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                queue.addAll(currentNode.getChildren());
            }
        }
        return Optional.empty();
    }
}
