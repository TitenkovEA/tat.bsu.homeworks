package testng.homework6.serveces;

import homework6.beans.Checkpoint;
import homework6.beans.Route;
import homework6.serveces.Validator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.*;

public class ValidatorTest {

    @DataProvider(name = "notValidPoints")
    private Object[][] createNotValidPoints() {
        return new Object[][]{
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1, 1)))},
                {new ArrayList<Checkpoint>()},
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1, 1),
                        new Checkpoint(1, 1)))},
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1, 1),
                        new Checkpoint(0, 1), new Checkpoint(1, 1)))},
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1, 1),
                        new Checkpoint(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY)))},
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1, 1),
                        new Checkpoint(Double.NaN, 1)))},
        };
    }

    @DataProvider(name = "validPoints")
    private Object[][] createValidPoints() {
        return new Object[][]{
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1, 1),
                        new Checkpoint(1, 2)))},
                {new ArrayList<Checkpoint>(Arrays.asList(new Checkpoint(1.0, 23),
                        new Checkpoint(1.234, 2.56), new Checkpoint(1.1, 23)))}
        };
    }

    @DataProvider(name = "notValidDouble")
    private Object[][] createNotValidDouble() {
        return new Object[][]{
                {Double.POSITIVE_INFINITY},
                {Double.NEGATIVE_INFINITY},
                {Double.NaN}
        };
    }

    @DataProvider(name = "validDouble")
    private Object[][] createValidDouble() {
        return new Object[][]{
                {-123.1234},
                {0.0},
                {1234.12341235}
        };
    }

    @Test(dataProvider = "notValidPoints")
    public void negativeValidateRouteExist(ArrayList<Checkpoint> points) throws Exception {
        assertFalse(Validator.validateRouteExist(new Route(points)));
    }

    @Test(dataProvider = "validPoints")
    public void positiveValidateRouteExist(ArrayList<Checkpoint> points) throws Exception {
        assertTrue(Validator.validateRouteExist(new Route(points)));
    }

    @Test(dataProvider = "notValidDouble")
    public void negativeValidateDouble(double testValue) {
        assertFalse(Validator.validateDouble(testValue));
    }

    @Test(dataProvider = "validDouble")
    public void positiveValidateDouble(double testValue) {
        assertTrue(Validator.validateDouble(testValue));
    }
}