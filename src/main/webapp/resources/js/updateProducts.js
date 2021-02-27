$(document).ready(function() {
        $('.edit_button').click(function(event) {
        	//alert("function");
        	var row = $(this).closest('tr');
        	
        	var productName = row.find(".product_name");
        	var category = row.find(".category");
        	var price = row.find(".price");
        	
        	productName.removeAttr('disabled');
        	category.removeAttr('disabled');
        	price.removeAttr('disabled');
        	
        })
        
        $('.save_button').click(function(event) {
        	//alert("function");
        	var row = $(this).closest('tr');
        	
        	var productName = row.find(".product_name");
        	var category = row.find(".category");
        	var price = row.find(".price");
        	
        	productName.attr('disabled', 'disabled');
        	category.attr('disabled', 'disabled');
        	price.attr('disabled', 'disabled');
        
        	
        	$.ajax({
				url : 'UpdateProduct',
				method: 'POST',
				data : {
					productNameValue : productName.val(),
					categoryValue : category.val(),
					priceValue : price.val()
				},
				success : function(responseText) {
					console.log(responseText);
				},
				error : function(response) {
					console.log('error');
				} 
			});
        	
        })
});









