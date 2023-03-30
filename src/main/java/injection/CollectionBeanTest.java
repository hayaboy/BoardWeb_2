package injection;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanTest {

	public static void main(String[] args) {
		AbstractApplicationContext	factory=new GenericXmlApplicationContext("applicationContext.xml");

		
		CollectionBean bean=(CollectionBean) factory.getBean("collectionBean");
		
		
//		List<String>  addresList=bean.getAddressList();
		
//		Set<String>  addresList=bean.getAddressList();
		
		//Map<String, String> addressList= (Map<String, String>) bean.getAddressList();
		//Returns a Set view of the keys contained in this map.
		//Set<String> keys= addressList.keySet();
		
		
		Properties addressList=bean.getAddressList();
		
		//Returns an unmodifiable set of keys from this property list where the key and its corresponding value are strings, 
		Set<String> keys= addressList.stringPropertyNames();
		
		for(String key : keys) {
			System.out.println(key);
			System.out.println(addressList.get(key));
		}
	}

}
