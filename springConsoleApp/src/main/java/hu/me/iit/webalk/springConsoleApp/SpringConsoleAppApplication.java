package hu.me.iit.webalk.springConsoleApp;

import hu.me.iit.webalk.springConsoleApp.impl.CombustionEngine;
import hu.me.iit.webalk.springConsoleApp.impl.ElectricEngine;
import hu.me.iit.webalk.springConsoleApp.impl.WheelImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringConsoleAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringConsoleAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Engine engine = new CombustionEngine(150, 2000);
		Wheel[] wheels = new WheelImpl[4];
		Arrays.fill(wheels, new WheelImpl(300, 18));

		Auto auto = new Auto(wheels, engine, "Opel");
		System.out.println(auto.toString());

		Engine engine2 = new ElectricEngine(5, 200);
		Wheel[] wheels2 = new WheelImpl[4];
		Arrays.fill(wheels2, new WheelImpl(300, 18));

		Auto auto2 = new Auto(wheels2, engine2, "Tesla");
		System.out.println(auto2.toString());
	}
}
