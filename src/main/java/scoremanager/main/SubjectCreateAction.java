package scoremanager.main;

import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectCreateAction extends Action {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// ローカル変数の指定 1
		SubjectDao subjectDao = new SubjectDao(); // クラス番号Daoを初期化
		
		// リクエストパラメーターの取得 2
		// なし

		// DBからデータ取得 3
		// なし

		// ビジネスロジック 4
		// なし

		// レスポンス値をセット 6
		// なし

		// JSPへフォワード 7
		req.getRequestDispatcher("subject_create.jsp").forward(req, res);
	}
}