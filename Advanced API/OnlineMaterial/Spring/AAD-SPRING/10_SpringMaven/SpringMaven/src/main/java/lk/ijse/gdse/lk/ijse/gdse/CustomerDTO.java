package lk.ijse.gdse.lk.ijse.gdse;

public class CustomerDTO {
    private String name;
    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
