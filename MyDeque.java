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
    string result = "{";
    if (this.size()== 0){
      return "{}";
    }
    int index = this.start;
    while(index != end){
      result += data[index] + " ";
      index++;
    }
    resuult += data[end]+ "}";
    return result;
    }

  public void resize(){

  }
  
  public void addFirst(E element){ }

public void addLast(E element){ }

public E removeFirst(){ }

public E removeLast(){ }

public E getFirst(){ }

public E getLast(){ }
}
