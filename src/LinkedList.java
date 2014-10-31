import java.io.BufferedReader;
import java.io.InputStreamReader;


public class LinkedList {
	
	public static Node BuildList(Node head){
		
		    int lineNum=1;
		    Node q = new Node();
		    if(head.next == null){
		    	head=q;
		    }else {
		    	q = head;
		    }
		    String oneLine;
		
	    System.out.println("Please Enter Your Text (Enter $ if you wish to terminate)");
	    try
	    {
	        BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));   
	        oneLine=indata.readLine();
	        while(!oneLine.equals("$"))
	        {
            	if( q.next == null){
            		Node p = new Node(lineNum , oneLine, null);
            		q.next=p;
            		q=p;
            		lineNum++;
            		//size++;
            		oneLine=indata.readLine();
            	}else {
            		q = q.next;
            	}
	        }
	    }catch (Exception e){
	    	System.out.println("Error input");
	    }
	    return head;
	    
	}
	//create insert method to add new list nodes in the middle of the list...

	public static void PrintList(Node n) {
		if(n != null){
			System.out.println(n.linenum + " " + n.data);
			PrintList(n.next);
		}
	}
	
	public static void PrintList(int m, int n, Node q){
		//System.out.println(n);
		if( m <= n){
			while(q.next != null && q.linenum != m){
				q = q.next;
			}
			while(m <= n){
				if(q.next != null){
					System.out.println(q.linenum + " " + q.data);
					q = q.next;
					m++;
				}else{
					System.out.println("Invalid line number for $print command");
					break;
				}
			}
		}else {
			System.out.println("The first parameter for $print must be smaller than or equal to the second.");
		}
	}
	
	public static Node DeleteNode(int m, int n, Node q){
		if(m <= n){
			Node p = new Node();
			while(q.next != null && q.linenum != m - 1){
				q = q.next;
			}
			while(m <= n){
				if(q.next != null){
					p = q.next;
					q.next = p.next;
					m++;
				}else {
					System.out.println("Invalid line number for $delete command");
					break;
				}
			}
		}else {
			System.out.println("The first parameter for $delete must be smaller than or equal to the second.");
		}
		return q;
	}
	
	public static void CleanLine(int size, Node n){
		int line = n.linenum;
		while(line < size){
			line++;
			n = n.next;
			n.linenum = line;
		}
	}
	public static int Size(Node n){
		int count = 0;
		while(n.next != null){
			count++;
			n = n.next;
		}
		return count;
	}

	public static Node SetLine(int line, Node current) {
		
		while(current.linenum != line ){
			current = current.next;
		}
		return current;
	}
	
	public static void Search(Node n, String word, int size){
		
		while(n.linenum <= size ){
			if(n.data.indexOf(word) != -1){
				System.out.println("found word on line" + n.linenum);
				break;
			}else if(n.linenum < size){
				n = n.next;
			}else{
				System.out.println("The word " + word + " was not found.");
				break;
			}
		};
	}
}
