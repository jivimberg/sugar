package me.jivimberg.android.sugartestapp.robolectric;

import com.orm.SugarRecord;
import com.orm.query.Select;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import me.jivimberg.android.sugartestapp.model.Contact;
import me.jivimberg.android.sugartestapp.model.Project;
import me.jivimberg.android.sugartestapp.model.ProjectExtending;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Config(emulateSdk = 18) //see http://goo.gl/3lqkX6
@RunWith(RobolectricTestRunner.class)
public class SugarRecordTest {

    @After
    public void cleanup(){
        SugarRecord.deleteAll(Contact.class);
        SugarRecord.deleteAll(Project.class);
    }

    @Test
    public void testInsert() {
        Contact contact = new Contact("Jack", 23, 45.4f, 1.87d, true);
        SugarRecord.save(contact);

        List<Contact> contacts = Select.from(Contact.class).list();
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
        assertNotNull(project);
        assertEquals(retrievedProject.getName(), projectName);
    }

    @Test
    public void findByIdOverloaded() {
        String projectName = "Title";
        ProjectExtending project = new ProjectExtending(projectName);
        ProjectExtending.save(project);

        ProjectExtending retrievedProject = ProjectExtending.findById(1L);
        assertNotNull(project);
        assertEquals(retrievedProject.getName(), projectName);
    }
}
