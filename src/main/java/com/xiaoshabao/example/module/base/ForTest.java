package com.xiaoshabao.example.module.base;
/**
 * 循环的使用，锚的使用
 */
public class ForTest {

	public void mao() {
		ma: for (int i = 1; i < 8; i++) {
			System.out.println("i:" + i);
			mb: for (int j = 9; j < 12; j++) {
				System.out.println("j:" + j);
				
				if (j == 10) {
					System.out.println("跳出本次循环:" + j);
					continue;
				}
				if (i == 4) {
					System.out.println("跳出j循环:" + j);
					break mb;
				}

				if (i == 6) {
					System.out.println("跳出i循环:" + j);
					break ma;
				}
				System.out.println("操作j循环:" + j);
			}
			System.out.println("操作i循环:" + i);
		}
	System.out.println("所有操作完成");
	}

	public static void main(String[] args) {
		ForTest b = new ForTest();
		b.mao();
	}

}
