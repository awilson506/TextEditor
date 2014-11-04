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
		
	    System.out.println("Enter text, enter $ to terminate)");
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

	public static void PrintList(Node n) {
		if(n != null){
			System.out.println(n.linenum + " " + n.data);
			PrintList(n.next);
		}
	}
	
	public static void PrintList(int m, int n, Node q){
		
		if( m <= n){
			if(m == 0){
				m++;
			}
			while(q.next != null && q.linenum != m){
				q = q.next;
			}
			while(m <= n){
				if(q != null){
					System.out.println(q.linenum + " " + q.data);
					q = q.next;
				}else{
					System.out.println(m + " **This line does not exist.");
					break;
				}
				m++;
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

	public static Node SetLine(int line, Node current, int size) {
		if(line <= size){
			while(current.linenum != line ){
				current = current.next;
			}
		}else{
			System.out.println("The line number you entered does not exist.");
		}
		return current;
	}
	
	public static void Search(Node n, String word){
		
		while(n != null ){
			if(n.data.indexOf(word) != -1){
				System.out.println("found word on line " + n.linenum);
				break;
			}
			n = n.next;
			if(n == null){
				System.out.println("Word not found.");
			}
		}
	}

	public static void InsertNodes(Node current) {
		
		String oneLine;
		int lineNum = current.linenum +1;
		Node q = current.next;
		System.out.println("Enter text, enter $ to terminate)");
	    try
	    {
	        BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));   
	        oneLine=indata.readLine();
	        while(!oneLine.equals("$"))
	        {
            	if( current.next == null){
            		Node p = new Node(lineNum , oneLine, null);
            		current.next=p;
            		current=p;
            		lineNum++;
            		oneLine=indata.readLine();
            	}else {
            		Node p = new Node(lineNum , oneLine, null);
            		current.next = p;
            		current = p;
            		lineNum++;
            		oneLine = indata.readLine();
            	}
	        }
	        current.next = q;
	    }catch (Exception e){
	    	System.out.println("Error input");
	    }
	}
}
