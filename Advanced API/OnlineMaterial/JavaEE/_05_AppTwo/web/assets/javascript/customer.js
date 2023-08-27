//save customer
$('#saveCustomer').click(function (e) {
    e.preventDefault();
    let serialize = $('#customerForm').serialize();
    console.log(serialize);

    $.ajax({
        url:"customerss",
        method:"POST",
        data:serialize,
        success:function (resp) {
            console.log(resp);

            for (const i in resp) {
                let customerId = resp[i].customerId;
                let customerName = resp[i].customerName;
                let customerAddress = resp[i].customerAddress;
                let customerSalary = resp[i].customerSalary;

                console.log(customerId ," ",customerName," ",customerAddress," ",customerSalary)
            }

        }
    });



});