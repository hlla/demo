package example.com.testcomponent;

import android.app.Activity;
import android.os.Bundle;

public class TestComponentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_component);
        getContentResolver().query(URIField.ACCOUNT_URI, null, null, null, null, null);
    }
}
