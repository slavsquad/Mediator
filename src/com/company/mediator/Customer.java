package com.company.mediator;

public class Customer {
    private String name;
    private String lastName;
    private int age;
    private boolean married;
    private String partnerName;
    private String partnerLastName;
    private boolean employment;
    private String company;
    private String position;
    private String otherInfo;

    public Customer() {
        name = "customer";
        lastName = "New";
        age = 12;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getName() {
        return name;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerLastName() {
        return partnerLastName;
    }

    public void setPartnerLastName(String partnerLastName) {
        this.partnerLastName = partnerLastName;
    }

    public boolean isEmployment() {
        return employment;
    }

    public void setEmployment(boolean employment) {
        this.employment = employment;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return lastName +" "+name;
    }
}