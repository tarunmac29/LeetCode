class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> dp = new ArrayList<>();

        for(int i = 0; i <= rowIndex; i++){
            List<Integer> ans = new ArrayList<>();

            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) ans.add(1);
                else{

                    int left = dp.get(i - 1).get(j - 1);
                    int right = dp.get(i - 1).get(j);

                    ans.add(left + right);
                }
            }

            dp.add(ans);
        }

        return dp.get(rowIndex);
    }
}