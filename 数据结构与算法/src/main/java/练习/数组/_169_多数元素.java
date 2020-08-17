package 练习.数组;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ClassName:_169_多数元素
 * Package:练习.数组
 * Description:
 *
 * @date:2020-01-17 21:18
 * @author:892698613@qq.com
 */
public class _169_多数元素 {

    public int majorityElement(int[] nums) {
        //if (nums==null||nums.length==0)return 0;

        int len=nums.length;
        if (len==1)return nums[0];
        int mid=len/2;

        Map<Integer,Integer> map=new HashMap<>();

        for (int i : nums) {
            Integer val=map.get(i);
            if (val!=null&&val>=mid)return i;
            map.merge(i,1,Integer::sum);
        }

        int maxKey=0;
        int maxVal=0;
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            if (map.get(integer)>maxVal){
                maxKey=integer;
                maxVal=map.get(integer);
            }
        }

        return maxKey;
    }

}
