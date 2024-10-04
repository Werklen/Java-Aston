public class Park {
    String name;

    Park(String nameP) {
        name = nameP;
    }

    public class Attraction {
        String name;
        String attractionInfo;
        String workTime;
        int price;

        Attraction(String nameA, String attractionInfo1, String workTime1, int price1) {
            name = nameA;
            attractionInfo = attractionInfo1;
            workTime = workTime1;
            price = price1;
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
