package leetcode680;

public class CheckValidPalindromeFunction {
	public boolean validPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		// check until left and right pointer not the same
		while (left < right && s.charAt(left) == s.charAt(right)) {
			left++;
			right--;
		}

		// left + 1 or right - 1 will count as delete once
		if (isValidAfterDeleteOnce(s, left + 1, right) || isValidAfterDeleteOnce(s, left, right - 1)) {
			return true;
		}

		return false;
	}

	private boolean isValidAfterDeleteOnce(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			} else {
				left++;
				right--;
			}
		}

		return true;
	}

	// second way to do it
	public boolean validPalindrome2(String s) {
		return valid(s, 0, s.length() - 1, 0);
	}

	private boolean valid(String s, int left, int right, int deleteOnce) {

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				deleteOnce++;
				if (deleteOnce > 1) {
					return false;
				}
				
				// left + 1 or right - 1 count as delete
				return valid(s, left + 1, right, deleteOnce) || valid(s, left, right - 1, deleteOnce);
			} else {
				left++;
				right--;
			}
		}

		return true;
	}
}
