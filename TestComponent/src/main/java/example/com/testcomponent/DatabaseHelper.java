/*
 * 文件名: DatabaseHelper.java
 * 版    权：  Copyright Huawei Tech. Co. Ltd. All Rights Reserved.
 * 描    述: 对每个数据库表定义了对应的数据表字段接口,获得数据库帮助累的实例,特殊URI的字符串定义接口
 * 创建人: zhouyujun
 * 创建时间:2012-4-9
 * 
 * 修改人：
 * 修改时间:
 * 修改内容：[修改内容]
 */
package example.com.testcomponent;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 数据库操作帮助类<BR>
 *
 * @author zhouyujun
 * @version [RCS Client V100R002C03, 2012-4-9]
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    /**
     * 数据库操作异常控制开关。开发调试阶段打开该开关,正式上线须关闭。
     */
    public static final boolean IS_PRINT_EXCEPTION = true;

    /**
     * 打印log信息时传入的标志
     */
    private static final String TAG = "DatabaseHelper";

    /**
     * 数据库的版本号
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * 数据库表操作对象
     */
    private static DatabaseHelper sSingleton = null;

    /**
     * 构造器创建数据库
     *
     * @param context 上下文
     */
    private DatabaseHelper(Context context, String databaseName) {
        super(context, databaseName, null, DATABASE_VERSION);
        Log.i(TAG, "init DatabaseHelper()");
    }

    /**
     * 获取DatabaseHelper对象
     *
     * @param context 上下文
     * @return DatabaseHelper对象
     */
    public static synchronized DatabaseHelper getInstance(Context context, String name) {
        if (sSingleton == null) {
            sSingleton = new DatabaseHelper(context, name);
        }
        return sSingleton;
    }

    /**
     * 创建数据库
     *
     * @param db SQLiteDatabase对象
     * @see SQLiteOpenHelper#onCreate(SQLiteDatabase)
     */
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "DatabaseHelper on Create()");

        createTable(db);
    }

    /**
     * 版本更新
     *
     * @param db         SQLiteDatabase对象
     * @param oldVersion 旧版本号
     * @param newVersion 新版本号
     * @see SQLiteOpenHelper#onUpgrade(SQLiteDatabase,
     * int, int)
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * 创建数据库中表格
     *
     * @param db SQLiteDatabase对象
     */
    private void createTable(SQLiteDatabase db) {
        try {
            // 1 创建"帐号信息"数据表
            createAccountTable(db);
            //2 创建"系统设置"数据表
//            createSettingTable(db);
//            //3 创建"照片墙设置"数据表
//            createWallTable(db);
//            //4 创建"微博动态数据表"
//            createMblogTrendTable(db);
//            //5 创建"Zone user数据表"
//            createZoneUserTable(db);
//            //6 创建"friends数据表"
//            createFriendsTable(db);
//            //6 创建"friends数据表"
//            createZonePhotoTable(db);
        } catch (Exception e) {
            Log.e(TAG, "createTable() exception:", e);
        }
    }

//    private void createZonePhotoTable(SQLiteDatabase db) {
//
//        StringBuffer sql = new StringBuffer();
//        sql.append(" create table if not exists ").append(Tables.ZONE_PHOTO);
//        sql.append(" ( ");
//        sql.append(ZoneUseColumns.ID)
//                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
//        sql.append(ZoneUseColumns.USERID).append(" TEXT NOT NULL , ");
//        sql.append(ZoneUseColumns.NEWPHOTOURL).append(" TEXT ");
//        sql.append(" );");
//        db.execSQL(sql.toString());
//        Log.d(TAG, "create " + Tables.FRIENDS + " success!");
//    }

    /**
     * 创建Zone用户数据表<BR>
     *
     * @param db SQLiteDatabase对象
     * @author wenhaizhang
     */
