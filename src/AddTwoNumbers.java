class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Result{

    public ListNode head;
    public ListNode tail;

    public Result(){
        this.head=new ListNode();
        this.tail=head;

    }

    public void append(int val){
    ListNode listNode=new ListNode(val);
    this.tail.next=listNode;
    this.tail=listNode;
    }
}
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1=new ListNode();
        l1.val=9;
        l1.next=new ListNode(9);
        l1.next.next=new ListNode(9);

        ListNode l2=new ListNode();
        l2.val=9;
        l2.next=new ListNode(9);
        l2.next.next=new ListNode(9);

        ListNode l=addTwoNumbers(l1,l2);
        while (l!=null){
            System.out.println(l.val);
            l=l.next;
        }
    }



    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){

        Result result=new Result();
        int carry=0;
        while(l1!=null || l2!=null){

            int n1= (l1==null)?0:l1.val;
            int n2=(l2==null)?0:l2.val;
            int sum=n1+n2+carry;
            result.append(sum%10);
            carry= sum>9?1:0;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }

        if(carry==1){
            result.append(1);
        }

        return result.head.next;
    }
}
