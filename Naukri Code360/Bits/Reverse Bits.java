
public class Solution {
	public static long reverseBits(long n) {
		// Write your code here
		long rev=0;
		for (int i=0; i<32; i++) {
			if ((n&(1L<<i))!=0) {
				rev|=(1L<<(32L-i-1L));
			}
		}

		return rev;
	}
}
