package code.marut.practice.tree;

public class SerializeDeserializeTree {

	public static class MyTree{
		public String d;
		public MyTree l;
		public MyTree r;
		public MyTree(String d) {
			this.d = d;
		}
	}
	
	public static void main(String[] args) {
		MyTree tree = new MyTree("A");
		tree.l=new MyTree("B");
		tree.r=new MyTree("C");
		
		tree.l.l = new MyTree("D");
		tree.l.r = new MyTree("E");
		tree.l.r.l = new MyTree("G");
		
		tree.r.r = new MyTree("F");
		String serializedString= serializeTree(tree);
		System.out.println(serializeTree(tree));
		MyTree dTree =deserializeTree(serializedString);
		System.out.println(dTree);
		
	}
	
	public static String serializeTree(MyTree tree) {
		String s="";
		return serialize(tree, s);
	}
	
	private static String serialize(MyTree curr, String s) {
		if(curr==null) {
			return s;
		}
		s+=curr.d;
		if(curr.l==null && curr.r==null) {
			return s;
		}
		s+="'";
		if(curr.l==null) {
			s+="/";
		}else {
			s = serialize(curr.l, s);
		}
		if(curr.r==null) {
			s+="/";
		}else {
			s = serialize(curr.r, s);
		}
		return s;
	}
	
	public static MyTree deserializeTree(String stored) {
		if(stored==null) {
			return null;
		}
		index=0;
		return deserialize(stored);
	}
	static Integer index;
	public static MyTree deserialize(String stored) {
		if(index>= stored.length()) {
			return null;
		}
		if(stored.charAt(index)=='/') {
			index++;
			return null;
		}
		if(stored.charAt(index)!='\''){
			MyTree temp = new MyTree(""+stored.charAt(index));
			index++;
			if(index>=stored.length()) {
				return temp;
			}else if(stored.charAt(index)=='\''){
				index++;
				temp.l = deserialize(stored);
				temp.r = deserialize(stored);
			}
			return temp;
		}
		return null;
	}
}
