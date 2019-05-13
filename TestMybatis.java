//Mybatis CRUD
package com.how2java;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Category;
public class TestMybatis{
	public static void main(String args[]) throws IOException{
		String resource="mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sSF=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sSF.openSession();
		
		Category c=new Category();
//		更新
		Category ca=session.selectOne("getCategory",2);
		ca.setName("category2.2");
		session.update("updateCategory",ca);
//		插入
//		c.setName("新增加的Category");
//		session.insert("addCategory",c);

//		删除		
//		c.setId(3);
//		session.delete("deleteCategory",c);

//		获取		
//		Category c=session.selectOne("getCategory",2);
//		System.out.println(c.getName());
		
		listAll(session);
		
		session.commit();
		session.close();
		
		}
	private static void listAll(SqlSession session){
		List<Category> cs=session.selectList("listCategory");
		for(Category c:cs){
			System.out.println(c.getName());
		}
	}
	}
