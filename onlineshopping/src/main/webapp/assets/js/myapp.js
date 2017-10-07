$(function() {
	
	// solving the active menu
	switch(menu)
	{
	case 'About Us':
		$('#about').addClass('active');
		break;
		
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
		
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
		
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	
	default:
		if(menu=="Home") break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	
	}
	
	//code for Jquery Data table
	//create a DataSet
	
	var $table =$('#productListTable');
	
	//execute the below code only where we have this table
	if($table.length){
		//console.log('Inside the table');
		
		var jsonUrl ='';
		if (window.categoryId =='') {
			jsonUrl=window.contextRoot +'/json/data/all/products';
		}
		else {
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId + '/products';
		}

		
	$table.DataTable({
				lengthMenu: [[3,5,10,-1],['3 ', '5 ', '10 ','All']],
				pageLength: 5,

				ajax: {
					url: jsonUrl,
					dataSrc:''	
				},
				
				columns: [
							{
								data:'code',
								mRender: function(data,type,row){
									
									return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>'
								}
								
							},
							{
								data:'name'
							},
							{
								data:'brand'	
							},
							{
								data:'unitPrice',
								mRender: function(data, type, row){
									return '&#8377; ' + data
								}
							},
							{
								data:'quantity',
								mRender: function(data,type,row){
									
									if(data <1){
										return '<span style="color:red"> Out of Stock </span>';
									}
									return data;
								}
							},
							{
								data:'id',
								bSortable: false,
								mRender: function(data, type, row){
									
									var str='';
									str +='<a href="'+ window.contextRoot +'/show/'+ data +'/product" class="btn btn-info btn-sm"><i class="fa fa-eye" aria-hidden="true"></i></a> &#160;';
									
									if(row.quantity <1){
										
									str +='<a href="javascript:void(0)" class="btn-outline btn-success btn-sm disabled"><i class="fa fa-shopping-cart" aria-hidden="true"> Add To Cart </i></span></a>';

									}
									else{
										str +='<a href="'+ window.contextRoot +'/cart/add/'+ data +'/product" class="btn btn-success btn-sm "><i class="fa fa-shopping-cart" aria-hidden="true"> Add To Cart </i></span></a>';

									}
										
									
									return str;
								}
								
								
							}
							
					
				]
				
				
				
				
	});
	}
	
});  
