package scoremanager.main;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;

import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// ローカル変数の指定 1
		String cd = "";
		String subject_name = "";
		Subject subject = new Subject();
		SubjectDao subjectDao = new SubjectDao();
		Map<String, String> errors = new HashMap<>(); // エラーメッセージ

		// リクエストパラメーターの取得 2
		cd = req.getParameter("cd");
		subject_name = req.getParameter("subject_name");

		// DBからデータ取得 3
		// なし

		// ビジネスロジック 4
		if (cd == null) { // 変更中に別画面から対象の科目が削除された場合
			errors.put("1", "科目が存在していません");
			// リクエストにエラーメッセージをセット
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("subject_update.jsp").forward(req, res);
			return;
		}

		// subjectに科目情報をセット
		subject.setCd(cd);
		subject.setSubjectName(subject_name);
		
		// 変更内容を保存
		subjectDao.save(subject);

		// レスポンス値をセット 6
		// なし

		// JSPへフォワード 7
		req.getRequestDispatcher("subject_update_done.jsp").forward(req, res);
	}

}
