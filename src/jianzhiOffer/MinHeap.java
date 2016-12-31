package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Created by tangjian on 2016/12/31.
 * <p>
 * 因为我们使用数组，我们需要知道如何计算指定节点(index)的父节点、左孩子和右孩子的索引。
 * <p>
 * 　　parent index : (index - 1) / 2
 * <p>
 * 　　left child : 2 * index + 1
 * <p>
 * 　　right child : 2 * index + 2
 */
public class MinHeap<E> {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap<>();
        minHeap.add(1);
        System.out.println(minHeap.size);
        minHeap.add(2);
        System.out.println(minHeap.size);
    }

    private static final int DEFAULT_CAPACITY = 10;
    int size;
    transient Object[] elementData;

    public boolean add(E element) {
        if (element == null) return false;
        ensureCapaityInternal(size + 1);
        if (elementData == null) {
            elementData = new Object[DEFAULT_CAPACITY];
        }
        elementData[size++] = element;
        minHeapfy();
        return true;
    }

    private void minHeapfy() {
        if (size <= 1) return;
        int lastIndex = size - 1;
        while (
                compare(elementData[lastIndex], elementData[(lastIndex - 1) / 2]) < 0) {
            lastIndex = (lastIndex - 1) / 2;
        }
    }

    final int compare(Object k1, Object k2) {
        return ((Comparable<? super E>) k1).compareTo((E) k2);
    }

    private void ensureCapaityInternal(int size) {

    }

    public boolean remove(Objects element) {
        if (element == null) return false;
        int index = indexOf(element);
        if (index == -1) return false;
        removeInternal(index);
        return true;
    }

    private void removeInternal(int index) {
        elementData[index] = elementData[--size];
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        while (left < size && (compare(elementData[index], elementData[left])) > 0
                || (compare(elementData[index], elementData[right])) > 0
                ) {

            if (compare(elementData[left], elementData[right]) < 0) {
                swap(elementData, index, left);
                index = left;

            } else {
                swap(elementData, index, right);
                index = right;
            }
             left = index * 2 + 1;
             right = index * 2 + 2;
        }


    }

    private void swap(Object[] elementData, int i, int j) {
        Object temp = elementData[i];
        elementData[i] = elementData[j];
        elementData[j] = temp;
    }

    /*private int indexOf(Objects element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (compare(element, elementData[i]) == 0){
                index = i;
                break;
            }
        }
        return index;
    }*/

    public int indexOf(Object o) {
        int start = 0;
        int node = 1;
        while(start < size) {
            start = node - 1;
            int end = start + node;
            int count = 0;
            while(start < size && start < end) {
                if(start == 0) {
                    if(compare(o, elementData[start]) == 0) {
                        return start;
                    } else if(compare(o, elementData[start]) < 0) {
                        return -1;
                    }
                } else {
                    if(compare(o, elementData[start]) == 0) {
                        return start;
                    } else if (compare(o, elementData[start]) < 0 &&
                            compare(o, getParent(start)) > 0) {
                        count++;
                    }
                }
                start++;
            }
            if(count == node) {
                return -1;
            } else {
                node = node * 2;
            }
        }
        return -1;
    }

    public Object getParent(int index) {
        return elementData[getParentIndex(index)];
    }

    public int getParentIndex(int index) {
        positionCheck(index);
        return (index - 1) / 2;
    }


    private void positionCheck(int index) {
        if(index <= 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
