let categoryRow;
let categoryGroupId;
let categoryGroupIdAll = document.getElementsByClassName("category-groupId");
let categoryDepth;
let categoryOrder;
let categoryName;
let categoryText;
let categoryDeleteBtn;
let categoryDeleteBtnAll = document.getElementsByClassName("category-delete-btn")
let categoryModiBtn;
let categoryInsertBtn;
let categoryInsertBtnAll = document.getElementsByClassName("category-insert-btn")
let categorySubmitBtn = document.getElementById("submit-btn");
let modiCnt = 0;

function modiBtnClick(categoryId){
	getElementsById(categoryId);
	if(categoryText.hasAttribute("disabled")) {
		categoryText.removeAttribute("disabled");
		modiCounter(1);
		categoryModiBtn.value = "확인";
	}
	else{
		categoryText.setAttribute("disabled", "disabled");
		if(document.getElementById("new-category-"+categoryId)){
			document.getElementById("new-category-"+categoryId).removeAttribute("id");
			let select = document.getElementById("select-type");
			document.getElementById("category-type-"+categoryId).value = select.value;
			let label = document.createElement("label");
			label.innerHTML = select.value == 0 ? "블로그" : "갤러리";
			select.parentNode.insertBefore(label, select);
			select.remove();
			
		}
		modiCounter(-1);
		categoryModiBtn.value = "수정";	
		categoryName.value = categoryText.value;
	}
}
function deleteBtnClick(categoryId){
	getElementsById(categoryId);
	if(categoryGroupId.value == categoryId) {
		for(let i=0; i<categoryGroupIdAll.length; i++) {
			console.log(categoryGroupIdAll[i].value)
			if(categoryGroupIdAll[i].value == categoryId) { 
				categoryGroupIdAll[i].parentElement.removeAttribute("id");
				categoryGroupIdAll[i].parentElement.innerHTML = "<input type='hidden' name='delete' value='"+categoryGroupIdAll[i].name+"'>";
				i--;	// HTML Collection은 실시간으로 업데이트 되므로 index의 값을 -1 해줘야 모든 하위카테고리가 정상적으로 삭제된다. 
			}
		}
	}
	else{
		categoryRow.removeAttribute("id");
		categoryRow.innerHTML = "<input type='hidden' name='delete' value='"+categoryId+"'>";
	}
}

