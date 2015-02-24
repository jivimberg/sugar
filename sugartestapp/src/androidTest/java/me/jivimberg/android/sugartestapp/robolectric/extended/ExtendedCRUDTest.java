package me.jivimberg.android.sugartestapp.robolectric.extended;

import com.orm.dsl.NotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import me.jivimberg.android.sugartestapp.model.entities.ExtendedSugarEntity;
import me.jivimberg.android.sugartestapp.robolectric.SugarAbstractCRUDTestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Config(emulateSdk = 18) //see http://goo.gl/3lqkX6
@RunWith(RobolectricTestRunner.class)
public class ExtendedCRUDTest extends SugarAbstractCRUDTestCase<ExtendedSugarEntity> {

    public ExtendedCRUDTest() {
        super(ExtendedSugarEntity.class);
    }

    @Override
    protected ExtendedSugarEntity createEntity(@NotNull String name) {
        return new ExtendedSugarEntity(name);
    }

    //Suggestion from issue #224
    @Test
    public void findByIdOverloaded() {
        String name = "Name1";
        ExtendedSugarEntity project = createEntity(name);
        ExtendedSugarEntity.save(project);

        ExtendedSugarEntity retrievedEntity = ExtendedSugarEntity.findById(1L);
        assertNotNull(retrievedEntity);
        assertEquals(retrievedEntity.getName(), name);
        assertEquals(1L, retrievedEntity.getId().doubleValue(), 0.001);
    }
}
