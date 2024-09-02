import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T extends Comparable<T>> {

    private final List<T> heap;

    public PriorityQueue() {
        this.heap = new ArrayList<>();
    }

    // O(n)
    public void addAll(List<T> elements) {
        for (T element: elements) {
            add(element);
        }
    }
    public int size() {
        return heap.size();
    }

    // złożoność obliczenowa: O(log(n))
    public void add(T element) {
        heap.add(element);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(i).compareTo(heap.get(parent(i))) > 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public T poll() {
        if (heap.isEmpty()) {
            return null;
        }
        T min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return min;
    }

    private void heapifyDown(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;
        if (left < heap.size() && heap.get(left).compareTo(heap.get(i)) > 0) {
            largest = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(largest)) > 0) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }
}
