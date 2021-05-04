import java.io.*;
import java.math.*;

public class theMain {
    private int sizeArray = 0;
    private int theArray[];
    private int index = -1;
    private int tempArray[];

    File fileoutput;

    public theMain(String theOuputfile) {
        fileoutput = new File(theOuputfile);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileoutput));
            // close the reader
            writer.close();
        } catch (Exception ex) {
            System.out.println("Error Could not write to file");
            System.exit(1);
        }
    }

    public void writeFIle(String input) {
        // writing to file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileoutput, true));
            writer.write(input);
            writer.write("\n");
            writer.close();
        } catch (Exception ex) {
            System.out.println("Error Could not write to file");
        }
    }

    public void writeFIle(int input) {
        // writing to file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileoutput, true));
            writer.write(String.valueOf(input));
            writer.write("\n");
            writer.close();
        } catch (Exception ex) {
            System.out.println("Error Could not write to file");
            return;
        }
    }

    public void pop() {
        int topEle = topElement();
        if (topEle < 0) {
            writeFIle("Error");
            System.exit(1);
            return;
        }
        if (topEle == 666) {
            System.out.println("666 once");
            shrinkStack(1);

            writeFIle("666");

            
            if ((index) >= 0 /* && (topEle = topElement()) == 666*/) {
                /**
                 * after recieving grade, changed the if statement
                 */
                shrinkStack(1);
                System.out.println("666 twice");

            }
            displayArray();
            return;

        }
        // push(7);
        topEle = topElement();
        if (topEle == 7) {
            System.out.println("7 once");
            writeFIle("7");
        } else if (topEle == 42) {
            System.out.println("42 once");
            writeFIle("42");
            for (; sizeArray != 0;) {
                shrinkStack(1);
            }
        } else {
            int anothertemp = theArray[index];
            shrinkStack(1);
            writeFIle(anothertemp);

        }
        displayArray();
    }

    private int topElement() {
        if (index < 0) {
            return index;
        }
        return theArray[index];
    }

    public void top() {
        int topEle = topElement();
        if (topEle < 0) {
            writeFIle("null");
            return;
        }

        if (topEle == 666) {
            writeFIle("999");
        } else if (topEle == 7) {
            shrinkStack(1);
        } else if (topEle == 319) {
            // push(319);
            // topEle = topElement();
            System.out.println("working");

            if (topEle == 319) {
                writeFIle("666");
            }
        } 
        /**
         * addition after recieving grade
         */
        else {
            writeFIle(topEle);
        }
        displayArray();
    }

    private void shrinkStack(int loopTime) {
        copyIntoTemp();

        // shrink og array
        index--;
        sizeArray--;
        theArray = new int[sizeArray];

        copyIntoOG();
    }

    public void push(int value) 
    {
        if (index < 0 && value != 666) {
            sizeArray = sizeArray + 1;

            theArray = new int[sizeArray];
            index++;
           // System.out.println("index is " + index);
           if (value == 3) {
               theArray[index] = 7;

           } else {
               theArray[index] = value;
           }
        } else if(index <0 && value == 666){
            sizeArray = sizeArray + 1;
            theArray = new int[sizeArray];
            index++;
            theArray[index] = value;
            growStack(2, value);
        }else if (value == 0) {
            System.out.println("in else if for 0");
        } else if (value == 666) {
            System.out.println("in else if for 666");
            growStack(3, value);

        } else if (value == 3) {
            growStack(1, 7);
        } else if (value == 13) {
            for (; sizeArray != 0;) {
                int anothertemp = theArray[index];
                shrinkStack(1);
                writeFIle(anothertemp);
            }
            //writeFIle(value);
            growStack(1, value);
        } else {
            growStack(1, value);
        }
        displayArray();
    }

    private void growStack(int loopTime, int theValue) {
        for (int k = 1; k <= loopTime; k++) {

            // copy og array into temp
            copyIntoTemp();
            // grow the og array
            index++;
            sizeArray = sizeArray + 1;
            theArray = new int[sizeArray];
            // copy the temp into og array
            copyIntoOG();

            // now we push the new value inside

            theArray[index] = theValue;
        }
    }

    private void copyIntoTemp() {
        tempArray = new int[sizeArray];
        for (int i = 0; i < theArray.length; i++) {
            this.tempArray[i] = this.theArray[i];
        }
    }

    private void copyIntoOG() {
        int useLength = tempArray.length;
        if (theArray.length < tempArray.length) {
            useLength = theArray.length;
        }
        for (int i = 0; i < useLength; i++) {
            theArray[i] = tempArray[i];
        }
    }

    private void displayArray() {
        // System.out.println("It goes top to down ");
        System.out.println();

        for (int i = index; i >= 0; i--) {
            System.out.print("[");
            System.out.print(theArray[i]);
            System.out.println("]");

        }
        if (index < 0) {
            System.out.println("the indexx is now" + index);
        }
        System.out.println();
    }

