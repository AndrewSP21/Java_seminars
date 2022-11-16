import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

class Cat{
    private int id;
    private String name;
    private String color;
    private int age;

    public Cat(int id, String name, String color,int age){
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public static void main(String[] args) {
        Cat youngCat = new Cat(1, "Барсик", "Черный", 5);
        Cat youngCat2 = new Cat(3, "Симка", "Белый", 3);
        Cat oldCat = new Cat(2, "Васька", "Рыжий", 12);
        Cat oldCat2 = new Cat(2, "Васька", "Рыжий", 12);

        var cat = new HashSet<Cat>(Arrays.asList(youngCat, youngCat2, oldCat, oldCat2));

        System.out.println(cat);
    }

    @Override
    public String toString() {
        return
                "Кличка: " + name + "\n"+
                "Окрас: " + color + "\n" +
                "Возраст: " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat cat)) return false;
        return id == cat.id && age == cat.age && name.equals(cat.name) && color.equals(cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
