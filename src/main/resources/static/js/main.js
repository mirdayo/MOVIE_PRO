// top-banner
const top_banner_btn_el = document.querySelector('.top-banner-btn');
top_banner_btn_el.addEventListener('click',function(){
const top_banner_el = document.querySelector('.top-banner');
top_banner_el.style.display="none";
});

// 스크롤시 네비 이동
//lodash's _.throttle(함수,지연시간) 사용
const nav_el = document.querySelector('nav');

window.addEventListener('scroll',_.throttle(function(){
    console.log("scroll_event's Y : " ,window.scrollY);

    if(window.scrollY>80){

        nav_el.style.position='fixed';
        nav_el.style.top="0px";
        nav_el.style.left="0px";
        nav_el.style.zIndex="10";
        nav_el.style.width="100%";

    }else{
        nav_el.style.position='relative';
    }
},300))
