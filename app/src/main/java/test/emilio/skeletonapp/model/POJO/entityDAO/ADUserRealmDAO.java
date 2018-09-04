package test.emilio.skeletonapp.model.POJO.entityDAO;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@RealmClass
public class ADUserRealmDAO implements RealmModel {
    @PrimaryKey
    private int code;

    private String name;
    private String username;
    private String email;
}
