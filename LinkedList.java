public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
            return;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public static void Traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        size++;
    }

    public static void addMiddle(int data,int index){

        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
            Node temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        newNode.next=temp.next;   //perform second case first 1->2->3->4->null
        temp.next=newNode;
        size++;

    }

    public static int removeFirst(){
        if(size==0){
            System.out.println("LinkedList is Empty");
            return -1;
        }
        if(size==1){
            head=tail=null;
            size--;
            return head.data;
        }
        int val=head.data;
        head=head.next;
        return val;

    }


    public static int removeLast(){
        if(size==0){
            System.out.println("LinkedList is Empty");
            return -1;
        }
        if(size==1){
            head=tail=null;
            size--;
            return head.data;
        }
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
      }
      size--;
      int val=temp.data;
      temp.next=null;
      return val;
    }
    public static int healper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int index=healper(head.next, key);
        if(index==-1){
            return -1;
        }
        return index+1;
    }

    public static void Rsearch(int key){
        System.out.println(healper(head,key));
    }


    public static Node reverse(){
        if(head==null || head.next==null){
            return head;
        }
        Node prev=head;
        Node curr=head.next;

        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;

            prev=curr;
            curr=next;
        }
        head.next=null;
        head=prev;
        return head;
    }

    public static void remove(int n){
        int sz=0;
        if(head==null){
            return;
        }
        
        Node temp=head;
        while(temp!=null){
            sz++;
            temp=temp.next;
        }

        if(sz==n){
            head=head.next;
            return;
        }
        int i=1;
        int toFindIndex=sz-n;
        Node prev=head;
        while(i < toFindIndex){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
       return;

    }

    public static Node FindMid(){
        if(head==null||head.next==null) return head;
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static Boolean Palindrome(){
        if(head==null || head.next==null||head.next==null){
            return true; 
        }

        Node mid=FindMid();
        
        Node prev=mid;
        Node curr=mid.next;
        while(curr!=null){
            Node next=curr.next;
          curr.next=prev;

          prev=curr;
          curr=next;
        }
        mid.next=null;
        mid=prev;
        Node left=head;
        Node right=mid;


        



        while(right!=null){
            if(left.data != right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        //ll.addFirst(25);
        //ll.addFirst(26);
        //ll.addFirst(85);
        //ll.Traverse(); // Corrected method call
       // System.out.println();
       addLast(6);
        addLast(36);
         addLast(85);
         addLast(85);
         addLast(85);
         addLast(36);
         addLast(6);
        
         //ll.Traverse(); 

        // ll.addMiddle( 88, 2);
        // ll.Traverse(); 
        // System.out.println();
        // ll.removeFirst();
        // ll.Traverse(); 
         
         //System.out.println();
         //ll.removeLast();
        // ll.Traverse(); 

         //System.out.println(ll.size);
        // Rsearch(85);
         //ll.Traverse(); 
         //System.out.println();
         //reverse();
         //ll.Traverse(); 
         //remove(4);
         //System.out.println();
         ll.Traverse(); 
         System.out.println(Palindrome());
         
    }
}
