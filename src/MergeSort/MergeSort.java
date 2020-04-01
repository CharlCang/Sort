package MergeSort;

public class MergeSort {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int[] help = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, help);
        return nums;
    }
    public void mergeSort(int[] nums, int start, int end, int[] help) {
        if (start < end) {

            int mid = (start + end) / 2;
            mergeSort(nums, start, mid, help);
            mergeSort(nums, mid + 1, end, help);
            merge(nums, start, mid, end, help);
        }
    }

    private void merge(int[] nums, int start, int mid, int end, int[] help) {

        if (start >= end) {
            return;
        }

        //构造新数组存储
        //int[] help = new int[nums.length];

        //将数组在新数组排序
        int p1 = start;
        int p2 = mid + 1;
        int i = start;
        while (p1 <= mid && p2 <= end) {
            if (nums[p1] < nums[p2]) {
                help[i] = nums[p1];
                i++;
                p1++;
            } else {
                help[i] = nums[p2];
                i++;
                p2++;
            }
        }

        while (p1 <= mid) {
            help[i] = nums[p1];
            i++;
            p1++;
        }
        while (p2 <= end) {
            help[i] = nums[p2];
            i++;
            p2++;
        }
        //复制回原数组
        for (int j = start;j <= end;j++) {
            nums[j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        MergeSort s = new MergeSort();
        s.sortArray(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
