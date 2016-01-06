package topn;

import java.util.Comparator;

public class Heap<T> {

    /**
     * 以数组形式存储堆元素
     */
    private T[] heap;

    /**
     * 用于比较堆中的元素。c.compare(根,叶子) > 0。
     * 使用相反的Comparator可以创建最大堆、最小堆。
     */
    private Comparator<? super T> c;

    public Heap(T[] a, Comparator<? super T> c) {
        this.heap = a;
        this.c = c;
        buildHeap();
    }

    /**
     * 返回值为i/2
     * @param i
     * @return
     */
    private int parent(int i) {
        return (i - 1) >> 1;
    }

    /**
     *
     * 返回指定节点的left子节点数组索引。相当于2*(i+1)-1
     * @param i
     * @return
     */
    private int left(int i) {
        return ((i + 1) << 1) - 1;
    }

    /**
     * 返回指定节点的right子节点数组索引。相当于2*(i+1)
     * @param i
     * @return
     */
    private int right(int i) {
        return (i + 1) << 1;
    }

    /**
     * 堆化
     * @param i
     * 堆化的起始节点
     */
    private void heapify(int i) {
        heapify(i, heap.length);
    }

    /**
     * 堆化
     * @param i
     * @param size 堆化的范围
     */
    private void heapify(int i, int size) {
        int l = left(i);
        int r = right(i);
        int next = i;
        if (l < size && c.compare(heap[l], heap[i]) > 0)
            next = l;
        if (r < size && c.compare(heap[r], heap[next]) > 0)
            next = r;
        if (i == next)
            return;
        swap(i, next);
        heapify(next, size);
    }

    /**
     * 对堆进行排序
     */
    public void sort() {
        // buildHeap();
        for (int i = heap.length - 1; i > 0; i--) {
            swap(0, i);
            heapify(0, i);
        }
    }

    /**
     * 交换数组值
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        T tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    /**
     * 创建堆
     */
    private void buildHeap() {
        for (int i = (heap.length) / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public void setRoot(T root) {
        heap[0] = root;
        heapify(0);
    }

    public T root() {
        return heap[0];
    }


    /**
     * @param args
     */
    public static void main(String[] args) {

        Integer[] temp = new Integer[] { 16, 14, 8, 7, 9, 3, 2, 4, 1 };
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        //创建最大堆
        Heap<Integer> heap = new Heap<Integer>(temp, comp);
        // heap.buildHeap();
        for (int i : temp) {
            System.out.print(i + " ");
        }

        System.out.println();

        heap.sort();
        for (int i : temp) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

}


