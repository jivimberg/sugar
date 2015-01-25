package me.jivimberg.android.sugartestapp.robolectric;

import com.orm.SugarRecord;
import com.orm.query.Select;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import me.jivimberg.android.sugartestapp.model.annotated.Car;
import me.jivimberg.android.sugartestapp.model.annotated.Category;
import me.jivimberg.android.sugartestapp.model.annotated.Contact;
import me.jivimberg.android.sugartestapp.model.annotated.Project;
import me.jivimberg.android.sugartestapp.model.extended.CarExtending;
import me.jivimberg.android.sugartestapp.model.extended.CategoryExtending;
import me.jivimberg.android.sugartestapp.model.extended.ProjectExtending;
import me.jivimberg.android.sugartestapp.model.annotated.SubCategory;
import me.jivimberg.android.sugartestapp.model.extended.SubCategoryExtending;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Config(emulateSdk = 18) //see http://goo.gl/3lqkX6
@RunWith(RobolectricTestRunner.class)
public class SugarRecordTest {

    @After
    public void cleanup(){
        SugarRecord.deleteAll(Category.class);
        SugarRecord.deleteAll(Contact.class);
        SugarRecord.deleteAll(Project.class);
        SugarRecord.deleteAll(SubCategory.class);
        SugarRecord.deleteAll(CategoryExtending.class);
        SugarRecord.deleteAll(ProjectExtending.class);
        SugarRecord.deleteAll(SubCategoryExtending.class);
        SugarRecord.deleteAll(Car.class);
        SugarRecord.deleteAll(CarExtending.class);
    }

    @Test
    public void testInsert() {
        Contact contact = new Contact("Jack", 23, 45.4f, 1.87d, true);
        SugarRecord.save(contact);

        List<Contact> contacts = Select.from(Contact.class).list();
        assertNotNull(contacts);
        assertEquals(1, contacts.size());
    }

    // Issue #213
    @Test
    public void testInsertWithUnderlinedField() {
        Car contact = new Car("Nissan");
        SugarRecord.save(contact);

        List<Car> contacts = Select.from(Car.class).list();
        assertNotNull(contacts);
        assertEquals(1, contacts.size());
    }

    // Issue #213
    @Test
    public void testInsertWithUnderlinedFieldExtending() {
        CarExtending contact = new CarExtending("Nissan");
        SugarRecord.save(contact);

        List<CarExtending> contacts = Select.from(CarExtending.class).list();
        assertNotNull(contacts);
        assertEquals(1, contacts.size());
    }

    @Test
    public void testInsertUniqueId() {
        String firstProjectTitle = "FirstTitle";
        Project project = new Project(1, firstProjectTitle);
        SugarRecord.save(project);

        List<Project> projects = Select.from(Project.class).list();
        assertNotNull(projects);
        assertEquals(1, projects.size());
        assertEquals(projects.iterator().next().getName(), firstProjectTitle);

        String secondProjectTitle = "SecondTitle";
        project = new Project(1, secondProjectTitle);

        SugarRecord.save(project);

        projects = Select.from(Project.class).list();
        assertNotNull(projects);
        assertEquals(1, projects.size());
        assertEquals(projects.iterator().next().getName(), secondProjectTitle);
    }

    @Test
    public void findById() {
        String projectName = "Title";
        Project project = new Project(5, projectName);
        SugarRecord.save(project);

        Project retrievedProject = SugarRecord.findById(Project.class, 1);
        assertNotNull(retrievedProject);
        assertEquals(retrievedProject.getName(), projectName);
    }

    @Test
    public void findByIdOverloaded() {
        String projectName = "Title";
        ProjectExtending project = new ProjectExtending(projectName);
        ProjectExtending.save(project);

        ProjectExtending retrievedProject = ProjectExtending.findById(1L);
        assertNotNull(retrievedProject);
        assertEquals(retrievedProject.getName(), projectName);
        assertEquals(1L, retrievedProject.getId().doubleValue(), 0.001);
    }

    // Issue #201
    @Test
    public void saveSetId() {
        String projectName = "Title";
        ProjectExtending project = new ProjectExtending(projectName);
        ProjectExtending.save(project);

        String newName = "newName";
        project.setName(newName);
        ProjectExtending.save(project);

        List<ProjectExtending> projects = Select.from(ProjectExtending.class).list();
        assertNotNull(projects);
        assertEquals(1, projects.size());

        assertEquals(1L, project.getId().doubleValue(), 0.001);
    }

    // Issue #215
    @Test
    public void persistingRelationships() {
        String name = "Name";
        Category category = new Category(name);
        SugarRecord.save(category);

        SubCategory subCategory = new SubCategory(category);
        SugarRecord.save(subCategory);

        List<SubCategory> subCategoryList = Select.from(SubCategory.class).list();
        assertNotNull(subCategoryList);
        assertEquals(1, subCategoryList.size());

        assertNotNull(subCategoryList.iterator().next().getCategory());
    }

    // Issue #215
    @Test
    public void persistingRelationshipsExtending() {
        String name = "Name";
        CategoryExtending category = new CategoryExtending(name);
        category.save();

        SubCategoryExtending subCategory = new SubCategoryExtending(category);
        subCategory.save();

        List<SubCategoryExtending> subCategoryList = Select.from(SubCategoryExtending.class).list();
        assertNotNull(subCategoryList);
        assertEquals(1, subCategoryList.size());

        assertNotNull(subCategoryList.iterator().next().getCategory());
    }
}
