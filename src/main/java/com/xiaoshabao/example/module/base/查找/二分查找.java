package com.xiaoshabao.example.module.base.查找;

import org.junit.jupiter.api.Test;

public class 二分查找 {
	//toIndex是结束的下标，但是不包括这个下标。
	public int binarySearch0(int[] a, int fromIndex, int toIndex,int key) {
		int low = fromIndex;
		int high = toIndex - 1;
		while (low <= high) {
			int mid = (low + high) >>> 1;//无符号右移,相当于除2
			int midVal = a[mid];
			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}
	
	@Test
	public void test(){
		int[] as={1,2,3,4,5,6,7,8,9};
		this.binarySearch0(as,0, 9, 7);
	}
}
