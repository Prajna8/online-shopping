<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp" %>

	<div class="container">
	
	<div class="row justify-content-md-center">
	
	<div class="col-md-6 col-md-offset-3">
	<div class="card">
	
	<div class="card-header">
	<h4>Sign Up- Address</h4>
	</div>
	
	<div class="card-body">
	
	<sf:form method="POST" class="form-horizontal" id="billingForm"
			modelAttribute="billing">
	
	
		<div class="form-group row">
		<label class="control-label col-md-4" for="addressLineOne">Address Line One</label>
		<div class="col-md-8">
		<sf:input type="text" path="addressLineOne" class="form-control" 
										placeholder="Enter Address Line One" />
		
		<sf:errors path="addressLineOne" cssClass="help-block" element="em" />
		</div>
		</div>
		
		<div class="form-group row">
		<label class="control-label col-md-4" for="addressLineTwo">Address Line Two</label>
		<div class="col-md-8">
		<sf:input type="text" path="addressLineTwo" class="form-control" 
										placeholder="Enter Address Line Two" />
		
		<sf:errors path="addressLineTwo" cssClass="help-block" element="em" />
		</div>
		</div>
	
		<div class="form-group row">
		<label class="control-label col-md-4" for="city">City</label>
		<div class="col-md-8">
		<sf:input type="text" path="city" class="form-control" 
										placeholder="Enter City Name" />
		
		<sf:errors path="city" cssClass="help-block" element="em" />
		</div>
		</div>
		
		<div class="form-group row">
		<label class="control-label col-md-4" for="postalCode">Postal Code</label>
		<div class="col-md-8">
		<sf:input type="text" path="postalCode" class="form-control" 
										placeholder="XXXXXXXXXX" />
		
		<sf:errors path="postalCode" cssClass="help-block" element="em" />
		</div>
		</div>
		
		<div class="form-group row">
		<label class="control-label col-md-4" for="state">State</label>
		<div class="col-md-8">
		<sf:input type="text" path="state" class="form-control" 
										placeholder="Enter State Name" />
		<sf:errors path="state" cssClass="help-block" element="em" />
		</div>
		</div>
		
		<div class="form-group row">
		<label class="control-label col-md-4" for="country">Country</label>
		<div class="col-md-8">
		<sf:input type="text" path="country" class="form-control" 
										placeholder="Enter Country Name" />
		<sf:errors path="country" cssClass="help-block" element="em" />
		</div>
		</div>
		
		<div class="form-group row">
		<div class="col-md-offset-4 col-md-8">
		
		<!-- submit button for moving to the personal -->
		<button type="submit" class="btn btn-primary"
				name="_eventId_personal">
		<i class="fa fa-angle-left" aria-hidden="true"></i>Previous - Personal 
		
		</button>
		
		<!-- submit button for moving to the confirm -->
		<button type="submit" class="btn btn-primary"
								name="_eventId_confirm">
		Next - Confirm<i class="fa fa-angle-right" aria-hidden="true"></i>
		
		</button>
		
		</div>
		</div>
		
	</sf:form>
	
	</div>
	</div>
	
	</div>
	</div>
	</div>	
			
<%@include file="../shared/flows-footer.jsp" %>



	