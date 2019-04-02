import java.io.*;
import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;


  /*

  Note Exceptions:
  remove/get  (both first and last) will throw:
  NoSuchElementException - if this deque is empty
  Add(both first and last) will throw:
  NullPointerException - if the specified element is null (this deque does not permit null elements)
  To create a generic array you need to create an array of Object, and then cast it to E. This causes a warning, and you can use the SuppressWarnings command to prevent it. This is an appropriate use of the command because we need to instantiate an array of objects and cast it. You would not use this in most other cases.

  Suppress the warning in the constructor:

  @SuppressWarnings("unchecked")
  public MyDeque(){
  data = (E[])new Object[10];
  }

  OR suppress the warning on the creation of the array, but you cannot directly assign to the instance variable if you do this. (This would prevent the accidental suppresion of additional warnings)

  public MyDeque(){
  @SuppressWarnings("unchecked")
  E[] d = (E[])new Object[10];
  data = d;
  }

  */

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[]) new Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String result = "{";
    if (this.size()== 0){
      return "{}";
    }
    int index = this.start;
    while(index != end){
      result += data[index] + " ";
      index++;

      if (index == data.length){
        index = 0;
      }

    }
    result += data[end]+ "}";
    return result;
    }

  @SuppressWarnings("unchecked")
  public void resize(){
    E[] resize = (E[]) new Object[data.length*2 + 1];

    int index = end;
    int resizedIndex = resize.length - 1;

    while (index != start){
      resize[resizedIndex] = data[index];
      resizedIndex --;
      index --;

      if (index == -1){
        index = data.length-1;
      }
    }

    resize[resizedIndex] = data[index];

    end = resize.length-1;
    start = resizedIndex;
    data = resize;

  }

  public void addFirst(E element){

      if (element == null){
        throw new NullPointerException("ELEMENT THAT IS TRYING TO BE ADDED IS NULL. NULL ELEMENTS CAN'T BE ADDED.");
      }

      if (size == 0) {
        data[data.length-1] = element;
        size ++;
        start = data.length-1;
        end = data.length-1;

      }

      else if (size() == data.length) {
        // data is full
        resize();
        start --;
        data[start] = element;
        size++;
      }

      else if (start > 0) {
        // data is not starting from the first spot available
        // push everything up  until all spots are full
        data[start-1] = element;
        size++;
        start--;
      }

      else if (start == 0) {
        // you start in the very beginning
        data[data.length-1] = element;
        start = data.length-1;
        // move it to the very end of the data and move the other way around (uses case above)
        size++;
      }
    }

public void addLast(E element){

  if (element == null){
    throw new NullPointerException("ELEMENT THAT IS TRYING TO BE ADDED IS NULL. NULL ELEMENTS CAN'T BE ADDED.");
  }

  if (size() == 0) {
    // adds the element to the end
    data[data.length-1] = element;
    // starts and end are the same as data has size of 1
    start = data.length-1;
    end = data.length-1;
    size++;

  }

  //if array is full, resize and add new element to first index.
  else if (size() == data.length) {
    // data is full
    resize();
    // added space
    data[0] = element;
    // used added space to move element to the very front
    end = 0;
    size++;
  }
  //if end is not at the last index of data (you can add to end+1)
  else if (end != data.length-1) {
    data[end+1] = element;
    end++;
    size++;
  }
  //else: if end is at last index but there is space in front.
  else {
    data[0] = element;
    end = 0;
    size++;
  }
}

public E removeFirst(){
   if (size() == 0){
     throw new NoSuchElementException("ELEMENT THAT IS TRYING TO BE ADDED IS NULL. NULL ELEMENTS CAN'T BE ADDED.");
   }
   E holder = data[start];
   data[start] = null;
   if (start == data.length-1){
     start = 0;
   }
   else start++;
   size--;
   return holder;
 }

public E removeLast(){
   if (size() ==0) throw new NoSuchElementException("ELEMENT THAT IS TRYING TO BE ADDED IS NULL. NULL ELEMENTS CAN'T BE ADDED.");
   E holder = data[end];
   data[end] = null;
   if (end == 0){
    end = data.length-1;
  }
   else end --;
   size--;
   return holder;
 }


public E getFirst(){ }

public E getLast(){ }
}
