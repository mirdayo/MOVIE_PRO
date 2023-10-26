
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

        //-------------------------------------
        //
        //-------------------------------------
        const nav_el = document.querySelector('nav');


        //lodash's _.throttle(함수,지연시간) 사용
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

        <!-- top-banner -->
        const top_banner_btn_el = document.querySelector('.top-banner-btn');
        top_banner_btn_el.addEventListener('click',function(){
            const top_banner_el = document.querySelector('.top-banner');
            top_banner_el.style.display="none";
        });

        fetch('/checkLogin')
            .then(response => response.json())
            .then(data => {
                // Set the value of 'isLoggedIn' variable based on the server's response.
                let isLoggedIn = data.isLoggedIn;

                let link = document.querySelector('#membership_link');

                link.addEventListener('click', function(event) {
                    event.preventDefault();

                    if (isLoggedIn) {
                        // If the user is logged in,
                        // move to the next page
                        window.location.href = '/member/userInfo';
                    } else {
                        // If the user is not logged in,
                        // show a popup and do not move to the next page
                        alert("로그인이 필요한 서비스입니다.");
                    }
               });
        });