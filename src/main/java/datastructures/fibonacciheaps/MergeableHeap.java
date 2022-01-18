package datastructures.fibonacciheaps;

// Introduction_To_Algorithms_3rd_Edition Chapter 19
// Fibonacci heap

public interface MergeableHeap<T> {
  MergeableHeap<T> makeHeap();

  void insert(MergeableHeap<T> heap, T x);

  T minimum(MergeableHeap<T> heap);

  T extractMin(MergeableHeap<T> heap);

  MergeableHeap<T> union(MergeableHeap<T> h1, MergeableHeap<T> h2);
}
