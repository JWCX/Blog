
let srcSocialMedia = [{"id" : "email", "src" : "./image/icon/social/email_240.png", "url" : "mailto:jw.chox@gmail.com"},
					  {"id" : "github", "src" : "./image/icon/social/github_240.png", "url" : "https://github.com/JWCX"},
					  {"id" : "kakao", "src" : "./image/icon/social/kakao_240.png", "url" : "https://open.kakao.com/o/sUtmjtO"},
					  {"id" : "instagram", "src" : "./image/icon/social/instagram_240.png", "url" : "https://www.instagram.com/b4mv"},
					  {"id" : "soundcloud", "src" : "./image/icon/social/soundcloud_240.png", "url" : "https://soundcloud.com/jung-woo-cho-3"}];
let srcBackground = ["./image/background/blacksea.jpg",
					"./image/background/iceland.jpg",
					"./image/background/milkyway.jpg",
					"./image/background/mountains.jpg",
					"./image/background/northernlights.jpg",
					"./image/background/ruins.jpg",
					"./image/background/sunset.jpg",
					"./image/background/uyuni.jpg"];
let strFirstPage = "Lorem Ipsum Dolor Sit Amet";

let strlength = 40;
let strstate = false;
setInterval(() => {
	if(strstate){
		strlength++;
	}
	else{
		strlength--;
	}
	if(strlength <= 0){
		strstate =true;
	}
	if(strlength >= 40){
		strstate =false;
	}
	fph.innerHTML = strFirstPage.substring(0, strlength);
}, 120);

// Initializing Tag Attributes And Styles
// Init - First Page Background
let fpb = document.getElementsByClassName("first-page-backgrounds");
fpb[0].style.backgroundImage = "url('"+srcBackground[0]+"')";
fpb[1].style.opacity = 0;
// Init - First Page Heading
let fph = document.getElementById("first-page-heading");
fph.innerHTML = strFirstPage;
// Init - Scroll Down Arrow
let scrollArrows = document.getElementsByClassName("arrows");
for(let i=0; i<scrollArrows.length; i++){
	scrollArrows[i].style.bottom = i*10+"px";	// offset = 10px
	scrollArrows[i].style.opacity = 0.33+(i*0.33);
}
// Init - Social Media Icons
let socialIcons = document.getElementsByClassName("social-icons");
for(let i=0; i<socialIcons.length; i++){
	socialIcons[i].id = srcSocialMedia[i].id;
	socialIcons[i].src = srcSocialMedia[i].src;
	socialIcons[i].style.opacity = 0.8;
}
// Init - Social Media Buttons
let socialButtons = document.getElementsByClassName("social-buttons");
for(let i=0; i<socialButtons.length; i++){
	socialButtons[i].style.left = 11+(i)*50+"px";	// offset = 50px
}

// Events
// Event - Scroll Down Button
document.getElementById("scroll-down-button").addEventListener("click",function(){
	$('html, body').animate({scrollTop: $("#main-page-container").offset().top}, 'slow');
});
// Event - Social Media Buttons
for(let i=0; i<socialButtons.length; i++){
	socialButtons[i].addEventListener("click", () => {
		setTimeout(() => {
			window.open(srcSocialMedia[i].url, "_blank");
		}, 200);
	});
}

// Effects
// Effect - Switching First Page Background
let image=1; fpbLayer=0;
let fpbSwitchInterval = setInterval(() => {		// TODO : Interval Must be terminated at some point
	fpbLayer = fpbLayer===0 ? 1 : 0;
	fpb[fpbLayer].style.backgroundImage = "url('"+srcBackground[image++]+"')";
	if(fpbLayer === 0){
		let opacity=1;
		let fpbFadeInterval = setInterval(() => {
			opacity -= 0.1;
			fpb[1].style.opacity = opacity;
			if(opacity <= 0){
				clearInterval(fpbFadeInterval);
			}
		},50);
	}
	else {
		let opacity=0;
		let fpbFadeInterval = setInterval(() => {
			opacity += 0.1;
			fpb[1].style.opacity = opacity;
			if(opacity >= 1)
				clearInterval(fpbFadeInterval);
		},50);
	}
	if(image===srcBackground.length)
		image=0;
}, 5000);
// Effect - First Page Heading
												// TODO : FIRST PAGE HEADING EFFECT CODE COMES HERE
// Effect - Scroll Down Arrow
let arrowFlag = [true,true,true];
let ArrowInterval = setInterval(() => {			// TODO: ArrowInterval Must be terminated at some point
	for(let i=0; i<scrollArrows.length; i++){
		let opacity = parseFloat(scrollArrows[i].style.opacity);
		if(opacity>=1 || opacity<=0.1)
			arrowFlag[i] = !arrowFlag[i];
		if(arrowFlag[i]) 
			scrollArrows[i].style.opacity = opacity+0.05;
		else
			scrollArrows[i].style.opacity = opacity-0.05;
	}
}, 50);
// Effect - Social Media Buttons
for(let i=0; i<socialButtons.length; i++){
	let zoomInInterval, zoomOutInterval;
	let zoomCnt = 0;
	let width = socialIcons[i].width;
	let height = socialIcons[i].height;
	let opacity = parseFloat(socialIcons[i].style.opacity);
	
	socialButtons[i].addEventListener("mouseover", () => {
		clearInterval(zoomOutInterval);
		zoomInInterval = setInterval(() => {
			zoomCnt++;
			socialIcons[i].style.width = width + zoomCnt + "px";
			socialIcons[i].style.height = height + zoomCnt + "px";
			socialIcons[i].style.opacity = opacity + (zoomCnt*0.02);
			if(zoomCnt>=10) 
				clearInterval(zoomInInterval);
			}, 10);
	});
	socialButtons[i].addEventListener("mouseout", () => {
		clearInterval(zoomInInterval);
		zoomOutInterval = setInterval(() => {
			zoomCnt--;
			socialIcons[i].style.width = width + zoomCnt + "px";
			socialIcons[i].style.height = height + zoomCnt + "px";
			socialIcons[i].style.opacity = opacity + (zoomCnt*0.02);
			if(zoomCnt<=0) 
				clearInterval(zoomOutInterval);
		}, 15);
	});
}
