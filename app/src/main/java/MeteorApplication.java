import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by eoin_a on 24/10/2016.
 */

public class MeteorApplication extends Application {

    private static final String REALM_DB = "meteor.db";

    @Override
    public void onCreate()
    {
        super.onCreate();
        configRealm();
    }

    private void configRealm()
    {
        RealmConfiguration realmconfig =  new RealmConfiguration.Builder(this)
                .name(REALM_DB)
                .build();

        Realm.setDefaultConfiguration(realmconfig);

        //realm = Realm.getDefaultInstance();  // to get realm in the app!!!
    }

}