function insertBtnClick(categoryId){
	let newId = 0;						// 새로 생성하는 카테고리에 할당할 임시 ID
	let newOrder = 0;
	let siblingId = 0;
	for(let i=0; i<categoryGroupIdAll.length; i++){
		if(parseInt(categoryGroupIdAll[i].name) >= newId)
			newId = categoryGroupIdAll[i].name;
	}
	newId++;
	let div = document.createElement("div");
	let groupId = document.createElement("input");
	let depth = document.createElement("input");
	let order = document.createElement("input");
	let type = document.createElement("input");
	let name = document.createElement("input");
		div.id = "category-row-"+newId;
		groupId.id = "category-groupId-"+newId;
		groupId.setAttribute("class", "category-groupId");
		depth.id = "category-depth-"+newId;
		order.id = "category-order-"+newId;
		type.id = "category-type-"+newId;
		name.id = "category-name-"+newId;
		name.value = "New Category";
	if(categoryId == 0){
		groupId.value = newId; 
		depth.value = 1;
		div.setAttribute("class", "category-depth-"+depth.value);
		for(let i=0; i<categoryGroupIdAll.length; i++){
			if(document.getElementById("category-depth-"+categoryGroupIdAll[i].name).value == depth.value) {
				let orderValue = parseInt(document.getElementById("category-order-"+categoryGroupIdAll[i].name).value);
				if(newOrder <= orderValue)
					newOrder = orderValue;
			}
		}
		order.value = newOrder + 1;
	} else {
		groupId.value = document.getElementById("category-groupId-"+categoryId).value; 
		depth.value = parseInt(document.getElementById("category-depth-"+categoryId).value)+1; 
		div.setAttribute("class", "category-depth-"+depth.value);
		for(let i=0; i<categoryGroupIdAll.length; i++){
			if(categoryGroupIdAll[i].value == groupId.value &&
					document.getElementById("category-depth-"+categoryGroupIdAll[i].name).value == depth.value) {
				let orderValue = parseInt(document.getElementById("category-order-"+categoryGroupIdAll[i].name).value);
				if(newOrder <= orderValue) {
					newOrder = orderValue;
					siblingId = categoryGroupIdAll[i].name;
				}
			}
		}
		order.value = newOrder + 1;
	}
	groupId.type = depth.type = order.type = type.type =  name.type = "hidden";
	groupId.name = depth.name =	order.name = type.name = name.name = newId;
	
	let selectType = document.createElement("select");
	let blogType = document.createElement("option");
	let galleryType = document.createElement("option");
		blogType.value = 0;
		blogType.innerHTML = "블로그";
		galleryType.value = 1;
		galleryType.innerHTML = "갤러리";
		selectType.appendChild(blogType);
		selectType.appendChild(galleryType);
		selectType.id = "select-type";
		
	let text = document.createElement("input");
		text.type = "text";
		text.id = "category-text-"+newId;
		text.setAttribute("class", "categories category-depth-"+depth.value);
		text.value = "New Category";
		
	let modiBtn = document.createElement("input");
		modiBtn.type = "button";
		modiBtn.id = "category-modi-btn-"+newId;
		modiBtn.value = "확인";
		modiBtn.setAttribute("onclick", "modiBtnClick("+newId+");");
	let deleteBtn = document.createElement("input");
		deleteBtn.type = "button";
		deleteBtn.id = "category-delete-btn-"+newId;
		deleteBtn.value = "삭제";
		deleteBtn.setAttribute("class", "category-delete-btn");
		deleteBtn.setAttribute("disabled", "disabled");
		deleteBtn.setAttribute("onclick", "deleteBtnClick("+newId+");");
	
	let newCategoryIdentifier = document.createElement("input");
		newCategoryIdentifier.type = "hidden";
		newCategoryIdentifier.id = "new-category-"+newId;
		newCategoryIdentifier.name = newId;
		newCategoryIdentifier.value = "new";
		
		div.appendChild(newCategoryIdentifier);
		div.appendChild(groupId);
		div.appendChild(depth);
		div.appendChild(order);
		div.appendChild(type);
		div.appendChild(name);
		div.appendChild(selectType);
		div.appendChild(text);
		div.appendChild(modiBtn);
		div.appendChild(deleteBtn);
	if(depth.value == 1) {
		let insertBtn = document.createElement("input");
			insertBtn.type = "button";
			insertBtn.id = "category-insert-btn-"+newId;
			insertBtn.value = "+";
			insertBtn.setAttribute("class", "category-insert-btn");
			insertBtn.setAttribute("disabled", "disabled");
			insertBtn.setAttribute("onclick", "insertBtnClick("+newId+");");
			div.appendChild(insertBtn);
	}
	modiCounter(1);
	if(categoryId == 0){
		document.getElementById("category-modify-field").appendChild(div);	
	} else { 
		if(parseInt(siblingId) != 0)
			getElementsById(siblingId);
		else 
			getElementsById(categoryId);
		categoryRow.parentNode.insertBefore(div, categoryRow.nextSibling);
	}
}

function getElementsById(categoryId){
	categoryRow = document.getElementById("category-row-"+categoryId);
	categoryGroupId = document.getElementById("category-groupId-"+categoryId);
	categoryDepth = document.getElementById("category-depth-"+categoryId);
	categoryOrder = document.getElementById("category-order-"+categoryId);
	categoryName = document.getElementById("category-name-"+categoryId);
	categoryText = document.getElementById("category-text-"+categoryId);
	categoryModiBtn = document.getElementById("category-modi-btn-"+categoryId);
	categoryDeleteBtn = document.getElementById("category-delete-btn-"+categoryId);
	categoryInsertBtn = document.getElementById("category-insert-btn-"+categoryId);
}

function modiCounter(value){
	modiCnt += value;
	if(modiCnt) {
		categorySubmitBtn.setAttribute("disabled", "disabled");
		for(let i=0; i<categoryDeleteBtnAll.length; i++)
			categoryDeleteBtnAll[i].setAttribute("disabled","disabled");
		for(let i=0; i<categoryInsertBtnAll.length; i++)
			categoryInsertBtnAll[i].setAttribute("disabled","disabled");
	}
	else {
		categorySubmitBtn.removeAttribute("disabled");
		for(let i=0; i<categoryDeleteBtnAll.length; i++)
			categoryDeleteBtnAll[i].removeAttribute("disabled");
		for(let i=0; i<categoryInsertBtnAll.length; i++)
			categoryInsertBtnAll[i].removeAttribute("disabled");
	}
}