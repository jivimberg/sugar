package me.jivimberg.android.sugartestapp.robolectric.annotated;

import com.orm.SugarRecord;
import com.orm.dsl.NotNull;
import com.orm.query.Select;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import me.jivimberg.android.sugartestapp.model.entities.annotated.UnderlinedPropertyNameAnnotated;
import me.jivimberg.android.sugartestapp.model.entities.extended.UnderlinedPropertyNameExtended;
import me.jivimberg.android.sugartestapp.robolectric.SugarAbstractCRUDTestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Config(emulateSdk = 18) //see http://goo.gl/3lqkX6
@RunWith(RobolectricTestRunner.class)
public class UnderlinedPropertyAnnotatedTest extends SugarAbstractCRUDTestCase<UnderlinedPropertyNameAnnotated> {

    public UnderlinedPropertyAnnotatedTest() {
        super(UnderlinedPropertyNameAnnotated.class);
    }

    @Override
    protected UnderlinedPropertyNameAnnotated createEntity(@NotNull String name) {
        return new UnderlinedPropertyNameAnnotated(name);
    }

    // Issue #213
    @Test
    public void testInsertWithUnderlinedFieldExtending() {
        UnderlinedPropertyNameExtended contact = new UnderlinedPropertyNameExtended("Nissan");
        SugarRecord.save(contact);

        List<UnderlinedPropertyNameExtended> contacts = Select.from(UnderlinedPropertyNameExtended.class).list();
        assertNotNull(contacts);
        assertEquals(1, contacts.size());
    }
}
