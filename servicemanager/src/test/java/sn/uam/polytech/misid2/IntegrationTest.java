package sn.uam.polytech.misid2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import sn.uam.polytech.misid2.config.AsyncSyncConfiguration;
import sn.uam.polytech.misid2.config.EmbeddedSQL;
import sn.uam.polytech.misid2.config.JacksonConfiguration;
import sn.uam.polytech.misid2.config.TestSecurityConfiguration;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(
    classes = { ServicemanagerApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class }
)
@EmbeddedSQL
public @interface IntegrationTest {
}
