<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">

	<div class="row">


		<!-- to display the actual products -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>


		<!-- to display the actual products -->
		<div class="col-md-9">

			<!-- who ate the bread crumbs -->
			<div class="row">

				<div class="col-lg-12">

					<!-- This will be displayed only when user click products -->

					<c:if test="${userClickAllProducts ==true}">
												
					<script>
						window.categoryId = '';
					</script>
					
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
						
					</c:if>


					<!-- This will be displayed only when user click products -->
						
						<c:if test="${userClickCategoryProducts == true}">
							
							<script>
								window.categoryId = '${category.id}';
							</script>
							
							<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>

						</ol>
					</c:if>

				</div>

			</div>

			<div class="col-xs-12">

				<table id="productListTable" class="table table-stripped table-bordered">
					
					<thead>
						<tr>
							<th></th>
							<th>Name</th>
							<th>Brand</th>
							<th>Price</th>
							<th>Qty. Available</th>
							<th> * </th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th></th>
							<th>Name</th>
							<th>Brand</th>
							<th>Price</th>
							<th>Qty. Available</th>
							<th> * </th>
						</tr>
					</tfoot>

				</table>

			</div>


		</div>
	</div>
</div>