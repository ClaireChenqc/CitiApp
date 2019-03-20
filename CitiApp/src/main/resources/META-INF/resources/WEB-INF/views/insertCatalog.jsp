<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		 <div class="modal-dialog" role="document">
		    <div class="modal-content">
		    	<div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Add New Item To Catalog</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
		      	</div>
		      	<form action="addItemToCatalog" method="post">
			    	<div class="modal-body">
						<div>
							<input type="text" class="form-control" placeholder="Enter an Item Description" id="description" name="description"> </br>
							<input type="text" class="form-control" placeholder="Enter an Item Price" id="price" name="price"> </br>
						</div>
					</div>
			      	<div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				        <button type="button" class="btn btn-primary">Save changes</button>
			      	</div>
		      	</form>
			</div>
		</div>
	</body>
</html>