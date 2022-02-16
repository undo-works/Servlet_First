package first.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import first.bean.CustomerBean;

/**
 * Servlet implementation class Use_Beans
 */
@WebServlet("/Use_Beans")
public class Use_Beans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Use_Beans() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//CustomerBeanのインスタンスを取得
		CustomerBean bean = new CustomerBean();
		
		//要素を入れる
		bean.setId(1);
		bean.setName("佐藤");
		bean.setHeight(160.0);
		
		//チェック処理の実行
		bean.checkValues();
		
		//リクエスト属性にcustomerの名前で格納
		request.setAttribute("customer", bean);
		
		//JSPのリソースを取得
		RequestDispatcher rd =request.getRequestDispatcher("Use_Beans_Pages.jsp");
		
		//JSPにフォワード
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
