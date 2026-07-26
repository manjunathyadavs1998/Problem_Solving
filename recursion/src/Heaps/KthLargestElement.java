package Heaps;

import java.util.*;

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
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            pq.offer(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll().getKey();
        }

        return ans;
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((a, b) -> {
                    if (!a.getValue().equals(b.getValue())) {
                        return a.getValue() - b.getValue();   // smaller frequency first
                    }
                    return b.getKey().compareTo(a.getKey());  // larger word first
                });

        for(Map.Entry<String, Integer>e:map.entrySet()){
            pq.offer(e);
            if(pq.size()>k) pq.poll();
        }
        List<String>result=new ArrayList<>();
        while(!pq.isEmpty()){
            Map.Entry<String, Integer>currEntry=pq.poll();
            result.add(currEntry.getKey());
        }
        Collections.reverse(result);
        return result ;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        KthLargestElement k=new KthLargestElement();
        System.out.println( k.findKthLargest(nums, 2, -1));
        System.out.println( k.findKthLargest(nums, 2));
    }
}
