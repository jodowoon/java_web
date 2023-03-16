package com.spring.ex01;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";  //SqlMapConfig 설정 정보 읽은 후 db연동 준비 
				Reader reader = Resources.getResourceAsReader(resource); // 읽은 설정 정보를 가져옴 
				sqlMapper = new SqlSessionFactoryBuilder().build(reader); // 마이바티스를 이용하여 sqlMapper 객체 가져오기 
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;

	}

	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();//실제 member.xml의 sql문을 호출하는데 사용되는 sqlsession 객체를 가져옵니다.
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList");
		//여러개의 레코드를 조회하므로 selectList() 메서드에 실행하고자 하는 sql문의 id 를 인자로 전달합니다. 
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