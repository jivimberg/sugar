package me.jivimberg.android.sugartestapp.robolectric.extended;

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
public class UnderlinedPropertyExtendedTest extends SugarAbstractCRUDTestCase<UnderlinedPropertyNameExtended> {

    public UnderlinedPropertyExtendedTest() {
        super(UnderlinedPropertyNameExtended.class);
    }

    @Override
    protected UnderlinedPropertyNameExtended createEntity(@NotNull String name) {
        return new UnderlinedPropertyNameExtended(name);
    }

    // Issue #213
    @Test
    public void testInsertWithUnderlinedField() {
        UnderlinedPropertyNameAnnotated contact = new UnderlinedPropertyNameAnnotated("Nissan");
        SugarRecord.save(contact);

        List<UnderlinedPropertyNameAnnotated> contacts = Select.from(UnderlinedPropertyNameAnnotated.class).list();
        assertNotNull(contacts);
        assertEquals(1, contacts.size());
    }
}
