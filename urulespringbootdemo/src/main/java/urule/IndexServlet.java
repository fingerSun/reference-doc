package urule;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Desc
 *      url设置
 * @author tonghan
 * @since 2019年1月1日
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 9155627652423910928L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath()+"/urule/frame");
	}
}
