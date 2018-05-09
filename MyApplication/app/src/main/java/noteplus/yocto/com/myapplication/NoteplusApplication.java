package noteplus.yocto.com.myapplication;

import android.app.Application;

public class NoteplusApplication extends Application {
    private static NoteplusApplication me;

    @Override
    public void onCreate() {
        super.onCreate();

        me = this;
    }

    public static NoteplusApplication instance() {
        return me;
    }
}

