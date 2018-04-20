package example.com.testcomponent;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
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
    private WeakHashMap<TestComponentActivity, String> weakHashMap = new WeakHashMap<>();
    @BindView(R.id.query)
    Button query;
    @BindView(R.id.insert)
    Button insert;
    @BindView(R.id.update)
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_component);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.query)
    public void onQueryClicked() {
        new Thread() {
            @Override
            public void run() {
                try {
                    Class cr = getClassLoader().loadClass("android.content.ContentResolver");
                    Method method = cr.getMethod("acquireProvider", android.net.Uri.class);
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
                getContentResolver().query(URIField.ACCOUNT_URI, null, null, null, null, null);
                weakHashMap.put(TestComponentActivity.this, "aaaa");
            }
        }.start();
        weakHashMap.put(new TestComponentActivity(), "bbbb");
    }

    @OnClick(R.id.insert)
    public void onInsertClicked() {
        new Thread() {
            @Override
            public void run() {
                getContentResolver().insert(URIField.ACCOUNT_URI, new ContentValues());
                Iterator keys = weakHashMap.keySet().iterator();
                while (keys.hasNext()) {
                    Log.d(TAG, "onInsertClicked: " + weakHashMap.get(keys.next()));
                }
            }
        }.start();
//
    }

    @OnClick(R.id.update)
    public void onUpdateClicked() {
        new Thread() {
            @Override
            public void run() {
                getContentResolver().update(URIField.ACCOUNT_URI, new ContentValues(), null, null);
            }
        }.start();
    }
}
