
package example.com.testutls;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;


public class TestContentProvider extends ContentProvider {
    private static final String TAG = "TestUtil_TestCP";
    private TestDBHelper mTestDBHelper;
    public static final String AUTHORITIES = "example.com.testutls.provider";
    public static final Uri CONTENT_URI_AUTHORITY = Uri.parse("content://" + AUTHORITIES);
    public static final Uri CONTENT_URI_AUTHORITY_LOCAL = Uri.parse("content://" + AUTHORITIES +
            "/recent_local");
    private static final UriMatcher MATCHER = new UriMatcher(
            UriMatcher.NO_MATCH);
    private static final int RECENT_LOCAL = 1;
    private static final int RECENT_FAVORITE = 2;
    private static final String MAX_RECENT_COUNT = "5";

    static {
        MATCHER.addURI(AUTHORITIES, "recent_local", RECENT_LOCAL);
        MATCHER.addURI(AUTHORITIES, "recent_favorite", RECENT_FAVORITE);
    }

    @Override
    public boolean onCreate() {
        Exception exception = new Exception("onCreate()");
        String str = getContext().getString(R.string.num);
        Log.d(TAG, "onCreate: getContext()=" + getContext() + " str=" + str + " app=" +
                getContext().getApplicationContext(), exception);
        mTestDBHelper = new TestDBHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        Log.d(TAG, "query: projection=" + projection + " selection=" + selection);
        switch (MATCHER.match(uri)) {
            case RECENT_LOCAL:
                Log.d(TAG, "query: 1");
                SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
                qb.setTables(TestDBHelper.TABLE_TEST);

                SQLiteDatabase db = mTestDBHelper.getWritableDatabase();
                return qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);
            case RECENT_FAVORITE:
                Log.d(TAG, "query: 2");
                SQLiteQueryBuilder qb1 = new SQLiteQueryBuilder();
                qb1.setTables(TestDBHelper.TABLE_TEST);

                SQLiteDatabase db1 = mTestDBHelper.getWritableDatabase();
                return qb1.query(db1, projection, selection, selectionArgs, null, null, sortOrder);
            default:
                throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());

        }

    }

//    private Cursor queryRecent(String typeSelectoin, String[] projection, String selection,
//                               String[] selectionArgs,
//                               String sortOrder) {
//        String and = " and ";
//        return mTestDBHelper.query(TestDBHelper.TABLE_TEST, projection, selection,
//                selectionArgs, null, null, sortOrder, MAX_RECENT_COUNT);
//    }

    @Override
    public String getType(Uri uri) {
        switch (MATCHER.match(uri)) {
            case RECENT_LOCAL:
                return "vnd.android.cursor.dir/locals";
            case RECENT_FAVORITE:
                return "vnd.android.cursor.item/favorites";
            default:
                throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long count = mTestDBHelper.insert(TestDBHelper.TABLE_TEST, null, values);
        Log.d(TAG, "insert: count=" + count);
        return uri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        return super.bulkInsert(uri, values);
    }
}
