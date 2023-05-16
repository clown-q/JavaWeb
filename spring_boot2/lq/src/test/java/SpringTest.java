import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xcu.dao.impl.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContest.xml")
public class SpringTest {
    @Autowired
    private UserController userController;
    @Test
    public void findUser(){
        userController.findUser();
    }
}
