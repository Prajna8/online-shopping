<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">

<div class="row">


			<!-- to display the actual products -->
			<div class="col-md-3">

				<%@include file="./shared/sidebar.jsp" %>

			</div>


			<!-- to display the actual products -->
			<div class="col-md-9">
	
				<!-- who ate the bread crumbs -->
				<div class="row">
	
							<div class="col-lg-12">
	
	<!-- This will be displayed only when user click products -->
	
				<c:if test="${userClickAllProducts ==true}">
						<ol class="breadcrumb">
						
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">All Products</li>
						
						</ol>
				</c:if>	
				
				
				<!-- This will be displayed only when user click products -->
	
				
				<c:if test="${userClickCategoryProducts == true}">
						<ol class="breadcrumb">
	
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">Category</li>
						<li class="active">${category.name}</li>
	
						</ol>
				</c:if>
				
		</div>
	
	</div>
		
					</div>
				</div>	
</div>