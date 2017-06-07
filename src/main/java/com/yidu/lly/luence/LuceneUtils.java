package com.yidu.lly.luence;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.FieldInfo.IndexOptions;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class LuceneUtils {

	 	private static Directory directory=null;
	 	static IndexWriterConfig config=null;
	    private static Version matchVersion=null;
	    private static Analyzer analyzer=null;
	    static{
	        
	        try {
	            directory=FSDirectory.open(new File("F://LuceneTest//index"));//索引存放硬盘的位置
	            
	            matchVersion=Version.LUCENE_46;//lucene的版本
	            
	            analyzer=new StandardAnalyzer(matchVersion);//标准分词器，也是单字分词器
	            
	            //config=new IndexWriterConfig(matchVersion, analyzer);//索引建立的配置
	            
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	    }
	    public static IndexWriter getIndexWriter() throws IOException{
	    	config=new IndexWriterConfig(matchVersion, analyzer);
	    	config.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);// 设置打开索引模式为创建或追加  
	        IndexWriter indexWriter=new IndexWriter(directory,config);
	        
	        
	        return indexWriter;
	    }
	    public static IndexSearcher getIndexSearcher() throws IOException{
	        
	        IndexReader indexReader=DirectoryReader.open(directory);
	        
	        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
	        
	        return indexSearcher;
	        
	    }
	    public static Version getMatchVersion() {
	        return matchVersion;
	    }
	    public static Analyzer getAnalyzer() {
	        return analyzer;
	    }
	   
}
