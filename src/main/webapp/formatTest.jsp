<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 연습</title>
<script type="text/javascript">
   alert('jstl 테스트 : ' + '${member.custname}')
</script>
</head>
<body>
<h3>JSTL과 EL</h3>
<ul>
   <li>JSTL - JSP(JavaServer Page) Standard Tag Library</li>
   <li>EL - Expression Language 기호는 &#36; &#123; &#125; : 메소드 등의 처리결과값을 출력
      : EL 출력할 때, c:out 코어태그를 사용하는데 이유는 보안문제 발생
   </li>   

</ul>
<h4>JSTL 로 할 수 있는 것들</h4>
<ul>
   <li>attribute(애트리뷰트) 가져오기 : 라이브러리 없이도 가능 애트리뷰터 가져오고 캐스팅 안해도 된다.<br>
    - ${hello}, ${count}, ${member}, ${member.custname}, ${member.phone}</li>
   <!-- FrontController패키지에 list.jsp -->
   <li>제어문 처리 : if, for (jstl core 태그설정 - taglib 지시자)
      <ul>
         <!-- list애트리뷰트를 for 로 li태그에 출력 -->
         <c:forEach items="${list2}" var="str" varStatus="status"> 
         <!-- items(배열,리스트)에서 가져올 항목을 저장할 변수는 var로 설정. varStatus는 상태값 가져오서 저장할 변수 -->
            <li>${str} - ${status.index}</li>
         </c:forEach>
         <li>${list2[0]}</li><!-- list.get(i) -->
         <li>${list2[1]}</li>
         <li>${list2[2]}</li>
         <li>${list2[3]}</li>
         <li>${list2[4]}</li>
         <li>${list2[5]}</li><!-- 오류가 안나고 ""  -->
      </ul>
      <ul>
         <c:if test="${count==1000}"><!-- test에는 조건식을 작성 -->
            <li>count는 1000입니다.</li>
         </c:if>
         <c:if test="${count!=1000}">
            <li>count는 1000이 아닙니다.</li>
         </c:if>
      </ul>
   </li>
   
   <li>Parameter(파라미터) 가져오기 - ${param.custid}, ${param.name }</li>
   <!-- param는 요청 파라미터를 저장하고 있는 객체 -->
   <li>변수 선언과 저장
      <c:set var="age" value="24"/>
      <c:choose>
         <c:when test="${age>40}">
            <strong style="color:green">성인입니다.</strong>
         </c:when>
         <c:when test="${age>20}">
            <strong style="color:blue">청년입니다.</strong>
         </c:when>
         <c:otherwise>
            <strong style="color:orange">어린이입니다.</strong>
         </c:otherwise>
      </c:choose>
   </li>
   <li>출력 포맷 설정하기 - fmt 태그 : format (숫자, 날짜 출력형식 / Locale 설정)<br>
      <fmt:formatNumber value="9999999"/><br>
      <!-- formatNumber는 바로 출력, value에는 값을 직접 또는 el -->
      <fmt:parseNumber var="test" value="8888888"/><!-- fmt:parseNumber는 변수에 저장 -->
      test : ${test }<br>
      <fmt:formatDate value=""/>
      <fmt:formatNumber value="9999999" type="currency"/><br><!-- 현재 locale : ko_kr -->
      <fmt:setLocale value="en_us"/><!-- locale 변경 : en_us -->
      <fmt:formatNumber value="9999999" type="currency"/><br>
      <!-- type: 화폐단위, 퍼센트출력 등 표시를 위한 키워드, pattern: 직접 소수점 이하, 전체 자리수 지정 -->
      <fmt:formatNumber value="789789.12345" pattern="#,###.###"/><br>
      <!-- pattern="#,###.###" 위 숫자일 경우 3자리마다 찍고 소수점은 3자리까지만 출력하도록 지정 -->
      <fmt:formatNumber value="789789.123" pattern="0000,000,000.00000"/><br>
      <!-- pattern="위 패턴일 경우" 0,000,789,789.12300 0을 쓴만큼 0을 포함출력 -->
      <fmt:formatDate value="${now}"/><br><!--  -->
      <%-- <fmt:parseDate var="datetime" value="<%= new Date() %>"/> --%>
      현재시간과 날짜 : ${datetime }<br>
   </li>
   
   
   <li>문자열 메소드 사용하기</li>
</ul>
</body>
</html>