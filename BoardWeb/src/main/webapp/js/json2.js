/**
 * json2.js
 */

document.querySelector('div.container-fluid>div:nth-of-type(2)').remove();
document.querySelector('div.container-fluid>table').remove();

let json = `[{"id":1,"first_name":"Nathanil","last_name":"Hamp","email":"nhamp0@t-online.de","gender":"Male","salary":3863},
{"id":2,"first_name":"Rozanne","last_name":"Mabb","email":"rmabb1@desdev.cn","gender":"Female","salary":1572},
{"id":3,"first_name":"Kassi","last_name":"Hegley","email":"khegley2@bigcartel.com","gender":"Female","salary":9890},
{"id":4,"first_name":"Calli","last_name":"Kincla","email":"ckincla3@csmonitor.com","gender":"Female","salary":6789},
{"id":5,"first_name":"Ignaz","last_name":"Darmody","email":"idarmody4@examiner.com","gender":"Male","salary":5166},
{"id":6,"first_name":"Willetta","last_name":"Lambricht","email":"wlambricht5@uol.com.br","gender":"Female","salary":9866},
{"id":7,"first_name":"Cori","last_name":"Blazewski","email":"cblazewski6@fotki.com","gender":"Male","salary":8428},
{"id":8,"first_name":"Davey","last_name":"Comoletti","email":"dcomoletti7@wikia.com","gender":"Male","salary":5150},
{"id":9,"first_name":"Kimberlee","last_name":"Fridaye","email":"kfridaye8@amazon.de","gender":"Female","salary":4506},
{"id":10,"first_name":"Yurik","last_name":"Lamplough","email":"ylamplough9@redcross.org","gender":"Non-binary","salary":1174},
{"id":11,"first_name":"John","last_name":"Kitter","email":"jkittera@hatena.ne.jp","gender":"Male","salary":6347},
{"id":12,"first_name":"Shane","last_name":"Joskowitz","email":"sjoskowitzb@imdb.com","gender":"Female","salary":1351},
{"id":13,"first_name":"Reade","last_name":"Tatlow","email":"rtatlowc@alibaba.com","gender":"Male","salary":8927},
{"id":14,"first_name":"Dana","last_name":"Glackin","email":"dglackind@dmoz.org","gender":"Female","salary":2677},
{"id":15,"first_name":"Patrizia","last_name":"Palumbo","email":"ppalumboe@parallels.com","gender":"Female","salary":2539},
{"id":16,"first_name":"Jessa","last_name":"Lindstedt","email":"jlindstedtf@smh.com.au","gender":"Female","salary":8956},
{"id":17,"first_name":"Zach","last_name":"Jouen","email":"zjoueng@cocolog-nifty.com","gender":"Male","salary":4883},
{"id":18,"first_name":"Risa","last_name":"Sellwood","email":"rsellwoodh@mysql.com","gender":"Female","salary":2411},
{"id":19,"first_name":"Vanna","last_name":"Rysdale","email":"vrysdalei@dailymotion.com","gender":"Female","salary":7598},
{"id":20,"first_name":"Sharon","last_name":"Seaking","email":"sseakingj@gravatar.com","gender":"Female","salary":9797}]`;

let employees = JSON.parse(json);
console.log(employees);
document.aquerySelector('#searchGender').addEventListener('change', function(e){
initList();	
})
function initList() {
	let target = document.getElementById('empList');
	target.innerHTML = '';
	let selvalue = document.aquerySelector('#searchGender').value;
	employees.forEach(emp => {
		if(selvalue == 'All' || emp.gender == selvalue){
		target.appendChild(makeRow(emp));
		}
	});
}

// 사원정보 => row 생성.
function makeRow(emp = {}) {
	let fields = ['id', 'first_name', 'last_name', 'salary'];
	let tr = document.createElement('tr');
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = emp[field];
		tr.appendChild(td);
	})
	return tr;
}