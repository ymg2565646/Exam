package scoremanager.main;

import java.util.List;

import javax.security.auth.Subject;

import bean.Teacher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectUpdateAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// ローカル変数の指定 1
		HttpSession session = req.getSession(); // セッション
		Teacher teacher = (Teacher)session.getAttribute("user");
		String cd = ""; // 科目コード
		String subject_name= ""; // 科目名
		Subject subject = new Subject();
		SubjectDao subjectDao = new SubjectDao();

		// リクエストパラメーターの取得 2
		cd = req.getParameter("cd");
		subject_name = req.getParameter("subject_name");

		// DBからデータ取得 3
		// 科目の詳細データを取得
		subject = subjectDao.get(cd);
		// ログインユーザーの学校コードをもとにクラス番号の一覧を取得
		List<String> subject_set = subjectDao.filter(teacher.getSchool());

		// ビジネスロジック 4
		cd = subject.getCd();
		subject_name = subject.getSubjectName();

		// レスポンス値をセット 6
		// リクエストに学生番号をセット
		req.setAttribute("cd", cd);
		// リクエストに氏名をセット
		req.setAttribute("subject_name", subject_name);

		req.setAttribute("subject_set", subject_set);

		// JSPへフォワード 7
		req.getRequestDispatcher("subject_update.jsp").forward(req, res);
	}

}