//    private void createZoneUserTable(SQLiteDatabase db) {
//        StringBuffer sql = new StringBuffer();
//        sql.append(" create table if not exists ").append(Tables.ZONE_USER);
//        sql.append(" ( ");
//        sql.append(ZoneUseColumns.ID)
//                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
//        sql.append(ZoneUseColumns.USERID).append(" TEXT NOT NULL, ");
//        sql.append(ZoneUseColumns.SIGNATURE).append(" TEXT, ");
//        sql.append(ZoneUseColumns.SRNNAME).append(" TEXT, ");
//        sql.append(ZoneUseColumns.NICKNAME).append(" TEXT, ");
//        sql.append(ZoneUseColumns.USRDESC).append(" TEXT, ");
//        sql.append(ZoneUseColumns.GENDER).append(" TEXT, ");
//        sql.append(ZoneUseColumns.BIRTHDAY).append(" INTEGER, ");
//        sql.append(ZoneUseColumns.REGION).append(" TEXT, ");
//        sql.append(ZoneUseColumns.CORPORATION).append(" TEXT, ");
//        sql.append(ZoneUseColumns.SCHOOL).append(" TEXT, ");
//        sql.append(ZoneUseColumns.PHONENUMBER).append(" TEXT, ");
//        sql.append(ZoneUseColumns.EMAILADDRESS).append(" TEXT, ");
//        sql.append(ZoneUseColumns.INTEGRAL).append(" INTEGER, ");
//        sql.append(ZoneUseColumns.HOBBY).append(" TEXT, ");
//        sql.append(ZoneUseColumns.USERHEAD).append(" TEXT, ");
//        sql.append(ZoneUseColumns.ALBUM).append(" TEXT, ");
//        sql.append(ZoneUseColumns.MBLOGNUMBER).append(" TEXT, ");
//        sql.append(ZoneUseColumns.PHOTONUMBER).append(" TEXT, ");
//        sql.append(ZoneUseColumns.FOLLOWNUMBER).append(" TEXT, ");
//        sql.append(ZoneUseColumns.FOLLOWERNUMBER).append(" TEXT, ");
//        sql.append(ZoneUseColumns.MESSAGENUMBER).append(" TEXT, ");
//        sql.append(ZoneUseColumns.FILEPATH).append(" TEXT, ");
//        sql.append(ZoneUseColumns.NEWMBLOGTHEME).append(" TEXT, ");
//        sql.append(ZoneUseColumns.NEWMBLOGCONTENT).append(" TEXT, ");
//        sql.append(ZoneUseColumns.NEWMBLOGDATE).append(" TEXT, ");
//        sql.append(ZoneUseColumns.NEWMBLOGID).append(" TEXT, ");
//        sql.append(ZoneUseColumns.NEWMBLOGFROM).append(" TEXT, ");
//        sql.append(ZoneUseColumns.NEWPHOTOSTRINGS).append(" TEXT, ");
//        sql.append(ZoneUseColumns.VIPGRADE).append(" INTEGER, ");
//        sql.append(ZoneUseColumns.VIPSTATE).append(" INTEGER, ");
//        sql.append(ZoneUseColumns.SKIN).append(" TEXT, ");
//        sql.append(ZoneUseColumns.NVIPGRADE)
//                .append(" INTEGER NOT NULL DEFAULT 0 ");
//        sql.append(" );");
//        db.execSQL(sql.toString());
//        Log.d(TAG, "create " + Tables.ZONE_USER + " success!");
//    }

    /**
     * 创建"账号"数据表<BR>
     *
     * @param db SQLiteDatabase对象
     */
    private void createAccountTable(SQLiteDatabase db) {
        StringBuffer sql = new StringBuffer();
        sql.append(" create table if not exists ").append(Tables.ACCOUNT);
        sql.append(" ( ");
        sql.append("id")
                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sql.append("country_code").append(" TEXT, ");
        sql.append("login_account").append(" TEXT NOT NULL, ");
        sql.append("timestamp").append(" TEXT");
//        sql.append(AccountColumns.PASSWORD).append(" TEXT, ");
//        sql.append(AccountColumns.AUTOLOGIN)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(AccountColumns.LAST_STATUS).append(" INTEGER, ");
//        sql.append(AccountColumns.USER_SYSID).append(" TEXT NOT NULL, ");
//        sql.append(AccountColumns.USER_ID).append(" TEXT, ");
//        sql.append(AccountColumns.TOKEN).append(" TEXT, ");
//        sql.append(AccountColumns.BIND_MOBILE).append(" TEXT, ");
//        sql.append(AccountColumns.BIND_EMAIL).append(" TEXT, ");
//        sql.append(AccountColumns.USER_STATUS).append(" TEXT, ");
//        sql.append(AccountColumns.USER_CURRENT)
//                .append(" INTEGER NOT NULL DEFAULT 0 ");
        sql.append(" );");
        db.execSQL(sql.toString());
        Log.d(TAG, "create " + Tables.ACCOUNT + " success!");
    }

    /**
     * 创建"系统设置"数据表<BR>
     *
     * @param db SQLiteDatabase对象
     */
