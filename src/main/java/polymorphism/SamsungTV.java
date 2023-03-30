package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "stv")
public class SamsungTV implements TV {
	
//	private SonySpeaker speaker;
	
	//@Autowired // �����̳ʰ� SonySpeaker ��ü�� speaker ������ �ڵ����� �Ҵ�
	//@Qualifier(value = "apple" )
	//private Speaker speaker;
	//private int price;
	
	
	@Resource(name = "sony") // �����̳ʰ� SonySpeaker ��ü�� speaker ������ �ڵ����� �Ҵ�,@Autowiredsms ������ Ÿ���� �������� ��ü�� �˻��Ͽ� ������ ������ ó��������,  ��ſ� @Resource�� ��ü�� �̸��� �̿��Ͽ� ������ ���� ó��
	private Speaker speaker;
	private int price;

	public SamsungTV() {
		System.out.println("�Ｚtv 1 ��ü ����");
	}
	
	//�����ڸ� �̿��� ������ ó��(Setter �޼��尡 �������� �ʴ� Ŭ������ ���ؼ��� ������ ������ ���)
//	public SamsungTV(Speaker speaker) {
//		System.out.println("�Ｚtv 2 ��ü ����");
//		this.speaker=speaker;
//	}
//	
//	
//	public SamsungTV(Speaker speaker, int price) {
//		System.out.println("�Ｚtv 3 ��ü ����");
//		this.speaker=speaker;
//		this.price=price;
//	}

	//setter ������
	
	
	
	public void powerOn() {
		System.out.println("S-TV ��" + price);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("setPrice() ȣ��");
		this.price = price;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker() ȣ��");
		this.speaker = speaker;
	}

	public void powerOff() {
		System.out.println("S-TV ��");
	}

	public void volumeUp() {
//		speaker=new SonySpeaker();
		speaker.volumeUp();
		
//		System.out.println("�Ҹ� �ø�");
	}

	public void volumeDown() {
		
//		speaker=new SonySpeaker();
		speaker.volumeDown();
//		System.out.println("�Ҹ� ����");
	}

	public void destroyMethod() {
//		speaker=new SonySpeaker();
		speaker.volumeDown();
		
	}

}
