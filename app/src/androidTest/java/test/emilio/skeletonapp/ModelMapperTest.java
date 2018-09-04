package test.emilio.skeletonapp;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;

import test.emilio.skeletonapp.model.POJO.entity.ADUser;
import test.emilio.skeletonapp.model.POJO.entityDAO.ADUserRealmDAO;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class ModelMapperTest {

    @Test
    public void mapperUserToUserRealm(){
        ModelMapper modelMapper = new ModelMapper();

        ADUser user = createUser();

        ADUserRealmDAO dao = modelMapper.map(user, ADUserRealmDAO.class);

        assertEquals (dao.getCode(), user.getCode());
        assertEquals (dao.getName(), user.getName());
        assertEquals (dao.getUsername(), user.getUsername());
        assertEquals (dao.getEmail(), user.getEmail());
    }

    private ADUser createUser(){
        ADUser user = new ADUser();

        user.setCode(1);
        user.setName("Tino");
        user.setUsername("Tovar");
        user.setEmail("tino@tovar.com");

        return user;
    }
}
