//text file
$("#button01").click(function () {

    $.ajax({
        url: "db/db.txt",
        success: function (resp) {
            console.log(resp)
            $("#display01").text(resp);
        },
        error: function (err) {
            console.log(err)
        },
        async: true
    });

});

//XML object
$("#button02").click(function () {
    $("#table01>tr").empty();
    $.ajax({
        url: "http://localhost:8080/GDSE02/hello",
        method:"POST",
        success: function (resp) {

        },
        error: function (err) {
            console.log(err)
        },
        async: true
    });
});

//json object
$("#button03").click(function () {

    $("#table02>tr").empty();

    $.ajax({
        url: "db/db.json",
        success: function (resp) {
            console.log(resp);

            for (const i in resp) {
                let id = resp[i].id;
                let name = resp[i].name;
                let address = resp[i].address;

                $("#table02").append(" <tr>\n" +
                    `        <td>${id}</td>\n` +
                    `        <td>${name}</td>\n` +
                    `        <td>${address}</td>\n` +
                    "    </tr>");

            }


        },
        error: function (err) {
            console.log(err)
        },
        async: true
    });


});





