package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@RestController
public class HelloController {

	@Autowired
	 private Environment env;

	@RequestMapping("/")
	public String hello() {
		return "Hello World";
	}

	@RequestMapping("/port")
	public String helloport() {
		String port = getPropertyValue("server.port");
		return "Hello World from port " + port;
	}

	public String getPropertyValue(@RequestParam("key") String key) {
		String returnValue = "No value";
		String keyValue = env.getProperty(key);

		if (keyValue != null && !keyValue.isEmpty()) {
			returnValue = keyValue;
		}
		return returnValue;
	}
}
