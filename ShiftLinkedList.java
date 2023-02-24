/* Time:  O(n)
   Space:  O(1)
*/

import java.util.*;

class Program {
  public static LinkedList shiftLinkedList(LinkedList head, int k) {
		LinkedList iterator = head;
		//System.out.println("Shift:  " + k);
		
		int length = 0;
		while (iterator != null){
			//System.out.print(iterator.value + " => ");
			iterator = iterator.next;
			length++;
		}
		
		//System.out.println("Length: " + length);
		int offset = Math.abs(k) % length;
		int newHeadIdx = k > 0 ? length-offset : offset;
		//System.out.println("New Head idx: " + newHeadIdx);
		
		//No shift (newHeadidx == 0) or attempting to shift null (newHeadIdx == length of list)
		if (newHeadIdx == 0 || newHeadIdx == length){
			return head;
		}
		
		iterator = head;
		int count = newHeadIdx;
		
		while (count > 1){
			iterator = iterator.next;
			count--;
		}
		
		LinkedList newHead = iterator.next;
		LinkedList newTail = iterator;
		
		
		//System.out.println("New Head:  " + newHead.value);
		//System.out.println("New Tail:  " + newTail.value);
		iterator = newHead;
		
		while (iterator.next!=null){
			iterator = iterator.next;
		}
		
		iterator.next = head;
		newTail.next = null;
		
    return newHead;
  }

  static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }
}
