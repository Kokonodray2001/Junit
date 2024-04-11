package kokoJunit;
import jdk.jfr.Enabled;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // by default its PER_METHOD // if its per class then @beforeAll and @afterAll no need to static
class MathUtilsTest {

    MathUtils mathUtils;
    static int n =0 ;
    @AfterAll
    static void printAfter(){
        System.out.println("After All " + n);
    }
    @BeforeAll
    static void printBefore(){
        System.out.println("Before All " + n);
    }
    @AfterEach
    void increaseCountOfN(){
        n++;
    }

    @BeforeEach
    void initMathUtils(){
        mathUtils =  new MathUtils();
    }

    @Test
    @DisplayName("testing add methods")
    void test(){

        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected,actual,"add methods should add 2 number");
    }
    @Test
    @DisplayName("testing area of a circle")
    void calculateAreaofaCircleCheckerTest() {

        double expected = 314.00;
        double actual = mathUtils.calculateAreaofaCircleChecker(10);
        boolean value = true;
        assumeTrue(value);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("testing divisibility by zero")
    @EnabledOnOs(OS.LINUX)
    void divisonByZeroCheckerTest(){

        assertThrows(ArithmeticException.class, () -> {mathUtils.divide(2,0 );
        } , "divide by zero should throw arithmetic exception");
    }

    @Test
    @DisplayName("This Test should not pass")
    @Disabled
    void failiongTest(){
        fail("this failed");
    }
    @Test
    @DisplayName("testing multiply using assetAll")
    void multiplyTwoNumberChecker(){
        assertAll(
                ()->assertEquals(mathUtils.multiply(1,2),2),
                ()->assertEquals(mathUtils.multiply(1,0),0),
                ()->assertEquals(mathUtils.multiply(2,2),4),
                ()->assertEquals(mathUtils.multiply(-1,2),-2)
        );
    }


}