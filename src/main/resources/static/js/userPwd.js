/* 유효성 검사 통과유무 변수 */
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
               url: '/member/passCheck',
               type: 'POST',
               contentType : 'application/json',
               data: JSON.stringify ({
                      userId: userId,
                      userPw: nowPw
                  }),
               success: function(data) {
                   if(data == "success") {
                       //현재 비밀번호가 일치하면, 새로운 비밀번호로 업데이트 요청을 보냅니다.
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
  $(".pwd-update-cancle-btn").click(function(){
    window.location.href = "/member/userInfo";
  });
});