import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
//		TV tv=new LgTV();
		
//		BeanFactory factory=new BeanFactory();
		
		//스프링에서는 BeanFactory와 이를 상속한 ApplicationContext 두 가지 유형의 컨테이너 제공
		//ApplicationContext가 즉시 로딩 외에 다양한 기능을 지원하므로 이것 사용
		
		//Abstract implementation of the org.springframework.context.ApplicationContextinterface
		//Create a new GenericXmlApplicationContext, loading bean definitions from the given resource locations and automatically refreshing the context.
		AbstractApplicationContext	factory=new GenericXmlApplicationContext("applicationContext.xml");
		//GenericXmlApplicationContext 객체가 생성되어 스프링 컨테이너가 구동됨
		
		//구동된 컨테이너로부터 삼성tv 객체를 얻어냄
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
		
		
		//스프링 컨테이너 종료 Close this application context, destroying all beans in its bean factory. 
		factory.close();
		
	}

}
