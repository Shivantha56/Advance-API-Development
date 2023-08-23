



document.getElementById("btn").addEventListener("click",function () {


    console.log("Request started")

    let http = new XMLHttpRequest();
    // console.log(http.readyState, "After the html Object");
    // console.log(http.status, "After the html Object");//prints the response status code
    //
    http.open("GET","/Advanced API/OnlineMaterial/Ajax/db/db.txt",true);// false = synchronous (blocking)
    // console.log(http.status);
    // console.log(http.readyState, "After the html open");
    //
    http.send();
    // console.log(http.status);

    // console.log(http.readyState, "After the html send");
    //
    // console.log(http.responseText);
    // console.log(http.readyState, "After the html response");

    // http.onreadystatechange = function (){
    //     console.log(http.readyState);
    //     console.log(http.status);
    //     console.log(http.response);
    //     if (http.readyState === 4 && http.status === 200){
    //         console.log(http.response);
    //         document.getElementById("desc").innerText = http.responseText;
    //     }
    //
    // }


    console.log(http.responseText);
    console.log("Request finished")

})