package me.jivimberg.android.sugartestapp.robolectric.extended;

import com.orm.dsl.NotNull;
import com.orm.query.Select;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import me.jivimberg.android.sugartestapp.model.entities.extended.ChildExtended;
import me.jivimberg.android.sugartestapp.model.entities.extended.ParentExtended;
import me.jivimberg.android.sugartestapp.robolectric.SugarAbstractCRUDTestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Config(emulateSdk = 18) //see http://goo.gl/3lqkX6
@RunWith(RobolectricTestRunner.class)
public class RelationshipExtendedTest extends SugarAbstractCRUDTestCase<ParentExtended> {

    public RelationshipExtendedTest() {
        super(ParentExtended.class);
    }

    @Override
    protected ParentExtended createEntity(@NotNull String name) {
        return new ParentExtended(name);
    }

    // Issue #215
    @Test
    public void persistingRelationshipsExtending() {
        String name = "Name";
        ParentExtended category = new ParentExtended(name);
        category.save();

        ChildExtended subCategory = new ChildExtended(category);
        subCategory.save();

        List<ChildExtended> subCategoryList = Select.from(ChildExtended.class).list();
        assertNotNull(subCategoryList);
        assertEquals(1, subCategoryList.size());

        assertNotNull(subCategoryList.iterator().next().getCategory());
    }
}
