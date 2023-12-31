function loadTable() {

    $(".table-row").empty();

    $.ajax({
        url: "customerss",
        method: "GET",
        // data: serialize,
        dataType: "json",
        success: function (resp) {


            console.log(resp);

            for (const i in resp) {
                let customerId = resp[i].customerId;
                let customerName = resp[i].customerName;
                let customerAddress = resp[i].customerAddress;
                let customerSalary = resp[i].customerSalary;

                $('#customerTable>tbody').append(`<tr class="table-row"><td>${customerId}</td><td>${customerName}</td>
                                                <td>${customerAddress}</td><td>${customerSalary}</td></tr>`);

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
            success: function (resp) {
                console.log(resp);


                let customerId = resp.customerId;
                let customerName = resp.customerName;
                let customerAddress = resp.customerAddress;
                let customerSalary = resp.customerSalary;

                console.log(customerId, " ", customerName, " ", customerAddress, " ", customerSalary)

                $('#customerTable>tbody').append(`<tr><td>${customerId}</td><td>${customerName}</td>
                                                <td>${customerAddress}</td><td>${customerSalary}</td></tr>`);
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

                for (const i in resp) {
                    let customerId = resp[i].customerId;
                    let customerName = resp[i].customerName;
                    let customerAddress = resp[i].customerAddress;
                    let customerSalary = resp[i].customerSalary;

                    $('#customerTable>tbody').append(`<tr class="table-row"><td>${customerId}</td><td>${customerName}</td>
                                                <td>${customerAddress}</td><td>${customerSalary}</td></tr>`);

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

    let query = "customerId="+customerId+"&customerName="+customerName+"&customerAddress="+customerAddress+"&customerSalary="+customerSalary;
    console.log(query)

    $.ajax({
        url: "customerss?"+query,
        method: "PUT",
        success: function (resp) {
            console.log(resp);
            loadTable();
        }
    });

});
