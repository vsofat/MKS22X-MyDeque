public class Calculator{

  public static double eval(String s){
    //first, split the string into smaller strings
    String[] split = s.split(" ");
    MyDeque<Double> nums = new MyDeque<Double>();

    double num = 0;
    int i=0;

    while (i < split.length) {

      //System.out.println(nums);
      try {
        num = Double.parseDouble(split[i]);
        nums.addLast(num);
      }catch (NumberFormatException e) {
        //reaches here if not a number.
        String data = split[i];
        if (cur.equals("+")) {
          double first = nums.getLast();
          //need to remove right away so getLast() works next.
          nums.removeLast();

          double second = nums.getLast();
          nums.removeLast();
          //add the sum to nums
          nums.addLast(first+second);
        }
      }
    }
  }
