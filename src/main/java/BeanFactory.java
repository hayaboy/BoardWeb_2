
public class BeanFactory {

	public Object getBean(String beanName){
		if(beanName.equals("s")) {
			return new SamsungTV();
		}else if(beanName.equals("lg")) {
			return new LgTV();
		}
		
		return null;
	}
}
