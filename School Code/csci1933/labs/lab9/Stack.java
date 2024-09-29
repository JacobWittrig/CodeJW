public class Stack<T>{
    private int size;
    Node top;
    Stack() {
        this.size=5;
        this.top = new Node();
    }
    // This is the default constructor, it should set the initial size of the stack to 5.
    Stack(int size) {
        this.size=size;
        this.top = new Node();
    }
    // This will initialize the size of the stack to size.
    T pop () throws StackException {

        if(top.getNext()==null)
            throw new StackException(this.size);
//            return null;
        Node currNode=top;
        if(top.getNext().getNext()==null){
            T retVal= (T) top.getNext().getData();
            top.setNext(null);
            return retVal;
        }
        while (currNode.getNext().getNext()!=null){
            currNode=currNode.getNext();
        }
        
        T retVal = (T) currNode.getNext().getData();
        currNode.setNext(null);
        return retVal;
    }
    // This will remove and return the object at the top of the stack.
    void push(T item) throws StackException {
        int length=0;
        Node currNode=this.top;
        while(currNode.getNext()!=null){
            currNode=currNode.getNext();
            length++;
        }
        if(length>=this.size)
            throw new StackException(this.size);
        else{
            currNode.setNext(new Node(item));
        }
    }
    //This will add an item to the top of the stack and throw an exception if the stack size is exceeded.



}