<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
	crossorigin="anonymous"></script>


<title>메타대 학사정보시스템</title>
</head>

<body class="bg-light">
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">

			<jsp:include page="/WEB-INF/views/sidebarGrade.jsp"></jsp:include>

			<main class="col-9 ms-sm-5 px-md-4">

			<p>
			<div style="overflow-y: auto; height: 800px">
				<table class="table table-striped table-hover"
					style="border-collapse: collapse; text-align: center; vertical-align: middle">
					<thead>
						<c:set var="subjScore_sum" value="0" />
						<c:set var="grade_sum" value="0" />
						<c:set var="subjScore_length" value="0" />
						
						
						<c:forEach var="gradeDTO" items="${allGradeList}">
							<c:if test="${ !(gradeDTO.regYear eq curYear and gradeDTO.regSemester eq curSemester)}">						
								<c:set var="subjScore_sum"
									value="${subjScore_sum + gradeDTO.subjScore}" />
								<c:set var="subjScore_length"
									value="${subjScore_length + 1}" />
								<c:set var="grade_sum" value="${grade_sum + gradeDTO.grade}" />
							</c:if>
						</c:forEach>

						<tr>
							<td colspan="6"><p class="text-center fs-2 fw-bold">전체학기
									성적조회</p></td>
						</tr>
						<tr>
							<th style="background-color: #cecece;">학과
							</td>
							<td>${studentInfo.deptName}</td>
							<th style="background-color: #cecece;">성명
							</td>
							<td colspan="3">${studentInfo.name}</td>
						</tr>
						<tr>
							<th style="background-color: #cecece;">총취득학점
							</td>
							<td>${subjScore_sum}</td>
							<th style="background-color: #cecece;">총평균학점
							</td>
							<td colspan="3"><fmt:formatNumber
									value="${grade_sum / subjScore_length}" pattern="#.##" /></td>
						</tr>
						<tr style="color: white;">
							<th
								style="position: sticky; background-color: lightslategrey; top: 0px">이수구분</th>
							<th
								style="position: sticky; background-color: lightslategrey; top: 0px">과목명</th>
							<th
								style="position: sticky; background-color: lightslategrey; top: 0px">등급</th>
							<th
								style="position: sticky; background-color: lightslategrey; top: 0px">학점</th>
							<th
								style="position: sticky; background-color: lightslategrey; top: 0px">평점</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="registerDTO" items="${yearSemesterList}">
							<c:if
								test="${ !((registerDTO.regYear eq curYear)and(registerDTO.regSemester eq curSemester)) }">
								<tr>
									<td colspan="6" style="background-color: white;">
										<p class="text-center fs-5 fw-bold">${registerDTO.regYear}년도
											${registerDTO.regSemester}학기</p>
									</td>
								</tr>
								<c:set var="scoreSum" value="0" />
								<c:set var="gradeSum" value="0" />
								<c:set var="scoreLen" value="0" />

								<c:forEach var="gradeDTO" items="${allGradeList}">

									<c:if
										test="${gradeDTO.regYear eq registerDTO.regYear and gradeDTO.regSemester eq registerDTO.regSemester}">
										<c:set var="scoreSum" value="${scoreSum + gradeDTO.subjScore}" />
										<c:set var="gradeSum" value="${gradeSum + gradeDTO.grade}" />
										<c:set var="scoreLen" value="${scoreLen + 1}" />
										<tr>
											<td>${gradeDTO.subjGroup}</td>
											<td>${gradeDTO.subjName}</td>
											<td><c:choose>
													<c:when test="${gradeDTO.grade==4.5}">A+</c:when>
													<c:when test="${gradeDTO.grade==4.0}">A0</c:when>
													<c:when test="${gradeDTO.grade==3.5}">B+</c:when>
													<c:when test="${gradeDTO.grade==3.0}">B0</c:when>
													<c:when test="${gradeDTO.grade==2.5}">C+</c:when>
													<c:when test="${gradeDTO.grade==2.0}">C0</c:when>
													<c:when test="${gradeDTO.grade==1.5}">D+</c:when>
													<c:when test="${gradeDTO.grade==1.0}">D0</c:when>
													<c:otherwise>F</c:otherwise>
												</c:choose></td>
											<td>${gradeDTO.subjScore}</td>
											<td>${gradeDTO.grade}</td>
										</tr>
									</c:if>
								</c:forEach>
								<tr>
									<td colspan="6"><label class="fw-bold"
										style="margin: 0px 10px">취득학점</label>${scoreSum}학점 <label
										class="fw-bold" style="margin: 0px 10px 0px 20px">평균학점</label>
										<fmt:formatNumber value="${gradeSum/scoreLen}" pattern="#.##" />
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</p>
		</div>
		</main>

	</div>
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>

</html>