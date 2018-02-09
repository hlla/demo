/*
 * 文件名: URIField.java
 * 版    权：  Copyright Huawei Tech. Co. Ltd. All Rights Reserved.
 * 描    述: [该类的简要描述]
 * 创建人: zhouyujun
 * 创建时间:2012-4-9
 * 
 * 修改人：
 * 修改时间:
 * 修改内容：[修改内容]
 */
package letv.com.testanr.component;

import android.net.Uri;

import letv.com.testanr.component.DatabaseHelper.Tables;

/**
 * Provieder中要用到的URI常量集合
 *
 * @author zhouyujun
 * @version [RCS Client V100R002C03, 2012-4-9]
 */
public class URIField {
    /**
     * 系统数据库操作权限/provider权限，与AndroidManifest.xml中的provider中的配置一致
     */
    public static final String AUTHORITY = "com.huawei.rcsbaseline.database.zone";

    /**
     * 系统数据库操作权限URI: 系统 provider URI
     */
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    /**
     * 基本数据库表操作URI: 帐号信息表
     */
    public static final Uri ACCOUNT_URI = Uri.parse("content://" + AUTHORITY
            + "/" + Tables.ACCOUNT);

    /**
     * 系统设置数据库表操作URI: 系统设置信息表
     */
    public static final Uri SETTING_URI = Uri.parse("content://" + AUTHORITY
            + "/" + Tables.SETTING);

    /**
     * 微博动态数据库表操作URI: 微博动态信息表表
     */
    public static final Uri MBLOG_TREND_URI = Uri.parse("content://"
            + AUTHORITY + "/" + Tables.MBLOG_TREND);

    /**
     * 基本数据库表操作URI: 照片墙信息表
     */
    public static final Uri WALL_URI = Uri.parse("content://" + AUTHORITY + "/"
            + Tables.WALL);

    /**
     * Zone User数据库表操作URI: User信息表
     */
    public static final Uri ZONE_USER_URI = Uri.parse("content://" + AUTHORITY
            + "/" + Tables.ZONE_USER);

    /**
     * Zone Album数据库表操作URI: 相片信息表
     */
    public static final Uri ZONE_PHOTO_URI = Uri.parse("content://" + AUTHORITY
            + "/" + Tables.ZONE_PHOTO);

    /**
     * friends数据库表操作URI: friends信息表
     */
    public static final Uri FRIENDS_URI = Uri.parse("content://" + AUTHORITY
            + "/" + Tables.FRIENDS);
}
