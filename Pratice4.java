public class Pratice4 {
  //给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
    public static void main(String[] args) {
        int[] arr ={-5,-3,-2,-1};
        sortedSquares(arr);


      /*  for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }*/
    }
    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        if (len ==1){
            nums[0] = nums[0]*nums[0];
            return nums;
        }
        int con = -1;
        for(int i =0;i<len;i++){
            if(nums[i]<0){
                con = i;
            }else{
                break;
            }
        }
        for(int i =0;i<len;i++){
            nums[i] = nums[i]*nums[i];
        }
        int[] arr = new int[len];
        int m = con;
        int n = con+1;
        int index = 0;
        while(m>=0|n<len){
            if(m>=0&&(n<len&&nums[m]>nums[n])){
                arr[index] = nums[n];
                ++n;
            }else if(m>=0&&(n<len&&nums[m] == nums[n])){
                arr[index] = nums[m];
                index= index +1;
                arr[index] = nums[n];
                --m;
                ++n;
            } else if(m>=0&&(n<len&&nums[m]<nums[n])){
                arr[index] = nums[m];
                --m;
            }else if(m<0 && n<len){
                arr[index] = nums[n];
                ++n;
            }else if(n>=len&&m>=0){
                arr[index] = nums[m];
                --m;
            }
            index = index+1;
        }
        for (int i =0;i<len;i++){
            System.out.println(arr[i]);
        }
        return arr;
    }
}
