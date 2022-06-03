package bfs.structs;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Tree objects for BFS algorithms
 * @param <T>
 */
@Getter
public class Tree<T> {
    private T value;
    private List<Tree<T>> children;

    public Tree(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public static <T> Tree<T> of(T value) {
        return new Tree<>(value);
    }

    public Tree<T> addChild(T value) {
        Tree<T> newChild = new Tree<>(value);
        children.add(newChild);
        return newChild;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "value=" + value +
                '}';
    }
}
