package com.xiaoshabao.example.module.base;

import java.util.HashMap;

public class EqualsAndHashCodeSimple {
	/**
	 * 娴嬭瘯绫�
	 */
	class People {
		private String name;
		private int age;

		public People() {
		}

		public People(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		/**
		 * 鍚屼竴涓被鐨刪ashCode鍚楃浉鍚�鐩哥瓑绫荤殑hashCode鐩哥瓑
		 */
		@Override
		public int hashCode() {
			return name.hashCode() * 37 + age;
		}

		/*
		 * 閲嶅啓equals蹇呴』娉ㄦ剰锛�1銆�鑷弽鎬э細瀵逛簬浠绘剰鐨勫紩鐢ㄥ�x锛寈.equals(x)涓�畾涓簍rue銆�br/> 
		 * 2銆佸绉版�锛氬浜庝换鎰忕殑寮曠敤鍊紉 鍜寉锛屽綋x.equals(y)杩斿洖true锛寉.equals(x)涔熶竴瀹氳繑鍥瀟rue銆�br/>
		 * 3銆佷紶閫掓�锛氬浜庝换鎰忕殑寮曠敤鍊紉銆亂鍜岋綒锛屽鏋渪.equals(y)杩斿洖true锛屽苟涓攜.equals(z)涔熻繑鍥瀟rue锛岄偅涔坸.equals(z)涔熶竴瀹氳繑 鍥�true銆�br/>
		 * 4銆佷竴鑷存�锛氬浜庝换鎰忕殑寮曠敤鍊紉 鍜�y锛屽鏋滅敤浜巈quals姣旇緝鐨勫璞′俊鎭病鏈夎淇敼锛屽娆¤皟鐢▁.equals(y)瑕佷箞涓�嚧鍦拌繑鍥瀟rue锛岃涔堜竴鑷村湴杩斿洖false銆�br/> 
		 * 5銆侀潪绌烘�锛氬浜庝换鎰忕殑闈炵┖寮曠敤鍊紉锛寈.equals(null)涓�畾杩斿洖false銆�br/>
		 * 璇锋敞鎰忥細<br/>
		 * 閲嶅啓equals鏂规硶鍚庢渶濂介噸鍐檋ashCode鏂规硶锛屽惁鍒欎袱涓瓑浠峰璞″彲鑳藉緱鍒颁笉鍚岀殑hashCode,杩欏湪闆嗗悎妗嗘灦涓娇鐢ㄥ彲鑳戒骇鐢熶弗閲嶅悗鏋�
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {// 鑷弽
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (this.getClass() != obj.getClass()) {
				return false;
			}
			return this.name.equals(((People) obj).name)
					&& this.age == ((People) obj).age;
		}
	}

	public static void main(String[] args) {
		EqualsAndHashCodeSimple bean = new EqualsAndHashCodeSimple();
		EqualsAndHashCodeSimple.People p1 = bean.new People("Jack", 12);
		System.out.println(p1.hashCode());
		HashMap<People, Integer> hashMap = new HashMap<People, Integer>();
		hashMap.put(p1, 1);

		// 濡傛灉娌℃湁hashCode鏂规硶锛岃繖涓繑鍥炰负绌猴紝鎵句笉鍒般�鍥犱负瑕佹牴鎹甴ashCode纭畾key鍊�
		System.out.println(hashMap.get(bean.new People("Jack", 12)));
	}
}
