package polymorphism;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "apple")
public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
	System.out.println("���� ����Ŀ �������");
	}
	
	public void volumeUp(){
		System.out.println("���� ����Ŀ �Ҹ� �ø�");
	}
	
	public void volumeDown(){
		System.out.println("���� ����Ŀ �Ҹ� ����");
	}

}
