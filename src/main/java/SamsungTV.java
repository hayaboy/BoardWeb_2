
public class SamsungTV implements TV{
	
	
	public void initMethod(){
		System.out.println("��ü �ʱ�ȭ");
	}
	
	/*
	 * public SamsungTV() { System.out.println("�Ｚtv ��ü ����"); }
	 */
	
	public void powerOn(){
		System.out.println("S-TV ��");
	}
	
	public void powerOff(){
		System.out.println("S-TV ��");
	}
	
	public void volumeUp(){
		System.out.println("S-TV �Ҹ� �ø�");
	}
	
	public void volumeDown(){
		System.out.println("S-TV �Ҹ� ����");
	}

	
	public void destroyMethod(){
		System.out.println("��ü ���� ���� ó���� ���� ó��...");
	}
	
}
