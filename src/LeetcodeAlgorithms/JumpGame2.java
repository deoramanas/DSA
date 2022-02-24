package LeetcodeAlgorithms;

public class JumpGame2 {
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};
        int jump = jump(nums);
        System.out.println(jump);
    }

    public static int jump(int[] nums) {
        int maxSoFar = 0;
        int ladder = 0;
        int jumps = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maxSoFar = Math.max(maxSoFar, i + nums[i]);
            if (i == ladder) {
                jumps++;
                ladder = maxSoFar;
            }
        }
        return jumps;
    }
}
