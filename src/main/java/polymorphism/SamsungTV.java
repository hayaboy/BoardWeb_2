package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "stv")
public class SamsungTV implements TV {
	
//	private SonySpeaker speaker;
	
	//@Autowired // 컨테이너가 SonySpeaker 객체를 speaker 변수에 자동으로 할당
	//@Qualifier(value = "apple" )
	//private Speaker speaker;
	//private int price;
	
	
	@Resource(name = "sony") // 컨테이너가 SonySpeaker 객체를 speaker 변수에 자동으로 할당,@Autowiredsms 변수의 타입을 기준으로 객체를 검색하여 의존성 주입을 처리하지만,  대신에 @Resource는 객체의 이름을 이용하여 의존성 주입 처리
	private Speaker speaker;
	private int price;

	public SamsungTV() {
		System.out.println("삼성tv 1 객체 생성");
	}
	
	//생성자를 이용한 의존성 처리(Setter 메서드가 제공되지 않는 클래스에 대해서만 생성자 인젝션 사용)
//	public SamsungTV(Speaker speaker) {
//		System.out.println("삼성tv 2 객체 생성");
//		this.speaker=speaker;
//	}
//	
//	
//	public SamsungTV(Speaker speaker, int price) {
//		System.out.println("삼성tv 3 객체 생성");
//		this.speaker=speaker;
//		this.price=price;
//	}

	//setter 인젝션
	
	
	
	public void powerOn() {
		System.out.println("S-TV 켬" + price);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("setPrice() 호출");
		this.price = price;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void powerOff() {
		System.out.println("S-TV 끔");
	}

	public void volumeUp() {
//		speaker=new SonySpeaker();
		speaker.volumeUp();
		
//		System.out.println("소리 올림");
	}

	public void volumeDown() {
		
//		speaker=new SonySpeaker();
		speaker.volumeDown();
//		System.out.println("소리 내림");
	}

	public void destroyMethod() {
//		speaker=new SonySpeaker();
		speaker.volumeDown();
		
	}

}
