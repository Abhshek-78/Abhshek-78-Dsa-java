class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l2=new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), l2);
        return l2;
        
    }
    private static void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> l2) {
        l2.add(new ArrayList<>(current)); 
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);          
            backtrack(i + 1, nums, current, l2); 
            current.remove(current.size() - 1); 
        }
    }
}
