package com.example.traviling;

public class Traveling {
    private String Name;
    private String description;
    private String address;
    private String phone;
    private String photo;


    public Traveling(String Name, String description, String address, String phone,String photo) {
        this.Name = Name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.photo=photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(Traveling description) {
        this.description = String.valueOf(description);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhoto(){return photo;}
    public void setPhoto(){this.photo=photo;}

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + Name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
