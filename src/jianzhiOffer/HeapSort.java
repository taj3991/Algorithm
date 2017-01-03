package jianzhiOffer;

/**
 * Created by tangjian on 2017/1/3.
 * <p>
 * http://blog.csdn.net/morewindows/article/details/6709644/#
 * <p>
 * http://blog.csdn.net/xiaoxiaoxuewen/article/details/7570621/
 */
public class HeapSort {


    public static void main(String[] args) {
        int a[] = {16, 7, 3, 20, 17, 8};
        int size = a.length - 1;
        HeapSort(a, size);
        for (int i : a) {
            System.out.print(i + "\t");
        }

    }

    static void HeapSort(int[] a, int endIndex)    //堆排序
    {
        int i;
        BuildHeap(a, endIndex);
        for (i = endIndex; i >= 1; i--) {
            swap(a, 0, i);           //交换堆顶和最后一个元素，即每次将剩余元素中的最大者放到最后面
            HeapAdjust(a, 0, i - 1);      //重新调整堆顶节点成为大顶堆
        }
    }


    static void BuildHeap(int[] a, int endIndex)    //建立堆
    {
        int i;
        for (i = endIndex / 2; i >= 0; i--)    //非叶节点最大序号值为size/2
        {
            HeapAdjust(a, i, endIndex);
        }
    }


    static void HeapAdjust(int[] a, int i, int endIndex)  //调整堆
    {
        int lchild = 2 * i + 1;       //i的左孩子节点序号
        int rchild = 2 * i + 2;     //i的右孩子节点序号
        int max = i;            //临时变量
        if (i <= endIndex / 2)          //如果i不是叶节点就不用进行调整
        {
            if (lchild <= endIndex && a[lchild] > a[max]) {
                max = lchild;
            }
            if (rchild <= endIndex && a[rchild] > a[max]) {
                max = rchild;
            }
            if (max != i) {
                swap(a, i, max);
                HeapAdjust(a, max, endIndex);    //避免调整之后以max为父节点的子树不是堆
            }
        }
    }


    static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
