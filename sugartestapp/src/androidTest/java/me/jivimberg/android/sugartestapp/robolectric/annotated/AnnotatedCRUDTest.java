package me.jivimberg.android.sugartestapp.robolectric.annotated;

import com.orm.dsl.NotNull;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import me.jivimberg.android.sugartestapp.model.entities.AnnotatedSugarEntity;
import me.jivimberg.android.sugartestapp.robolectric.SugarAbstractCRUDTestCase;

@Config(emulateSdk = 18) //see http://goo.gl/3lqkX6
@RunWith(RobolectricTestRunner.class)
public class AnnotatedCRUDTest extends SugarAbstractCRUDTestCase<AnnotatedSugarEntity> {

    public AnnotatedCRUDTest() {
        super(AnnotatedSugarEntity.class);
    }

    @Override
    protected AnnotatedSugarEntity createEntity(@NotNull String name) {
        return new AnnotatedSugarEntity(name);
    }
}
