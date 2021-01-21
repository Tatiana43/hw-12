package ru.netology.domain;

public class Smartphone extends Product {
    private String productionCompany;

    public Smartphone() {
        super();
    }
    public Smartphone(int id, String name, int price, String productionCompany) {
        super(id, name, price);
        this.productionCompany = productionCompany;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

}
