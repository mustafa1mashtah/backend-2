package at.nacs.cinema;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerLoaderTest {

    @Autowired
    CustomerLoader customerLoader;

    @Test
    void getNames(){
        int size = customerLoader.getCustomers().size();
        Assertions.assertEquals(22,size);

    }


}