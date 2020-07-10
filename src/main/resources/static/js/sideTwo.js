/**
 * 分页
 */

let param;
let pageNum; //当前页
let nextPage; //下一页
let hasNextPage;//当前页下一页
let pages; //总页数
let total; //总信息数
let hasPreviousPage;//当前页上一页
let prePage;//初始页
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
                //遍历bookInfo ，append tbody
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
//首页
function homePage(){
    getBookListPage("");
}
//上一页
function previousPage(){
    param = hasPreviousPage?prePage:1;
    getBookListPage(param);
}
//下一页
function nextPages(){
    param = hasNextPage?nextPage:pages;
    getBookListPage(param);
}
//尾页
function lastPage(){
    param = pages;
    getBookListPage(param);
}