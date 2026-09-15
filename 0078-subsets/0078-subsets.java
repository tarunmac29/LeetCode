class Solution {
    public static void solve(int[] arr, int idx, List<List<Integer>> ans, List<Integer> list){
        if(idx == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[idx]);
        solve(arr, idx + 1, ans, list);

        list.remove(list.size()- 1);
        solve(arr, idx + 1, ans, list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(nums, 0, ans, list);

        return ans;
    }
}