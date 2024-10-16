package org.lesson10;

import java.util.ArrayList;
import java.util.List;

public class Park {

    String name;

    public Park(String nameP) {
        name = nameP;
    }

    private List<Attraction> attractions = new ArrayList<>();

    public void createAttraction(String nameA, String attractionInfo1, String workTime1, int price1) {
        new Attraction(nameA, attractionInfo1, workTime1, price1);
    }

    public void printAttractions() {
        for (Attraction i : attractions) {
            System.out.println(i.toString());
        }
    }

    private class Attraction {
        private String name;
        private String attractionInfo;
        private String workTime;
        private double price;

        public void setName(String name1) {
            name = name1;
        }

        public void setAttractionInfo(String attractionInfo1) {
            attractionInfo = attractionInfo1;
        }

        public void setWorkTime(String workTime1) {
            workTime = workTime1;
        }

        public void setPrice(double price1) {
            price = price1;
        }

        Attraction(String nameA, String attractionInfo1, String workTime1, int price1) {
            name = nameA;
            attractionInfo = attractionInfo1;
            workTime = workTime1;
            price = price1;
            attractions.add(this);
        }

        @Override
        public String toString() {
            return "Attraction {" +
                    "nameA='" + name + '\'' +
                    ", attractionInfo='" + attractionInfo + '\'' +
                    ", workTime='" + workTime + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
