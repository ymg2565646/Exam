//科目削除サーブレット
package scoremanager.main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectDeleteAction extends Action{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)throws Exception{
		HttpSession session = req.getSession();
	}
}