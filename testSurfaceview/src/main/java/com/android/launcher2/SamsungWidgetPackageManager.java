package com.android.launcher2;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public enum SamsungWidgetPackageManager
{
  INSTANCE(LauncherApplication.getInst());
  
  static final boolean DEBUG = true;
  private static final boolean DEBUGGABLE = Utilities.DEBUGGABLE();
  private static final int DEFAULT_WIDGET_NUMBER = 10;
  private static final String INTENT_ACTION = "com.samsung.sec.android.SAMSUNG_APP_WIDGET_ACTION";
  private static final String INTENT_CATEGORY = "com.samsung.sec.android.SAMSUNG_APP_WIDGET";
  private static final String LOG_TAG = "SWidgetPkgMgr";
  private static final String METADATA_NAME = "com.samsung.sec.android.SAMSUNG_WIDGET";
  private static final String[] WIDGET_ID_COL = { "appWidgetId" };
  private static final String WIDGET_ID_WHERE = "itemType=" + Integer.toString(900);
  static final String WIDGET_NAME = "plug_in_name";
  private final LauncherApplication mApp;
  private int mConfigMccWhenLoaded;
  private int mConfigMncWhenLoaded;
  private String mLocaleWhenLoaded;
  private final PackageManager mPkgMgr;
  private List<SamsungWidgetProviderInfo> mSamsungWidgets;
  
  private SamsungWidgetPackageManager(LauncherApplication paramLauncherApplication)
  {
    this.mApp = paramLauncherApplication;
    this.mPkgMgr = paramLauncherApplication.getPackageManager();
  }
  
  /* Error */
  private SamsungWidgetProviderInfo loadWidgetLk(ResolveInfo paramResolveInfo, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/android/launcher2/SamsungWidgetPackageManager:mApp	Lcom/android/launcher2/LauncherApplication;
    //   4: aload_1
    //   5: getfield 126	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   8: getfield 131	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
    //   11: iconst_3
    //   12: invokevirtual 135	com/android/launcher2/LauncherApplication:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   15: astore 7
    //   17: aload_1
    //   18: getfield 126	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   21: aload_0
    //   22: getfield 108	com/android/launcher2/SamsungWidgetPackageManager:mPkgMgr	Landroid/content/pm/PackageManager;
    //   25: aload_2
    //   26: invokevirtual 139	android/content/pm/ActivityInfo:loadXmlMetaData	(Landroid/content/pm/PackageManager;Ljava/lang/String;)Landroid/content/res/XmlResourceParser;
    //   29: astore 10
    //   31: aload 10
    //   33: ifnonnull +12 -> 45
    //   36: aconst_null
    //   37: areturn
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 142	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   43: aconst_null
    //   44: areturn
    //   45: aload 10
    //   47: invokeinterface 148 1 0
    //   52: istore_3
    //   53: iload_3
    //   54: iconst_2
    //   55: if_icmpne +418 -> 473
    //   58: aload 7
    //   60: invokevirtual 154	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   63: astore 8
    //   65: aload 8
    //   67: invokevirtual 160	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   70: astore 9
    //   72: aload 8
    //   74: ldc 35
    //   76: ldc -94
    //   78: aload_1
    //   79: getfield 126	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   82: getfield 131	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
    //   85: invokevirtual 166	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   88: istore_3
    //   89: iload_3
    //   90: ifne +117 -> 207
    //   93: aload_1
    //   94: aload_0
    //   95: getfield 108	com/android/launcher2/SamsungWidgetPackageManager:mPkgMgr	Landroid/content/pm/PackageManager;
    //   98: invokevirtual 170	android/content/pm/ResolveInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   101: invokeinterface 173 1 0
    //   106: astore_2
    //   107: aload 10
    //   109: aconst_null
    //   110: ldc -81
    //   112: iconst_0
    //   113: invokeinterface 179 4 0
    //   118: istore_3
    //   119: aload 10
    //   121: aconst_null
    //   122: ldc -75
    //   124: iconst_0
    //   125: invokeinterface 179 4 0
    //   130: istore 4
    //   132: aload 10
    //   134: aconst_null
    //   135: ldc -73
    //   137: iconst_0
    //   138: invokeinterface 179 4 0
    //   143: istore 6
    //   145: aload 10
    //   147: aconst_null
    //   148: ldc -71
    //   150: iconst_0
    //   151: invokeinterface 179 4 0
    //   156: istore 5
    //   158: aload 10
    //   160: aconst_null
    //   161: ldc -69
    //   163: invokeinterface 191 3 0
    //   168: astore 10
    //   170: iload 4
    //   172: ifeq +8 -> 180
    //   175: iload 5
    //   177: ifne +40 -> 217
    //   180: ldc 26
    //   182: new 77	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   189: ldc -63
    //   191: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_2
    //   195: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 199	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   204: pop
    //   205: aconst_null
    //   206: areturn
    //   207: aload 8
    //   209: iload_3
    //   210: invokevirtual 202	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   213: astore_2
    //   214: goto -107 -> 107
    //   217: new 204	com/android/launcher2/SamsungWidgetProviderInfo
    //   220: dup
    //   221: aload_1
    //   222: getfield 126	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   225: getfield 131	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
    //   228: aload_1
    //   229: getfield 126	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   232: getfield 207	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   235: aload 10
    //   237: invokespecial 210	com/android/launcher2/SamsungWidgetProviderInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   240: astore_1
    //   241: aload_1
    //   242: aload_2
    //   243: putfield 213	com/android/launcher2/SamsungWidgetProviderInfo:mWidgetTitle	Ljava/lang/String;
    //   246: aload_1
    //   247: iload 6
    //   249: putfield 216	com/android/launcher2/SamsungWidgetProviderInfo:mWidgetPreview	I
    //   252: iload_3
    //   253: ifeq +10 -> 263
    //   256: aload 8
    //   258: iload_3
    //   259: invokevirtual 202	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   262: astore_2
    //   263: aload_1
    //   264: aload_2
    //   265: putfield 219	com/android/launcher2/SamsungWidgetProviderInfo:mDescription	Ljava/lang/String;
    //   268: aload 9
    //   270: getfield 224	android/content/res/Configuration:orientation	I
    //   273: istore 6
    //   275: iconst_2
    //   276: istore_3
    //   277: iload 6
    //   279: iconst_2
    //   280: if_icmpne +96 -> 376
    //   283: aload_1
    //   284: aload 8
    //   286: iload 5
    //   288: invokevirtual 228	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   291: putfield 231	com/android/launcher2/SamsungWidgetProviderInfo:mHorizontalWidth	I
    //   294: aload_1
    //   295: aload 8
    //   297: iload 4
    //   299: invokevirtual 228	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   302: putfield 234	com/android/launcher2/SamsungWidgetProviderInfo:mHorizontalHeight	I
    //   305: iconst_1
    //   306: istore_3
    //   307: aload 9
    //   309: iload_3
    //   310: putfield 224	android/content/res/Configuration:orientation	I
    //   313: aload 8
    //   315: aload 9
    //   317: aload 8
    //   319: invokevirtual 238	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   322: invokevirtual 242	android/content/res/Resources:updateConfiguration	(Landroid/content/res/Configuration;Landroid/util/DisplayMetrics;)V
    //   325: iload_3
    //   326: iconst_2
    //   327: if_icmpne +81 -> 408
    //   330: aload_1
    //   331: aload 8
    //   333: iload 5
    //   335: invokevirtual 228	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   338: putfield 231	com/android/launcher2/SamsungWidgetProviderInfo:mHorizontalWidth	I
    //   341: aload_1
    //   342: aload 8
    //   344: iload 4
    //   346: invokevirtual 228	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   349: putfield 234	com/android/launcher2/SamsungWidgetProviderInfo:mHorizontalHeight	I
    //   352: aload 9
    //   354: iload 6
    //   356: putfield 224	android/content/res/Configuration:orientation	I
    //   359: aload 7
    //   361: invokevirtual 154	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   364: aload 9
    //   366: aload 8
    //   368: invokevirtual 238	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   371: invokevirtual 242	android/content/res/Resources:updateConfiguration	(Landroid/content/res/Configuration;Landroid/util/DisplayMetrics;)V
    //   374: aload_1
    //   375: areturn
    //   376: aload_1
    //   377: aload 8
    //   379: iload 5
    //   381: invokevirtual 228	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   384: putfield 245	com/android/launcher2/SamsungWidgetProviderInfo:mVerticalWidth	I
    //   387: aload_1
    //   388: aload 8
    //   390: iload 4
    //   392: invokevirtual 228	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   395: putfield 248	com/android/launcher2/SamsungWidgetProviderInfo:mVerticalHeight	I
    //   398: goto -91 -> 307
    //   401: astore_1
    //   402: aload_1
    //   403: invokevirtual 249	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   406: aconst_null
    //   407: areturn
    //   408: aload_1
    //   409: aload 8
    //   411: iload 5
    //   413: invokevirtual 228	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   416: putfield 245	com/android/launcher2/SamsungWidgetProviderInfo:mVerticalWidth	I
    //   419: aload_1
    //   420: aload 8
    //   422: iload 4
    //   424: invokevirtual 228	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   427: putfield 248	com/android/launcher2/SamsungWidgetProviderInfo:mVerticalHeight	I
    //   430: goto -78 -> 352
    //   433: astore_1
    //   434: aload_1
    //   435: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   438: aconst_null
    //   439: areturn
    //   440: astore_1
    //   441: getstatic 69	com/android/launcher2/SamsungWidgetPackageManager:DEBUGGABLE	Z
    //   444: ifeq +15 -> 459
    //   447: ldc 26
    //   449: ldc -4
    //   451: invokestatic 199	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   454: pop
    //   455: aload_1
    //   456: invokevirtual 253	android/content/res/Resources$NotFoundException:printStackTrace	()V
    //   459: aconst_null
    //   460: areturn
    //   461: astore_1
    //   462: goto -21 -> 441
    //   465: astore_1
    //   466: goto -32 -> 434
    //   469: astore_1
    //   470: goto -68 -> 402
    //   473: iload_3
    //   474: iconst_1
    //   475: if_icmpne -430 -> 45
    //   478: aconst_null
    //   479: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	this	SamsungWidgetPackageManager
    //   0	480	1	paramResolveInfo	ResolveInfo
    //   0	480	2	paramString	String
    //   52	424	3	i	int
    //   130	293	4	j	int
    //   156	256	5	k	int
    //   143	212	6	m	int
    //   15	345	7	localContext	Context
    //   63	358	8	localResources	Resources
    //   70	295	9	localConfiguration	Configuration
    //   29	207	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	17	38	android/content/pm/PackageManager$NameNotFoundException
    //   241	252	401	org/xmlpull/v1/XmlPullParserException
    //   256	263	401	org/xmlpull/v1/XmlPullParserException
    //   263	275	401	org/xmlpull/v1/XmlPullParserException
    //   283	305	401	org/xmlpull/v1/XmlPullParserException
    //   307	325	401	org/xmlpull/v1/XmlPullParserException
    //   330	352	401	org/xmlpull/v1/XmlPullParserException
    //   352	374	401	org/xmlpull/v1/XmlPullParserException
    //   376	398	401	org/xmlpull/v1/XmlPullParserException
    //   408	430	401	org/xmlpull/v1/XmlPullParserException
    //   241	252	433	java/io/IOException
    //   256	263	433	java/io/IOException
    //   263	275	433	java/io/IOException
    //   283	305	433	java/io/IOException
    //   307	325	433	java/io/IOException
    //   330	352	433	java/io/IOException
    //   352	374	433	java/io/IOException
    //   376	398	433	java/io/IOException
    //   408	430	433	java/io/IOException
    //   45	53	440	android/content/res/Resources$NotFoundException
    //   58	89	440	android/content/res/Resources$NotFoundException
    //   93	107	440	android/content/res/Resources$NotFoundException
    //   107	170	440	android/content/res/Resources$NotFoundException
    //   180	205	440	android/content/res/Resources$NotFoundException
    //   207	214	440	android/content/res/Resources$NotFoundException
    //   217	241	440	android/content/res/Resources$NotFoundException
    //   241	252	461	android/content/res/Resources$NotFoundException
    //   256	263	461	android/content/res/Resources$NotFoundException
    //   263	275	461	android/content/res/Resources$NotFoundException
    //   283	305	461	android/content/res/Resources$NotFoundException
    //   307	325	461	android/content/res/Resources$NotFoundException
    //   330	352	461	android/content/res/Resources$NotFoundException
    //   352	374	461	android/content/res/Resources$NotFoundException
    //   376	398	461	android/content/res/Resources$NotFoundException
    //   408	430	461	android/content/res/Resources$NotFoundException
    //   45	53	465	java/io/IOException
    //   58	89	465	java/io/IOException
    //   93	107	465	java/io/IOException
    //   107	170	465	java/io/IOException
    //   180	205	465	java/io/IOException
    //   207	214	465	java/io/IOException
    //   217	241	465	java/io/IOException
    //   45	53	469	org/xmlpull/v1/XmlPullParserException
    //   58	89	469	org/xmlpull/v1/XmlPullParserException
    //   93	107	469	org/xmlpull/v1/XmlPullParserException
    //   107	170	469	org/xmlpull/v1/XmlPullParserException
    //   180	205	469	org/xmlpull/v1/XmlPullParserException
    //   207	214	469	org/xmlpull/v1/XmlPullParserException
    //   217	241	469	org/xmlpull/v1/XmlPullParserException
  }
  
  private void loadWidgetsLk(List<SamsungWidgetProviderInfo> paramList, ResolveInfo paramResolveInfo)
  {
    Object localObject1 = new ComponentName(paramResolveInfo.activityInfo.packageName, paramResolveInfo.activityInfo.name);
    Object localObject2 = paramResolveInfo.activityInfo.metaData;
    if ((localObject2 == null) || (((Bundle)localObject2).isEmpty())) {
      Log.e("SWidgetPkgMgr", "No widget meta-data found for component: " + ((ComponentName)localObject1).flattenToShortString());
    }
    for (;;)
    {
      return;
      localObject1 = ((Bundle)localObject2).keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((String)localObject2).startsWith("com.samsung.sec.android.SAMSUNG_WIDGET")))
        {
          localObject2 = loadWidgetLk(paramResolveInfo, (String)localObject2);
          if (localObject2 != null) {
            paramList.add(localObject2);
          }
        }
      }
    }
  }
  
  public int allocWidgetId()
  {
    int i = 1;
    int j = 1;
    Cursor localCursor = this.mApp.getContentResolver().query(LauncherSettings.Favorites.CONTENT_URI_NO_NOTIFICATION, WIDGET_ID_COL, WIDGET_ID_WHERE, null, "appWidgetId");
    if (localCursor != null) {}
    for (i = j;; i = j + 1) {
      if (localCursor.moveToNext())
      {
        j = localCursor.getInt(0);
        if (i == j) {}
      }
      else
      {
        localCursor.close();
        return i;
      }
    }
  }
  
  public SamsungWidgetItem createWidget(Context paramContext, SamsungWidgetProviderInfo paramSamsungWidgetProviderInfo)
  {
    return SamsungWidgetItem.makeSamsungWidget(paramContext, paramSamsungWidgetProviderInfo, allocWidgetId());
  }
  
  public SamsungWidgetItem createWidget(Context paramContext, SamsungWidgetProviderInfo paramSamsungWidgetProviderInfo, SamsungWidgetItem paramSamsungWidgetItem)
  {
    if (paramSamsungWidgetItem.widgetId == -1L) {}
    for (long l = allocWidgetId();; l = paramSamsungWidgetItem.widgetId) {
      return SamsungWidgetItem.makeSamsungWidget(paramContext, paramSamsungWidgetProviderInfo, l, paramSamsungWidgetItem);
    }
  }
  
  public void destroyWidget(ActivityGroup paramActivityGroup, SamsungWidgetItem paramSamsungWidgetItem)
  {
    long l = paramSamsungWidgetItem.widgetId;
    paramActivityGroup.getLocalActivityManager().destroyActivity(Long.toString(l), true);
  }
  
  public SamsungWidgetProviderInfo findWidget(ComponentName paramComponentName, String paramString)
  {
    Iterator localIterator = getWidgetItems().iterator();
    while (localIterator.hasNext())
    {
      SamsungWidgetProviderInfo localSamsungWidgetProviderInfo = (SamsungWidgetProviderInfo)localIterator.next();
      if ((paramComponentName.equals(localSamsungWidgetProviderInfo.getComponentName())) && ((paramString == localSamsungWidgetProviderInfo.mThemeName) || ((paramString != null) && (paramString.equals(localSamsungWidgetProviderInfo.mThemeName))))) {
        return localSamsungWidgetProviderInfo;
      }
    }
    return null;
  }
  
  void forceReload()
  {
    try
    {
      this.mSamsungWidgets = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public List<SamsungWidgetProviderInfo> getWidgetItems()
  {
    try
    {
      if (this.mSamsungWidgets == null)
      {
        Object localObject1 = this.mApp.getResources().getConfiguration();
        this.mConfigMccWhenLoaded = ((Configuration)localObject1).mcc;
        this.mConfigMncWhenLoaded = ((Configuration)localObject1).mnc;
        this.mLocaleWhenLoaded = ((Configuration)localObject1).locale.toString();
        localObject1 = new Intent("com.samsung.sec.android.SAMSUNG_APP_WIDGET_ACTION");
        ((Intent)localObject1).addCategory("com.samsung.sec.android.SAMSUNG_APP_WIDGET");
        Object localObject2 = this.mPkgMgr.queryIntentActivities((Intent)localObject1, 128);
        if (DEBUGGABLE) {
          Log.d("SWidgetPkgMgr", "Query for samsung widgets returned: " + ((List)localObject2).size());
        }
        localObject1 = new ArrayList(10);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          loadWidgetsLk((List)localObject1, (ResolveInfo)((Iterator)localObject2).next());
        }
        this.mSamsungWidgets = Collections.unmodifiableList(localList1);
      }
    }
    finally {}
    List localList2 = this.mSamsungWidgets;
    return localList2;
  }
  
  void loadIfNeeded()
  {
    try
    {
      Configuration localConfiguration = this.mApp.getResources().getConfiguration();
      if ((this.mConfigMccWhenLoaded != localConfiguration.mcc) || (this.mConfigMncWhenLoaded != localConfiguration.mnc) || (!localConfiguration.locale.toString().equals(this.mLocaleWhenLoaded))) {
        this.mSamsungWidgets = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/SamsungWidgetPackageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */