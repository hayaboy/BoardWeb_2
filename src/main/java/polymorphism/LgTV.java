package polymorphism;

import org.springframework.stereotype.Component;

@Component(value = "ltv")
public class LgTV implements TV {
	
	public void powerOn(){
		System.out.println("L-TV ��");
	}
	
	public void powerOff(){
		System.out.println("L-TV ��");
	}
	
	public void volumeUp(){
		System.out.println("L-TV �Ҹ� �ø�");
	}
	
	public void volumeDown(){
		System.out.println("L-TV �Ҹ� ����");
	}

}
