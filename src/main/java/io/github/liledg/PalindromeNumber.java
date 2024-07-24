package io.github.liledg;

public class PalindromeNumber {

  public static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    final String integer = Integer.toString(x);

    for (int i = 0; i < integer.length() / 2; i++) {
      if (integer.charAt(i) != integer.charAt(integer.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPalindromeSolutionTwo(int x) {
    if(x == 0) return true;

    if(x < 0 || x % 10 == 0) return false;

    int reverse = 0;
    while(x > reverse){
      int pop = x%10;
      x /= 10;

      reverse = (reverse * 10) + pop;
    }
    if(x == reverse || x == reverse / 10){
      return true;
    }else{
      return false;
    }
  }

  public static void main(String[] args) {
    System.out.println(1345112%10);
    System.out.println(isPalindrome(12121));
  }

}
