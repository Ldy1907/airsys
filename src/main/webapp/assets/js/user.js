//delete user
	function deleteUser(id){
    	var isdelete = confirm("您是否要删除");
    	if(isdelete){
    		window.location.href='deleteUser/'+id;
    	}
    }
	
//update user
    function update(id) {
	window.location.href = 'updateUser/' + id;
    }