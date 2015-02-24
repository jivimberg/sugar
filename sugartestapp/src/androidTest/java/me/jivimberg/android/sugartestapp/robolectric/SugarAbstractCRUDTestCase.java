package me.jivimberg.android.sugartestapp.robolectric;

import com.orm.SugarRecord;
import com.orm.dsl.NotNull;
import com.orm.query.Select;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import me.jivimberg.android.sugartestapp.model.entities.annotated.ParentAnnotated;
import me.jivimberg.android.sugartestapp.model.entities.SugarEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Config(emulateSdk = 18) //see http://goo.gl/3lqkX6
@RunWith(RobolectricTestRunner.class)
public abstract class SugarAbstractCRUDTestCase<T extends SugarEntity> {

    @NotNull
    private final Class<T> clazz;


    public SugarAbstractCRUDTestCase(@NotNull final Class<T> clazz){
        this.clazz = clazz;
    }

    protected abstract T createEntity(@NotNull String name);

    @After
    public void cleanup(){
        SugarRecord.deleteAll(clazz);
    }

    @Test
    public void testInsert() {
        String name = "John";
        SugarEntity entity = createEntity(name);
        SugarRecord.save(entity);

        List<? extends SugarEntity> entities = Select.from(clazz).list();
        assertNotNull(entities);
        assertEquals(1, entities.size());
        assertEquals(entities.iterator().next().getName(), name);
    }

    @Test
    public void testUpdate() {
        String name = "Name1";
        SugarEntity entity = createEntity(name);
        SugarRecord.save(entity);

        String name2 = "Name2";
        entity.setName(name2);
        SugarRecord.save(entity);

        List<? extends SugarEntity> entities = Select.from(clazz).list();
        assertNotNull(entities);
        assertEquals(1, entities.size());
        entity = entities.iterator().next();
        assertEquals(entity.getName(), name2);
    }

    @Test
    public void findById() {
        String name = "Name1";
        SugarEntity entity = createEntity(name);
        SugarRecord.save(entity);

        SugarEntity retrievedProject = SugarRecord.findById(clazz, 1);
        assertNotNull(retrievedProject);
        assertEquals(retrievedProject.getName(), name);
    }

    // Issue #250
    @Test
    public void deleteAllAndSave() {
        String name = "Name1";
        SugarEntity entity = createEntity(name);
        SugarRecord.save(entity);

        List<? extends SugarEntity> entities = Select.from(clazz).list();
        assertNotNull(entities);
        assertEquals(1, entities.size());

        SugarRecord.deleteAll(ParentAnnotated.class);
        SugarRecord.save(entity);

        entities = Select.from(clazz).list();
        assertNotNull(entities);
        assertEquals(1, entities.size());
    }

}
