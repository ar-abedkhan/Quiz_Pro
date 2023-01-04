package com.abedkhan.quizpro;

public class country_data {

    String countryname,population,area,map;


    public country_data(String countryname, String population, String area, String map) {
        this.countryname = countryname;
        this.population = population;
        this.area = area;
        this.map = map;
    }


    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
