package linklist;

public class Node {		//双向链表节点
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


class Solution430 {
	Node successor=null,tail;
    public Node flatten(Node head) {		//扁平化多级双向链表
    	if(head==null) return head;
    	Node cur=head;
    	while(cur.next!=null) cur=cur.next;				//从后往前
    	Node ncur=cur,successor;
    	while(cur.child!=null||cur.prev!=null){			//当前节点有孩子或者有后继
    		if(cur.child==null) cur=cur.prev;
    		else{
    			successor=cur.next;
    			cur.next=cur.child;
        		cur.child.prev=cur;
        		cur.child=null;
        		while(cur.next!=null) {
        			cur=cur.next;
        			if(cur.child!=null) ncur=cur;
        		}
        		cur.next=successor;
        		if(successor!=null) successor.prev=cur;
        		cur=ncur;
    		}
    	}
    	
    	return head;  
    }
   
}