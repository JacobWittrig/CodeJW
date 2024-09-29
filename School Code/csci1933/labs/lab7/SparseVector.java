public class SparseVector {

	private Node head;
	private int length;

	public SparseVector(int len){
		head = null;
		length = len;
	}

	// Prints out a sparse vector (including zeros)
	public String toString(){

		String result = "";
		Node currNode = head;
		int currIndex = 0;
		while( currNode != null ){
			int idx = currNode.getIndex();

			// Pad the space between nodes with zero
			while( currIndex < idx ){
				result += "0, ";
				currIndex++;
			}
			result += currNode;
			currNode = currNode.getNext();
			currIndex++;

			// Only add a comma if this isn't the last element
			if( currNode != null ){ result += ", "; }
		}
		return result;
	}

	// TODO: Implement me for milestone 2
	public void addElement(int index, double value){
		
		if(index>this.length){
			System.out.println("The index does not exist :(");
			return;
		}
		Node newNode = new Node(index, value);
		Node currNode = head;
		if(head==null){
			head=newNode;
			return;
		}
		if(index<head.getIndex()){
			newNode.setNext(head);
			head=newNode;
		}
		if(currNode.getNext()==null){
			currNode.setNext(newNode);
			return;
		}
		while( currNode.getNext() != null ){
			if(currNode.getNext().getIndex()>index){
				newNode.setNext(currNode.getNext());
				currNode.setNext(newNode);
				return;
			}
			
			currNode = currNode.getNext();
			if(currNode.getNext()==null){
				currNode.setNext(newNode);
				return;
			}

		}
		
	}

	// TODO: Implement me for milestone 4
	public static double dot( SparseVector x, SparseVector y ){
		if(x.length!=y.length){
			System.out.println("Cant do");
			return -1.0;
		}
		double total=0;
		Node xNode=x.head;
		Node yNode=y.head;
		while ((xNode!=null) && (yNode!=null)){
			if (xNode.getIndex()==yNode.getIndex()){
				total+=xNode.getValue()*yNode.getValue();
				xNode=xNode.getNext();
				yNode=yNode.getNext();
			}
			else if (xNode.getIndex()<yNode.getIndex()){
				xNode=xNode.getNext();
			}
			else if (xNode.getIndex()>yNode.getIndex()){
				yNode=yNode.getNext();
			}

		}
		return total;
	}

	public void removeElement(int index){
		Node currNode=head;
		if (currNode==null)
			return;
		if (currNode.getIndex()==index)
			{if(currNode.getNext()==null)
				{head=null;
				return;}
			else
				{head=currNode.getNext();
				return;}
			}
		while (currNode.getNext().getIndex()!=index){
			currNode=currNode.getNext();
		}
		// if(currNode==null | currNode.getNext()==null)
		// 	return;
		if(currNode.getIndex()>index)
			return;
		currNode.setNext(currNode.getNext().getNext());
	}

	// TODO: Test out your code here!
	public static void main(String[] args) {
		// SparseVector jacobsVector = new SparseVector(9);
		// System.out.println("Here is an empty vector: ");
		// System.out.println(jacobsVector);
		// System.out.println("Adding elements: ");
		// jacobsVector.addElement(1, 25.0);
		// jacobsVector.addElement(7, -11.2);
		// jacobsVector.addElement(8, 32.0);
		// System.out.println(jacobsVector);

		// SparseVector x = new SparseVector(100000000);
		// x.addElement(0, 1.0);
		// x.addElement(10000000, 3.0);
		// x.addElement(10000001, -2.0);
		// SparseVector y = new SparseVector(100000000);
		// y.addElement(0, 2.0);
		// y.addElement(10000001, -4.0);
		// double result = dot(x, y);
		// System.out.println(result);

		SparseVector x = new SparseVector(100000000);
		x.addElement(0, 1.0);
		x.addElement(10000000, 3.0);
		x.addElement(10000001, -2.0);
		SparseVector y = new SparseVector(100000000);
		y.addElement(0, 2.0);
		y.addElement(10000001, -4.0);
		y.removeElement(0);
		double result = dot(x, y);
		System.out.println(result);

	}
}


