hljs.initHighlightingOnLoad();

let $submitBtn = document.getElementById("submit-btn");
let $cancelBtn = document.getElementById("cancel-btn");
let $form = document.getElementById("form");
let $content = document.getElementById("content");

$form.addEventListener("submit",() => {
	let delta = quill.getContents();
	$content.value = JSON.stringify(delta).replace(/\/script/g, "\\/script");
})
$submitBtn.addEventListener("click", () => {

});
$cancelBtn.addEventListener("click", () => {
	history.go(-1);
	//	location.replace(document.getElementById("context-path").value+"/main");
});

let $title = document.getElementById("title");
let $category = document.getElementById("category");
let $contentField;

$category.addEventListener("mouseout", submittable);
document.getElementById("body").addEventListener("keydown", submittable);

function submittable(){
	if($title.value != "" && $category.value != "Select Category" && $contentField.innerHTML != "<p><br></p>"){
		$submitBtn.removeAttribute("disabled");
	} else {
		$submitBtn.setAttribute("disabled","disabled");
	}
}

let quill = new Quill('#editor', {
	theme: 'snow',
	placeholder: " 내용을 입력하세요... ",
	modules: {
		imageResize: {
			modules: ["Resize", "DisplaySize"]
		},
		formula: true,
		syntax: true,
		toolbar: [ 
			[{"font": []}, {"size": []}],
			[{"header":"1"}, {"header":"2"}],
			["bold", "italic", "underline", "strike"],
			[{"color": []},{"background": []}],
			[{"script": "sub"}, {"script": "super"}],
			[{"indent": "-1"}, {"indent": "+1"}],
			[{"align": ""}, {"align": "center"}, {"align": "right"}, {"align": "justify"}],
			[{"list": "bullet"}, {"list": "ordered"}],
			["blockquote", "code-block", "formula"],
			["image", "video", "link"],
			["clean"]
		]
	}
});

setTimeout(() => {
	let toolbar = document.getElementsByClassName("ql-toolbar")[0];
	toolbar.style.background = "linear-gradient(rgba(0,0,40,0.1),rgba(210,210,255,0.1))";
	toolbar.style.border = "none";
	toolbar.style.boxShadow = "0px 5px 10px -5px black";
	$contentField = document.getElementsByClassName("ql-editor")[0];
	$contentField.style.minHeight= "70vh";
		quill.setContents(content);
}, 0);