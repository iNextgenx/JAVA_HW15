import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Moscow", "Berlin", 300, 11, 20); //9h
    Ticket ticket2 = new Ticket("Moscow", "Berlin", 1000, 5, 21); //16h
    Ticket ticket3 = new Ticket("Berlin", "Prague", 1000, 3, 7);
    Ticket ticket4 = new Ticket("London", "Berlin", 200, 18, 22);
    Ticket ticket5 = new Ticket("Moscow", "Berlin", 500, 20, 24); //4
    Ticket ticket6 = new Ticket("Helsinki", "Saint-Petersburg", 450, 2, 8);

    @Test
    public void shouldTestCompareToEqual() { // Тест при равных

        int expected = 0;
        int actual = ticket3.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestCompareTo1morethan2() {  // Тест при первом объекте больше второго

        int expected = 1;
        int actual = ticket3.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestCompareTo2morethan1() {  //  Тест при втором обьекте блоьше первого

        int expected = -1;
        int actual = ticket4.compareTo(ticket5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestSearchWithCompare() {   // Тест Search с сортировкой по цене

        AviaSouls aSouls = new AviaSouls();

        aSouls.add(ticket1);
        aSouls.add(ticket2);
        aSouls.add(ticket3);
        aSouls.add(ticket4);
        aSouls.add(ticket5);
        aSouls.add(ticket6);

        Ticket[] actual = aSouls.search("Moscow", "Berlin");
        Ticket[] expected = {ticket1, ticket5, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTestSearchwithComparator() {   // Тест Search с сортировкай с параметром TimeComparator

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        AviaSouls aSouls = new AviaSouls();

        aSouls.add(ticket1);
        aSouls.add(ticket2);
        aSouls.add(ticket3);
        aSouls.add(ticket4);
        aSouls.add(ticket5);
        aSouls.add(ticket6);

        Ticket[] actual = aSouls.searchAndSortBy("Moscow", "Berlin", timeComparator);
        Ticket[] expected = {ticket5, ticket1, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

}

