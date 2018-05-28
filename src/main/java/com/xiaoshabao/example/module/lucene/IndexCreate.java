package com.xiaoshabao.example.module.lucene;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;


public class IndexCreate {
	
	/**
	 * 创建
	 */
	@Test
	public void test1() {
		//分词技术(标准分词)
		Analyzer analyzer=new StandardAnalyzer();
		//索引配置信息
		IndexWriterConfig indexWriterConfig=new IndexWriterConfig(analyzer);
		//索引打开方式（没有新建，有打开）
		indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
		//
		Directory directory=null;
		IndexWriter writer=null;
		try {
			directory=FSDirectory.open(Paths.get("E:\\test\\indexs"));
			writer = new IndexWriter(directory, indexWriterConfig);
			
			//创建文档
			Document doc = new Document();
			//创建域
			doc.add(new IntPoint("id",1));
			doc.add(new TextField("content","测试内容",Field.Store.YES));
			doc.add(new StringField("remark","备注一下",Field.Store.YES));
			writer.addDocument(doc);
			
			writer.commit();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
