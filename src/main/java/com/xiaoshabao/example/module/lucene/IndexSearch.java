package com.xiaoshabao.example.module.lucene;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

public class IndexSearch {
	
	@Test
	public void test1() {
		Directory directory=null;
		try {
			directory=FSDirectory.open(Paths.get("E:\\test\\indexs"));
			//读取索引文件
			IndexReader reader = DirectoryReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);
			//分词技术，要和创建索引用的一样
			Analyzer analyzer=new StandardAnalyzer();
			
			//请求，限定搜索字段
			QueryParser parser = new QueryParser("content", analyzer);
			//设置搜索关键字
			Query query = parser.parse("测试");
			//搜索前10条
			TopDocs results = searcher.search(query, 10);
			
			//结果输出
			//结果数组
			ScoreDoc[] hits = results.scoreDocs;
			for(int i=0;i<hits.length;i++) {
				Document doc = searcher.doc(hits[i].doc);
				System.out.println("文档id："+doc.get("id"));
				System.out.println("文档content："+doc.get("content"));
				System.out.println("文档remark："+doc.get("remark"));
			}
			directory.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("索引读取错误");
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("解析关键字错误");
		}
		
	}

}
