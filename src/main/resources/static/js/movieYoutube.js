//-------------------------------------
//MAIN-01 BANNER BACKGROUND
//-------------------------------------
const Bgswiper = new Swiper('.main-01 .swiper', {
// Optional parameters
direction: 'horizontal', //수평 슬라이드(기본)
loop: true,

// If we need pagination
pagination: {
    el: '.swiper-pagination',
    type:'bullets',     //added ------ bullets,progressbar,fraction
    clickable:'true'    //added ------
},

// Navigation arrows
navigation: {
    nextEl: '.swiper-button-next',
    prevEl: '.swiper-button-prev',
},

// And if we need scrollbar
scrollbar: {
    el: '.swiper-scrollbar',
},

//---Added...
autoplay:{            //시작시 바로 재생 여부
    delay:5000,
    disableOnInteraction:false //사용자의 action에 따른 슬라이드 동작 정지여부
},
//---Added... 마우스 휠 효과
mousewheel:false,
// effect : 'fade',
speed:1000,
});

//-------------------------------------
//MAIN-02 BANNER BACKGROUND
//-------------------------------------
const main_02swiper = new Swiper('.main-02 .swiper', {
direction:'horizontal', //수평 슬라이드(기본)
autoplay:{            //시작시 바로 재생 여부
    delay:2000,
    disableOnInteraction:false //사용자의 action에 따른 슬라이드 동작 정지여부
},
loop:true, //무한재생

slidesPerView:5,  //한번에 보여주는 slide개수
spaceBetween:0,   //slide 간격 (px)
centeredSlides:true,

// // navigation
navigation:{
    prevEl:'.swiper-button-prev',
    nextEl:'.swiper-button-next'
},
});
