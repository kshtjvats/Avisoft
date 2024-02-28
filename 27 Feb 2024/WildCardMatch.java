 import java.util.Arrays;
 import java.util.Scanner;
 
 class WildcardMatching {
     public static void main(String[] args){
         Scanner scanner = new Scanner(System.in);
         
         // Prompt user to enter the string and pattern
         System.out.println("Enter String :");
         String str = scanner.next();
         System.out.println("Enter pattern :");
         String pattern = scanner.next();
         
         // Check if the string matches the pattern
         if(isMatch(str, pattern))
             System.out.println(1);
         else
             System.out.println(0);
 
     }
     public static boolean isMatch(String text, String pattern) {
         // Create a 2D array to store intermediate results
         int dp[][] = new int[text.length()][pattern.length()];
         // Initialize the array with -1
         for(int[] arr : dp)
             Arrays.fill(arr, -1);
         // Call the helper method to perform wildcard matching
         return wildcardMatch(text, pattern, text.length()-1, pattern.length()-1, dp);
     }
     private static boolean wildcardMatch(String text, String pattern, int textIndex, int patternIndex, int[][] dp){
         // Base case: both text and pattern are exhausted
         if(textIndex < 0 && patternIndex < 0)
             return true;
         // Base case: pattern is exhausted but text is not
         if(textIndex >= 0 && patternIndex < 0)
             return false;
         // Base case: text is exhausted but pattern is not
         if(textIndex < 0 && patternIndex >=0){
             // If remaining pattern characters are all '*'
             for(int k = 0; k <= patternIndex; ++k){
                 if(pattern.charAt(k)!= '*')
                     return false;
             }
             return true;
         }
 
         // Check if the result is already computed
         if(dp[textIndex][patternIndex] != -1)
             return dp[textIndex][patternIndex] == 1;
 
         // Check if characters match or pattern has '?'
         boolean result = false;
         if(text.charAt(textIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '?')
             result = wildcardMatch(text, pattern, textIndex-1, patternIndex-1, dp);
         // Check if pattern has '*'
         if(pattern.charAt(patternIndex) == '*')
             result = wildcardMatch(text, pattern, textIndex-1, patternIndex, dp) || wildcardMatch(text, pattern, textIndex, patternIndex-1, dp);
 
         // Store the result in the dp array
         dp[textIndex][patternIndex] = result ? 1 : 0;
         return result;
     }
 }
 