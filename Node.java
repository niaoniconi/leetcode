package linklist;

public class Node {		//˫������ڵ�
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


class Solution430 {
	Node successor=null,tail;
    public Node flatten(Node head) {		//��ƽ���༶˫������
    	if(head==null) return head;
    	Node cur=head;
    	while(cur.next!=null) cur=cur.next;				//�Ӻ���ǰ
    	Node ncur=cur,successor;
    	while(cur.child!=null||cur.prev!=null){			//��ǰ�ڵ��к��ӻ����к��
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