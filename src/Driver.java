import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Driver {

	public static void printInstructions(){
		String[] instructions = new String[]{
				"The following commands are accepted to this text editor simulator.",
				"$insert string_data",
				"$delete m n",
				"$print m n",
				"$line m",
				"$search string_data",
				"$done",
				"Parameters m and n are integers for which you would like to inclusively print or delete"
		};
		
		for(String s : instructions){
			System.out.println(s);
		}
	}

	public static void startEditor() {
		
		String line;
		Node head = new Node();
		Node current = new Node(0, null, null);
		int size;
		
		try{
			BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
			line = indata.readLine();
						
			while(!line.equals("$done")){
				
				String[] command = line.split(" ");
				
				if(command[0].equals("$insert")){
					head = LinkedList.BuildList(head);
					size = LinkedList.Size(head);
					LinkedList.CleanLine(size, head);
				}else if (command[0].equals("$print")){
					
					if(command.length == 3){
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
					current = LinkedList.SetLine(Integer.parseInt(command[1]), head);
					LinkedList.PrintList(Integer.parseInt(command[1]) -1, Integer.parseInt(command[1]) + 1, head);
					//System.out.println(current.linenum);
				}else if(command[0].equals("$search")){
					size = LinkedList.Size(head);
					LinkedList.Search(head, command[1], size);
					
				}else {
					System.out.println(command[0] + " is not a valid command.");
				}
				
				line = indata.readLine();
			}
			
		} catch(Exception e){
			System.out.println("Error -- " + e.toString());
		}
		System.out.println("Text editor simulation has terminated.");
	}
	
	
}


