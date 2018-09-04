package test.emilio.skeletonapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import test.emilio.skeletonapp.model.POJO.entity.ADUser;
import test.emilio.skeletonapp.model.POJO.entityDAO.ADUserRealmDAO;
import test.emilio.skeletonapp.model.realm.ADRealm;
import test.emilio.skeletonapp.model.realm.repository.RealmRepository;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;



@RunWith(AndroidJUnit4.class)
@MediumTest
public class RepositoryRealmTest {

    @BeforeClass
    public static void setUpClass() {
        Context context = InstrumentationRegistry.getTargetContext();
        ADRealm realm = new ADRealm();

        realm.init(context);
    }

    @Test
    public void testSaveAndFetchEntity(){
        ADUser user = createUser();

        RealmRepository<ADUser, ADUserRealmDAO> repository = new RealmRepository<>(ADUser.class, ADUserRealmDAO.class);

        repository.save(user);
        ADUser dao = repository.fetch(buildQueryOneValue());

        assertEquals (dao.getCode(), user.getCode());
        assertEquals (dao.getName(), user.getName());
        assertEquals (dao.getUsername(), user.getUsername());
        assertEquals (dao.getEmail(), user.getEmail());
    }

    @Test
    public void testSaveAndFetchEntities(){
        List<ADUser> entities = createUserList();

        RealmRepository<ADUser, ADUserRealmDAO> repository = new RealmRepository<>(ADUser.class, ADUserRealmDAO.class);

        repository.save(entities);
        List<ADUser> entitiesSaved = repository.fetchAll(buildQueryAll());

        for(int i = 0; i < entities.size(); i++){
            assertEquals (entities.get(i).getCode(), entitiesSaved.get(i).getCode());
            assertEquals (entities.get(i).getName(), entitiesSaved.get(i).getName());
            assertEquals (entities.get(i).getUsername(), entitiesSaved.get(i).getUsername());
            assertEquals (entities.get(i).getEmail(), entitiesSaved.get(i).getEmail());
        }
    }

    @Test
    public void testUpdateAndFetchEntity(){
        ADUser user = updateUser();

        RealmRepository<ADUser, ADUserRealmDAO> repository = new RealmRepository<>(ADUser.class, ADUserRealmDAO.class);

        repository.update(user);
        ADUser dao = repository.fetch(buildQueryOneValue());

        user = createUser();

        assertEquals (dao.getCode(), user.getCode());
        assertNotEquals (dao.getName(), user.getName());
        assertEquals (dao.getUsername(), user.getUsername());
        assertEquals (dao.getEmail(), user.getEmail());
    }

    @Test
    public void testUpdateAndFetchEntities(){
        List<ADUser> entities = updateUserList();

        RealmRepository<ADUser, ADUserRealmDAO> repository = new RealmRepository<>(ADUser.class, ADUserRealmDAO.class);

        repository.update(entities);
        List<ADUser> entitiesSaved = repository.fetchAll(buildQueryAll());

        entities = createUserList();

        for(int i = 0; i < entities.size(); i++){
            assertEquals (entities.get(i).getCode(), entitiesSaved.get(i).getCode());
            assertNotEquals (entities.get(i).getName(), entitiesSaved.get(i).getName());
            assertEquals (entities.get(i).getUsername(), entitiesSaved.get(i).getUsername());
            assertEquals (entities.get(i).getEmail(), entitiesSaved.get(i).getEmail());
        }
    }

    @Test
    public void testDeleteAndFetchEntity(){
        RealmRepository<ADUser, ADUserRealmDAO> repository = new RealmRepository<>(ADUser.class, ADUserRealmDAO.class);

        repository.delete(buildQueryOneValue());
        ADUser entityDeleted = repository.fetch(buildQueryOneValue());

        assertNull (entityDeleted);
    }

    private ADUser createUser(){
        ADUser user = new ADUser();

        user.setCode(1);
        user.setName("Tino");
        user.setUsername("Tovar");
        user.setEmail("tino@tovar.com");

        return user;
    }

    private ADUser updateUser() {
        ADUser user = createUser();
        user.setName("Antonio");

        return user;
    }

    private List<ADUser> createUserList(){
        List<ADUser> entities = new ArrayList<>();

        for(int i = 0; i < 10; i++) {

            ADUser user = new ADUser();

            user.setCode(1 + i);
            user.setName("Tino" + i);
            user.setUsername("Tovar" + i);
            user.setEmail("tino@tovar.com" + i);

            entities.add(user);
        }

        return entities;
    }

    private List<ADUser> updateUserList(){
        List<ADUser> entities = createUserList();

        for(int i = 0; i < entities.size(); i++) {
            entities.get(i).setName("Antonio" + i);
        }

        return entities;
    }

    private RealmQuery<ADUserRealmDAO> buildQueryOneValue() {
        RealmQuery<ADUserRealmDAO> query;
        Realm realm = Realm.getDefaultInstance();

        query = realm.where(ADUserRealmDAO.class);
        query.equalTo("code", 1);

        return query;
    }

    private RealmQuery<ADUserRealmDAO> buildQueryAll() {
        RealmQuery<ADUserRealmDAO> query;
        Realm realm = Realm.getDefaultInstance();

        query = realm.where(ADUserRealmDAO.class).sort("code");

        return query;
    }
}
