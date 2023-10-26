<!-- 로그인 성공,실패 alert 메시지 -->
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
                            window.location.href = "/main"; // 로그인 후 이동할 URL
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