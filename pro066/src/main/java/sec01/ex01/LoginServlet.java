
package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;  //요청과 관련된 api 클래스
import javax.servlet.http.HttpServletResponse;  //응답과 관련된 api 클래스 

@WebServlet("/login")
// 서블릿의 매핑 이름은 login 이다. webServlet 애너테이션을 사용할 경우 web.xml 에서 경로를 설정해야하는걸 
//HttpServlet 클래스를 상속받아 사용할 수 있다. 
public class LoginServlet  extends HttpServlet{
   public void init() throws ServletException {
      System.out.println("init 메서드 호출");
   }
  // HttpServletRequest 클래스를 통하여 웹 브라우저에서 전송한 정보를 톰캣 컨테이너가 객체를 생성하여 doGet()로 넘겨준다
   protected void doGet(HttpServletRequest request , HttpServletResponse response) 
                                            throws ServletException, IOException {
      request.setCharacterEncoding("utf-8"); 	
      String user_id=request.getParameter("user_id");
      String user_pw=request.getParameter("user_pw"); 
      System.out.println("아이디:"+user_id);
      System.out.println("비밀번호:"+user_pw);
   }

   public void destroy() {
      System.out.println("destroy 메서드 호출 서블릿 종료!");
   }
}
