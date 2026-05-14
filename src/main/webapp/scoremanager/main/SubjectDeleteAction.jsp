<%-- デリートJSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:import url="/common/base.jsp">
	<c:param name="content">
	<c:param name="title">
		得点管理システム
	</c:param>
		<div id="wrap_box">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2">科目情報削除</h2>
		</div>
		<label>
			<p>「<%--ここに取得した科目の名前を入れる。--%>」を削除してもよろしいですか</p>
		</label>
		<button>
			<input type="submit">削除</input>
		</button>
	</c:param>
</c:import>