//    private void createSettingTable(SQLiteDatabase db) {
//        StringBuffer sql = new StringBuffer();
//        sql.append(" create table if not exists ").append(Tables.SETTING);
//        sql.append(" ( ");
//        sql.append(MoreSettingCloums.ID)
//                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
//        sql.append(MoreSettingCloums.USER_ID)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(MoreSettingCloums.AUTO_LOAD)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(MoreSettingCloums.DISPLAY_REMARKS)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(MoreSettingCloums.PROFILE)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(MoreSettingCloums.ATUO_NOTIFICATION)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(MoreSettingCloums.NOTIFICATION)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(MoreSettingCloums.MBLOG)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(MoreSettingCloums.MENTION)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(MoreSettingCloums.COMMENT)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(MoreSettingCloums.TOUCH)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(MoreSettingCloums.NEWFOLLOWER)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(MoreSettingCloums.RINGTONE_REMINDER)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(MoreSettingCloums.VIBRATION_REMINDER)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(MoreSettingCloums.ZONE_BLACK).append(" INTEGER , ");
//        sql.append(MoreSettingCloums.EMAIL_BIND)
//                .append(" INTEGER NOT NULL DEFAULT 0 ");
//        sql.append(" );");
//        db.execSQL(sql.toString());
//        Log.d(TAG, "create " + Tables.SETTING + " success!");
//    }

    /**
     * 创建"微博动态"数据表<BR>
     *
     * @param db SQLiteDatabase对象
     * @author jiancheng
     */
