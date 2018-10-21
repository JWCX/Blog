hljs.initHighlightingOnLoad();
let quill = new Quill("#editor",{
	theme: "snow",
	modules: {
		syntax: true,
		toolbar: false,
	}
});
quill.enable(false);
setTimeout(() => {
	quill.setContents(content);
}, 0);


$like = document.getElementById("like");

$inputFields = document.getElementsByClassName("key-listener");
$submit = document.getElementById("submit");

for(let i=0; i<$inputFields.length; i++){
	$inputFields[i].addEventListener("keydown", ()=>{
		if($inputFields[0].value != "" && $inputFields[1].value != "" && $inputFields[2].value != "")
			$submit.removeAttribute("disabled");
		else
			$submit.setAttribute("disabled", "disabled");
	});
}
$inputFields[0].addEventListener("keyup", ()=>{
	if($inputFields[0].value.length > 20){
		alert("이름은 스무자 이상 입력 할 수 없습니다.");
		$inputFields[0].value = $inputFields[0].value.substring(0,20);
	}
})
$inputFields[1].addEventListener("keyup", ()=>{
	if($inputFields[1].value.length > 20){
		alert("비밀번호는 스무자 이상 입력 할 수 없습니다.");
		$inputFields[1].value = $inputFields[1].value.substring(0,20);
	}
})
$inputFields[2].addEventListener("keyup", ()=>{
	if($inputFields[2].value.length > 900){
		alert("코멘트는 900자 이상 입력 할 수 없습니다.");
		$inputFields[2].value = $inputFields[2].value.substring(0,900);
	}
})


function commentDelete(categoryId, postId, commentId, pw){
	if(prompt("비밀번호를 입력하세요.") == pw)
		window.location.replace("/blog/comment/delete_comment?categoryId="+categoryId+"&postId="+postId+"&commentId="+commentId);
	else
		alert("잘못된 비밀번호 입니다.");
}
function commentModify(categoryId, postId, commentId, pw){
//	if(prompt("비밀번호를 입력하세요.") == pw)
//		window.location.replace("/blog/comment/delete_comment?categoryId="+categoryId+"&postId="+postId+"&commentId="+commentId);
}
