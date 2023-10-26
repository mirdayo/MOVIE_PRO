//회원 정보 수정,탈퇴 페이지 전환
$(document).ready(function() {
    // 페이지 로딩 시 모든 섹션을 숨깁니다.
    $('.userChange').hide();
    $('.userWithdraw').hide();

    // '회원 정보 변경' 버튼 클릭 시
    $('.tab-update').click(function() {
        // 회원 정보 변경 섹션만 보이고 나머지는 숨깁니다.
        $('.userChange').show();
        $('.userWithdraw').hide();

        // URL 변경
        history.pushState(null, null, '/member/userInfo/update');
    });

    // '회원 탈퇴' 버튼 클릭 시
    $('.tab-delete').click(function() {
        // 회원 탈퇴 섹션만 보이고 나머지는 숨깁니다.
        $('.userChange').hide();
        $('.userWithdraw').show();

        // URL 변경
        history.pushState(null, null, '/member/userInfo/delete');
    });
});

//회원 탈퇴 기능
$(document).ready(function(){
   $('.delete-btn').on('click', function(event) {
       event.preventDefault();

        if ($('#userDeleteChk').is(':checked')) {

            //input DTO
            var userId = $("#userId").val();

            $.ajax({
                url: '/member/userInfo/delete',
                type: 'POST',
                data: { userId: userId },
                success: function(data) {
                    // 성공 시 처리
                    alert('회원탈퇴가 성공적으로 진행되었습니다!');
                    window.location.href = "/main";
                },
                error: function(err) {
                    // 실패 시 처리
                    console.error(err);
                    alert('요청이 실패했습니다.');
                }
            });
        } else {
           alert('sssss');
        }
    })
});

/* 유효성 검사 통과유무 변수 */
var nameCheck = false;            // 이름
var phoneCheck = false;            // 휴대폰번호
var addressCheck = false;         // 주소
var pwCheck = false;            // 비번
var pwckCheck = false;            // 비번 확인
var pwckcorCheck = false;        // 비번 확인 일치 확인

//패스워드 수정 기능
$(document).ready(function(){
    $('#pw-update-form').on('submit', function(event) {
      event.preventDefault();

        //input DTO
        var nowPw = $("#nowPw").val();
        var userId = $("#userId").val();
        var userPw = $("#userPw").val();

        //유효성 검사 변수
        var pw = $('.pw_input').val();       // 비밀번호 입력란
        var pwck = $('.pwck_input').val();   // 비밀번호 확인 입력란

        //새로운 비밀번호 유효성 검사
        if(pw == ""){
            $('.final_pw_ck').css('display','block');
            pwCheck = false;
        }else{
            $('.final_pw_ck').css('display', 'none');
            pwCheck = true;
        }

        //새로운 비밀번호 확인 유효성 검사
        if(pwck == "") {
            $('.final_pwck_ck').css('display','block');
            pwckCheck = false;
        }else{
            $('.final_pwck_ck').css('display', 'none');
            pwckCheck = true;
        }

        //최종 확인
        if(pwCheck&&pwckCheck&&pwckcorCheck  == true) {
           //현재 비밀번호 일치 확인
           $.ajax({
               url: '/member/userInfo/passCheck',
               type: 'POST',
               contentType : 'application/json',
               data: JSON.stringify ({
                      userId: userId,
                      userPw: nowPw
                  }),
               success: function(data) {
                   if(data == "success") {
                       // 현재 비밀번호가 일치하면, 새로운 비밀번호로 업데이트 요청을 보냅니다.
                       $.ajax({
                           url: '/member/userInfo/update',
                           type: 'POST',
                           contentType : 'application/json',
                           data: JSON.stringify ({
                               userId: userId,
                               userPw: userPw
                           }),
                           success:function(data){
                               alert('비밀번호 변경에 성공했습니다.');
                               window.location.href = "/member/userInfo";
                           },
                           error:function(err){
                               console.error(err);
                               alert('비밀번호 변경 요청이 실패했습니다.');
                           }
                       });
                   } else {
                       alert('현재 비밀번호가 일치하지 않습니다. 다시 입력해주세요.');
                   }
               },
               error:function(err){
                  console.error(err);
                  alert('현재 비밀번호 확인 요청이 실패했습니다.');
              }
          });
       };
   });
});


