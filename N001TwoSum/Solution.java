package N001TwoSum;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
//        1. 定义数组用于存放结果
        int[] result = new int[2];

//        2. while 循环遍历查找相加为 target 的两个 index
        int i = 0;
        boolean flag = false;
        while (!flag) {
            System.out.println("outer " + i + " loop");
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println("inner " + j + " loop");
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    flag = true;
                    break;
                }
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        int[] result = new Solution().twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
