package com.xiaoshabao.example.module.base.排序;

import org.junit.Test;
/**
 * 插入排序
 *<p>从第二个元素开始，将该元素与前边的元素比较，
 *如果前边的元素大于当前预算，把前边的元素后移</p>
 */
public class Insertsort {
	int[] a={ 89,87, 67, 69,100, 75,  99, 90};
	@Test
	public void insertsort() {
		int i, j;
		// 做外层循环，跳过第一个
		for (i = 1; i < a.length; i++)
			// 判断如果是否满足插入排序条件
			if (a[i] < a[i - 1]) {
				int temp = a[i];
				//比对，后移
				for (j = i - 1; j >= 0 && a[j] > temp; j--)
					a[j + 1] = a[j];
				a[j + 1] = temp;
			}
		for (i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
	
	@Test
	public void test(){
		int i,j;
		for(i=1;i<a.length;i++){ 
			if(a[i]<a[i-1]){
				int temp=a[i];
				for(j=i-1;j>=0 && a[j]>temp;j--){
					a[j+1]=a[j];
				}
				a[j+1]=temp;
			}
		}
		for (i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}
