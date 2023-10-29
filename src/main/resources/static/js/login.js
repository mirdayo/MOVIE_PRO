//회원 비회원 전환 버튼
const memberBtn = document.querySelector(".tab-member-btn");
const nonmemberBtn = document.querySelector(".tab-nonmember-btn");
const loginBox = document.querySelector(".login-box");
const nonloginBox = document.querySelector(".non-login-box");

memberBtn.addEventListener("click", function() {
loginBox.style.display = "block";
nonloginBox.style.display = "none";
memberBtn.style.borderBottom = "2px solid black";
nonmemberBtn.style.borderBottom = "2px solid lightgray";
});

nonmemberBtn.addEventListener("click", function() {
loginBox.style.display = "none";
nonloginBox.style.display = "block";
memberBtn.style.borderBottom = "2px solid lightgray";
nonmemberBtn.style.borderBottom = "2px solid black";
});

// 로그인 성공,실패 alert 메시지
$(document).ready(function(){
    $("#login_form").submit(function(e){
        e.preventDefault(); //기본 form submit 동작을 막기

        var userId = $("#userId").val();
        var userPw = $("#userPw").val();

        $.ajax({
            type: "POST",
            url: "/member/loginrequest", // 실제 로그인 처리를 하는 URL
            data: {
                userId: userId,
                userPw: userPw
            },
            success: function(response) {
                //서버에서 로그인 성공 메시지를 반환했다고 가정
                if(response == "success") {
                    Swal.fire({
                        icon: 'success',
                        title: '로그인에 성공하였습니다.',
                        confirmButtonText: '확인'
                    }).then((result) => {
                        if (result.isConfirmed) {
                            window.location.href = "/index"; // 로그인 후 이동할 URL
                        }
                    });
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: '로그인에 실패하였습니다.',
                        text:'아이디 혹은 비밀번호가 잘못되었습니다.',
                        confirmButtonText: '확인'
                    });
                }
            },
            error:function(request,status,error){
                Swal.fire({
                    icon: 'error',
                    title: '로그인에 실패하였습니다.',
                    text:("code:"+request.status + " 오류로 인해 로그인이 실패하였습니다."),
                    confirmButtonText: '확인'
                });
           }
        });
    });
});


// 하단 광고 이미지 랜덤 표시
let bottomBanner = Math.floor(Math.random() * 3);
let imgName = ['RUBYGILLMAN_980180', 'Conan_980180', 'Metamorphosis_980180'];
$('.bot_banner').children('a').children('img').attr('src', '/image/' + imgName[bottomBanner] + '.jpg');

// 생년월일 선택자
const yearSelect = document.getElementById('year-select');
const monthSelect = document.getElementById('month-select');
const daySelect = document.getElementById('day-select');

 // 연도 범위 설정 (예: 1900-2023)
const startYear = 1900;
const endYear = 2023;

 // 연도 <select> 채우기
for (let year = startYear; year <= endYear; year++) {
 const option = document.createElement('option');
 option.value = year;
 option.textContent = year;
 yearSelect.appendChild(option);
}

 // 월 <select> 채우기
for (let month = 1; month <= 12; month++) {
 const option = document.createElement('option');
 option.value = month;
 option.textContent = month;
 monthSelect.appendChild(option);
}

 // 일 <select> 채우기
function fillDaySelect(days) {
 daySelect.innerHTML = '';
 for (let day = 1; day <= days; day++) {
   const option = document.createElement('option');
   option.value = day;
   option.textContent = day;
   daySelect.appendChild(option);
 }
}

 // 기본값으로 31일로 설정
fillDaySelect(31);

 // 월을 선택하면 대응하는 일 수로 변경
monthSelect.addEventListener('change', function () {
 const selectedMonth = this.value;
 let days;
 if (selectedMonth === '2') {
   days = 28; // 윤년 계산은 생략
 } else if (['4', '6', '9', '11'].includes(selectedMonth)) {
   days = 30;
 } else {
   days = 31;
 }
 fillDaySelect(days);
});

// 우측 광고 이미지 넘기기
const swiper_vertical = new Swiper(".f-section .swiper", {
 // Optional parameters
 direction: "vertical",
 autoplay: {
   delay: 1000,
 },
 loop: true,
});
