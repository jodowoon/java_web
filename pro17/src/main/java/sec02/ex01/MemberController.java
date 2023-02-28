package sec02.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
//@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	MemberDAO memberDAO; //MemberDAO 형식의 참조변수 형태의 memberDAO 인스턴스 변수 생성

	public void init() throws ServletException {
		memberDAO = new MemberDAO(); // init 메서드를 통하여 memberDAO 변수 초기화 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");//요청된 페이지를 한글방식으로 읽겠다.
		response.setContentType("text/html;charset=utf-8");//응답방식 또한 한글 방식으로 읽겠다. 
		String action = request.getPathInfo(); //요청의 맨 마지막 경로 저장하여 전달 url 요청명을 가저온다 
		System.out.println("action:" + action);//요청된 경로 출력 
		if (action == null || action.equals("/listMembers.do")) { //최초요청이거나 action이 listMembers.do일 경우  수행 
			List<MemberVO> membersList = memberDAO.listMembers(); //listMembers를 호출하여 회원정보를 ArrayList 형식으로 반환 받습니다. t_member 에 저장된 데이터 가져오기 
			request.setAttribute("membersList", membersList); //가져온 list 형태의 membersList를 "membersList"속성이름으로 바인딩하기 
			nextPage = "/test02/listMembers.jsp"; // 웹 컨테이너 차원에서 다른 페이지로 이동 (리다이렉트의 경우 새로운 페이지로 이동하면서 Request와 Response 객체가 새롭게 생성)
		} else if (action.equals("/addMember.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");  //받아온 정보들을 저장
			MemberVO memberVO = new MemberVO(id, pwd, name, email); //MemberVO 형태로 memberVO에 저장 
			memberDAO.addMember(memberVO);
			nextPage = "/member/listMembers.do";

		} else if (action.equals("/memberForm.do")) {
			nextPage = "/test02/memberForm.jsp";
		} else {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test02/listMembers.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);  // nextPage에서 지정한 url을 서블릿으로 요청합니다. 
	}

}



