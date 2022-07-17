package n03.linkedlist.leetcode.easy.n21;

public class Test {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        Solution solution = new Solution();
        System.out.println(solution.toString(solution.mergeTwoLists(list1, list2)));
    }
}