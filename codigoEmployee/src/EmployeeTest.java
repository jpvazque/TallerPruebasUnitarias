package tallerpruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmployeeTest {

	
	//------------ CALCULAR SALARIO ------------
	
	@Test
	//CASO 1: Para un empleado tipo Worker calcular el salario con CURRENCY que no sea USD
	void testCurrencyNotUSD() {
		Employee e = new Employee(400, "GBP", 10, EmployeeType.Worker);
		
		float expected = (float) (0.95*400.00+(386.00/6.00));
		float actual = e.cs();
		
		Assertions.assertEquals(expected, actual);
	}

	
	@Test
	//CASO 2: Para un empleado tipo Worker calcular el salario con CURRENCY que sea USD
	void testCurrencyUSD() {
		Employee e = new Employee(400, "USD", 10, EmployeeType.Worker);
		
		float expected = (float) (400.00+(386.00/6.00));;
		float actual = e.cs();
		
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	//CASO 3: Calcular el salario para un tipo de empleado no válido (null)
	void testInvalidEmployee() {
		Employee e = new Employee(400, "USD", 10, null); 
		
		//EN EL CASO 3 NO SE ESTA VALIDANDO QUE EL TIPO DE EMPLEADO PUEDE SER NULO (CONSTRUCTOR DEL EMPLEADO)
		
		float expected = 0.0F;
		float actual = e.cs();
		
		Assertions.assertEquals(expected, actual);
	}		
	
	
	
	
	@Test
	//CASO 4: Calcular el salario para un tipo de empleado SUPERVISOR
	void testSupervisor() {
		Employee e = new Employee(400, "USD", 10, EmployeeType.Supervisor);
		
		float expected = (float) (400.00+(10*0.35)+(386.00/6.00));
		float actual = e.cs();
		
		Assertions.assertEquals(expected, actual);
	}	
	
	
	@Test
	//CASO 5: Calcular el salario para un tipo de empleado MANAGER
	void testManager() {
		Employee e = new Employee(400, "USD", 10, EmployeeType.Manager);
		
		float expected = (float) (400.00+(10*0.7)+(386.00/6.00));
		float actual = e.cs();
		
		Assertions.assertEquals(expected, actual);
	}	
	
	
			
	//--------- CALCULAR BONO FIN DE AÑO ----------
	
	@Test
	//CASO 1: Para un empleado tipo MANAGER calcular el bono anual con CURRENCY que no sea USD
	void testCurrencyNotUSDBono() {
		Employee e = new Employee(400, "GBP", 10, EmployeeType.Manager);
		
		float expected = (float) (0.95*400.00+(386.00*1.0F));
		float actual = e.CalculateYearBonus();
		
		Assertions.assertEquals(expected, actual);
	}

	
	@Test
	//CASO 2: Para un empleado tipo MANAGER calcular el bono anual con CURRENCY que sea USD
	void testCurrencyUSDBono() {
		Employee e = new Employee(400, "USD", 10, EmployeeType.Manager);
		
		float expected = (float) (400.00+(386.00*1.0F));
		float actual = e.CalculateYearBonus();
		
		Assertions.assertEquals(expected, actual);
	}
	
	
	@Test
	//CASO 3: Calcular el bono anual para un tipo de empleado WORKER
	void testSupervisorBono() {
		Employee e = new Employee(400, "USD", 10, EmployeeType.Worker);
		
		float expected = 386.0F;
		float actual = e.CalculateYearBonus();
		
		Assertions.assertEquals(expected, actual);
	}	
	
	
	@Test
	//CASO 4: Calcular el bono anual para un tipo de empleado SUPERVISOR
	void testManagerBono() {
		Employee e = new Employee(400, "USD", 10, EmployeeType.Supervisor);
		
		float expected = (float) (400.00+(386.00*0.5F));
		float actual = e.CalculateYearBonus();
		
		Assertions.assertEquals(expected, actual);
	}	
	
}
