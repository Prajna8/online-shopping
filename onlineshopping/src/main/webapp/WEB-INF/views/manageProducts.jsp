<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">


<!-- this line almost pressed my buttons ....
							.......remember this shit-->
	
	<div class="row justify-content-md-center">
	
	<c:if test="${not empty message}">
	
		<div class="col-xs-12">
		<div class="alert alert-success alert-dismissible">
		
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				${message}
		
		</div>
		</div>
	
	</c:if>
	
	

		<div class="col-md-offset-2 col-md-8">

			<div class="card">
					<div class="card-header">
						<h4>Product Management</h4>
					</div>

				<div class="card-body">
					
					<!-- FORM ELEMENTS -->
					<!-- sf stands for spring form tagLib -->
					<sf:form class="form-horizontal" modelAttribute="product"
									action="${contextRoot}/manage/products" method="POST"
									enctype="multipart/form-data">
					
					<!-- I donno what "form-group row" does but it helps bring label and text on the same page -->
					
						<div class="form-group row">
								<label class="col-sm-4 col-form-label" for="name">Enter Product Name: </label>
						<div class="col-sm-8">
								<sf:input type="text" path="name" id="name" placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
						</div>
					    </div>
					
						<div class="form-group row">
								<label class="control-label col-md-4" for="brand">Enter Brand Name: </label>
								<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand" placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
						</div>
						</div>
					
						<div class="form-group row">
								<label class="control-label col-md-4" for="description">Product Description: </label>
								<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4" placeholder="write a description" class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em" />
						</div>
						</div>
					
						<div class="form-group row">
								<label class="control-label col-md-4" for="unitPrice">Enter Unit Price: </label>
								<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitprice" placeholder="Unit Price in &#8377" class="form-control"/>
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
						</div>
						</div>
					
						<div class="form-group row">
								<label class="control-label col-md-4" for="quantity">Quantity Available: </label>
								<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity" placeholder="Quantity Available" class="form-control"/>
						</div>
						</div>
						
						<!-- File element for image upload -->
						<div class="form-group row">
								<label class="control-label col-md-4" for="file">Select an image: </label>
								<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control"/>
								<sf:errors path="file" cssClass="help-block" element="em" /> 
						</div>
						</div>
						
						<div class="form-group row">
								<label class="control-label col-md-4" for="quantity">Quantity Available: </label>
								<div class="col-md-8">
								<sf:select class="form-control" id="categoryId" path="categoryId" 
									items="${categories}"
									itemLabel="name"
									itemValue="id"
								/>
								
						<c:if test="${product.id == 0}">
						
						<!-- this div is only visible when product.id is zero -->
						
							<div class="text-right">
								<br/>
								<button type="button" data-toggle="modal" data-target="#myCategoryModal"
																class="btn btn-outline-dark btn-sm">Add Category</button>
																
							</div>
						</c:if>
						
						<div class="form-group row">
						<br/>
								<div class="col-md-offset col-md-8">
								<input type="submit" name="brand" id="brand" value="Submit" class="btn btn-primary" />
						
						</div>
						</div>
						
						<!-- <div class="form-group row">
								<div class="col-md-offset col-md-8">
								<input type="submit" name="brand" id="brand" value="Submit" class="btn btn-primary" /> -->
						
						<!-- Hidden fields comes here -->
						<sf:hidden path="id"/>
						<sf:hidden path="code"/>
						<sf:hidden path="supplierId"/>
						<sf:hidden path="active"/>
						<sf:hidden path="purchases"/>
						<sf:hidden path="views"/>
						
						</div>
						</div>
					
					
				</sf:form>
					
					<!-- will use later 
					
					<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
					
					<div class="card-footer">
							By Uuuuggghhh.com
						</div> -->
			</div>
			
		</div>
	</div>
</div>


	
	<div class="row justify-content-md-center">
	
		<div class="col-md-12" style="margin-top:50px">
		<h3>Available Products</h3>
		<hr/>
		</div>
	
		<div class="col-md-12">
		
				
		<!-- Product tabel for admin -->
		
		<div class="container-fluid">
		
			<div class="table-responsive">
			
			<table id="adminProductsTable" class="table table-stripped table-bordered">
			
				<thead>
					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Quantity</th>
						<th>Unit Price</th>
						<th>Active</th>
						<th>Edit</th>
					</tr>
				</thead>
			
	
			
				<tfoot>
					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Quantity</th>
						<th>Unit Price</th>
						<th>Active</th>
						<th>Edit</th>
					</tr>
				</tfoot>
			</table>
			
			</div>
		
		
		</div>
		
		
		
		
			
			  
			
			
		</div>
	</div>
<div class="row justify-content-md-center">
	
	<!-- same id is used as in the add catorgy button myCategoryModal -->
	
	<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			
				<!-- MODAL HEADER -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add New Category</h4>
				</div>
				
				
				<div class="modal-body">
				
				<!-- Category form -->
			<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" 
				method="POST" class="form-horizontal">
				
				<div class="form-group row">
					<label for="category_name" class="control-label col-md-4">Category name</label>
					
					<div class="col-md-8">
						<sf:input type="text" path="name" id= "category_name" class="form-control"/>
					
					</div>
				</div>
				
				<div class="form-group row">
					<label for="category_description" class="control-label col-md-4">Category Description</label>
					
					<div class="col-md-8">
						<sf:textarea cols="" rows="5" type="text" path="description" id="category_description" class="form-control"/>
					
					</div>
				</div>
				
				<div class="form-group row">
					
					<div class="col-md-offset-4 col-md-8">
						<input type="submit" value="Add Category" class="btn btn-primary"/>
					</div>
				</div>
				
			</sf:form>
				
				
				
				</div>
			</div>
		</div>
	</div>    
    
</div>
</div>