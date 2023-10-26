<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    	<header>
		<div id="header_section" class="header">
			<h1 class="logo">
				<a href="${pageContext.request.contextPath}/main"></a>
			</h1>
			<div class="gnb">
				<ul class="menu1">
					<li><a href=""><img src="/resources/image/페이스북.png"
							alt="페이스북로고"></a></li>
					<li><a href="" style="width: 35px"><img
							src="/resources/image/유튜브-removebg-preview.png" alt="유튜브로고"></a></li>
					<li><a href=""><img src="/resources/image/인스타그램.png"
							alt="인스타그램로고"></a></li>
				</ul>
				<ul class="menu2">
					<li><a href="">멤버십</a></li>
					<li><a href="">고객센터</a></li>
					<li><a href="">단체관람/대관문의</a></li>
					<c:if test="${empty SPRING_SECURITY_CONTEXT}">
                    	<li id="loginLink"><a href="${pageContext.request.contextPath}/member/login">로그인</a></li>
                    </c:if>
                    <c:if test="${not empty SPRING_SECURITY_CONTEXT}">
                    	<li id="logoutLink"><a href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
                    </c:if>
				</ul>
				<ul class="menu3">
					<li><a href="${pageContext.request.contextPath}/member/join">회원가입</a></li>
					<li><a href="">바로예매</a></li>
					<li><a href=""><img src="/resources/image/햄버거버튼.png"></a></li>
				</ul>
				<div class="nav">
					<ul class="submenu">
						<li><a href="">예매</a>
							<ul class="submenu1">
								<li><a href="">예매하기</a></li>
								<li><a href="">상영시간표</a></li>
								<li><a href="">할인안내</a></li>
							</ul></li>
						<li><a href="">영화</a>
							<ul class="submenu2">
								<li><a href="">홈</a></li>
								<li><a href="">현재상영작</a></li>
								<li><a href="">상영예정작</a></li>
								<li><a href="">아르떼</a></li>
								<li><a href="">국립극장</a></li>
							</ul></li>
						<li><a href="">영화관</a>
							<ul class=submenu3>
								<li><a href="">스페셜관</a></li>
								<li><a href="">서울</a></li>
								<li><a href="">경기/인천</a></li>
								<li><a href="">충청/대전</a></li>
								<li><a href="">전라/광주</a></li>
								<li><a href="">경상/대구</a></li>
								<li><a href="">경상/부산/울산</a></li>
								<li><a href="">강원</a></li>
								<li><a href="">제주</a></li>
							</ul></li>
						<li><a href="">이벤트</a>
							<ul class="submenu4">
								<li><a href="">홈</a></li>
								<li><a href="">영화</a></li>
								<li><a href="">시사회/무대인사</a></li>
								<li><a href="">HOT</a></li>
								<li><a href="">제휴할인</a></li>
								<li><a href="">우리동네영화관</a></li>
							</ul></li>
						<li><a href="">스토어</a>
							<ul class="submenu5">
								<li><a href="">베스트</a></li>
								<li><a href="">관람권</a></li>
								<li><a href="">스낵음료</a></li>
								<li><a href="">포토카드</a></li>
							</ul></li>
						<li><a href=""></a>
							<ul></ul></li>
					</ul>
				</div>
			</div>
		</div>
	</header>
    