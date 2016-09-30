package ph.com.smart.rma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ph.com.smart.rma.model.RequestDto;

@SpringBootApplication
@RestController
public class RmaMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(RmaMenuApplication.class, args);
	}
	
	@RequestMapping(value="/something",method=RequestMethod.POST)
	public RequestDto something(@RequestBody RequestDto request){
		return request; 
	}
}
