public class ArrayList<T extends Comparable<T>> implements List<T> {
  private T[] a;
  private boolean isSorted;
  private int size;
  public ArrayList(){
    a = (T[]) new Comparable[2];
    isSorted=true;
    size=0;
  }

  public static void main(String args[]){
    ArrayList testList= new ArrayList();
    testList.add(1);
    testList.add(0,1);
    testList.add(3);
    testList.add(2,2);
    testList.add(3,3);
    testList.add(2,5);
    ArrayList testList2= new ArrayList();
    testList2.add(5);
    testList2.add(1);
    testList2.add(3);
    testList.isSorted= testList.sortedChecker();
    System.out.println(testList.isSorted());
    System.out.println(testList.toString());
  }

  public boolean sortedChecker(){
    boolean sorted=true;
    for(int i=0;i<this.size-1;i++){
      if(a[i].compareTo(a[i+1])>0)
        sorted=false;
    }
    return sorted;
  }

    /**
   * Add an element to end of the list. If element is null,
   * it will NOT add it and return false.  Otherwise, it
   * will add it and return true. Updates isSorted to false if
   * the element added breaks sorted order.
   *
   * @param element element to be added to the list.
   * @return if the addition was successful.
   */
  public boolean add(T element){
    if(element==null){
      return false;
    }
    int newSize=size;
    if(size==a.length){
      newSize*=2;
      T[] newA = (T[]) new Comparable[newSize];
      for(int i=0;i<size;i++){
        newA[i]=a[i];
      }
      newA[size]=element;
      a=newA;
      this.size++;
    }
    else{
      a[size]=element;
      this.size++;
    }
    if(this.size<=1){
      this.isSorted=true;
    }
    else if(a[size-1].compareTo(a[size-2])<0)
      this.isSorted=false;
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
    if(element==null | index<0 | index>=this.size){
      return false;
    }
//    int newSize=this.size;
//    if(size+1>=a.length) {
//      newSize *= 2;
//    }
//    T[] newA = (T[]) new Comparable[newSize];
//    int elementAdded=0;
//    for(int i=0;i<index;i++) {
//      newA[i]=a[i];
//    }
//    newA[index]=element;
//    for(int i=index;i<this.size;i++){
//      newA[i+1]=a[i];
//    }
//    a=newA;
//    this.size++;
//
//
//    if(a[index].compareTo(a[index-1])<0)
//      this.isSorted=false;
//    if(index<size-1 && a[index].compareTo(a[index+1])>1)
//      this.isSorted=false;
//    return true;
    ArrayList newList = new ArrayList();
    for(int x=0;x<size;x++){
      if(x==index){
        newList.add(element);
      }
      newList.add(a[x]);
    }
    this.a= (T[]) newList.a;
    this.size=newList.size;
    this.isSorted=sortedChecker();
    //adds element to index

//    if(this.isSorted()&&this.size>1){
//      if(index>0&&this.a[index].compareTo(this.a[index-1])<0)
//        this.isSorted=false;
//      if(index<size-1&&this.a[index].compareTo(this.a[index+1])>0)
//        this.isSorted=false;
//    }

    return true;

  };

  /**
   * Remove all elements from the list and updates isSorted accordingly.
   */
  public void clear(){
    for(int i=0;i<a.length;i++){
      a[i]=null;
    }
    this.size=0;
  };

  /**
   * Return the element at given index. If index is
   * out-of-bounds, it will return null.
   *
   * @param index index to obtain from the list.
   * @return the element at the given index.
   */
  public T get(int index){
    if(index<0 | index>=a.length)
      return null;
    return a[index];
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
    if(element==null){
      return -1;
    }
    for(int i=0;i<a.length;i++){
      if(a[i]==element)
        return i;
    }
    return -1;
  };

  /**
   * Return true if the list is empty and false otherwise.
   *
   * @return if the list is empty.
   */
  public boolean isEmpty(){
    return this.size==0;
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
    if(isSorted)
      return;
    boolean changeMade=false;
    while(!isSorted){
      changeMade=false;
      for(int i=0;i<this.size-1;i++){
        if(a[i].compareTo(a[i+1])>0){
          T temp=a[i];
          a[i]=a[i+1];
          a[i+1]=temp;
          changeMade=true;
        }

      }
      if(!changeMade)
        isSorted=true;
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
    if(index<0 | index>=size)
      return null;
    T retVal = a[index];
    for(int i=index;i<this.size-1;i++){
      a[i]=a[i+1];
    }
    ArrayList sortedArray=new ArrayList();
    sortedArray.a=this.a.clone();
    sortedArray.size=this.size;
    sortedArray.sort();
    if(this.a.equals(sortedArray.a)){
      this.isSorted=true;
    }
    else{
      this.isSorted=false;
    }
    this.size--;
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
    ArrayList uniqueArrayList=new ArrayList();
    for (T element:a){
      if(uniqueArrayList.indexOf(element)==-1)
        uniqueArrayList.add(element);
    }
    this.size=uniqueArrayList.size;
    this.a=(T[]) uniqueArrayList.a;
  };

  /**
   * Reverses the list IN PLACE. Any use of intermediate data structures will yield
   * your solution invalid.
   */
  public void reverse(){
    for(int i=0;i<Math.ceil(this.size/2);i++){
      T temp1=a[i];
      T temp2=a[size-1-i];
      a[i]=temp2;
      a[size-1-i]=temp1;
    }
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
//    System.out.println(toString());
//    System.out.println(otherList.toString());
    ArrayList<T> other = (ArrayList<T>) otherList;
    this.sort();
    this.removeDuplicates();
    other.sort();
    other.removeDuplicates();
    if(this.size==0){
      this.a=other.a;
      this.size=other.size;
      return;}
    if(other.size==0)
      return;
    T[] newA = (T[]) new Comparable[this.a.length+other.a.length];
    int newAsize=0;
    for(T element:this.a){
      if(other.indexOf(element)==-1&&element!=null){
        newA[newAsize]=element;
        newAsize++;
      }
    }
    for(T element:other.a){
      if(this.indexOf(element)==-1&&element!=null){
        newA[newAsize]=element;
        newAsize++;
      }
    }
    this.a=newA;
    this.size=newAsize;
    this.isSorted=false;
    sort();

    
  };

  /**
   * Returns the minimum value of the List
   * If the list is empty, return NULL.
   * Note, consider how sorting can affect runtime or optimize this solution
   */
  public T getMin(){
    if(this.size==0)
      return null;
    if(this.isSorted)
      return a[0];
    T minimum=a[0];
    for(int i=0;i<this.size;i++){
      if(a[i].compareTo(minimum)<0)
        minimum=a[i];
    }
    return minimum;
  };

  /**
   * Returns the maximum value of the List
   * Note, consider how sorting can affect runtime or optimize this solution
   */
  public T getMax(){
    if(this.size==0)
      return null;
    if(this.isSorted)
      return a[size-1];
    T maximum=a[0];
    for(int i=0;i<this.size;i++){
      if(a[i].compareTo(maximum)>0)
        maximum=a[i];
    }
    return maximum;
  };

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
    String retString="";
    for(int i=0;i<this.size;i++){
      retString+=(""+a[i]+"\n");
    }
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