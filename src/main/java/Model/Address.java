package Model;

public class Address {

    private String street;
    private String postalCode;
    private String phone;
    private String district;

    public Address(String street, String postalCode, String phone, String district) {
        this.street = street;
        this.postalCode = postalCode;
        this.phone = phone;
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getDistrict() {
        return district;
    }
}
