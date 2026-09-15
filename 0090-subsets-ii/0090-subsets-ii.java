class Solution {
    public static void solve(int[] arr, int idx, ArrayList<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));

        for(int i = idx; i < arr.length; i++){
            if(i != idx && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            solve(arr, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        solve(nums, 0, list, ans);

        return ans;
    }
}