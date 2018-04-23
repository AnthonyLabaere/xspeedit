package fr.alabaere.xspeedit.supplyChain.service;

import fr.alabaere.xspeedit.TestObjectFactory;
import fr.alabaere.xspeedit.supplyChain.SupplyChainRepository;
import fr.alabaere.xspeedit.supplyChain.SupplyChainService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:application-test.yml")
@ActiveProfiles("test")
@Transactional
public class AbstractSupplyChainServiceTest {

    @Resource
    protected SupplyChainService supplyChainService;

    @Resource
    protected SupplyChainRepository supplyChainRepository;

    protected TestObjectFactory factory;

    @Before
    public void setUp() {
        this.factory = new TestObjectFactory();
    }
}
