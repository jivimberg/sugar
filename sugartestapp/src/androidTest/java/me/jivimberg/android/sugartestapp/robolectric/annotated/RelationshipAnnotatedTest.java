package me.jivimberg.android.sugartestapp.robolectric.annotated;

import com.orm.SugarRecord;
import com.orm.dsl.NotNull;
import com.orm.query.Select;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import me.jivimberg.android.sugartestapp.model.entities.ExtendedSugarEntity;
import me.jivimberg.android.sugartestapp.model.entities.annotated.ChildAnnotated;
import me.jivimberg.android.sugartestapp.model.entities.annotated.ParentAnnotated;
import me.jivimberg.android.sugartestapp.robolectric.SugarAbstractCRUDTestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Config(emulateSdk = 18) //see http://goo.gl/3lqkX6
@RunWith(RobolectricTestRunner.class)
public class RelationshipAnnotatedTest extends SugarAbstractCRUDTestCase<ParentAnnotated> {

    public RelationshipAnnotatedTest() {
        super(ParentAnnotated.class);
    }

    @Override
    protected ParentAnnotated createEntity(@NotNull String name) {
        return new ParentAnnotated(name);
    }

    //Suggestion from issue #224
    // Issue #215
    @Test
    public void persistingRelationships() {
        String name = "Name";
        ParentAnnotated parentAnnotated = new ParentAnnotated(name);
        SugarRecord.save(parentAnnotated);

        ChildAnnotated childAnnotated = new ChildAnnotated(parentAnnotated);
        SugarRecord.save(childAnnotated);

        List<ChildAnnotated> childAnnotatedList = Select.from(ChildAnnotated.class).list();
        assertNotNull(childAnnotatedList);
        assertEquals(1, childAnnotatedList.size());

        assertNotNull(childAnnotatedList.iterator().next().getParent());
    }

    @Ignore //Waiting for #254 to be merged
    @Test
    public void testUpdate() {

    }
}
