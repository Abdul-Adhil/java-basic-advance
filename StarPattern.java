/*

Print the following Pattern

Input: 5

    *
   ***
  *****
 *******
*********

*/

class StarPattern {
    public static void main (String[] args) {
        /* code */
        
        int input = 5;
        
        for(int i=0; i<input; i++){
            
            
            for(int j=i; j<input; j++){
                System.out.print(" ");
            }
        
            for(int k=0; k<=i*2; k++){
              System.out.print("*");
            }
            
           System.out.println(); 
        }
    }
}