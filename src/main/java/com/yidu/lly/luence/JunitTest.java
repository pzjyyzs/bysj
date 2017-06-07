package com.yidu.lly.luence;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.yidu.lly.model.Article;

public class JunitTest {
	  private LuceneDao luceneDao=new LuceneDao();
	    
	    @Test
	    public void addIndex() throws IOException{
	        for(int i=0;i<30;i++){
	            Article article=new Article();
	            article.setAid(i);
	            article.setArticlename("lucene 的一个全文检索服务器."+i);
	            article.setArticlecontent("lucene 的一个全文检索服务器"+i);
	            article.setUid(i);
	            luceneDao.addIndex(article);
	        }
	    
	    }
	    
	    @Test
	    public void testDel() throws IOException{
	        luceneDao.delIndex("title", "lucene");
	        
	    }
	    
	    //更新时通过查询条件删除所有命中的doc,建立一个新的
	    @Test
	    public void testUpdate() throws IOException{
	        
	       String fieldName="title";
	       
	       String fieldValue="lucene";
	       
	       Article article=new Article();
	       
	       
	       article.setAid(9527);
	       

	       
	       
	       article.setArticlename("对付对付对付");
	       
	       article.setArticlecontent("对付对付对付");
	       
	       
	        
	       luceneDao.updateIndex(fieldName, fieldValue, article);
	        
	    }
	    
	    
	    @Test
	    public void testsearcher() throws Exception{
	        String keywords="lucene";
	        //title content   textfield 现在使用的分词器是单字分词..
	        List<Article> listArticles=luceneDao.findIndex(keywords,0,10);
	        for(Article article:listArticles){
	            System.out.println(article.getAid());
	            System.out.println(article.getUid());
	            System.out.println(article.getArticlecontent());
	            System.out.println(article.getArticlename());
	            
	        }
	    }
}