//이름 수정 기능
$(document).ready(function(){
   $('#name-update-form').on('submit', function(event) {
       event.preventDefault();

            //input DTO
            var userId = $("#userId").val();
            var userName = $("#userName").val();
            //유효성 검사 변수
            var name = $('.user_input').val();

            //이름 유효성 검사
            if(name == ""){
                $('.final_name_ck').css('display','block');
                nameCheck = false;
            }else{
                $('.final_name_ck').css('display', 'none');
                nameCheck = true;
            }
            if(nameCheck == true) {
                $.ajax({
                    url: '/member/userInfo/update',
                    type: 'POST',
                    contentType : 'application/json',
                    data: JSON.stringify ({
                            userId: userId,
                            userName: userName }),
                    success: function(data) {
                        // 성공 시 처리
                        alert('성공함');
                    },
                    error: function(err) {
                        // 실패 시 처리
                        console.error(err);
                        alert('요청이 실패했습니다.');
                    }
                });
            }else {
              //통과 실패시 구문
              alert('유효성 통과 실패');
           }
    })
});

//휴대폰 번호 수정 기능
$(document).ready(function(){
  $('#phone-update-form').on('submit', function(event) {
         event.preventDefault();

            //input DTO
            var userId = $("#userId").val();
            var userPhone = $("#userPhone").val();
            //유효성 검사 변수
            var phone = $('.phone_input').val();

            //phone 유효성 검사
            if(phone == ""){
                $('.final_phone_ck').css('display','block');
                phoneCheck = false;
            }else{
                $('.final_phone_ck').css('display', 'none');
                phoneCheck = true;
            }

            if(phoneCheck == true) {
                $.ajax({
                    url: '/member/userInfo/update',
                    type: 'POST',
                    contentType : 'application/json',
                    data: JSON.stringify ({ userId: userId,
                            userPhone: userPhone }),
                    success: function(data) {
                        // 성공 시 처리
                        alert('성공함');
                    },
                    error: function(err) {
                        // 실패 시 처리
                        console.error(err);
                        alert('요청이 실패했습니다.');
                    }
                });
            } else {
                //통과 실패시 구문
                alert('유효성 통과 실패');
            }
    })
});

//주소 수정 기능
$(document).ready(function(){
   $('#addr-update-form').on('submit', function(event) {
          event.preventDefault();

            //input DTO
            var userId = $("#userId").val();
            var userAddr1 = $("input[name=userAddr1]").val();
            var userAddr2 = $("input[name=userAddr2]").val();
            var userAddr3 = $("input[name=userAddr3]").val();

            //유효성 검사 변수
            var addr = $('.address_input_3').val();        //주소 입력란

            //주소 유효성 검사
            if(addr == ""){
                $('.final_addr_ck').css('display','block');
                addressCheck = false;
            }else{
                $('.final_addr_ck').css('display', 'none');
                addressCheck = true;
            }

            if(addressCheck == true) {
                $.ajax({
                    url: '/member/userInfo/update',
                    type: 'POST',
                    contentType : 'application/json',
                    data: JSON.stringify ({
                            userId: userId,
                            userAddr1: userAddr1,
                            userAddr2: userAddr2,
                            userAddr3: userAddr3 }),
                    success: function(data) {
                        // 성공 시 처리
                        alert('성공함');
                    },
                    error: function(err) {
                        // 실패 시 처리
                        console.error(err);
                        alert('요청이 실패했습니다.');
                    }
                });
            } else {
                //통과 실패시 구문
                alert('유효성 검사 실패');
            }
    })
});

//비밀번호 확인 일치 유효성 검사
$('.pwck_input').on("propertychange change keyup paste input", function(){

    var pw = $('.pw_input').val();
    var pwck = $('.pwck_input').val();
    $('.final_pwck_ck').css('display', 'none');

    if(pw == pwck){
        $('.pwck_input_re_1').css('display','block');
        $('.pwck_input_re_2').css('display','none');
        pwckcorCheck = true;
    }else{
        $('.pwck_input_re_1').css('display','none');
        $('.pwck_input_re_2').css('display','block');
        pwckcorCheck = false;
    }
});

//나가기 버튼 누를시 인포페이지로 돌아가게
$(document).ready(function(){
  $(".delete-cancle-btn").click(function(){
    window.location.href = "/member/userInfo";
  });
});

$(document).ready(function(){
  $(".update-cancle-btn").click(function(){
    window.location.href = "/member/userInfo";
  });
});
