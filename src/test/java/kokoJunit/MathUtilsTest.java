package kokoJunit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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
    void test(){

        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected,actual,"add methods should add 2 number");
    }
    @Test
    void calculateAreaofaCircleCheckerTest() {

        double expected = 314.00;
        double actual = mathUtils.calculateAreaofaCircleChecker(10);
        assertEquals(expected,actual);
    }

    @Test
    void divisonByZeroCheckerTest(){

        assertThrows(ArithmeticException.class, () -> {mathUtils.divide(2,0 );
        } , "divide by zero should throw arithmetic exception");
    }

}