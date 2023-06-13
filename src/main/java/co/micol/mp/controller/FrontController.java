package co.micol.mp.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.mp.common.Command;
import co.micol.mp.main.command.MainCommand;
import co.micol.mp.member.command.AjaxCheckId;
import co.micol.mp.member.command.MemberInsert;
import co.micol.mp.member.command.MemberLogOut;
import co.micol.mp.member.command.MemberLogin;
import co.micol.mp.member.command.MemberLoginForm;
import co.micol.mp.member.command.RegisterForm;
import co.micol.mp.notice.command.NoticeInsert;
import co.micol.mp.notice.command.NoticeInsertForm;
import co.micol.mp.notice.command.NoticeList;
import co.micol.mp.notice.command.NoticeSelect;
import co.micol.mp.product.command.ProductInsert;
import co.micol.mp.product.command.ProductInsertForm;
import co.micol.mp.product.command.ProductList;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map.put("/main.do", new MainCommand());
		map.put("/register.do", new RegisterForm());
		map.put("/ajaxCheckId.do", new AjaxCheckId());
		map.put("/memberInsert.do" , new MemberInsert());
		map.put("/memberLoginForm.do", new MemberLoginForm());
		map.put("/memberLogin.do", new MemberLogin());
		map.put("/memberLogOut.do", new MemberLogOut());
		map.put("/noticeList.do", new NoticeList()); // 공지사항 게시판
		map.put("/noticeInsertForm.do", new NoticeInsertForm()); // 인서트 폼 호출
		map.put("/noticeInsert.do", new NoticeInsert()); // 공지사항 인서트 기능
		map.put("/noticeSelect.do", new NoticeSelect()); //공지사항 상세보기
		
		
		//제품등록 폼
		map.put("/productList.do", new ProductList());
		map.put("/productInsertForm.do", new ProductInsertForm());
		map.put("/productInsert.do", new ProductInsert());
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("Ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
//			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			viewPage += ".tiles";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(viewPage);
		}
	}

}