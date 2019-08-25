import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		int[] a = {9,9,9};
		System.out.println(Arrays.toString(plusOne(a)));
	}

    public static int[] plusOne(int[] digits) {
        int[] b = digits.clone();
        for(int i=digits.length-1; i>=0; i--){
           b[i] = digits[i]+1;
            if(b[i] == 10) {
                b[i] = 0;
                continue;
            }
            else break;
        }
        return b;
    }
}