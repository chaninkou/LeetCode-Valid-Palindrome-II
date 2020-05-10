package leetcode680;

public class CheckValidPalindromeFunction {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }
        
        if(isValid(s, left + 1, right) || isValid(s, left, right - 1)){
            return true;
        }

        return false;
    }
    
    private boolean isValid(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            } else {
                left++;
                right--;
            }
        }
        
        return true;
    }
}
