//json object
$("#button03").click(function () {

    $("#table02>tr").empty();

    $.ajax({
        url: "customer",
        method:"GET",
        dataType:"json",
        success: function (resp) {
            console.log(resp);
            console.log(typeof(resp))

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

$("#button04").click(function () {

    $("#table02>tr").empty();

    $.ajax({
        url: "item",
        method:"GET",
        dataType:"json",
        success: function (resp) {
            console.log(resp);
            console.log(typeof(resp));

            for (const i in resp) {
                let id = resp[i].id;
                let name = resp[i].name;
                let price = resp[i].price;

                $("#table03").append(" <tr>\n" +
                    `        <td>${id}</td>\n` +
                    `        <td>${name}</td>\n` +
                    `        <td>${price}</td>\n` +
                    "    </tr>");

            }


        },
        error: function (err) {
            console.log(err)
        },
        async: true
    });


});



$('#btn04').click(function () {
    // let name = $("#name").val();
    // let address = $('#address').val();
    // let email = $('#email').val();
    let data = $("#customerForm").serialize();
    console.log(data);
   // let json = "{\"name\":name,"address":address,email:email}"

    $.ajax({
        url:"customer",
        method:"POST",
        data:data,
        dataType:"json",
        success:function (resp) {
            console.log(resp);
            for (const i in resp) {
                let id = resp[i].name;
                let name = resp[i].address;
                let price = resp[i].email;

                $("#table03").append(" <tr>\n" +
                    `        <td>${id}</td>\n` +
                    `        <td>${name}</td>\n` +
                    `        <td>${price}</td>\n` +
                    "    </tr>");

            }
        }
    });


});


$('#btn05').click(function () {
    let name = $("#name").val();
    // let address = $('#address').val();
    // let email = $('#email').val();
    // let data = $("#customerForm").serialize();
    // console.log(data);
    // let json = "{\"name\":name,"address":address,email:email}"

    $.ajax({
        url:"customer?cusName="+name,
        method:"DELETE",
        // data:data,
        dataType:"json",
        success:function (resp) {
            // console.log(resp);
            // for (const i in resp) {
            //     let id = resp[i].name;
            //     let name = resp[i].address;
            //     let price = resp[i].email;
            //
            //     $("#table03").append(" <tr>\n" +
            //         `        <td>${id}</td>\n` +
            //         `        <td>${name}</td>\n` +
            //         `        <td>${price}</td>\n` +
            //         "    </tr>");
            //
            // }
        }
    });


});


// 


