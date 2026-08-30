class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer,Integer> first=new HashMap<>();
        Map<Integer,Integer> last=new HashMap<>();
        Map<Integer,Integer> count=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(!first.containsKey(num)){
                first.put(num,i);
            }
            last.put(num,i);
            count.put(num,count.getOrDefault(num,0)+1);
        }
        int sc=0;
        for(int num:first.keySet()){
            int fIdx=first.get(num);
            int lIdx=last.get(num);
            int to=count.get(num);
            if((lIdx-fIdx+1)==to){
                sc++;
            }
        }
        return sc;
    }
}©leetcode