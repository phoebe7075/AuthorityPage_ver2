<%@ page import="java.util.List" %>
<%@ page import="persistance.AuthorityDTO" %><%--
  Created by IntelliJ IDEA.
  User: Herase
  Date: 2020-06-03
  Time: 오후 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <style>
        .id {
            margin: 0;
            width: 100px;
            text-align: center;
            border-width: 1px;
        }

        .info {
            margin: 0;
            width: 200px;
            text-align: center;
            border-width: 1px;
        }
        .tableview {
            margin-left : 200px;
            margin-top : 120px;
            max-width : 400px;
        }

        .ch {
            margin: 0;
            width: 150px;
            text-align: center;
            border-width: 1px;
        }

        table {
            border: 1px solid #444444;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #444444;
            border-collapse: collapse;
        }

        .btn {
            margin-top: 10px;
            margin-left: 20px;
        }
        .spec {
            width: 200px;
            text-align : center;
        }
    </style>
    <title>권한 관리페이지</title>
</head>
<body>
<div class="AuthorityInfo">
    <div class = "tableview">
        <table  class="table1">
           <thead>
            <tr>
                <td class="ch">체크박스</td>
                <td class="id">ID</td>
                <td class="info">권한</td>
            </tr>
           </thead>
            <%
                List<AuthorityDTO> list = (List<AuthorityDTO>) request.getAttribute("authorityDto");
                for (AuthorityDTO dto : list) {
                    pageContext.setAttribute("dto",dto);
            %>
            <tr>
                <td class="ch">
                    <input type="checkbox" name="columncheck" onclick="oneCheckbox(this)">
                </td>
                <td class="id">${dto.ID}</td>
                <td class="info">${dto.authorityName}</td>
            </tr>
            <% } %>
        </table>
        <button class="btn" onclick="enrollPopUp()">등록</button>
        <button class="btn" onclick="deletePopUp()">삭제</button>
        <button class="btn" onclick="updatePopUp()">수정</button>
        <input type="text" id="recieve_id" hidden>
    </div>
</div>
<script>
    function oneCheckbox(a){
        var obj = document.getElementsByName("columncheck");
        for(var i=0; i<obj.length; i++){
            if(obj[i] != a){
                obj[i].checked = false;
            }
        }
    }
    function enrollPopUp(){
        window.open("AuthorityEnrollView.jsp","등록창","width=400, height=300, left=300, top=300");
    }
    function deletePopUp() {
        var checkbox = $("input:checkbox[name=columncheck]:checked");
        var col1 = "";
        var col2 = "";
        checkbox.each(function (i) {
            var tr = checkbox.parent().parent().eq(i);
            var td = tr.children();
            col1 = td.eq(1).text();
            col2 = td.eq(2).text();
        });
        var really = confirm( "정말로 삭제하시겠습니까?" );
        if (really)
        {
            var url = 'Delete?id=' + col1 + '&name=' +col2;
            window.open(url,"삭제창","width=400, height=300, left=300, top=300");
        }
    }
    var updateWin
    function updatePopUp(){
        updateWin = window.open("AuthorityUpdateView.jsp","수정창","width=400, height=300, left=300, top=300");
        setUpdateid();
    }
    function setUpdateid()
    {
        var checkbox = $("input:checkbox[name=columncheck]:checked");
        var col1 = "";
        checkbox.each(function (i) {
            var tr = checkbox.parent().parent().eq(i);
            var td = tr.children();
            col1 = td.eq(1).text();
        });
        document.getElementById("recieve_id").value = col1;
    }
</script>
</body>
</html>
