function regionSelect(region){
	$.ajax({
	type: "POST",
	url: "regSecond",
	data: {region_code:region},
	success: function(result){
		console.log(region);
		//배열 개수 만큼 option 추가
		console.log(result)
		
		$("#theater").find("option").remove().end().append("<option></option>");
  
		var theaterList = JSON.parse(result);
		for(var i=0; i<theaterList.length; i++){
			var theaterCode = theaterList[i].THEATER_CODE;
			var theaterName = theaterList[i].THEATER_NAME;
			$("#theater").append("<option value='"+theaterCode+"'>"+theaterName+"</option>");
		}

	},
	error: function (jqXHR, textStatus, errorThrown) {
		alert("오류가 발생하였습니다.");
	}
	});
}

function theaterSelect(theater){
	$.ajax({
	type: "POST",
	url: "regLast",
	data: {theater_code:theater},
	success: function(result){
		console.log(theater);
		//배열 개수 만큼 option 추가
		console.log(result)
		$("#roomType").find("option").remove().end().append("<option></option>");
		
		var tempResult = JSON.parse(result);
		
		var room_4d = tempResult[0].EXIST_4D;
		console.log(room_4d)
		if(room_4d == "y"){
			$("#roomType").append("<option value=\"4DX\">4DX</option>");
		}
		var room_IMAX = tempResult[0].EXIST_IMAX;
		if(room_IMAX == "y"){
			$("#roomType").append("<option value=\"IMAX\">IMAX</option>");
		}
		var room_2d = tempResult[0].EXIST_NORMAL;
		if(room_2d == "y"){
			$("#roomType").append("<option value=\"2D\">2D</option>");
		}
	},
	
	error: function (jqXHR, textStatus, errorThrown) {
		alert("오류가 발생하였습니다.");
	}
	});
}

function check(form) {

	var datevalue = form.date.value;
	console.log(datevalue);
	
	var year = datevalue.substr(6,4);
	console.log(year);
	var mm = datevalue.substr(0,2);
	mm = mm*1 -1;
	console.log(mm);
	var dd = datevalue.substr(3,2);
	console.log(dd);
	
	datevalue = new Date(year, mm, dd).format("yyyy-MM-dd");
	console.log(datevalue);
	
	var today = new Date().format("yyyy-MM-dd");;
	today.setDate(today.getDate());
	console.log(today);
	
	
	var maxday = new Date().format("yyyy-MM-dd");;
	maxday.setDate(today.getDate() + 3);
	console.log(maxday);
	
	if(datevalue == today){
		return true;
	}
	
	if(datevalue > maxday) {
		form.date.value = '';
		return false;
	}
	
	if(datevalue < today) {
		form.date.value = '';
		return false;
	}
	return true;
}