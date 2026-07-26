class Solution {
    public static void solve(int[] arr, int target, int idx, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = idx; i < arr.length; i++){
            if(i > idx && arr[i] == arr[i - 1]) continue;
            if(arr[i] > target) break;

            list.add(arr[i]);
            solve(arr, target - arr[i], i + 1, list, ans);

            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        solve(candidates, target, 0, list, ans);

        return new ArrayList<>(ans);
    }
}