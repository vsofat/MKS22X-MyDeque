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
        //reaches here if not a number
        String data = split[i];

        // ADDITION
        if (cur.equals("+")) {
          double first = nums.getLast();
          nums.removeLast(); // remove the number you just got

          double second = nums.getLast();
          nums.removeLast(); // remove the number you just got
          nums.addLast(first+second); // sum in your nums
        }

        //SUBTRACTION
        else if (cur.equals("-")) {
            double second = nums.getLast();
            nums.removeLast(); // remove the number you just got

            double first = nums.getLast();
            nums.removeLast(); // remove the number you just got

            nums.addLast(second-first); // differnece added to your nums
          }

        else if (cur.equals("*")) {
              double n1 = nums.getLast();
              //need to remove right away so getLast() works next
              nums.removeLast();

              double n2 = nums.getLast();
              nums.removeLast();
              //add the sum to nums
              nums.addLast(n1*n2);
                  }
      }
    }
  }
