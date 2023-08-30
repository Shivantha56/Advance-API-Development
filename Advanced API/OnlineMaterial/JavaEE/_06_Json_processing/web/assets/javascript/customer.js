$('#customerTable>tbody>.table-row').click(function () {

    console.log("table row triggered")

    $('#customerForm>input').empty();


    let id = $('#customerTable>tbody>tr:nth-child(1)>:nth-child(1)').text();
    let name = $('#customerTable>tbody>tr:nth-child(1)>td:nth-child(2)').text();
    let address = $('#customerTable>tbody>tr:nth-child(1)>td:nth-child(3)').text();
    let salary = $('#customerTable>tbody>tr:nth-child(1)>td:nth-child(4)').text();

    console.log(id+" "+name+" "+address+" "+salary);

    $('#customerId').val(id);
    $('#customerName').val(name);
    $('#customerAddress').val(address);
    $('#customerSalary').val(salary);



})




function loadTable() {

    $(".table-row").empty();
    $.ajax({
        url: "customerss",
        method: "GET",
        // data: serialize,
        dataType: "json",
        success: function (resp) {


            // console.log(resp);
            // $(".table-row").empty();


            for (let i in resp) {

                if (i == 0) {

                    let statusCode = resp[0].status;
                    let data = resp[0].data;
                    let message = resp[0].message;

                    console.log(statusCode+" "+data+" "+message);

                } else {

                    let customerId = resp[i].customerId;
                    let customerName = resp[i].customerName;
                    let customerAddress = resp[i].customerAddress;
                    let customerSalary = resp[i].customerSalary;

                    $('#customerTable>tbody').append(`<tr class="table-row"><td>${customerId}</td><td>${customerName}</td>
                                                <td>${customerAddress}</td><td>${customerSalary}</td></tr>`);

                }
            }

        }
    });
}


//save customer
$('#saveCustomer').click(function (e) {
    e.preventDefault();
    let serialize = $('#customerForm').serialize();
    console.log(serialize);

    $.ajax({
        url: "customerss",
        method: "POST",
        data: serialize,
        dataType: "json",
        success: function (resp) {
            console.log(resp);


            let customerId = resp.customerId;
            let customerName = resp.customerName;
            let customerAddress = resp.customerAddress;
            let customerSalary = resp.customerSalary;

            console.log(customerId, " ", customerName, " ", customerAddress, " ", customerSalary)

            $('#customerTable>tbody').append(`<tr><td>${customerId}</td><td>${customerName}</td>
                                                <td>${customerAddress}</td><td>${customerSalary}</td></tr>`);
        },
        error: function (ob, data, message) {

            console.log("ob :", ob);
            console.log("data :", data);
            console.log("message :", message);

        }
    });

});

// get Customer

$('#getAllCustomer').click(function (e) {
    e.preventDefault();
    let serialize = $('#customerForm').serialize();
    console.log(serialize);

    $.ajax({
        url: "customerss",
        method: "GET",
        data: serialize,
        dataType: "json",
        success: function (resp) {


            console.log(resp);
            $(".table-row").empty();


            for (let i in resp) {

                if (i == 0) {

                    let statusCode = resp[0].status;
                    let data = resp[0].data;
                    let message = resp[0].message;

                    console.log(statusCode+" "+data+" "+message);

                } else {

                    let customerId = resp[i].customerId;
                    let customerName = resp[i].customerName;
                    let customerAddress = resp[i].customerAddress;
                    let customerSalary = resp[i].customerSalary;

                    $('#customerTable>tbody').append(`<tr class="table-row"><td>${customerId}</td><td>${customerName}</td>
                                                <td>${customerAddress}</td><td>${customerSalary}</td></tr>`);

                }
            }

        }
    });

});

//delete customer
$('#deleteCustomer').click(function (e) {
    e.preventDefault();
    let cusId = $("#customerId").val();

    $.ajax({
        url: "customerss?customerId=" + cusId,
        method: "DELETE",
        // data: cusId,
        // dataType: "json",
        success: function (resp) {
            console.log(resp);
            loadTable();
        }
    });


});


// update customer
$('#updateCustomer').click(function (e) {
    e.preventDefault();

    let customerId = $('#customerId').val();
    let customerName = $('#customerName').val();
    let customerAddress = $('#customerAddress').val();
    let customerSalary = $('#customerSalary').val();

    let query = "customerId=" + customerId + "&customerName=" + customerName + "&customerAddress=" + customerAddress + "&customerSalary=" + customerSalary;


    let json = JSON.stringify({"customerID":customerId,"customerName":customerName,"customerAddress":customerAddress,"customerSalary":customerSalary});
    console.log(json);

    console.log(query)

    $.ajax({
        url: "customerss",
        method: "PUT",
        contentType:"application/json",
        data:json,
        success: function (resp) {
            console.log(resp);
            loadTable();
        }
    });

});
