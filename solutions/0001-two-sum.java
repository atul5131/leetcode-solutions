/*

Intuition
You get an array nums and a number target. Find the two indices whose values add up to target. Exactly one answer exists, and you can’t use the same element twice.

Approach
Brute force: check every pair with two nested loops. That is O(n²), which is too slow when n is up to 10⁴.

Optimized (HashMap): think of a shop where you need two items that cost ₹9 together. You pick up the ₹2 item and ask yourself, “have I already seen a ₹7 item?” If yes, you’re done. If not, you note down “₹2 item, position 0” and move on. The HashMap is that notebook.

Complexity
Time complexity:
Time: O(n). One pass, with O(1) average per HashMap operation.

Space complexity:
Space: O(n). The map can hold up to n entries.

Code
*/
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];

            if (seen.containsKey(need)) {
                return new int[]{seen.get(need), i};
            }

            seen.put(nums[i], i);
        }

        return new int[]{};
    }
}