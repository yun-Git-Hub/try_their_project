function side1(){
    document.getElementById("li_1").style.backgroundColor="black";
    document.getElementById("li_2").style.backgroundColor="";
    document.getElementById("li_3").style.backgroundColor="";
    document.getElementById("li_4").style.backgroundColor="";
    document.getElementById("li_5").style.backgroundColor="";
    document.getElementById("li_6").style.backgroundColor="";
    $("#text1").load("sideOne");
    document.getElementById("text1").style.display="flex";
    document.getElementById("text1").style.textAlign="left";
    document.getElementById("text1").style.paddingTop="0px";
}
function side2(){
    document.getElementById("li_1").style.backgroundColor="";
    document.getElementById("li_2").style.backgroundColor="black";
    document.getElementById("li_3").style.backgroundColor="";
    document.getElementById("li_4").style.backgroundColor="";
    document.getElementById("li_5").style.backgroundColor="";
    document.getElementById("li_6").style.backgroundColor="";
    $("#text1").load("sideTwo");

    document.getElementById("text1").style.display="flex";
    document.getElementById("text1").style.textAlign="left";
    document.getElementById("text1").style.paddingTop="0px";
}
function side3(){
    document.getElementById("li_1").style.backgroundColor="";
    document.getElementById("li_2").style.backgroundColor="";
    document.getElementById("li_3").style.backgroundColor="black";
    document.getElementById("li_4").style.backgroundColor="";
    document.getElementById("li_5").style.backgroundColor="";
    document.getElementById("li_6").style.backgroundColor="";
    $("#text1").load("sideThree");

    document.getElementById("text1").style.display="flex";
    document.getElementById("text1").style.textAlign="left";
    document.getElementById("text1").style.paddingTop="0px";
}