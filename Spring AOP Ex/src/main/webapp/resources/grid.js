var gridSet = function(gridId , data) {
	var html = "";
	var grid = document.getElementById(gridId);
	if(grid == null){
		alert("그리드가 존재하지 않습니다.");
		return;
	}
	
	var colums = grid.children[0].children[0].children.length;
	var ids = [];
	
	for(var i = 0; i< colums; i++){
		ids.push(grid.children[0].children[0].children[i].id);
	}
	
	var map = new Map();
	
	for(var i = 0; i< ids.length; i++){
		var arr = [];
		
		for(var j=0; j<data.length; j++){
			arr.push(data[j][ids[i]]);
		}
		map.set(ids[i], arr);
	}

	for(var i= 0; i<data.length; i++){
		html += '<tr>';
		for(var j=0; j< map.size; j++){
			html += '<td id = "'+ids[j]+'">'+map.get(ids[j])[i]+'</td>';
			console.log('<td id = "'+ids[j]+'">'+map.get(ids[j])[i]+'</td>');
		}
		html += '</tr>';
	}
	grid.children[1].innerHTML = html;
};










