import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int[] arr, int target, int index,
                       List<Integer> list, List<List<Integer>> ans) {


        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (index == arr.length || target < 0) {
            return;
        }


        list.add(arr[index]);
        solve(arr, target - arr[index], index, list, ans);
        list.remove(list.size() - 1);


        solve(arr, target, index + 1, list, ans);
    }
}