public static void main(String[] args) {
    if (args.length != 2) {
        System.out.println("There needs to be 2 command line arguments for this program to work");
        System.exit(1);
    }
    File file = new File(args[0]);
    theMain test = new theMain(args[1]);
    char[] eachline;
    int i = 0;
    int countNum = 0;
    int[] numArray;
    int p = 0;
    int h = 0;
    int sum = 0;
    int z = 0;
    boolean matching = false;
    boolean skip = false;

    try 
    {
     // create a reader instance
     BufferedReader br = new BufferedReader(new FileReader(file));

     // read until end of file
     String line;
     while ((line = br.readLine()) != null) {
         System.out.println(line);
         eachline = new char[line.length()];

         //copies each char into an array
         for (i = 0; i < line.length(); i++) {
             eachline[i] = line.charAt(i);
         }
         //converts the string to lowercase
         String templine = line.toLowerCase();

         if(eachline[0] == ' '){
            test.writeFIle("Input error.");
             System.out.println("space in front");
         }
    else if ((matching = templine.contains("push()"))){
            test.writeFIle("Input error.");
    }
         //checks if the string contains push(
   else if ((matching = templine.contains("push("))) 
    {
              //trying to find the bracket (
        for (p = 0; p < line.length(); p++) 
        {

            //wwhen we find the first bracket
          if (eachline[p] == '(') {
             countNum = 0;
             while (eachline[p + countNum + 1] != ')') 
             {
               skip = checkIfNum(eachline[p + countNum + 1]);
                // if it not a letter then we are going to have a input error
                if (skip == false) {
                  test.writeFIle("Input error.");
                  /**
                   * after receiving grades
                   */
                  System.exit(1);
                  break;
                }
              countNum++;
             }
             if (eachline[(eachline.length)-1] != ')' ){
                test.writeFIle("Input error.");
                
                 System.out.println("extra letter.");
                 skip = false;
             }

            // if the chars were letters then we can start converting them into ints
           if (skip== true) 
           {
              numArray = new int[countNum];
              for (h = 0; h < countNum; h++) {
                // try {
                    numArray[h] = Integer.parseInt(String.valueOf(eachline[h + p + 1]));
                  //} catch (Exception ne) {
                    //if (eachline[h + p + 1] == '-') {
                    //test.writeFIle("Input error");
                    // System.exit(1);
                   // }
                  //}
               }
              sum = 0;
              for (z = numArray.length - 1; z >= 0; z--) {
              int temp = countNum - 1;
              sum += Math.pow(10, (temp - z)) * numArray[z];
              }
           // }
         //        }
       // }
             // System.out.println(sum);
             if (sum < 0) {
                 test.writeFIle("Input error.");
                 // System.exit(1);
             } else {
                 test.push(sum);
             }
            }
        }
      }
    } 
    else if ((matching = templine.contains("pop()"))) 
    {
             // System.out.println("hi");
             for (p = 0; p < line.length(); p++) {
             }
             // System.out.println(sum);
             test.pop();
         } else if ((matching = templine.contains("top()"))) {
             // System.out.println("hello");
             for (p = 0; p < line.length(); p++) {
             }
             // System.out.println(sum);
             test.top();
         } else {
             test.writeFIle("Input error.");
             // System.exit(1);
         }

     }

           // close the reader
  br.close();
  } 
  catch (Exception ex) {
           System.out.println("Invalid input file");
           ex.printStackTrace();
  }
}

   // this is say if a character is not a letter than return false, else return
   // false
   private static boolean checkIfNum(char check) {
        if(check > '9' || check < '0'){
             System.out.print("omg it does");
             return false;
         }
         return true;
    }
}