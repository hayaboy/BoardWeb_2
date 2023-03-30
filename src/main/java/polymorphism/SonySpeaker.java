package polymorphism;

import org.springframework.stereotype.Component;

@Component(value = "sony")
public class SonySpeaker implements Speaker {
	
	public SonySpeaker() {
	System.out.println("소니 스피커 만들어짐");
	}
	
	public void volumeUp(){
		System.out.println("소니 스피커 소리 올림");
	}
	
	public void volumeDown(){
		System.out.println("소니 스피커 소리 내림");
	}

}
