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

//json object
$("#button03").click(function () {

    $("#table02>tr").empty();

    $.ajax({
        url: "customer",
        method:"GET",
        dataType:"json",
        success: function (resp) {
            console.log(resp);

            for (const i in resp) {
                let id = resp[i].fName;
                let name = resp[i].lName;
                let address = resp[i].email;

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





