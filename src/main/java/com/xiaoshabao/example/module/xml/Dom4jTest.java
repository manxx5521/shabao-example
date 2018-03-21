package com.xiaoshabao.example.module.xml;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/**
 * dom4j解析方式
 * 较为优秀的xmlAPI解析方式
 * <p>示例分为解析和生成两个部分</p>
 */
public class Dom4jTest {

	/**
	 * 解析xml文件
	 * @throws Exception
	 */
	@Test
	public void parseXMLbyImooc() throws Exception {
		// 创建reader，用来加载xml
		SAXReader reader = new SAXReader();
		// 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
		Document document = reader.read(getClass().getResourceAsStream(
				"books.xml"));

		// 可以通过解析字符串方式获得
		// Document document = DocumentHelper.parseText("<csdn></csdn>");

		// 通过document对象获取根节点bookstore
		Element bookStore = document.getRootElement();
		// 通过element对象的elementIterator方法获取迭代器
		@SuppressWarnings("rawtypes")
		Iterator it = bookStore.elementIterator();
		// 遍历迭代器，获取根节点中的信息（书籍）
		while (it.hasNext()) {
			System.out.println("=====开始遍历某一本书=====");
			Element book = (Element) it.next();
			// 获取book的属性名以及 属性值
			@SuppressWarnings("unchecked")
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attr : bookAttrs) {
				System.out.println("属性名：" + attr.getName() + "--属性值："
						+ attr.getValue());
			}
			@SuppressWarnings("rawtypes")
			Iterator itt = book.elementIterator();
			while (itt.hasNext()) {
				Element bookChild = (Element) itt.next();
				System.out.println("节点名：" + bookChild.getName() + "--节点值："
						+ bookChild.getStringValue());
			}
			System.out.println("=====结束遍历某一本书=====");
		}

	}
	
	
	/**
	 * 生成xml文件
	 * @throws Exception
	 */
	@Test
	public void toXmlFile() throws Exception{
		// 第一种方式：创建文档，并创建根元素
		// 创建文档:使用了一个Helper类
		Document document = DocumentHelper.createDocument();

		// 创建根节点并添加进文档
		Element root = DocumentHelper.createElement("student");
		document.setRootElement(root);

		// 第二种方式:创建文档并设置文档的根元素节点
		Element root2 = DocumentHelper.createElement("student");
		Document document2 = DocumentHelper.createDocument(root2);

		// 添加属性
		root2.addAttribute("name", "zhangsan");
		// 添加子节点:add之后就返回这个元素
		Element helloElement = root2.addElement("hello");
		Element worldElement = root2.addElement("world");

		helloElement.setText("hello Text");
		worldElement.setText("world text");

		// 输出
		// 输出到控制台
		XMLWriter xmlWriter = new XMLWriter();
		xmlWriter.write(document);

		// 输出到文件
		// 格式
		OutputFormat format = new OutputFormat("    ", true);// 设置缩进为4个空格，并且另起一行为true
		XMLWriter xmlWriter2 = new XMLWriter(
				new FileOutputStream("student.xml"), format);
		xmlWriter2.write(document2);

		// 另一种输出方式，记得要调用flush()方法,否则输出的文件中显示空白
		XMLWriter xmlWriter3 = new XMLWriter(new FileWriter("student2.xml"),
				format);
		xmlWriter3.write(document2);
		xmlWriter3.flush();
		// close()方法也可以
	}
}
