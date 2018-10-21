
//Init - Social Media Icons2
let socialIcons2 = document.getElementsByClassName("social-icons-2");
for(let i=0; i<socialIcons2.length; i++){
	socialIcons2[i].id = srcSocialMedia2[i].id;
	socialIcons2[i].src = srcSocialMedia2[i].src;
	socialIcons2[i].style.opacity = 0.8;
}
// Init - Social Media Buttons2
let socialButtons2 = document.getElementsByClassName("social-buttons-2");
for(let i=0; i<socialButtons2.length; i++){
	socialButtons2[i].style.left = (i)*36+"px";	// offset = 32px
}
//Event - Social Media Buttons2
for(let i=0; i<socialButtons2.length; i++){
	socialButtons2[i].addEventListener("click", () => {
		setTimeout(() => {
			window.open(srcSocialMedia2[i].url, "_blank");
		}, 200);
	});
}
//Effect - Social Media Buttons2
for(let i=0; i<socialButtons2.length; i++){
	let zoomInInterval, zoomOutInterval;
	let zoomCnt = 0;
	let width = socialIcons2[i].width;
	let height = socialIcons2[i].height;
	let opacity = parseFloat(socialIcons2[i].style.opacity);
	
	socialButtons2[i].addEventListener("mouseover", () => {
		clearInterval(zoomOutInterval);
		zoomInInterval = setInterval(() => {
			zoomCnt++;
			socialIcons2[i].style.width = width + zoomCnt + "px";
			socialIcons2[i].style.height = height + zoomCnt + "px";
			socialIcons2[i].style.opacity = opacity + (zoomCnt*0.02);
			if(zoomCnt>=10) 
				clearInterval(zoomInInterval);
			}, 10);
	});
	socialButtons2[i].addEventListener("mouseout", () => {
		clearInterval(zoomInInterval);
		zoomOutInterval = setInterval(() => {
			zoomCnt--;
			socialIcons2[i].style.width = width + zoomCnt + "px";
			socialIcons2[i].style.height = height + zoomCnt + "px";
			socialIcons2[i].style.opacity = opacity + (zoomCnt*0.02);
			if(zoomCnt<=0) 
				clearInterval(zoomOutInterval);
		}, 15);
	});
}


let $selectedCategoryId = document.getElementById("selected-category-id");
let $highCategories = document.getElementsByClassName("category-depth-1");
let $categories = document.getElementsByClassName("category-depth-2");
let $buttons = document.getElementsByClassName("buttons");

for(let i=0; i<$categories.length; i++){
	if($selectedCategoryId.value == $categories[i].id){
		$categories[i].style.background = "linear-gradient(to bottom, rgba(250,250,250,0.9), rgba(255,255,255,0.95), rgba(255,255,255,1))";
	}
}

for(let i=0; i<$highCategories.length; i++){
	$highCategories[i].addEventListener("click", function(event){
	    event.preventDefault()
	});
}

// Effect - Buttons
for(let i=0; i<$buttons.length; i++){
	let mouseOverInterval, mouseOutInterval;
	let cnt = 0;
	$buttons[i].addEventListener("mouseover", () => {
		clearInterval(mouseOutInterval);
		mouseOverInterval = setInterval(() => {
			cnt++;
			$buttons[i].style.background = "radial-gradient(rgba(10,10,20,"+(0.6+cnt/100)+"),rgba(15,15,30,"+(0.4+cnt/100)+"))";
			if(cnt>=40) 
				clearInterval(mouseOverInterval);
		}, 5);
	});
	$buttons[i].addEventListener("mouseout", () => {
		clearInterval(mouseOverInterval);
		mouseOutInterval = setInterval(() => {
			cnt--;
			$buttons[i].style.background = "radial-gradient(rgba(10,10,20,"+(0.6+cnt/100)+"),rgba(15,15,30,"+(0.4+cnt/100)+"))";
			if(cnt<=0) 
				clearInterval(mouseOutInterval);
		}, 5);
	});
}
// Effect - Categories
for(let i=0; i<$categories.length; i++){
	if($categories[i].id == $selectedCategoryId.value)
		continue;
	let mouseOverInterval, mouseOutInterval;
	let cnt = 0;
	$categories[i].addEventListener("mouseover", () => {
		clearInterval(mouseOutInterval);
		mouseOverInterval = setInterval(() => {
			cnt++;
			$categories[i].style.background = "linear-gradient(to bottom, rgba(250,250,250,"+(0.2+cnt/100)+"),rgba(255,255,255,"+(0.3+cnt/100)+"),"
 												+"rgba(255,255,255,"+(0.4+cnt/100)+"),rgba(255,255,255,"+(0.48+cnt/100)+"),rgba(255,255,255,"+(0.5+cnt/100)+"))";
			if(cnt>=50) 
				clearInterval(mouseOverInterval);
			}, 1);
	});
	$categories[i].addEventListener("mouseout", () => {
		clearInterval(mouseOverInterval);
		mouseOutInterval = setInterval(() => {
			cnt--;
			$categories[i].style.background = "linear-gradient(to bottom, rgba(250,250,250,"+(0.2+cnt/100)+"),rgba(255,255,255,"+(0.3+cnt/100)+"),"
												+"rgba(255,255,255,"+(0.4+cnt/100)+"),rgba(255,255,255,"+(0.48+cnt/100)+"),rgba(255,255,255,"+(0.5+cnt/100)+"))";
			if(cnt<=0) 
				clearInterval(mouseOutInterval);
		}, 1);
	});
}

//