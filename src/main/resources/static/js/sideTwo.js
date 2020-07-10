let param;
let pageNum;
let nextPage;
let hasNextPage;
let pages;
let total;
let hasPreviousPage;
let prePage;
function removeTbody(){
    //清空tbody中的内容
    const $data = $(".bookBody");
    for (let a = $data.length - 1; a >= 0;a--) {
        $($data[a]).remove();
    }
    $("#book_Info").append("<tbody class='bookBody'></tbody>")
}
function getBookListPage(param){
    $.ajax({
        url: "/sideTwoPage",
        type: "POST",
        data: {"pageNum":param},
        success:function(data){
            console.log(data);
            removeTbody();
            $.each(data['bookList'],function(i,d){
                $(".bookBody").append(
                    "<tr><td>"+d['b_id']+"</td><td>"+d['b_name']+"</td><td>"+d['b_author']+"</td><td>"+d['b_time']+"</td></tr>"
                )
            })
            pageNum=data.pageInfo["pageNum"];
            pages=data.pageInfo["pages"];
            total=data.pageInfo["total"];
            hasNextPage=data.pageInfo["hasNextPage"];
            nextPage=data.pageInfo["nextPage"];
            hasPreviousPage=data.pageInfo["hasPreviousPage"];
            prePage=data.pageInfo["prePage"];
            $(".pageNum").html(pageNum);
            $(".pages").html(pages);
            $(".total").html(total);
        }
    });
}
$(function(){
    getBookListPage("");
})

function homePage(){
    getBookListPage("");
}
function previousPage(){
    param = hasPreviousPage?prePage:1;
    getBookListPage(param);
}
function nextPages(){
    param = hasNextPage?nextPage:pages;
    getBookListPage(param);
}
function lastPage(){
    param = pages;
    getBookListPage(param);
}