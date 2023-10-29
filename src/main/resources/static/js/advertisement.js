// TOP 누르면 최상단 이동
const toTopBtn_el = document.getElementById('to_top');
toTopBtn_el.addEventListener('click',function(){
    window.scrollTo({top:0,behavior:'smooth'})
})

// 스크롤시 메뉴 따라오기
// 좌측 광고
$(window).scroll(function(){
    var scrollTop = $(document).scrollTop();
    if (scrollTop < 300) {
    scrollTop = 300;
}
$(".left_section").stop();
$(".left_section").animate( { "top" : scrollTop });
});

// 우측 퀵메뉴
$(window).scroll(function(){
    var scrollTop = $(document).scrollTop();
    if (scrollTop < 200) {
    scrollTop = 200;
    }
$(".quick_section").stop();
$(".quick_section").animate( { "top" : scrollTop });
});

// x표시 광고 끄기
// 버튼과 광고 요소 선택
const bannerCloseButton = document.querySelector('.banner_close');
const leftBanner = document.querySelector('.left_banner');

// 버튼 클릭 시 광고 숨기기
bannerCloseButton.addEventListener('click', function () {
    leftBanner.style.display = 'none';
    bannerCloseButton.style.display = 'none';
});