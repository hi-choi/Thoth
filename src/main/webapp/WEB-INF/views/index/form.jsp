<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Thoth 지식과 과학의신 </title>
  <style>
    /*전체영역에 적용하는 스타일시트*/
    /*body { margin: 0 }*/
    #wrap { width:960px; margin: 0 auto;
      /*border: 1px solid red;*/ }

    /*링크에 대한 스타일시트*/
    a { font-weight: bold }
    a:link { text-decoration: none; color: black }
    a:visited { text-decoration: none; color: black }
    a:active { text-decoration: underline; color: orange }
    a:hover { text-decoration: underline; color: orange }

    /*header영역에 적용하는 스타일시트*/
    /*nav영역에 적용하는 스타일시트*/
    nav ul { list-style-type: none; padding-bottom: 15px }
    nav ul li { float: left; margin-left: 100px; }
    nav hr { clear: both; }

    /*main영역에 적용하는 스타일시트*/
    #container { min-height: 500px; }

    /*footer영역에 적용하는 스타일시트*/
    footer p { text-align: center }
  </style>
</head>
<body>
<div id="wrap">
  <%@ include file="/WEB-INF/tiles/header.jsp" %>

  <div id="container"></div>

  <%@ include file="/WEB-INF/tiles/footer.jsp" %>
</div>
</body>
</html>