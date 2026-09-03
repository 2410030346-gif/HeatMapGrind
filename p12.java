class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>s1=new HashSet<>();
        for(int i:nums1){
              s1.add(i);
            }
            Set<Integer> s2=new HashSet<>();
            for(int j:nums2){
                if(s1.contains(j)){
                    s2.add(j);
                }
            }
            int [] result=new int[s2.size()];
            int index=0;
            for(int num:s2){
                result[index++]=num;
            }
            return result;
    }
        }