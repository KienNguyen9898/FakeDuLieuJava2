import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Human> humanList = new ArrayList<>();
        Faker faker = new Faker(new Locale("vi"));
        for (int i =0; i<1000; i++){
            //fake thong tin
            Human human = new Human();
            human.setId(i);
            human.setFirstName(faker.name().firstName());
            human.setLastName(faker.name().lastName());
            human.setCity(faker.address().cityName());
            human.setGender(faker.number().numberBetween(0,2));
            human.setAge(faker.number().numberBetween(10,51));
            human.setSalary(faker.number().numberBetween(10,3001));
            // Them vao humanList
            humanList.add(human);
        }

        //in lai du lieu
        long count =
        humanList.stream().filter(human -> human.getAge()>18 && human.getGender()==1).count();
        System.out.println("So nguoi la nam tren 18 tuoi: " +count);

        //b.co bn nguoi la nu va ten dem la thi
        long count1 = humanList.stream().filter(human -> human.getGender() == 0 && human.getFirstName().contains("thị")).count();
        System.out.println("So nguoi la nu va co ten dem la 'Thi' la: "+count1);
        //

    }
}
