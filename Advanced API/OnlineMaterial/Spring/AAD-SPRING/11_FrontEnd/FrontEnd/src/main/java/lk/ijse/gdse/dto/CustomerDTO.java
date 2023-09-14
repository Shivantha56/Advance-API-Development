package lk.ijse.gdse.dto;

public class CustomerDTO {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerSalary;

    public CustomerDTO() {
    }

    public CustomerDTO(String customerId, String customerName, String customerAddress, String customerSalary) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(String customerSalary) {
        this.customerSalary = customerSalary;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary='" + customerSalary + '\'' +
                '}';
    }
}