//    private void createMblogTrendTable(SQLiteDatabase db) {
//        //UNIQUE ON CONFLICT REPLACE
//        StringBuffer sql = new StringBuffer();
//        sql.append(" create table if not exists ").append(Tables.MBLOG_TREND);
//        sql.append(" ( ");
//        sql.append(MBlogTrendColumns.ID)
//                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
//        sql.append(MBlogTrendColumns.CURRENT_USER_ID)
//                .append(" TEXT NOT NULL , ");
//        sql.append(MBlogTrendColumns.USER_ID).append(" TEXT NOT NULL , ");
//        sql.append(MBlogTrendColumns.VIP_GRADE).append(" INTEGER  , ");
//        sql.append(MBlogTrendColumns.NVIP_GRADE).append(" INTEGER  , ");
//        sql.append(MBlogTrendColumns.NICKNAME).append(" TEXT , ");
//        sql.append(MBlogTrendColumns.HAS_PIC).append(" INTEGER , ");
//        sql.append(MBlogTrendColumns.HAS_FWMBLOG).append(" INTEGER , ");
//        sql.append(MBlogTrendColumns.PORTRAIT_URL).append(" TEXT , ");
//        sql.append(MBlogTrendColumns.PORTRAIT_THUMBNAIL_URL).append(" TEXT , ");
//        sql.append(MBlogTrendColumns.MBLOG_ID).append(" INTEGER NOT NULL , ");
//        sql.append(MBlogTrendColumns.TIME).append(" TEXT NOT NULL , ");
//        sql.append(MBlogTrendColumns.CONTENT).append(" TEXT , ");
//        sql.append(MBlogTrendColumns.PIC_URL).append(" TEXT  , ");
//        sql.append(MBlogTrendColumns.PIC_THUMBNAIL_URL).append(" TEXT  , ");
//        sql.append(MBlogTrendColumns.COMMENT_NUM).append(" INTEGER  , ");
//        sql.append(MBlogTrendColumns.FORWARD_NUM).append(" INTEGER  , ");
//        sql.append(MBlogTrendColumns.FWBLOG_USER_ID).append(" INTEGER  , ");
//        sql.append(MBlogTrendColumns.FWBLOG_USER_NICK).append(" TEXT  , ");
//        sql.append(MBlogTrendColumns.FWBLOG_ID).append(" INTEGER  , ");
//        sql.append(MBlogTrendColumns.FWBLOG_COMMENT_NUM).append(" INTEGER  , ");
//        sql.append(MBlogTrendColumns.FWBLOG_FORWARD_NUM).append(" INTEGER  , ");
//        sql.append(MBlogTrendColumns.FORWARD_CONTEN).append(" TEXT , ");
//        sql.append(MBlogTrendColumns.FORWARD_PIC_URL).append(" TEXT  , ");
//        sql.append(MBlogTrendColumns.FORWARD_THUMBNAIL_URL).append(" TEXT  , ");
//        sql.append(MBlogTrendColumns.SRC).append(" TEXT  ");
//        sql.append(" );");
//        db.execSQL(sql.toString());
//        Log.d(TAG, "create " + Tables.MBLOG_TREND + " success!");
//    }

    /**
     * 创建"照片墙"数据表<BR>
     *
     * @param db SQLiteDatabase对象
     */
//    private void createWallTable(SQLiteDatabase db) {
//        StringBuffer sql = new StringBuffer();
//        sql.append(" create table if not exists ").append(Tables.WALL);
//        sql.append(" ( ");
//        sql.append(WallColumns.ID)
//                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
//        sql.append(WallColumns.USERID).append(" TEXT NOT NULL, ");
//        sql.append(WallColumns.NICKNAME).append(" TEXT NOT NULL, ");
//        sql.append(WallColumns.GENDER).append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(WallColumns.USERICON).append(" TEXT, ");
//        sql.append(WallColumns.VIPGRADE)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(WallColumns.VIPSTATE)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(WallColumns.VTYPE).append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(WallColumns.DISTANCE).append(" FLOAT NOT NULL DEFAULT 0, ");
//        sql.append(WallColumns.FANSCOUNT)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(WallColumns.ISFRIEND)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(WallColumns.UPDATETIME).append(" TEXT , ");
//        sql.append(WallColumns.SIGNATURE).append(" TEXT , ");
//        sql.append(WallColumns.USERTAG)
//                .append(" INTEGER NOT NULL DEFAULT 1 , ");
//        sql.append(WallColumns.CURUSERID).append(" TEXT NOT NULL ");
//        sql.append(" );");
//        db.execSQL(sql.toString());
//        Log.d(TAG, "create " + Tables.WALL + " success!");
//    }

    /**
     * 创建"friends"数据表 [一句话功能简述]<BR>
     * [功能详细描述]
     *
     * @param db SQLiteDatabase对象
     */
