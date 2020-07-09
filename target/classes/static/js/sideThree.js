$("#b_name").blur(function () {
    const null_reg=/^\s*$/g;
    const name = $("#b_name").val();
    if(null_reg.test(name)==false){
        $("#name_err").html("<font class='corr'>√</font>")
    }else{
        $("#name_err").html("<font class='err'>请填写书名</font>")
    }
});
$("#b_author").blur(function () {
    const null_reg=/^\s*$/g;
    const name = $("#b_author").val();
    if(null_reg.test(name)==false){
        $("#author_err").html("<font class='corr'>√</font>")
    }else{
        $("#author_err").html("<font class='err'>请填写作者名</font>")
    }
});
function insertBookInfo() {
    const b_name=$("#b_name").val();
    const b_author=$("#b_author").val();
    const bookList={"b_name":b_name,"b_author":b_author};
    $.ajax({
        url:"/insertBookInfo",
        type: "post",
        data: bookList,
        success:function(data) {
            if(data=="true"){
                alert("添加成功！");
                return true;
            }else{
                alert("添加失败！");
                return false;
            }
        }
    });
}