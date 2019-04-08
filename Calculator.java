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
        String DATA = split[i];

        // ADDITION
        if (DATA.equals("+")) {
          double first = nums.getLast();
          nums.removeLast(); // remove the number you just got

          double second = nums.getLast();
          nums.removeLast(); // remove the number you just got
          nums.addLast(first+second); // sum in your nums
        }

        //SUBTRACTION
        else if (DATA.equals("-")) {
            double second = nums.getLast();
            nums.removeLast(); // remove the number you just got

            double first = nums.getLast();
            nums.removeLast(); // remove the number you just got

            nums.addLast(second-first); // differnece added to your nums
          }

        // MULTIPLICATION
        else if (DATA.equals("*")) {
              double first = nums.getLast();
              nums.removeLast(); // remove the number you just got

              double second = nums.getLast();
              nums.removeLast(); // remove the number you just got

              nums.addLast(first*second); // product added
        }

        // DIVISION
        else if (DATA.equals("/")) {
              double n2 = nums.getLast();
              //need to remove right away so getLast() works next.
              nums.removeLast();

              double n1 = nums.getLast();
              nums.removeLast();
              //add the sum to nums
              nums.addLast(n1/ n2);
            }

      }
    }
  }
