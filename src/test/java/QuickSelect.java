public class QuickSelect {
    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }
        int pivotIndex = partition(arr, left, right); // 分区，返回基准索引
        if (pivotIndex == k) {
            return arr[pivotIndex];
        } else if (pivotIndex > k) { // 目标在基准左侧（降序）
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else { // 目标在基准右侧
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // 选择最后一个元素作为基准值
        int i = left - 1; // 指向大于等于基准值的区域末尾
        for (int j = left; j < right; j++) {
            if (arr[j] >= pivot) { // 降序分区：大的元素在前
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right); // 将基准值放到正确位置
        return i + 1; // 返回基准值的索引
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 2};
        //k=2代表第2+1大的元素
        System.out.println(quickSelect(arr, 0, arr.length - 1, 2));
    }
}
