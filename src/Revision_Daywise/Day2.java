package Revision_Daywise;

public class Day2 {


    // DAY - 2
    //Arrays

    // Linear Search
//    public class LinearSearch {
//        public static int search(int[] arr, int target) {
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] == target) {
//                    return i;
//                }
//            }
//            return -1;
//        }
//
//    }
//    public static void main(String[] args) {
//        int arr[] = {1,2,3,4,5};
//        int target = 4;
//        System.out.println(LinearSearch.search(arr, target));
//    }

    // Largest in array

//    public static void main(String[] args) {
//        int arr[] = {10,20,30,40,50};
//        int max = arr[0];
//
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > max) {
//                max = arr[i];
//            }
//        }
//        System.out.println(max);
//    }

    // Binary Search
//    public static int binarySearch(int [] arr, int target) {
//
//        int low = 0;
//        int high = arr.length - 1;
//
//        while(low <= high){
//            int mid = low + (high-low)/2;
//            if(arr[mid] == target){
//                return mid;
//            } else if (arr[mid] > target) {
//                high = mid - 1;
//
//            } else {
//                low = mid + 1;
//            }
//        }
//        return -1;
//    }
//    public static void main(String[] args) {
//        int arr[] = {10,20,30,40,50};
//        int target = 20;
//        System.out.println(binarySearch(arr,target));
//    }


    // Reverse an array

//    public static int[] reverseArray(int[] arr){
//        int temp[] = new int[arr.length];
//        for (int i = 0, j= arr.length -1; i < arr.length; j--, i++) {

    /// /            for (int j = arr.length-1; j <= i; j--) { // giving error: The output isn't matching because
    /// /            your code is outputting [20, 20, 20, 20, 20] instead of reversing the array
    /// /                temp[i] = arr[j];
    /// /            }
//            temp[i] = arr[j];
//        }
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = temp[i];
//        }
//        return arr;
//
//    }
//    public static void main(String[] args) {
//        int arr[] = {10,20,30,40,50};
//        System.out.println(Arrays.toString(reverseArray(arr)));
//    }


    // SubArrays

//    public static void main(String[] args) {
//    int arr[] = {10,20,30,40,50};
//
//    for (int i = 0; i < arr.length; i++) {
//        for (int j=i; j < arr.length; j++) {
//            for (int k=i; k <= j; k++) {
//                System.out.print(arr[k] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
//    }

    // Max SubArray Sum
    //Brute Force
//    public static int maxSubArraySum(int[] nums) {
//    int MaxSum = Integer.MINVALUE;;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                System.out.println(sum);
//                if (sum > MaxSum) {
//                    MaxSum = sum;
//                }
//            }
//        }
//        return MaxSum;
//    }
//    public static void main(String[] args) {
//    int nums[] = {10,20,30,40};
//        System.out.println(maxSubArraySum(nums));
//    }
//    // Kadane's Algorithm for MaxSubArray Sum
//    public static int KadaneAlgo(int[] nums){
//    int maxSum = nums[0];
//    int currentSum = nums[0];
//
//    for (int i = 1; i <= nums.length-1; i++) {
//        currentSum += nums[i];
//        currentSum = Math.max(currentSum, nums[i]);
//        maxSum = Math.max(currentSum, maxSum);
//        }
//    return maxSum;
//    }
//    public static void main(String[] args) {
//    int nums[] = {10,20,30,40};
//    System.out.println(KadaneAlgo(nums));
//    }

    // Trapped Water
//    public static void main(String[] args) {// 2 pointer approach
//        int arr[] = {10, 11, 14, 11, 1, 11};
//        int left = 0, right = arr.length - 1;
//        int leftMax = 0, rightMax = 0;
//        int trappedWater = 0;
//        while (left < right) {
//            if (arr[left] < arr[right]) { // leftMax is bottleneck
//                if (arr[left] >= leftMax) {
//                    leftMax = arr[left];
//                } else {
//                    trappedWater += leftMax - arr[left];
//                }
//                left++;
//            } else {
//                if (arr[right] >= rightMax) {
//                    rightMax = arr[right];
//                } else {
//                    trappedWater += rightMax - arr[right
//                            ];
//                }
//                right--;
//            }
//        }
//        System.out.println(trappedWater);
//    }

    // Buy AND sELL Stocks
public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyingPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < buyingPrice) {
                buyingPrice = price;
            }else if(price - buyingPrice > maxProfit) {
                maxProfit = price - buyingPrice;
            }
        }
        return maxProfit;

}
public static void main(String[] args) {
        int prices[] = {10,5,15,10};
    System.out.println(maxProfit(prices));
}
}
