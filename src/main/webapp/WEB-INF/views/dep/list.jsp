<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>전체 부서 조회</title>
</head>

<body>
	<div>
		<h3>부서 조회</h3>
		<a href="depInsert">등록 페이지</a>
		<button type="button" id="checkDel">선택 삭제</button>
		<table border="1">
			<thead>
				<tr>
					<th><input type="checkbox"></th>
					<th>부서번호</th>
					<th>부서이름</th>
					<th>매니저번호</th>
					<th>지역번호</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${depList}" var="dept">
					<!-- <tr onclick="location.href='deptInfo?departmentId=${dept.departmentId}'"> -->
						<tr onclick="findDeptInfo(event, ${dept.departmentId})">
						<td><input type="checkbox"></td>
						<td>${dept.departmentId}</td>
						<td>${dept.departmentName}</td>
						<td>${dept.managerId}</td>
						<td>${dept.locationId}</td>
						<td><button type="button" id="delBtn">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form name="del" action="depDelete" method="POST">
		
		</form>
	</div>
</body>
<script>
//redirect로 정보를 넘길때 사용
	let result = "${departmentId}";
	if(result != ""){
		alert(result);
	}
	
	//선택 삭제
	document.getElementById('checkDel').addEventListener('click',function(e){
		let checked = document.querySelectorAll('input[type="checkbox"]:checked');
		for(let i=0; i<checked.length; i++){
			let deptNo = checked[i].parentElement.nextElementSibling.textContent; //checkbox - td - 부서번호
			insertDeptInfo(i, deptNo);
		}

		del.submit();
	});

	function insertDeptInfo(index, deptNo){
		let inputTag = document.createElement('input');
		inputTag.type = 'hidden';
		inputTag.name='depList['+index+'].departmentId'; 
		//DeptListVO에 있는 배열 depList의 몇번째 idx.객체 필드 -> 객체가 배열을 가지고 있다는 것을 알리는 정보
		//list 형태가 아닌 DeptListVO 형태로 보냄 
		inputTag.value = deptNo;
		let formTag = document.getElementsByName('del')[0];
		formTag.append(inputTag);
	}

	// let delBtnList = Array.from(document.getElementsByTagName('button')).filter(item => item.id != 'checkDel'); 
	//type=button인 모든 버튼 중에서 checkDel을 제외한 버튼
	let delBtnList = Array.from(document.querySelectorAll('#delBtn'))

	delBtnList.forEach(el=>{
		el.addEventListener('click', function(e){
			
			let tdList = this.parentElement.parentElement.children;
			let deptNo = tdList[1].textContent;

			insertDeptInfo(0,deptNo);
			del.submit();
		})
	});

	// function delBtnEvt(event){
	// 	let deptNo = event.target.parentElement.parentElement.children[1].textContent;
	// 	document.getElementById('delBtn').addEventListener('click',function(){
	// 		console.log(deptNo);
	// 		insertDeptInfo(0,deptNo);
	// 	})
		// document.getElementById('delBtn').addEventListener('click',function(e){
				// deptNo.remove();
			
			// del.submit();
		// })
	// }

	function findDeptInfo(event, deptNo){
		if(event.target.tagName != 'INPUT' && event.target.tagName != 'BUTTON'){
			location.href='deptInfo?departmentId='+deptNo;

			// event.target //실제 이벤트가 발생한 태그
			// event.currentTarget //this 와 같은 의미 -> 지금 해당 이벤트에 대해 동작을 하는 태그
			// event.preventDefault(); //기본으로 등록된 이벤트 동작을 막음.
			// event.stopPropagation(); //이벤트 버블링(전파) 막음
		}
	}

</script>
</html>