public class Node {
	
	String data;
    int linenum;
    Node next;

    public Node()
    {
    	linenum = 0;
        data = null;
        next = null;
    }

    public Node(int y, String x, Node n)
    {
    	linenum = y;
        data = x;
        next = n;
    }
}
