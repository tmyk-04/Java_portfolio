<%@page import="bean.DB_bean.DisasterType"%>
<%@page import="org.apache.catalina.User"%>
<%@page import="bean.DB_bean.Shelter"%>
<%@ page import="bean.API_bean.UserAddress" %>
<%@ page import="bean.DTO.ShelterDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!--戻り値がobject型のためキャストが必要-->
<% UserAddress ua = (UserAddress) request.getAttribute("ua"); %>
<% ShelterDTO dto = (ShelterDTO) request.getAttribute("dto"); %>
<% String[] type = (String[]) request.getAttribute("type"); %>
<% DisasterType ds = new DisasterType(); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="CSS/style.css">
    <title>検索結果</title>
</head>
<body>
<h1>検索結果</h1>
<h3>入力情報</h3>
<p><%= ua.getAddress() %></p>
<p>緯度: <%= ua.getLatitude() %></p>
<p>経度: <%= ua.getLongitude() %></p>
<% if (ua.getError() != null) { %>
<p><%= ua.getError() %></p>
<% } %>
<p>災害種別:
<!--lengthの前にnullをチェックしないと例外発生-->
<% if ((type == null) || (type.length == 0)) { %>
選択されていません。
<% } else { 
	for (String str : type) { %>
	<%= ds.getMap(str) %>
<% }
	} %>
</p>

<h3>検索結果</h3>

<% if ((dto != null) && ( dto.size()) > 0) {
        for (int i = 0; i < dto.size(); i++) { 
            Shelter sl = dto.get(i); %>
            <h4><%= i + 1 %>件目</h4>
            <p>距離:<%= sl.getDistance_km() %> km</p>
            <p>名称:<%= sl.getName() %></p>
            <p>名称_カナ:<%= sl.getName_kana() %></p>	
            <p>住所:<%= sl.getAddress() %></p>
            <p>緯度:<%= sl.getLatitude() %></p>
            <p>経度:<%= sl.getLongitude() %></p>
            <p>電話番号:<%= sl.getTel() %></p>
            <p>収容可能人数:<%= sl.getCapacity() %> 人</p>
<% }
    	} else { %>
    <p>データが見つかりませんでした。</p>
    <p>うまく検索できない場合は住所の丁目、番地以降を削除して再度検索してください。</p>
    <p>※現在、大規模な火事、火山現象に対応する避難所は登録されていません。</p>
<% } %>


<form action="/DisasterRelief/userForm.html" method="post">
    <button type="submit">戻る</button>
</form>
</body>
</html>