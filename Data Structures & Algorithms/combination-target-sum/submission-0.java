class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] arr, int target,
                           List<Integer> temp,
                           List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (index == arr.length || target < 0)
            return;

        // Take current element
        temp.add(arr[index]);
        backtrack(index, arr, target - arr[index], temp, result);
        temp.remove(temp.size() - 1);

        // Skip current element
        backtrack(index + 1, arr, target, temp, result);
    }
}