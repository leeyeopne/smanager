/**
 
json4.js*/
document.querySelector('div.container-fluid>div:nth-of-type(3)').remove();
document.querySelector('div.container-fluid>table').remove();
document.querySelector('#show').remove();

// Asynchronous Javascript And Xml (AJAX) 
let students;
let xhtp = new XMLHttpRequest();
xhtp.open('get', 'studentJson.do'); // 특정페이지 요청.
xhtp.send();
xhtp.onload = function(e) {
	console.log(xhtp.response);
	let json = xhtp.response;
	students = JSON.parse(json);
	initList();
}

function initList() {
	let target = document.getElementById('stdList');
	target.innerHTML = '';
	students.forEach(emp => {
		target.appendChild(makeRow(emp));
	});
}

// 사원정보 => row 생성.
function makeRow(emp = {}) {
	let fields = ['stdNo', 'stdName', 'stdPhone'];
	let tr = document.createElement('tr'); // document.createElement('tr') 'tr'을 만들기 위해서 사용
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = emp[field];
		tr.appendChild(td);
	});

	// 삭제버튼
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.setAttribute('class', ' btn btn-danger'); //<button class=
	btn.addEventListener('click', function(e) {
		console.log(e);
		e.stopPropagation()// click : button > td >tr >table......... 전달전달전달되는걸 차단
		e.target.parentElement.parentElement.remove();
	}, false);
	btn.innerHTML = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	td = document.createElement('td');

	return tr;
}

function deleteRowFnc(e) {
	console.log(e.target.parentElement.parentElement / firstChild.innerText);
	let tr = e.target.parentElement.parentElement;
	let sno = e.target.parentElement.parentElement.firstChild.innerText;
	sno = e.target.parentElement.parentElement.dataset.sno; //getAttribute("data-sno")
	const delHtp = new XMLHttpRequest();
	delHtp.open('get', 'removeStudent.do?sno=' + sno);
	delHtp.send();
	delHtp.onload = function(e) {
		let result = JSON.parse(delHtp.responseText); // {"retCode" : "Success"}
		if (result.retCode == 'Success') {
			alert("성공!");
			tr.remove();
		} else if (result.retCode == 'Fail') {
			alert("관리자에 문의하세요!");
		}//end else if
	}//end function

}//end function


