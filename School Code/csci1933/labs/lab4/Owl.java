public class Owl {
    private String name;
    private int age;
    private double weight;

    public Owl(String name, int age, double weight){
        this.name=name;
        this.age=age;
        this.weight=weight;
    }
    

    public static void main (String Args[]){
        Owl owl1 = new Owl("owl1", 5, 12.0);
        Owl owl2 = new Owl("owl2", 5, 12.0);
        Owl owl3 = new Owl("owl1", 5, 12.0);
        System.out.println(owl1.equals(owl2));
        System.out.println(owl1.equals(owl3));
        


    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return this.age;
    }
    public void setage(int age){
        this.age=age;
    }
    public double getWeight(){
        return this.weight;
    }
    public void setWeight(double weight){
        this.weight=weight;
    }

    public boolean equals(Owl other){
        if (this.age==other.age && this.name==other.name && this.weight==other.weight)
            return true;
        return false;
    }
}
