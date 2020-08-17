package 练习.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:_1287_数组中出现次数超过25的元素
 * Package:练习.数组
 * Description:
 *
 * @date:2020-01-19 09:37
 * @author:892698613@qq.com
 */
public class _1287_数组中出现次数超过25的元素 {

    public int findSpecialInteger(int[] arr) {
        if (arr==null||arr.length==0)return 0;
        if(arr.length==1)return arr[0];
        int len= arr.length;

        int target=len/4;

        Map<Integer,Integer> map=new HashMap<>();

        for (int i : arr) {
            Integer count = map.get(i);
            if (count!=null&&count>=target)return i;
            map.put(i,count==null?1:count+1);
        }

        return 0;
    }

}
