package www.wyh.leetcode451;

import java.util.Arrays;
import java.util.HashMap;
/**using hashtable+stringbuilder
 * time complexity:O(n)
 * space complexity:O(256)
 * */
public class Solution {
	public String frequencySort(String s) {
		if(s.length()==0)
			return "";
		
		int[] freq=new int[256];
		for(int i=0;i<s.length();i++)
			freq[s.charAt(i)]++;
		
		HashMap<Integer,String> map=new HashMap<>();
		for(int i=0;i<freq.length;i++) {
			if(freq[i]!=0) {
				char ch=(char)i;
				
				String str=map.get(freq[i]);
				if(map.get(freq[i])!=null) {
					String newStr=str.concat(build(ch,freq[i]));
					map.put(freq[i], newStr);
				}
				else
					map.put(freq[i], build(ch,freq[i]));
			}
		}
		//Integer[] keys = map.keySet().toArray(new Integer[] {});
		Integer[] keys = new Integer[map.size()];
		int k=0;
		for(Integer i: map.keySet()) {
			keys[k++]=i;
		}
			
		Arrays.sort(keys);
		StringBuilder res =new StringBuilder();
		for(int i=keys.length-1;i>=0;i--)
			res.append(map.get(keys[i]));
		return res.toString();
		
	}
	private String build(char ch,int times) {
		String str=Character.toString(ch);
		StringBuilder res=new StringBuilder();
		int t=0;
		while(t<times) {
			res.append(str);
			t++;
		}
		return res.toString();
	}
	public static void main(String[] args) {
		String s = "tree";
		System.out.print(new Solution().frequencySort(s));
	}
}
