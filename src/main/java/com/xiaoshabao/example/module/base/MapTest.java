package com.xiaoshabao.example.module.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * map基础知识测试
 */
public class MapTest {
	private static Map<String, String> hm = new HashMap<String, String>();
	static {
		hm.put("111", "222");
	}
	

	/**
	 * 获得一个不存在的变量时，返回null
	 */
	@Test
	public void test() {
		Map<String, String> params = new HashMap<String, String>();
		String name = params.get("name");
		System.out.println(name == null ? "是空值" : name);// 结果 是空值(null)
	}
	
	
	/**
	 * idea推荐方式
	 */
	@Test
  public void testidea() {
    Map<String, Object> params = new HashMap<>();
    
    for (Map.Entry<String, Object> entry : params.entrySet()) {
      System.out.println(entry.getKey());
      System.out.println(entry.getValue());
    }
  }

	/**
	 * 1.8遍历方式
	 */
	@Test
	public void traverseMap8() {
		hm.forEach((k,v)->{
			// 输出内容
			System.out.println(k + "\t" + v);
		});
	}
	
	/**
	 * 遍历一个map有很多种方式,但是以以下方式性能最优。
	 * <p>
	 * 方法不支持1.5以下JDK。 如果只是遍历key值使用下边第二个方法traverseMapKey()
	 * 
	 * entrySet方式优于keySet方式
	 * </p>
	 * 
	 */
	@Test
	public void traverseMap() {
//		Set<Map.Entry<String, String>> entrySet = hm.entrySet();
		Iterator<Map.Entry<String, String>> iter = hm.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			// 输出内容
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}

	/**
	 * 只是遍历map的key值
	 */
	@Test
	public void traverseMapKey() {
		Set<String> keySet = hm.keySet();

		Iterator<String> iter = keySet.iterator();
		while (iter.hasNext()) {
			String key = iter.next();

			// 输出内容
			System.out.println("key值为：" + key);
		}
	}

	/**
	 * 1.5jdk以下遍历方式
	 * 
	 * @Title: traverseMap15
	 * @Description: TODO
	 */
	@SuppressWarnings("rawtypes")
	public void traverseMap15() {
		Set keys = hm.keySet();
		Iterator iterator = keys.iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			Object value = hm.get(key);
			System.out.println("输出" + key + "--" + value);
		}
	}

}
