package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import bean.School;

public class SubjectDao extends Dao {
	//科目の一件検索メソッド
	public Subject get(String cd, School school) throws Exception{
		//科目インスタンスを初期化
		Subject subject = new Subject();
		//データベースへのコネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		
		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from subject where cd=? and school_cd=?");
			//プリペアードステートメントに科目番号をバインド
			statement.setString(1, cd);
			statement.setString(2, school.getCd());
			//プリぺアードステートメントを実行
			ResultSet resultSet = statement.executeQuery();
			
			// 学校Daoを初期化
			SchoolDao schoolDao = new SchoolDao();
			
			if (resultSet.next()) {
				subject.setCd(resultSet.getString("cd"));
				subject.setName(resultSet.getString("name"));
				subject.setSchool(schoolDao.get(resultSet.getString("school_cd")));
			}else {
				// リザルトセットが存在しない場合
				// 学生インスタンスにnullをセット
				subject= null;
			}
		}catch (Exception e) {
			throw e;
		}finally {
			//プリペアードステートメントを閉じる
			if (statement != null) {
				try{
					statement.close();
				}catch (SQLException sqle) {
					throw sqle;
				}
			}
			//コネクションを閉じる
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		return subject;
	}
	//学校ごとの科目名を取得するメソッド
	public List<Subject> filter(School school) throws Exception{
		// リストを初期化
		List<Subject> list = new ArrayList<>();
		// データベースへのコネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection
				.prepareStatement("select name,cd from subject where school_cd=?");
			// プリペアードステートメントに学校コードをバインド
			statement.setString(1, school.getCd());
			// プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();
			// リザルトセットを全件走査
			while (rSet.next()) {
			    Subject subject = new Subject();
			    subject.setName(rSet.getString("name"));
			    subject.setCd(rSet.getString("cd"));
			    list.add(subject);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			// コネクションを閉じる
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		return list;
	}
	//科目を登録するメソッド
	public boolean save(Subject subject) throws Exception {
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		// 実行件数
		int count = 0;

		try {
			// データベースから科目を取得
			Subject old = get(subject.getCd());
			if (old == null) {
				// 科目が存在しなかった場合
				// プリペアードステートメントにINSERT文をセット
				statement = connection.prepareStatement("insert into subject(cd, name, school_cd) values(?, ?, ?)");
				// プリペアードステートメントに値をバインド
				statement.setString(1, subject.getCd());
				statement.setString(2, subject.getName());
				statement.setInt(3, subject.getSchool_cd());
			} else {
				// 科目が存在した場合
				// プリペアードステートメントにUPDATE文をセット
				statement = connection.prepareStatement("update subject set name = ? where cd = ?");
				// プリペアードステートメントに値をバインド
				statement.setString(1, subject.getName());
				statement.setString(2, subject.getCd());
			}

			// プリペアードステートメントを実行
			count = statement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			// コネクションを閉じる
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		if (count > 0) {
			// 実行件数が1件以上ある場合
			return true;
		} else {
			// 実行件数が0件の場合
			return false;
		}
	}
	// 科目を削除するメソッド
	public boolean delete(Subject subject) throws Exception {
	    Connection connection = getConnection();
	    PreparedStatement statement = null;
	    int count = 0;

	    try {
	        statement = connection.prepareStatement(
	            "delete from subject where cd = ? and school_cd = ?"
	        );

	        statement.setString(1, subject.getCd());
	        statement.setInt(2, subject.getSchool_cd());
	        
	        count = statement.executeUpdate();

	    } catch (Exception e) {
	        throw e;
	    } finally {
	        if (statement != null) {
	            try { statement.close(); 
	            } catch (SQLException sqle) {
	            	throw sqle;
	            	}
	        }
	        if (connection != null) {
	            try { connection.close();
	            } catch (SQLException sqle) { 
	            	throw sqle; 
	            	}
	        }
	    }
	    return count > 0;
	}

}