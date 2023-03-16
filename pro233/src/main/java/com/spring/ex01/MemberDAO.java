package com.spring.ex01;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() { //데이터를 반환해주는 메소드? 
		if (sqlMapper == null) {  //sqlMapper 이 null이라면 첫번째 접속이라는 의미...?
			try {
				String resource = "mybatis/SqlMapConfig.xml";  //resource에 오라클 db연동준비 
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader); //마이바티스를 이용하여 sqlMapper
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}

	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession(); //member.xml 의 sql 문을 호출하는데 사용되는 SqlSession 객체를 가져옵니다. 
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList"); //selectAllMemberList 안에 쿼리문 가져오기 
		return memlist;
	}
	
//	 public List<HashMap<String, String>> selectAllMemberList() { 
//		sqlMapper = getInstance(); 
//     	SqlSession session = sqlMapper.openSession();
//		List<HashMap<String, String>> memlist = null; 
//   	memlist = session.selectList("mapper.member.selectAllMemberList"); 
//		return memlist; 
//	 }
	
}
