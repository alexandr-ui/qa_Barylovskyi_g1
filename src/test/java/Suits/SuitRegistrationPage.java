package Suits;

import RegistrationTests.RegistrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//анотация Junit для запуска Suite в этом классе
//И в этом же классе будет находится Suite c набором тестов
@RunWith(Suite.class)

@Suite.SuiteClasses(
        {
                RegistrationTest.class,
                RegistrationTest.class
        }
)
public class SuitRegistrationPage {

}
