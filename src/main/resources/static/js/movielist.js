    $(document).ready(function(){
        var moveForm = $("#moveForm");

        $(".move").on("click", function(e){
            e.preventDefault();

            moveForm.append("<input type='hidden' name='movieId' value='"+ $(this).attr("href")+"'>");
            moveForm.attr("action", "/main");
            moveForm.submit();
        });

        $(".pageInfo_area a").on("click", function(e){
            e.preventDefault();

            var pageNum = parseInt($(this).text());

            if(!isNaN(pageNum)){
                $("input[name='pageNum']").val(pageNum);
                $("#moveForm").attr("action", "/movielist");
                $("#moveForm").submit();
            }
        });
    });
    $(".previous a, .next a").on("click", function(e){
        e.preventDefault();

        var pageNum = $(this).attr('href').match(/pageNum=(\d+)/)[1];

        if(pageNum){
            $("input[name='pageNum']").val(pageNum);
            $("#moveForm").attr("action", "movielist");
            $("#moveForm").submit();
        }
    });
});