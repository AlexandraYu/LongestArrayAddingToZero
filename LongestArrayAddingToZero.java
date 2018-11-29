public class LongestArrayAddingToZero{
    public static int[] longestZeroArray(int[] array) {
        //we start by fixing "left end" on 1st element, then 2nd, 3rd...
        //then we move the "right end" from 1st, adding the content of the each element up to the last...
        int i=0, j=0, max_j=0, max_i=0, sum=0, len=0, max_length=0;
        boolean longest_array = false; 
        for(i=0; i<array.length; i++){
            sum=0; 
            if (longest_array == true) {
                break; 
            }
            for(j=i; j<array.length; j++) {
                System.out.print("array.length is " +array.length+"\n");
                sum=sum+array[j]; 
                System.out.print("sum is " +sum+"\n");
                //so if we find the sum is zero, we check the distance between j and i,if it's larger than the max_length, we store the "largest j" that results in summing up the elements to 0
                if(sum==0) {
                    len = j-i+1;
                    System.out.print("length is: "+len+"\n");
                    //a special case is if the whole array adds up to zero, then we know it's the longest, no need to check
                    if (len==array.length) {
                        System.out.print("here? \n");
                        max_j = array.length-1; 
                        max_i = 0; 
                        longest_array = true; 
                        if (len > max_length) max_length = len; 
                        break; 
                    }
                    else {
                        if (len > max_length) {
                            max_j = j; 
                            max_i = i; 
                            max_length = len; 
                            System.out.print("max_length is: "+max_length+"\n");
                            System.out.print("max_j is: "+max_j+"\n");
                        }
                    }
                }
            }
        }
        //there's possibility that no result if found, meaning max_length =0
        System.out.print("max_length: "+max_length+"\n");
        System.out.print("again max_j is: "+max_j+"\n");
        if(max_length==0) {
            System.out.print("Nothing found! \n"); 
            return null;
        }
        else return composeNewArray(array, max_i, max_j); 
        //return array
    }
    private static int[] composeNewArray(int[] a, int left, int right) {
        System.out.print("right is: "+right+"\n");
        System.out.print("left is: "+left+"\n");
        int[] myArray = new int[right-left+1]; 
        for (int i=0; i<myArray.length; i++) {
            myArray[i]=a[i]; 
        }
        return myArray; 
    }

    public static void main(String []args){
    //    int[] a = new int[] {0, 2, -1, 3};
    //    int[] a = new int[] {0};
    //    int[] a = new int[] {2, -1, 3};
    //    int[] a = new int[] {0, 2, -1};
    //    int[] a = new int[] {-1, 3};
        int[] a = new int[] {0, 2, -2};
        int[] resultArray = longestZeroArray(a);
        if (resultArray!=null) {
            for (int i=0; i<resultArray.length; i++) {
                System.out.print(resultArray[i]+"\n");
            }
        }
    }
}
