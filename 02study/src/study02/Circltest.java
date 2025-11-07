package study02;

public class Circltest {

	public static void main(String[] args) {
		
		Circle obj = new Circle();
		
		obj.redius= 100;//객체의 필드 접근
		obj.color="blue";
		obj.redius=1000;
		
		obj.getArea();
		
//		System.out.println(obj);
//		System.out.println(obj.redius+","+obj.color);
		
//		System.out.println(obj.getArea1());

		double area= obj.getArea1();
		System.out.println("원의면적은?"+area);
		
	}

}
