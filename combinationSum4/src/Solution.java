import java.util.*;

/**
 * Created by cw on 7/31/16.
 */
public class Solution {


    private Map<Integer, Integer> mapResult = new HashMap<>();

    private Map<Integer, Integer> mark = new HashMap<>();

    private int helloResult(int[] nums, int target) {

        if (mapResult.get(target) == null) {
            mapResult.put(target, 0);
        }

        for (int sub : nums) {

            int current = target - sub;
            if (current > 0) {


                if (mark.get(target) == null)
                    mapResult.put(target, mapResult.get(target) + helloResult(nums, current));
            } else if (current == 0) {
                if (mapResult.get(target) == null) {
                    mapResult.put(target, 1);
                } else {
                    if (mark.get(target) == null)
                        mapResult.put(target, mapResult.get(target) + 1);
                }
            }
        }
        if (mark.get(target) == null)
            mark.put(target, 1);
        return mapResult.get(target);
    }
    public int combinationSum4(int[] nums, int target){

        if(nums.length <= 0){
            return 0;
        }
        helloResult(nums, target);

        return mapResult.get(target);

    }


    public static void main(String[] args){

       // Map<Integer, ArrayList<Integer>> t = new HashMap<>();
        Solution s = new Solution();
        System.out.println(s.combinationSum4(new int[]{1,2,3}, 5));

    }
}
