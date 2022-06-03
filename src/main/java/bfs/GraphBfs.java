package bfs;

import bfs.structs.Node;

import java.util.*;


public class GraphBfs {
    public static void main(String[] args) {
        Node<Integer> start = new Node<>(10);
        Node<Integer> firstNeighbor = new Node<>(2);
        start.connect(firstNeighbor);

        Node<Integer> firstNeighborNeighbore = new Node<>(3);
        firstNeighbor.connect(firstNeighborNeighbore);
        firstNeighborNeighbore.connect(start);

        Node<Integer> secondNeighbor = new Node<>(4);
        start.connect(secondNeighbor);

        search(4, firstNeighborNeighbore)
                .ifPresent(it -> System.out.printf("Result: %s", it));
    }

    public static <T> Optional<Node<T>> search(T value, Node<T> start) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);

        Set<Node<T>> alreadyVisited = new HashSet<>();

        Node<T> currentNode;

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.printf("Visited node with value: %s %n", currentNode.getValue());

            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                alreadyVisited.add(currentNode);
                queue.addAll(currentNode.getNeighbors());
                queue.removeAll(alreadyVisited);
            }
        }

        return Optional.empty();
    }
}
