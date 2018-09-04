package test.emilio.skeletonapp.model.realm;


import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class ADMigration implements RealmMigration {

    @Override
    public void migrate(DynamicRealm dynamicRealm, long oldVersion, long newVersion) {

        RealmSchema schema = dynamicRealm.getSchema();

        if (oldVersion == 1) {

        }
    }
}
