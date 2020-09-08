package Day;

import java.util.*;

public class LeetCode9_8 {
    public static void main(String[] args) {
        /*
         * [4,1,-1,2,-1,2,3]
         */
        Solution s = new Solution();
        int [] nums = new int[]{4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(s.topKFrequent(nums,2)));
    }

}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(null != map.get(nums[i])){
                int tmp = map.get(nums[i]) + 1;
                map.put(nums[i],tmp);
            }else{
                map.put(nums[i],1);
            }
        }

        List<Map.Entry<Integer,Integer>> list=new ArrayList<>();
        list.addAll(map.entrySet());
        ValueComparator vc=new ValueComparator();
        Collections.sort(list,vc);
        int i=1;
        int[] result = new int[k];
        for (Map.Entry<Integer, Integer> entry : list) {
            if(i>k)break;
            result[i-1]=entry.getKey();
            i++;
        }
        return result;
    }
}
class ValueComparator implements Comparator<Map.Entry<Integer, Integer>>  {
    public int compare(Map.Entry<Integer, Integer> mp1, Map.Entry<Integer, Integer> mp2) {
        return mp2.getValue() - mp1.getValue();
    }
}