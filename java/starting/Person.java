public class Person {
    private String name;
    private int age;
  
    // constructor
    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }
  
    // getters and setters
    public String getName() {
      return name;
    }
  
    public int getAge() {
      return age;
    }
  
    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof Person)) {
        return false;
      }
      Person person = (Person) o;
      return person.name.equals(name) && person.age == age;
    }
  
    @Override
    public int hashCode() {
      return Objects.hash(name, age);
    } 
    public static void main(String[] args) {
        Person p1 = new Person("John", 30);
        Person p2 = new Person("John", 30);
        Person p3 = new Person("Bob", 35);
        System.out.println("P1==P2: "+p1.equals(p2));
        System.out.println("P1==P3: "+p1.equals(p3));
    }
}