//    private void createFriendsTable(SQLiteDatabase db) {
//        StringBuffer sql = new StringBuffer();
//        sql.append(" create table if not exists ").append(Tables.FRIENDS);
//        sql.append(" ( ");
//        sql.append(FriendsColumns.ID)
//                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
//        sql.append(FriendsColumns.USER_SYS_ID).append(" TEXT NOT NULL , ");
//        sql.append(FriendsColumns.USER_ID).append(" TEXT NOT NULL , ");
//        sql.append(FriendsColumns.SRN_NAME).append(" TEXT , ");
//        sql.append(FriendsColumns.NICK_NAME).append(" TEXT , ");
//        sql.append(FriendsColumns.REMARK_NAME).append(" TEXT , ");
//        sql.append(FriendsColumns.GENDER).append(" TEXT NOT NULL , ");
//        sql.append(FriendsColumns.USER_ICON_URL).append(" TEXT , ");
//        sql.append(FriendsColumns.SIGNATURE).append(" TEXT , ");
//        sql.append(FriendsColumns.VIP_GRADE)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(FriendsColumns.VIP_STATE)
//                .append(" INTEGER NOT NULL DEFAULT 0, ");
//        sql.append(FriendsColumns.UPDATE_TIME).append(" TEXT , ");
//        sql.append(FriendsColumns.OPENED_BUSINESS).append(" TEXT , ");
//        sql.append(FriendsColumns.SUGGESTED_REASON).append(" TEXT , ");
//        sql.append(FriendsColumns.USER_TYPE)
//                .append(" INTEGER NOT NULL DEFAULT -1 ,");
//        sql.append(FriendsColumns.RELATION_TYPE)
//                .append(" INTEGER NOT NULL DEFAULT -1 ,");
//        sql.append(FriendsColumns.NEWEST_BLOG_CONTENT).append(" TEXT , ");
//        sql.append(FriendsColumns.NEWEST_BLOG_HAS_PIC).append(" TEXT , ");
//        sql.append(FriendsColumns.SINGLE_FILTER_CHARACTER).append(" TEXT ");
//        sql.append(" );");
//        db.execSQL(sql.toString());
//        Log.d(TAG, "create " + Tables.FRIENDS + " success!");
//    }

    /**
     * 数据库表名定义接口<BR>
     * 定义系统中用到的数据库表名的接口
     *
     * @author zhouyujun
     * @version [RCS Client V100R002C03, 2012-3-22]
     */
    public interface Tables {
        /**
         * 数据库表名: 帐号信息表
         */
        public static final String ACCOUNT = "Accout";

        /**
         * 数据库表名: 系统设置信息表
         */
        public static final String SETTING = "setting";

        /**
         * 数据库表名: 微博动态表
         *
         * @author jiancheng
         */
        public static final String MBLOG_TREND = "mblog_trend";

        /**
         * 数据库表名: 照片墙信息表
         */
        public static final String WALL = "Wall";

        /**
         * 数据库表名: zone user信息表
         */
        public static final String ZONE_USER = "Zone_User";

        /**
         * 数据库表名: zone Photo信息表
         */
        public static final String ZONE_PHOTO = "Zone_Photo";

        /**
         * 数据库表名: friends信息表
         */
        public static final String FRIENDS = "friends";
    }

    /**
     * 触发器名称定义接口<BR>
     * 定义系统中用到的触发器
     *
     * @author zhouyujun
     * @version [RCS Client V100R002C03, 2012-3-29]
     */
    public interface Triggers {
        /**
         * 数据库中信息表最大记录数为1000
         */
        public static final String MAX_MESSAGE_RECORD_COUNT = "1000";
    }

    /**
     * 数据特殊操作条件定义接口<BR>
     * 定义特殊操作URI中用到的字符串标志
     *
     * @author zhouyujun
     * @version [RCS Client V100R002C03, 2012-3-22]
     */
    public interface QueryCondition {
        /**
         * 自定义联系人删除操作的URI:<BR>
         */
        public static final String CONTATCINFO_DELETE = "contatcinfo_delete";
    }

    /**
     * 根据异常控制开关打印异常<BR>
     *
     * @param e 异常
     */
    public static void printException(Exception e) {
        if (IS_PRINT_EXCEPTION) {
            throw new RuntimeException(e);
        } else {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            e.printStackTrace(ps);

            Log.e(TAG, new String(baos.toByteArray()));

            try {
                baos.close();
            } catch (IOException e1) {
                DatabaseHelper.printException(e1);
            }
        }
    }

    /**
     * 关闭游标<BR>
     *
     * @param cursor 要关闭的游标对象
     */
    public static void closeCursor(Cursor cursor) {
        if (null != cursor) {
            cursor.close();
        }
    }

}
