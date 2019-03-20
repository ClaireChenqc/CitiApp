<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>My Shop</title>
</head>
<body style="overflow-x:hidden">
	<jsp:include page="headers.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="row">
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
		  Launch demo modal
		</button>
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<jsp:include page="insertCatalog.jsp" />
		</div>
	</div>
	<div class="row">
 		<div class="col-7">
 			<h3>Catalog</h3>
 			<div class="row">
	    	<c:forEach var="item" items="${catalogItems}">
				<div class="col-3" style="margin:10px">
					<form action="addItemToCart" method="post">
						<label>Item: ${item.value.description}</label> </br>
						<label>Price : $${item.value.price}</label> 
						<input type="hidden" name="id" value="${item.key}"> </br>
						<input type="text" class="form-control" id="quantity" name="quantity"> </br>
						
						<button type="submit" class="btn btn-primary">Add To Cart</button>
					</form>
				</div>
			</c:forEach>
			</div>
		</div>
	    <div class="col-5">
	    	<h3><i class="fas fa-shopping-cart"></i> My Cart</h3>
	    	<% if(request.getAttribute("cartDetails") != null) { %>
	    	<div class="row">
		    	<div>
		    		<form action="deleteItemToCart" >
		    			<table class="table">
		    				<thead>
			    				<th>Item</th>
			    				<th>Unit Price</th>
			    				<th>Quantity</th>
			    				<th>Total</th>
			    				<th></th>
		    				</thead>
		    				<tbody>
			    				<c:forEach var="item" items="${cartDetails}">
			    					<tr>
					    				<td>
											<label>${item.value[0]}</label> </br>
											<input type="hidden" name="id" value="${item.key}">
										</td>
										<td>
					    					<label>$${item.value[1]}</label> 
										</td>
										<td>
											<label>${item.value[2]}</label> 
										</td>
										<td>
											<label>$${item.value[3]}</label> 
										</td>
										<td >
											<% if(request.getAttribute("cartDetails") != null) { %>
											<button type="submit" class="btn btn-danger"><i class="fas fa-times"></i></button>
											<% } %>
										</td>
									<tr>
								</c:forEach>
							</tbody>
						</table>
					</form>				
				</div>
			</div>
			
			<hr></hr>
			<div >
				<label style="display: block;">Net Cost: $${netCost}</label>
				<label style="display: block;">Total Cost: $${totalCost}</label>
			</div>
			<form action="addItemToCart" >
				<button type="submit" class="btn btn-primary">Checkout</button>
			</form>
			<% } %>
			
	    </div>
  	</div>
  	
	

    
    <!-- <p>Message: <b>${msg}</b></p>
	<p>Favourite Football Team: <b>${fft}</b></p>
	<p>Favourite CitiBank: <b>${favCiti}</b></p>
	<p>Favourite Number: <b>${favNumber}</b></p> -->
	<hr>
	<p>Page generated at <%= new java.util.Date() %></p>
	
</body>
</html>