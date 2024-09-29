public class LinkedList<T extends Comparable<T>> implements List<T> {
    private boolean isSorted;
    private int size;
    private Node head;
    public LinkedList(){
        this.isSorted=true;
        this.size=0;
        this.head = new Node(null,null);
    }

    public static void main(String args[]){
        LinkedList testList = new LinkedList();


        testList.add(1);
        testList.add(2);
        testList.add(1);
        testList.add(3);

        testList.removeDuplicates();

        System.out.println("\n");

        System.out.println(testList.sortedChecker());
        System.out.println("testing");

    }

    public boolean sortedChecker(){
        boolean sorted=true;
        if(this.size<=1)
            return sorted;
        Node currNode=head.getNext();
        while(currNode!=null&&currNode.getNext()!=null){
            if(currNode.getData().compareTo(currNode.getNext().getData())>0)
                sorted=false;
            currNode=currNode.getNext();
        }
        return sorted;
    };
    /**
   * Add an element to end of the list. If element is null,
   * it will NOT add it and return false.  Otherwise, it
   * will add it and return true. Updates isSorted to false if
   * the element added breaks sorted order.
   *
   * @param element element to be added to the list.
   * @return if the addition was successful.
   */
  public boolean add(T element) {
      if (element == null)
          return false;
      Node newNode = new Node(element);
      Node currNode = this.head;
      while (currNode.getNext() != null) {
          currNode = currNode.getNext();
      }
      currNode.setNext(newNode);
      this.size += 1;
      if (this.size > 1){
          if(currNode.getData().compareTo(newNode.getData())>0)
              this.isSorted=false;
      }

    return true;
  };

  /**
   * Add an element at specific index. This method should
   * also shift the element currently at that position (if
   * any) and any subsequent elements to the right (adds
   * one to their indices). If element is null, or if index
   * index is out-of-bounds (index < 0 or index >= size_of_list),
   * it will NOT add it and return false. Otherwise it will
   * add it and return true. See size() for the definition
   * of size of list. Also updates isSorted variable to false if the
   * element added breaks the current sorted order.
   *
   * @param index index at which to add the element.
   * @param element element to be added to the list.
   * @return if the addition was successful.
   */
  public boolean add(int index, T element){
    if(element==null)
        return false;
    if(index<0||index>=this.size)
        return false;

    
    Node newNode = new Node(element);
    Node currNode = head;
    if(index==0){
        if(head.getNext()==null){
            head.setNext(newNode);
        }
        else{
            if(newNode.getData().compareTo(head.getNext().getData())>0){
                this.isSorted=false;
            }
            newNode.setNext(head.getNext());
            head.setNext(newNode);
        }
        this.size+=1;
        return true;
    }
    //checks to see if node needs to be added at beginning
    int currIndex=0;
    while(currIndex<index-1){
        currNode=currNode.getNext();
        currIndex+=1;
    }
    if(newNode.getData().compareTo(currNode.getData())<0)
        this.isSorted=false;
    currNode=currNode.getNext();
    if(currNode.getNext()==null){
        currNode.setNext(newNode);}
    else{
        newNode.setNext(currNode.getNext());
        currNode.setNext(newNode);
    }
    this.size+=1;
    return true;
    //iterates through to the index then adds
    
  };

  /**
   * Remove all elements from the list and updates isSorted accordingly.
   */
  public void clear(){
    this.head.setNext(null);
    this.size=0;
    this.isSorted=true;
    };

  /**
   * Return the element at given index. If index is
   * out-of-bounds, it will return null.
   *
   * @param index index to obtain from the list.
   * @return the element at the given index.
   */
  public T get(int index){
      if(this.size==0 | index<0 | index>=size)
          return null;
    Node currNode=this.head.getNext();
    int location=0;
    while(location<index){
        currNode=currNode.getNext();
        location++;
    }
    return (T) currNode.getData();
  };

  /**
   * Return the first index of element in the list. If element
   * is null or not found in the list, return -1. If isSorted is
   * true, uses the ordering of the list to increase the efficiency
   * of the search.
   *
   *
   * @param element element to be found in the list.
   * @return first index of the element in the list.
   */
  public int indexOf(T element){
      if(element==null | this.size==0)
          return -1;
    int location = 0;
    if(this.isSorted&&this.size>=10){
        int middleRange=this.size/2;
        Node currNode=this.head.getNext();
        Node fastNode=currNode;

        while(middleRange>5){
            fastNode=currNode;
            int fastLocation=location;
            for(int i=0;i<middleRange-1;i++){
                if(fastNode!=null){
                fastNode=fastNode.getNext();
                fastLocation++;}
                if(fastNode!=null&&fastNode.getData().compareTo(element)<0)
                    currNode=fastNode;
                    location=fastLocation;
            }
            middleRange/=2;
        }
        while(currNode!=null){
            if(currNode.getData().equals(element))
                return location;
            currNode=currNode.getNext();
            location++;
        }

            //Add some redundancy so that no element is missed out on.

        
    }//above checks for the sorted range using a binary search, reducing the range it needs to sort by a factor of 1.5 for reduancy each time
    else{
        Node currNode=this.head.getNext();
        while(currNode!=null){
        if(currNode.getData()==element){

            return location;}
        else
            location++;
        currNode=currNode.getNext();
        }

    }
    return -1;
  };

  /**
   * Return true if the list is empty and false otherwise.
   *
   * @return if the list is empty.
   */
  public boolean isEmpty(){
    if (this.size==0)
        return true;
    return false;
  };

  /**
   * size() return the number of elements in the list. Be careful
   * not to confuse this for the length of a list like for an ArrayList.
   * For example, if 4 elements are added to a list, size will return
   * 4, while the last index in the list will be 3. Another example
   * is that an ArrayList like [5, 2, 3, null, null] would have a size
   * of 3 for an ArrayList.
   * ArrayList and LinkedList hint: create a class variable in both ArrayList
   * and LinkedList to keep track of the sizes of the respective lists.
   *
   * @return size of the list.
   */
  public int size(){
    return this.size;
  };

  /**
   * Sort the elements of the list in ascending order using bubble sort.
   * If isSorted is true, do NOT re-sort.
   * Hint: Since T extends Comparable, you will find it useful
   * to use the public int compareTo(T other) method.
   * Updates isSorted accordingly.
   */
  public void sort(){
    if(this.isSorted)
        return;
    if(this.size<=1){
        this.isSorted=true;
        return;
    }
    boolean changeMade=false;
    while(!this.isSorted){
        changeMade=false;
        Node currNode=this.head.getNext();
        while(currNode.getNext()!=null){
            if(currNode.getData().compareTo(currNode.getNext().getData())>0){
                T tempData= (T)currNode.getData();
                currNode.setData(currNode.getNext().getData());
                currNode.getNext().setData(tempData);
                changeMade=true;
            }
            currNode=currNode.getNext();
        }
        if(!changeMade)
            this.isSorted=true;
    }
    
  };

  /**
   * Remove whatever is at index 'index' in the list and return
   * it. If index is out-of-bounds, return null. For the ArrayList,
   * elements to the right of index should be shifted over to maintain
   * contiguous storage. Must check to see if the list is sorted after removal
   * of the element at the given index and updates isSorted accordingly.
   *
   * @param index position to remove from the list.
   * @return the removed element.
   */
  public T remove(int index){
    if(index>=this.size | index<0|size<=0)
        return null;
    T retVal=get(index);
    int location=-1;
    Node currNode=head;
    while (location<index-1){
        currNode=currNode.getNext();
        location++;
    }

    if(currNode.getNext().getNext()!=null){
        currNode.setNext(currNode.getNext().getNext());
    }
    else{
        currNode.setNext(null);
    }
    size--;
    this.isSorted=sortedChecker();
//    if(size<=1){
//        this.isSorted=true;
//        return retVal;
//    }
//    LinkedList sortedList=new LinkedList();
//    if(size>0){
//        Node addNode=this.head.getNext();
//        while(addNode!=null){
//            sortedList.add(addNode.getData());
//            addNode=addNode.getNext();
//        }
//        sortedList.sort();
//        boolean sorted=true;
//        Node startList=head.getNext();
//        Node sortedStart=sortedList.head.getNext();
//        while(startList!=null){
//            if(!startList.getData().equals(sortedStart.getData()))
//                sorted=false;
//            startList=startList.getNext();
//            sortedStart=sortedStart.getNext();
//        }
//        isSorted=sorted;
//    }
    return retVal;

  };

  /**
   * Remove all duplicate elements from the list.
   * The removal must be done in a stable manner,
   * or in other words the first occurrence of an element must keep its relative order
   * to the first occurrences of other elements.
   * Example A,B,A,C,B,A,D -> A,B,C,D
   */
  public void removeDuplicates(){

    if(this.size<=1)
        return;
    LinkedList newList=new LinkedList();
    Node currNode=head.getNext();

    while(currNode!=null){
        if(newList.indexOf((T) currNode.getData())==-1){
            newList.add((T)currNode.getData());
            newList.size++;

        }
        currNode=currNode.getNext();
    }
    this.size=newList.size/2;

    this.head=newList.head;
    this.isSorted=newList.isSorted;


  };

  /**
   * Reverses the list IN PLACE. Any use of intermediate data structures will yield
   * your solution invalid.
   */
  public void reverse(){
    if(this.size<=1)
        return;
    Node currNode=this.head.getNext();
    Node reverseNode = currNode;
    Node newNode= new Node(null);
    while(currNode.getNext()!=null){
        currNode=currNode.getNext();
        newNode=new Node(currNode.getData());
        newNode.setNext(reverseNode);
        reverseNode=newNode;
        
        
    }
    head.setNext(reverseNode);
//reverses

    this.isSorted=sortedChecker();
      //checks if sorted
  };

  /**
   * The current list should be updated to contain all elements that are in
   * the current list or the other list, but NOT in both of the lists. As an
   * example, if list1 contains (A,B,C) and list2 contains (B,C,D), then
   * list1.exclusiveOr(list2) should contain (A,D).
   *
   * If otherList is null, do not make any modifications.
   *
   * The final result should be sorted and all duplicates should be removed.
   * Consider calling sort() and removeDuplicates() on both of the lists
   * before computing the exclusive or.
   * Note, you will have to cast otherList from a List<T> type to a ArrayList<T> type or LinkedList<T>.
   *
   * After checking for possible errors, you're first few lines of code should be:
   * LinkedList<T> other = (LinkedList<T>) otherList; or ArrayList<T> other = (Arraylist<T>) otherList;
   * this.sort();
   * this.removeDuplicates();
   * other.sort();
   * other.removeDuplicates();
   *
   * @param otherList the other list that this operation is being performed on.
   */
  public void exclusiveOr(List<T> otherList){
    LinkedList<T> other = (LinkedList<T>) otherList;
    sort();
    removeDuplicates();
    other.sort();
    other.removeDuplicates();
    LinkedList<T> xorList=new LinkedList<T>();
    if(other.size==0)
        return;
    if(this.size==0)
        {this.head=other.head;
        this.size=other.size;
        return;}
    Node currNode=this.head;
    int newSize=0;
    while(currNode!=null){
        if(otherList.indexOf((T) currNode.getData())==-1)
            {xorList.add((T) currNode.getData());
            newSize++;
            };
        currNode=currNode.getNext();
    }
    currNode=other.head;
    while(currNode!=null){
        if(indexOf((T) currNode.getData())==-1)
            {xorList.add((T) currNode.getData());
                newSize++;
                };
        currNode=currNode.getNext();
    }
    xorList.sort();
    this.head=xorList.head;
    this.size=newSize;
    this.isSorted=true;

  };

  /**
   * Returns the minimum value of the List
   * If the list is empty, return NULL.
   * Note, consider how sorting can affect runtime or optimize this solution
   */
  public T getMin(){

    if(this.size==0)
        return null;

    if(isSorted) {
        return (T) this.head.getNext().getData();
    }

    Node currNode=this.head.getNext();
    T minVal=(T) currNode.getData();
    while(currNode.getNext()!=null){

        currNode=currNode.getNext();
        if(currNode.getData().compareTo(minVal)<0){

            minVal=(T) currNode.getData();}
    }
    return minVal;
  };

  /**
   * Returns the maximum value of the List
   * Note, consider how sorting can affect runtime or optimize this solution
   */
  public T getMax(){
    if(this.size==0)
        return null;
    if(isSorted)
        return get(this.size);
    
    Node currNode=this.head.getNext();
    T maxVal=(T) currNode.getData();
    while(currNode.getNext()!=null){
        currNode=currNode.getNext();
        if(currNode.getData().compareTo(maxVal)>0)
            maxVal=(T) currNode.getData();
    }
    return maxVal;
  };;

  /**
   * Note that this method exists for debugging purposes.
   * It calls the toString method of the underlying elements in
   * the list in order to create a String representation of the list.
   * The format of the toString should appear as follows:
   * Element_1
   * Element_2
   * .
   * .
   * .
   * Element_n
   * Watch out for extra spaces or carriage returns. Each element
   * should be printed on its own line.
   *
   * @return String representation of the list.
   */
  public String toString(){
      if(this.size==0)
          return "";
    Node currNode=this.head.getNext();
    String retString="";
    while(currNode.getNext()!=null){
        retString+=(""+currNode.getData()+"\n");
        currNode=currNode.getNext();
    };
      retString+=(""+currNode.getData()+"\n");
    return retString;
  };

  /**
   * Simply returns the isSorted attribute.
   *
   * @return isSorted boolean attribute.
   */
  public boolean isSorted(){
    return this.isSorted;
  };


}