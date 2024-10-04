public class Main {
    public static void main(String[] args) {
        Employee[] men = new Employee[5];
        men[0] = new Employee("chel1", "rab1", "murmur1@gmail.com", "7911111111", 501, 21);
        men[1] = new Employee("chel2", "rab2", "murmur2@gmail.com", "7911111112", 502, 22);
        men[2] = new Employee("chel3", "rab3", "murmur3@gmail.com", "7911111113", 503, 23);
        men[3] = new Employee("chel4", "rab4", "murmur4@gmail.com", "7911111114", 504, 24);
        men[4] = new Employee("chel5", "rab5", "murmur5@gmail.com", "7911111115", 505, 25);
        for (Employee i : men) {
            System.out.println(i);
        }

        Park park1 = new Park("Park1");
        Park.Attraction attraction1 = park1.new Attraction("Bomb", "Anything", "9:00 - 21:00", 50);
        System.out.println(attraction1);
    }
}
