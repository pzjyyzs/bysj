package com.yidu.lly.luence;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;

import com.yidu.lly.model.Article;

public class ArticleUtils {
	  public static Document articleToDocument(Article article){
	        
	        Document document=new Document();
	        
	        IntField idfield=new IntField("id",article.getAid(),Store.YES);
	        
	        IntField authorfield=new  IntField("uid", article.getUid(), Store.YES);
	   
	        TextField title=new TextField("title", article.getArticlename(),Store.YES);

	        
	        TextField contentfield=new TextField("content", article.getArticlecontent(),Store.YES);
	        
	        document.add(idfield);
	        document.add(authorfield);
	        
	        document.add(title);
	        document.add(contentfield);
	        
	        return document;
	        
	    }
}
