package rest;

import com.emu.apps.sample.tomee.model.Document;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Module;
import org.apache.openejb.testng.PropertiesBuilder;

import java.util.Properties;

public class ModuleConfig {

    @Module
    public PersistenceUnit persistence() {
        PersistenceUnit unit = new PersistenceUnit("sample-unit");
        unit.setJtaDataSource("dbJta");
        unit.setNonJtaDataSource("dbUnmanaged");
        unit.getClazz().add(Document.class.getName());
        unit.setProperty("openjpa.jdbc.SynchronizeMappings", "buildSchema(ForeignKeys=true)");
        return unit;
    }

    @Configuration
    public Properties configuration() {
        return new PropertiesBuilder()
                .p("db", "new://Resource?type=DataSource")
                .p("db.JdbcUrl", "jdbc:hsqldb:mem:test")
                .build();
    }

}
