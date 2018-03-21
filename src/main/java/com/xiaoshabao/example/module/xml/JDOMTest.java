package com.xiaoshabao.example.module.xml;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;

/**
 * jdom使用类
 */
public class JDOMTest {

	/**
	 * xml解析方法
	 * 
	 * @throws Exception
	 */
	@Test
	public void parseXML() throws Exception {
		// 创建builder 对象
		SAXBuilder builder = new SAXBuilder();
		// 通过文件输入流构建builder
		Document document = builder.build(getClass().getResourceAsStream(
				"books.xml"));
		// 获得根节点root节点
		Element rootElement = document.getRootElement();
		// 获得根节点下子节点的list
		List<Element> bookList = rootElement.getChildren();
		
		List<Book> list=new ArrayList<Book>();
		// 对节点遍历
		for (Element book : bookList) {
			
			Book bookEntity=new Book();
			System.out.println("开始解析第" + (bookList.indexOf(book) + 1) + "书");

			// 解析book属性 方法 1，也就是id属性
			List<Attribute> attrList = book.getAttributes();
			// 因为可能存在多个属性，适用于不知道属性多少
			for (Attribute attr : attrList) {
				String attrName = attr.getName();
				String attrValue = attr.getValue();
				System.out.println("属性值解析：名字->" + attrName + "  值->"
						+ attrValue);
			}
			// 解析book属性 方法 2、如果在知道具体属性，可使用以下方法直接获得
			String id = book.getAttributeValue("id");
			System.out.println("直接获得id的值：" + id);
			bookEntity.setId(id);

			// 遍历book节点的子节点
			// 对book节点的子节点的节点名以及节点值的遍历
			List<Element> bookChilds = book.getChildren();
			for (Element child : bookChilds) {
				String childName = child.getName();
				String childValue = child.getValue();
				System.out.println("节点名：" + childName + "-节点值：" + childValue);
				//根据取出的具体属性添加到bookEntity中
				if (child.getName().equals("name")) {
					bookEntity.setName(child.getValue());
				} else if (child.getName().equals("author")) {
					bookEntity.setAuthor(child.getValue());
				} else if (child.getName().equals("year")) {
					bookEntity.setYear(child.getValue());
				} else if (child.getName().equals("price")) {
					bookEntity.setPrice(child.getValue());
				} else if (child.getName().equals("language")) {
					bookEntity.setLanguage(child.getValue());
				}
			}

			System.out.println("结束解析第" + (bookList.indexOf(book) + 1) + "书");
			list.add(bookEntity);
			//list是线性的，并且实现Serializable。添加后可将bookEntity置空便于回收
			bookEntity=null;
		}
		
		
		//测试实体内容
		System.out.println("第一本书的名字:"+list.get(0).getName());
		System.out.println("第二本书的价钱:"+list.get(1).getPrice());
	}

}
