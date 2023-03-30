import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
//		TV tv=new LgTV();
		
//		BeanFactory factory=new BeanFactory();
		
		//������������ BeanFactory�� �̸� ����� ApplicationContext �� ���� ������ �����̳� ����
		//ApplicationContext�� ��� �ε� �ܿ� �پ��� ����� �����ϹǷ� �̰� ���
		
		//Abstract implementation of the org.springframework.context.ApplicationContextinterface
		//Create a new GenericXmlApplicationContext, loading bean definitions from the given resource locations and automatically refreshing the context.
		AbstractApplicationContext	factory=new GenericXmlApplicationContext("applicationContext.xml");
		//GenericXmlApplicationContext ��ü�� �����Ǿ� ������ �����̳ʰ� ������
		
		//������ �����̳ʷκ��� �Ｚtv ��ü�� ��
		/* TV tv=(TV) factory.getBean("tv"); */
		
		TV tv1=(TV) factory.getBean("tv");
		TV tv2=(TV) factory.getBean("tv");
		TV tv3=(TV) factory.getBean("tv");
		TV tv4=(TV) factory.getBean("tv");
		
		//System.out.println(tv);
		//tv.powerOn();
		//tv.volumeUp();
		//tv.volumeDown();		
		//tv.powerOff();
		
		
		//������ �����̳� ���� Close this application context, destroying all beans in its bean factory. 
		factory.close();
		
	}

}
