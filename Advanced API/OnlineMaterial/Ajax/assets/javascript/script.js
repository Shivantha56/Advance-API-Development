



document.getElementById("btn").addEventListener("click",function () {


    console.log("Request started")

    var http = new XMLHttpRequest();
    console.log(http.readyState, "After the html Object");

    http.open("GET","/Advanced API/OnlineMaterial/Ajax/db/db.txt")
    console.log(http.readyState, "After the html open");

    http.send();
    console.log(http.readyState, "After the html send");

    console.log(http.responseText);
    console.log(http.readyState, "After the html response");

    http.onreadystatechange = function (){
        console.log(http.readyState, "Inside on ready state");
        console.log(http.response);

    }

    console.log("Request finished")

})