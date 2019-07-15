<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<style>
table .newimg{
	width:110px;
	height:157px;
}
</style>
<div class="center_page">
	<h1>pe Page!!</h1>
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Data Table Example
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Poster</th>
							<th>Title</th>
							<th>Genre</th>
							<th>Open</th>
							<th>Close</th>
							<th>Place</th>							
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Poster</th>
							<th>Title</th>
							<th>Genre</th>
							<th>Open</th>
							<th>Close</th>
							<th>Place</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="u" items="${clist}">
							<tr>
								<td><img src="${u.poster}" class="newimg"></td>
								<td>${u.title}</td>
								<td>${u.genre}</td>
								<td>${u.open}</td>
								<td>${u.close}</td>								
								<td>${u.place}</td>								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="card-footer small text-muted">Updated yesterday at
			11:59 PM</div>
	</div>
</div>
