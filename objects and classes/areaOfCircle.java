package java_class_and_obj;

public class areaOfCircle {
	int radius;
areaOfCircle(int radius){
	this.radius=radius;
}
public void area() {
	double area=3.14*radius*radius;
	System.out.println(area);
}
public void perimeter() {
	double perimeter=2*(3.14)*radius;
	System.out.println(perimeter);
}
public static void main(String[]args) {
	areaOfCircle a1=new areaOfCircle(8);
	a1.area();
	a1.perimeter();
}

}
