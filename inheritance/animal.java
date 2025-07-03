package inheritance;

class Animals {


	String name;
	int age;
	Animals(String name,int age){
		this.name=name;
		this.age=age;
	}
	void makeSound() {
		System.out.println("animals sound");
	}

}

class Dog extends Animals{
	public Dog(String name,int age){
		super(name,age);
	}
	void makeSound() {
		System.out.println(name+"is barking");
	}

}
class cat extends Animals{
	cat(String name,int age){
		super(name,age);
	}
	void makeSound() {
		System.out.println(name+"meow!!");
	}

}
class bird extends Animals{
	bird(String name,int age){
		super(name,age);
	}
	void makeSound() {
		System.out.println(name+"is chirping");
	}

}
class animal{
	public static void main(String[] args) {
		Animals a1= new Animals("labra",10);

		Dog a2=new Dog("husky",2);
		a2.makeSound();

		cat a3=new cat("kitty",3);
		bird a4=new bird("sparrow",1);

		a1.makeSound();
		a3.makeSound();
		a4.makeSound();

	}
}
