package example.com.testcomponent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestComponentActivity extends Activity {
    private static final String TAG = "TestComponent1_Activity";
    public static final String MAIN_PROCESS_ACTION = "android.intent.action.mystaticreceiver";
    public static final String LOADING_PROCESS_ACTION = "android.intent.action.MyStaticReceiverA";
    @BindView(R.id.bindservice)
    Button bindservice;
    @BindView(R.id.main_broadcast)
    Button mainBroadcast;
    @BindView(R.id.loading_broadcast)
    Button loadingBroadcast;
    private WeakHashMap<TestComponentActivity, String> weakHashMap = new WeakHashMap<>();
    @BindView(R.id.query)
    Button query;
    @BindView(R.id.insert)
    Button insert;
    @BindView(R.id.update)
    Button update;

    private void launchLauncher(String name) {
        Intent localIntent = new Intent("android.intent.action.MAIN");
        localIntent.addCategory("android.intent.category.HOME");

//        localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        localIntent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
//        localIntent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
//        localIntent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        try {
//            localIntent.setPackage(getPackageName());
            localIntent.setComponent(new ComponentName(getPackageName(), name));
            startActivity(localIntent);
        } catch (Exception localException) {
            localIntent.setComponent(new ComponentName(getApplicationContext(),
                    TestComponentActivity.class));
            startActivity(localIntent);
        } finally {
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String className = getIntent().getComponent().getClassName();
        Log.d(TAG, "onCreate: className=" + className);
        setContentView(R.layout.test_component);
        ButterKnife.bind(this);
        getContentResolver().registerContentObserver(URIField.ACCOUNT_URI, true, new
                ContentObserver(null) {
                    @Override
                    public void onChange(boolean selfChange) {
                        Log.d(TAG, "onChange selfChange=" + selfChange);
                    }
                });
//        try {
//            Context context = createPackageContext("tropical.island.summer.theme.cool", Context
//                    .CONTEXT_INCLUDE_CODE | Context.CONTEXT_IGNORE_SECURITY);
//            Log.d(TAG, "onCreate: pkg=" + context.getPackageName());
//            int id = context.getResources().getIdentifier("loading_gear_blue", "drawable", context
//                    .getPackageName());
//            Log.d(TAG, "onCreate: id=" + id);
//            query.setBackground(context.getDrawable(id));
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    @OnClick(R.id.query)
    public void onQueryClicked() {
        new Thread() {
            @Override
            public void run() {
                try {
                    Class cr = getClassLoader().loadClass("android.content.ContentResolver");
                    Method method = cr.getMethod("acquireProvider", Uri.class);
                    Object transport = method.invoke(getContentResolver(), URIField
                            .ACCOUNT_URI);
                    Log.d(TAG, "onQueryClicked: " + transport + "  class=" + transport.getClass());
                    Class tsCl = transport.getClass();
                    Method get = tsCl.getDeclaredMethod("getContentProvider");
                    get.setAccessible(true);
                    Log.d(TAG, "onQueryClicked: get" + get.invoke(transport));
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d(TAG, "onQueryClicked: e" + e);
                }
                ContentProviderClient providerClient = null;
                try {
                    providerClient = getContentResolver().acquireContentProviderClient(URIField
                            .ACCOUNT_URI);
//                    providerClient.setDetectNotResponding(3000);
                    providerClient.query
                            (URIField.ACCOUNT_URI, null, null, null, null, null);
//                    getContentResolver().query
//                            (URIField.ACCOUNT_URI, null, null, null, null, null);
                } catch (Exception e) {
                } finally {
                    boolean isResult = providerClient.release();
                    Log.d(TAG, "run: isResult=" + isResult);
                }
                weakHashMap.put(TestComponentActivity.this, "aaaa");
            }
        }.start();
        weakHashMap.put(new TestComponentActivity(), "bbbb");
    }

    int i = 0;

    @OnClick(R.id.insert)
    public void onInsertClicked() {
//        i++;
        new Thread() {
            @Override
            public void run() {
                ContentValues contentValues = new ContentValues();
                contentValues.put("login_account", "cj" + i);
                getContentResolver().insert(URIField.ACCOUNT_URI, contentValues);
                Iterator keys = weakHashMap.keySet().iterator();
                while (keys.hasNext()) {
                    Log.d(TAG, "onInsertClicked: " + weakHashMap.get(keys.next()));
                }
            }
        }.start();
//        PackageManager pm = getPackageManager();
//        pm.setComponentEnabledSetting(new ComponentName(this, "example.com.testcomponent" +
//                        ".TestComponentActivity"),
//                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
//        pm.setComponentEnabledSetting(new ComponentName(this, "example.com.testcomponent" +
//                        ".MainAliasActivity"),
//                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
//        SharedPreferences sharedPreferences = getSharedPreferences("abc", 0);
////            SystemProperties.set("debug.test.euro", "false");
//        sharedPreferences.edit().putBoolean("debug.test.euro", true).apply();
//
    }

    @OnClick(R.id.update)
    public void onUpdateClicked() {
        String className = getIntent().getComponent().getClassName();
        SharedPreferences sharedPreferences = getSharedPreferences("abc", 0);
        boolean isEuro = sharedPreferences.getBoolean("debug.test.euro", false);
        Log.d(TAG, "onCreate: isEuro=" + isEuro);
        if (isEuro) {
            PackageManager pm = getPackageManager();
            pm.setComponentEnabledSetting(new ComponentName(this, "example.com.testcomponent" +
                            ".MainAliasActivity"),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
            pm.setComponentEnabledSetting(new ComponentName(this, "example.com.testcomponent" +
                            ".TestComponentActivity"),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            if ("example.com.testcomponent.MainAliasActivity".equalsIgnoreCase(className)) {
                launchLauncher("example.com.testcomponent.TestComponentActivity");
            }
//            SystemProperties.set("debug.test.euro", "false");
            sharedPreferences.edit().putBoolean("debug.test.euro", false).apply();
        }

//        new Thread() {
//            @Override
//            public void run() {
//                getContentResolver().update(URIField.ACCOUNT_URI, new ContentValues(), null,
// null);
//            }
//        }.start();
    }

    @OnClick(R.id.bindservice)
    public void onBindserviceClicked() {
        Intent intent = new Intent();
        intent.setClassName("letv.com.testanr11", "letv.com.testanr.MyService");
        boolean result = bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d(TAG, "onServiceConnected: ");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d(TAG, "onServiceDisconnected: ");

            }
        }, BIND_AUTO_CREATE);
        Log.d(TAG, "onBindServiceClicked: end result=" + result);
    }

    @OnClick(R.id.main_broadcast)
    public void onMainBroadcastClicked() {
        Intent intent = new Intent(MAIN_PROCESS_ACTION);
//        Intent intent = new Intent(Intent.ACTION_PACKAGE_ADDED);
//        intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
        sendBroadcast(intent);
    }

    @OnClick(R.id.loading_broadcast)
    public void onLoadingBroadcastClicked() {
        Intent intent1 = new Intent(LOADING_PROCESS_ACTION);
        intent1.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
        sendBroadcast(intent1);
    }

}
