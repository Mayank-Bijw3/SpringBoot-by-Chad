package com.springCore.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication(
        //use for manual scanning outside of main file
        scanBasePackages ={"com.xyz.xyz",
                            "com.pqr.pqr"})

 */

@SpringBootApplication  //this auto scan
public class SpringdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}

}
