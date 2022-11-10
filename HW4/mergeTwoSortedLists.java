import java.util.ArrayList;
import java.util.List;

public class mergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        final ListNode merged;

        if (list1.val < list2.val) {
            merged = list1;
            merged.next = mergeTwoLists(list1.next, list2);

        } else {
            merged = list2;
            merged.next = mergeTwoLists(list1, list2.next);
        }

        return merged;
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}

