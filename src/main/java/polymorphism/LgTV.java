package polymorphism;

import org.springframework.stereotype.Component;

@Component(value = "ltv")
public class LgTV implements TV {
	
	public void powerOn(){
		System.out.println("L-TV 脑");
	}
	
	public void powerOff(){
		System.out.println("L-TV 阐");
	}
	
	public void volumeUp(){
		System.out.println("L-TV 家府 棵覆");
	}
	
	public void volumeDown(){
		System.out.println("L-TV 家府 郴覆");
	}

}
