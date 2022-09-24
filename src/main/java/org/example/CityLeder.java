package org.example;

public class CityLeder {
    private int id;
    private String name;
    private String positioin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositioin() {
        return positioin;
    }

    public void setPositioin(String positioin) {
        this.positioin = positioin;
    }

    @Override
    public String toString() {
        return "CityLeder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", positioin='" + positioin + '\'' +
                '}';
    }
}
