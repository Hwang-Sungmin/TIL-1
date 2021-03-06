<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="center_page">
	<h1>Performance Page!!</h1>
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Performance Post Table
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Contents</th>
							<th>TITLE</th>
							<th>TEXT</th>
							<th>CATEGORY</th>
							<th>Author</th>
							<th>REGDATE</th>
							<th>RATES</th>
							<th>Detail</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${plist}">
							<c:choose>
								<c:when test="${p.category eq 2 }">
									<tr>
										<td><c:set var="loop_flag" value="false" />
										<c:forEach var="c" items="${clist}">
										  <c:if test="${not loop_flag }">
												<c:choose>												
													<c:when test="${c.id eq p.contents}">
													  <c:set var="loop_flag" value="true" />														
														<img src="${c.poster}" class="newimg">
														<p>${c.title}</p>													
													</c:when>
												</c:choose>
												 </c:if>
											</c:forEach></td>
										<td>${p.title }</td>
										<td>${p.text }</td>
										<td>${p.category }</td>
										<td>${p.writer}</td>
										<td>${p.regdate }</td>
										<td>
										<c:if test="${p.star == 0 }"> </c:if>
										<c:if test="${p.star == 1 }"> ★☆☆☆☆</c:if>
										<c:if test="${p.star == 2 }"> ★★☆☆☆</c:if>
										<c:if test="${p.star == 3 }"> ★★★☆☆</c:if>
										<c:if test="${p.star == 4 }"> ★★★★☆</c:if>
										<c:if test="${p.star == 5 }"> ★★★★★</c:if>										
										</td>
										<td><form action="postdetail.sh" method="POST">
											<input type="hidden" value="${p.id}" name="id">											
											<input type="submit" value="자세히보기">
										</form></td>
										
									</tr>
								</c:when>
							</c:choose>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="card-footer small text-muted">Updated yesterday at
			11:59 PM</div>
	</div>
	<a id="write" href="pelist.sh">글쓰기</a>
</div>