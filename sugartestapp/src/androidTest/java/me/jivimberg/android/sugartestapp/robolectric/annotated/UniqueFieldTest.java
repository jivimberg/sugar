package me.jivimberg.android.sugartestapp.robolectric.annotated;

import com.orm.SugarRecord;
import com.orm.dsl.NotNull;
import com.orm.query.Select;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import me.jivimberg.android.sugartestapp.model.entities.annotated.UniqueField;
import me.jivimberg.android.sugartestapp.robolectric.SugarAbstractCRUDTestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Config(emulateSdk = 18) //see http://goo.gl/3lqkX6
@RunWith(RobolectricTestRunner.class)
public class UniqueFieldTest extends SugarAbstractCRUDTestCase<UniqueField> {

    public UniqueFieldTest() {
        super(UniqueField.class);
    }

    @Override
    protected UniqueField createEntity(@NotNull String name) {
        return new UniqueField(1, name);
    }

    @Test
    public void testUpdateAnnotated() {
        String firstProjectTitle = "FirstTitle";
        UniqueField uniqueField = new UniqueField(1, firstProjectTitle);
        SugarRecord.save(uniqueField);

        List<UniqueField> uniqueFields = Select.from(UniqueField.class).list();
        assertNotNull(uniqueFields);
        assertEquals(1, uniqueFields.size());

        UniqueField uniqueFieldToUpdate = uniqueFields.iterator().next();
        assertEquals(uniqueFieldToUpdate.getName(), firstProjectTitle);

        String secondProjectTitle = "SecondTitle";
        uniqueFieldToUpdate.setName(secondProjectTitle);
        SugarRecord.save(uniqueFieldToUpdate);

        uniqueFields = Select.from(UniqueField.class).list();
        assertNotNull(uniqueFields);
        assertEquals(1, uniqueFields.size());
        assertEquals(uniqueFields.iterator().next().getName(), secondProjectTitle);
    }
}
