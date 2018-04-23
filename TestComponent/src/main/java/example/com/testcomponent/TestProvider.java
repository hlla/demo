/*
 * 文件名: HiZoneProvider.java
 * 版    权：  Copyright Huawei Tech. Co. Ltd. All Rights Reserved.
 * 描    述: [该类的简要描述]
 * 创建人: zhouyujun
 * 创建时间:2012-4-9
 * 
 * 修改人：
 * 修改时间:
 * 修改内容：[修改内容]
 */
package example.com.testcomponent;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

import java.util.Vector;

import example.com.testcomponent.DatabaseHelper.Tables;

/**
 * SQLiteContentProvider子类，具体实现查询语句的类。
 *
 * @author zhouyujun
 * @version [RCS Client V100R002C03, 2012-4-9]
 */
public class TestProvider extends SQLiteContentProvider {
    /**
     * 打印log信息时传入的标志
     */
    private static final String TAG = "TestComponent1_Provider";

    /**
     * URI匹配值: 帐号信息表URI
     */
    public static final int ACCOUNT = 0x00000010;

    /**
     * URI匹配值: 系统设置信息表URI
     */
    public static final int SETTING = 0x00000020;

    /**
     * URI匹配值: 照片墙信息表URI
     */
    public static final int WALL = 0x00000030;

    /**
     * URI匹配值: 微博动态信息表URI
     */
    public static final int MBLOG_TREND = 0x00000040;

    /**
     * URI匹配值: zone user信息表URI
     */
    public static final int ZONE_USER = 0x00000050;

    /**
     * URI匹配值: zone album信息表URI
     */
    public static final int ZONE_ALBUM = 0x00000060;

    /**
     * URI匹配值: zone photo信息表URI
     */
    public static final int ZONE_PHOTO = 0x00000070;

    /**
     * URI匹配值: friends信息表URI
     */
    public static final int FRIENDS = 0x00000080;

    /**
     * 需要通知的uri集合
     */
    private Vector<Uri> mNotifyChangeUri;

    /**
     * URI键值队
     */
    private static final UriMatcher URIMATCHER = new UriMatcher(
            UriMatcher.NO_MATCH);
    /**
     * 数据库名称
     */
    private static final String DATABASE_NAME = "hizone.db";

    static {
        // 账号
        URIMATCHER.addURI(URIField.AUTHORITY, Tables.ACCOUNT, ACCOUNT);

        //系统设置
        URIMATCHER.addURI(URIField.AUTHORITY, Tables.SETTING, SETTING);

        //微博动态
        URIMATCHER.addURI(URIField.AUTHORITY, Tables.MBLOG_TREND, MBLOG_TREND);

        //照片墙
        URIMATCHER.addURI(URIField.AUTHORITY, Tables.WALL, WALL);

        //zone Use
        URIMATCHER.addURI(URIField.AUTHORITY, Tables.ZONE_USER, ZONE_USER);

        //zone Photo
        URIMATCHER.addURI(URIField.AUTHORITY, Tables.ZONE_PHOTO, ZONE_PHOTO);

        //friends
        URIMATCHER.addURI(URIField.AUTHORITY, Tables.FRIENDS, FRIENDS);
    }

    /**
     * 初始化NotifyChangeUri
     *
     * @author zhouxuesong
     */
    private void initNotifyChangeUri() {
        mNotifyChangeUri = new Vector<Uri>();
    }

    /**
     * 初始化<BR>
     * 初始化URI集合，初始化各处理具体业务的handler
     *
     * @return 是否成功
     */
    private boolean initialize() {
        mDb = getDatabaseHelper().getWritableDatabase();
        initNotifyChangeUri();
        return null != mDb;
    }

    /**
     * 创建关联 provider对象入口
     *
     * @return boolean
     * @see android.content.ContentProvider#onCreate()
     */
    @Override
    public boolean onCreate() {
        Log.d(TAG, "TestProvider--->onCreate()");

        super.onCreate();
        try {
            return initialize();
        } catch (RuntimeException e) {
            Log.e(TAG, "TestProvider--->onCreate() exception:", e);
            return false;
        }

    }

