package wyh.leetcode217;

import java.util.HashMap;

public class Solution1 {
	public boolean containsDuplicate(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i ++) 
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		for(Integer num: map.keySet())
			if(map.get(num)>1)
				return false;
		return true;
	}
	
	
}
