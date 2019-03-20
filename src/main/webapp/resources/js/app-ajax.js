$(document).ready(function() {
        $('#userName').blur(function(event) {
        		console.log(event);
                var name = $('#userName').val();
                $.get('GetUserServlet', {
                        userName : name
                }, function(responseText) {
                        $('#ajaxGetUserServletResponse').text(responseText);
                });
        });
        
});

//$(document).ready(function() {
//	$('#userName').blur(function() {
//		$.ajax({
//			url : 'GetUserServlet',
//			method: 'GET',
//			data : {
//				userName : $('#userName').val()
//			},
//			success : function(responseText) {
//				$('#ajaxGetUserServletResponse').text(responseText);
//			}
//		});
//	});
//});

//$.ajax({
//	  url: url,
//	  data: data,
//	  success: success,
//	  dataType: dataType
//	});