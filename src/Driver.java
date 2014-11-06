import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Driver {

	public static void startEditor() {
		
		String line;
		Node head = new Node();
		Node current = new Node(1, null, null);
		int size;
		System.out.println("The current line is: " + current.linenum);
		System.out.println("Please enter a command or line of text.");
		
		try{
			BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
			line = indata.readLine();
						
			while(!line.equals("$done")){
				//loop until user enters $done
				String[] command = line.split("[, ]");
				if(command[0].equals("$insert")){
					
					if(current.data == null){
						head = LinkedList.BuildList(head);
						size = LinkedList.Size(head);
						LinkedList.CleanLine(size, head);
					}else {
						LinkedList.InsertNodes(current);
						size = LinkedList.Size(head);
						LinkedList.CleanLine(size, current);
					}
				}else if (command[0].equals("$print")){
					
					if(command.length == 3){
						size = LinkedList.Size(head);
						LinkedList.PrintList(Integer.parseInt(command[1]), Integer.parseInt(command[2]), head.next);
					}else if(command.length == 1){
						LinkedList.PrintList(head.next);
					}else {
						System.out.println("Invalid amount of parameters for $print");
					}
				}else if(command[0].equals("$delete")){
					Node q = LinkedList.DeleteNode(Integer.parseInt(command[1]), Integer.parseInt(command[2]), head);
					size = LinkedList.Size(head);
					LinkedList.CleanLine(size, q);
				}else if(command[0].equals("$line")){
					size = LinkedList.Size(head);
					current = LinkedList.SetLine(Integer.parseInt(command[1]), head, size);
					if(current.data != null){
						LinkedList.PrintList(Integer.parseInt(command[1]) -1, Integer.parseInt(command[1]) + 1, head);
					}
				}else if(command[0].equals("$search")){
					LinkedList.Search(head.next, command[1]);
					
				}else {
					System.out.println("The command you entered is not valid.");
				}
				System.out.println("The current line is: " + current.linenum);
				System.out.println("Please enter a command or line of text.");
				line = indata.readLine();
			}
			
		} catch(Exception e){
			System.out.println("Error -- " + e.toString());
		}
		System.out.println("Text editor simulation has terminated.");
	}
	
	
}


