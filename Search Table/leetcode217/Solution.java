package wyh.leetcode217;

import java.util.HashSet;
/**using hashtable
 * time complexity:O(n)
 * space complexity:O(n)
 * */
public class Solution {
	public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i ++){
            if(!set.contains(nums[i]))
                set.add(nums[i]);
            else
                return true;
        }
        return false;
    }
}