    /**
     * 返回一个DatabaseHelper实例
     * <p>
     * 子类重写方法
     *
     * @param context Context
     * @return DatabaseHelper
     * @see com.huawei.basic.android.im.component.database.SQLiteContentProvider
     * #getDatabaseHelper(android.content.Context)
     */
    @Override
    protected SQLiteOpenHelper getDatabaseHelper(Context context) {
        return DatabaseHelper.getInstance(context, DATABASE_NAME);
    }

    /**
     * 查询接口<BR>
     *
     * @param uri           Uri
     * @param projection    String[] 查询要返回的列
     * @param selection     String   条件
     * @param selectionArgs String[] 条件值
     * @param orderBy       String 排序字段
     * @return Cursor 返回数据cursor
     * @see android.content.ContentProvider#query(Uri,
     * String[], String, String[],
     * String)
     */
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String orderBy) {
        Log.i(TAG, "begin query...   uri==> " + uri + " thread=" + Thread.currentThread().getName());
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Cursor cursor = null;

        int match = URIMATCHER.match(uri);
        switch (match) {
            default:
                SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
                qb.setTables(getTableNameByMatchCode(match));
                cursor = qb.query(mDb,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        orderBy,
                        null);
                break;
        }
        Log.i(TAG, "end query...   uri==> " + uri);
        return cursor;
    }

    /**
     * 事务中对insert的处理
     * 子类重写方法
     *
     * @param uri    插入的地址描述
     * @param values 插入的值
     * @return 插入后的uri描述
     * @see com.huawei.basic.android.im.component.database.SQLiteContentProvider
     * #insertInTransaction(android.net.Uri, android.content.ContentValues)
     */
    @Override
    protected Uri insertInTransaction(Uri uri, ContentValues values) {
        Uri resultUri = null;
        TableHandler tableHandler = getTableHandlerByUri(uri);

        if (null != tableHandler && null != values) {
            long rowId = tableHandler.insert(mDb, null, values);

            if (rowId > 0) {
                resultUri = ContentUris.withAppendedId(uri, rowId);
            }
        } else {
            Log.w(TAG, "insertInTransaction()  fail, uri: " + uri
                    + ", uri or tableName is null...");
        }

        return resultUri;
    }

    /**
     * 修改接口<BR>
     *
     * @param uri         Uri
     * @param values      ContentValues 需要更新的数据
     * @param whereClause String 条件
     * @param whereArgs   String[] 条件值
     * @return count 更新的数目
     * @see android.content.ContentProvider#update(Uri,
     * ContentValues, String, String[])
     */
    @Override
    protected int updateInTransaction(Uri uri, ContentValues values,
                                      String selection, String[] selectionArgs) {
        Log.i(TAG, "updateInTransaction()--->begin,uri: " + uri);
        int count = 0;
        TableHandler tableHandler = getTableHandlerByUri(uri);
        if (null != tableHandler && null != values) {
            count = tableHandler.update(mDb, values, selection, selectionArgs);
        }

        Log.i(TAG, "updateInTransaction()uri: " + uri);

        if (count > 0) {
            switch (URIMATCHER.match(uri)) {
                default:
                    break;
            }
        }

        return count;
    }

    /**
     * 删除接口
     *
     * @param uri         Uri
     * @param whereClause String
     * @param whereArgs   String[]
     * @return int
     * @see android.content.ContentProvider#delete(Uri,
     * String, String[])
     */
    @Override
    protected int deleteInTransaction(Uri uri, String selection,
                                      String[] selectionArgs) {
        Log.i(TAG, "deleteInTransaction--->begin");

        int count = 0;

        TableHandler tableHandler = getTableHandlerByUri(uri);

        if (null != tableHandler) {
            Log.i(TAG, "delete tableName, Uri: " + uri);

            count = tableHandler.delete(mDb, selection, selectionArgs);
            if (count > 0) {
            }
        }

        return count;
    }

    /**
     * 当有数据内容变动时，通知变动的抽象方法
     * 子类继承方法
     *
     * @see com.huawei.basic.android.im.component.database.SQLiteContentProvider#notifyChange()
     */
    @Override
    protected void notifyChange() {
        synchronized (mNotifyChangeUri) {
            ContentResolver contentResolver = getContext().getContentResolver();
            for (Uri uri : mNotifyChangeUri) {
                Log.d(TAG, "监听到数据变化 " + uri);
                contentResolver.notifyChange(uri, null);
            }
            mNotifyChangeUri.clear();
        }
    }

    /**
     * [一句话功能简述]<BR>
     * [功能详细描述]
     *
     * @param arg0
     * @return
     * @see android.content.ContentProvider#getType(Uri)
     */

    @Override
    public String getType(Uri arg0) {
        return null;
    }

    /**
     * 具体处理数据库操作的类
     *
     * @author qinyangwang
     * @version [RCS Client V100R002C03, 2012-2-15]
     */
    private class TableHandler {
        /**
         * 数据表名称
         */
        protected String mTableName;

        /**
         * 构造方法，传入表名。<BR>
         *
         * @param tableName 表名
         */
        public TableHandler(String tableName) {
            mTableName = tableName;
        }

        /**
         * 向指定的数据库中插入数据<BR>
         *
         * @param db             数据库
         * @param nullColumnHack 默认空值列
         * @param values         插入的值
         * @return 新插入数据的rowId
         */
        public long insert(SQLiteDatabase db, String nullColumnHack,
                           ContentValues values) {
            return db.insert(mTableName, nullColumnHack, values);
        }

        /**
         * 删除指定数据库中的数据<BR>
         *
         * @param db          数据库
         * @param whereClause 条件语句
         * @param whereArgs   条件语句的值
         * @return 删除的行数
         */
        public int delete(SQLiteDatabase db, String whereClause,
                          String[] whereArgs) {
            return db.delete(mTableName, whereClause, whereArgs);
        }

        /**
         * 更新数据库中的数据<BR>
         *
         * @param db          数据库
         * @param values      需要更新的数据
         * @param whereClause 条件语句
         * @param whereArgs   条件
         * @return 更改的行数
         */
        public int update(SQLiteDatabase db, ContentValues values,
                          String whereClause, String[] whereArgs) {
            return db.update(mTableName, values, whereClause, whereArgs);
        }
    }

    /**
     * 通过Uri获得处理目的数据库表的对象<BR>
     *
     * @param uri 数据表所在的ContentProvider地址
     * @return 具体处理业务逻辑的handler对象
     */
    private TableHandler getTableHandlerByUri(Uri uri) {
        String tableName = getTableNameByUri(uri);
        TableHandler tableHandler = null;
        if (null != tableName) {
            tableHandler = new TableHandler(tableName);
        }
        return tableHandler;
    }

    /**
     * 根据Uri匹配出数据库表名<BR>
     *
     * @param uri Uri
     * @return 数据库表名
     */
    private String getTableNameByUri(Uri uri) {
        if (uri != null) {
            final int match = URIMATCHER.match(uri);
            return getTableNameByMatchCode(match);
        }
        return null;
    }

    /**
     * 根据match值匹配出数据库表名
     *
     * @param match match 解析URI获得的对应的整数值
     * @return String 数据库表名
     */
    private String getTableNameByMatchCode(int match) {
        switch (match) {
            case ACCOUNT:
                return Tables.ACCOUNT;
            case SETTING:
                return Tables.SETTING;

            //微博动态
            case MBLOG_TREND:
                return Tables.MBLOG_TREND;

            // 照片墙
            case WALL:
                return Tables.WALL;

            // zone user列表
            case ZONE_USER:
                return Tables.ZONE_USER;

            // zone photo列表
            case ZONE_PHOTO:
                return Tables.ZONE_PHOTO;

            // friends列表
            case FRIENDS:
                return Tables.FRIENDS;

            default:
                return null;
        }
    }
}
