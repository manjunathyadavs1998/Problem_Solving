package Heaps;

import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0; i<k ;i++){
            pq.offer(nums[i]);
        }
        for(int i=k; i<nums.length; i++){
            if(!pq.isEmpty()&&pq.peek()<=nums[i]){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return !pq.isEmpty()?pq.peek():-1;
    }
    public int findKthLargest(int[] nums, int k, int y) {
        int[] count = new int[20001];

        for (int num : nums)
            count[num + 10000]++;

        for (int i = count.length - 1; i >= 0; i--)
            if (count[i] > 0) {
                k -= count[i];
                if (k <= 0) return i - 10000;
            }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        KthLargestElement k=new KthLargestElement();
        System.out.println( k.findKthLargest(nums, 2, -1));
        System.out.println( k.findKthLargest(nums, 2));
    }
}
