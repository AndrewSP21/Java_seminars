import java.util.*;

public class intersectionOfTwoArraysII {
    public static void main(String[] args) {
        int nums1[] = {4,9,5};
        int nums2[] = {9,4,9,8,4};
        for (var t :intersect(nums2, nums1)
             ) {
            System.out.println(t);
        }
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            intersect(nums2, nums1);
        }

        List <Integer> nums3 = new ArrayList<Integer>();
        List <Integer> nums4 = new ArrayList<Integer>();
        for (Integer var : nums1) {
            nums3.add(var);
        }
        for (int i = 0; i < nums2.length; i++) {

            if (nums3.indexOf(nums2[i]) != -1) {
                nums4.add(nums2[i]);
                nums3.remove(nums3.indexOf(nums2[i]));
            }
        }
        int array[] = new int[nums4.size()];
        for (int i = 0; i < nums4.size(); i++) {
            array[i] = nums4.get(i);
        }
        return array;
    }
}
