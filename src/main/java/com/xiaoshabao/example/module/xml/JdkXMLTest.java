package com.xiaoshabao.example.module.xml;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * jdk的xml解析分为两种DOM和SAX
 */
public class JdkXMLTest {
	/**
	 * 解析xml
	 * DOM解析会一次性将文件读到内存中，然后在解析
	 */
	@Test
	public void parseDomXML() {
		// 创建一个DocumentBuilderFactory的对象,这是个工厂方法
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 创建一个DocumentBuilder的对象
		try {
			// 创建DocumentBuilder对象，具体的xml解析类
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 获得当前类的相对路径
			String path = getClass().getResource("").toString();
			// 通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下,路径为项目路径
			Document document = db.parse(path + "books.xml");

			// 获取所有book节点的集合
			NodeList bookList = document.getElementsByTagName("book");
			// 通过nodelist的getLength()方法可以获取bookList的长度
			System.out.println("一共有" + bookList.getLength() + "本书");
			// 遍历每一个book节点
			for (int i = 0; i < bookList.getLength(); i++) {
				System.out.println("=================下面开始遍历第" + (i + 1)
						+ "本书的内容=================");
				// 通过 item(i)方法 获取一个book节点，nodelist的索引值从0开始
				Node book = bookList.item(i);

				// 获取book节点的所有属性集合,属性是<book id="1">中id的值
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("第 " + (i + 1) + "本书共有" + attrs.getLength()
						+ "个属性");
				// 遍历book的属性
				for (int j = 0; j < attrs.getLength(); j++) {
					// 通过item(index)方法获取book节点的某一个属性
					Node attr = attrs.item(j);
					// 获取属性名
					System.out.print("属性名：" + attr.getNodeName());
					// 获取属性值
					System.out.println("--属性值" + attr.getNodeValue());
				}

				// 前提：已经知道book节点有且只能有1个id属性
				// 将book节点进行强制类型转换，转换成Element类型
				// Element book = (Element) bookList.item(i);
				// 通过getAttribute("id")方法获取属性值
				// String attrValue = book.getAttribute("id");
				// System.out.println("id属性的属性值为" + attrValue);
				
				// 解析book节点的子节点
				NodeList childNodes = book.getChildNodes();
				// 遍历childNodes获取每个节点的节点名和节点值
				System.out.println("第" + (i + 1) + "本书共有"
						+ childNodes.getLength() + "个子节点");
				for (int k = 0; k < childNodes.getLength(); k++) {
					// 区分出text类型的node以及element类型的node
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						// 获取了element类型节点的节点名
						System.out.print("第" + (k + 1) + "个节点的节点名："
								+ childNodes.item(k).getNodeName());
						// 获取了element类型节点的节点值
						System.out.println("--节点值是："
								+ childNodes.item(k).getFirstChild()
										.getNodeValue());
						// System.out.println("--节点值是：" +
						// childNodes.item(k).getTextContent());
					}
				}
				System.out.println("======================结束遍历第" + (i + 1)
						+ "本书的内容=================");
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 和Dom不同，SAX会创建一个Handler逐步解析xml文件
	 */
	@Test
	public void parseSaxXML() {
		// 获得SAXParserFactory工厂类
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			// ͨ根据工厂类获得具体的SAXParser解析类
			SAXParser parser = factory.newSAXParser();

			// 获得当前类的相对路径
			String path = getClass().getResource("").toString();
			// 创建一个解析xml的Handler
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse(path+"/books.xml", handler);
			System.out.println("遍历元素，一共" + handler.getBookList().size()
					+ "个");
			for (Book book : handler.getBookList()) {
				System.out.println(book.getId());
				System.out.println(book.getName());
				System.out.println(book.getAuthor());
				System.out.println(book.getYear());
				System.out.println(book.getPrice());
				System.out.println(book.getLanguage());
				System.out.println("----finish----");
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


/**
 * SAX需要通过Handler来解析XML
 */
class SAXParserHandler extends DefaultHandler {
	String value = null;
	Book book = null;
	private ArrayList<Book> bookList = new ArrayList<Book>();

	public ArrayList<Book> getBookList() {
		return bookList;
	}
	
	//只是为了获得现在遍历第几本书
	int bookIndex = 0;

	/**
	 * 用来表示解析开始
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("SAX解析开始");
	}

	/**
	 * 用来表示解析结束
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("SAX解析结束");
	}

	/**
	 * 遍历XML的开始标签，解析xml元素。比如<name>前标签
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// 调用父类，使用DefaultHandler默认的handler解析开始标签
		super.startElement(uri, localName, qName, attributes);
		// 以为只有book有属性id，所以单独解析
		if (qName.equals("book")) {
			bookIndex++;
			// 创建一个book对象
			book = new Book();
			// 开始解析book元素的属性
			System.out.println("==开始遍历某一本书的内容===");
			
			// //已知book元素下属性的名称，根据属性名称获取属性值
			// String value = attributes.getValue("id");
			// System.out.println("book的属性值是：" + value);
			// 不知道book元素下属性的名称以及个数，如何获取属性名以及属性值
			
			int num = attributes.getLength();
			for (int i = 0; i < num; i++) {
				System.out.print("book元素的第" + (i + 1) + "个属性名是："
						+ attributes.getQName(i));
				System.out.println("---属性值是：" + attributes.getValue(i));
				
				if (attributes.getQName(i).equals("id")) {
					book.setId(attributes.getValue(i));
				}
			}
		} else if (!qName.equals("name") && !qName.equals("bookstore")) {
			System.out.print("节点名是：" + qName + "---");
		}
	}

	/**
	 * 遍历XML的结束标签，解析xml元素。比如</name>前标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//调用DefaultHandler类的endElement方法
		super.endElement(uri, localName, qName);
		//判断是否针对一本书已经遍历结束
		if (qName.equals("book")) {
			bookList.add(book);
			book = null;
			System.out.println("======================结束遍历某一本书的内容=================");
		}
		else if (qName.equals("name")) {
			book.setName(value);
		}
		else if (qName.equals("author")) {
			book.setAuthor(value);
		}
		else if (qName.equals("year")) {
			book.setYear(value);
		}
		else if (qName.equals("price")) {
			book.setPrice(value);
		}
		else if (qName.equals("language")) {
			book.setLanguage(value);
		}
	}

	//节点值
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		value = new String(ch, start, length);
		if (!value.trim().equals("")) {
			System.out.println("节点值是：" + value);
		}
	}
}
