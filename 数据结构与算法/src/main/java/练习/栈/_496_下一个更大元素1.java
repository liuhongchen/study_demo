package 练习.栈;

import java.util.HashMap;
import java.util.Map;

public class _496_下一个更大元素1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if (nums1==null||nums2==null)return null;
        Map<Integer,Integer> map=new HashMap<>();
        int len2=nums2.length;
        for (int i=0;i<len2;i++){
            for (int j=i+1;j<len2;j++){
                if (nums2[j]>nums2[i]){
                    map.put(nums2[i],nums2[j]);
                    break;
                }
            }
        }

        int len1=nums1.length;
        for (int i=0;i<len1;i++){
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;

    }
}
