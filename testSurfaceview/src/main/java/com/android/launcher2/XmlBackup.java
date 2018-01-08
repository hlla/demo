package com.android.launcher2;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.xmlpull.v1.XmlSerializer;

public class XmlBackup
  extends BroadcastReceiver
{
  private static final boolean DEBUGGABLE = ;
  private static final String HOMESCREEN_BACKUP_EXML = "/homescreen.exml";
  private static final String REQUEST_BACKUP_HOMESCREEN = "com.sec.android.intent.action.REQUEST_BACKUP_HOMESCREEN";
  private static final String REQUEST_RESTORE_HOMESCREEN = "com.sec.android.intent.action.REQUEST_RESTORE_HOMESCREEN";
  private static final String RESPONSE_BACKUP_HOMESCREEN = "com.sec.android.intent.action.RESPONSE_BACKUP_HOMESCREEN";
  private static final String RESPONSE_RESTORE_HOMESCREEN = "com.sec.android.intent.action.RESPONSE_RESTORE_HOMESCREEN";
  private static final String TAG = "HomeScreenXmlBackup";
  private static Cipher cipher;
  
  /* Error */
  private void RestoreLogs(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 51	java/io/File
    //   3: dup
    //   4: new 53	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   11: aload_2
    //   12: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc 15
    //   17: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 14
    //   28: iconst_0
    //   29: istore 6
    //   31: iconst_0
    //   32: istore 5
    //   34: aconst_null
    //   35: astore 8
    //   37: aload 4
    //   39: invokestatic 69	com/android/launcher2/XmlBackup:StreamCrypt	(Ljava/lang/String;)Ljavax/crypto/spec/SecretKeySpec;
    //   42: astore 4
    //   44: aload 4
    //   46: astore 8
    //   48: aconst_null
    //   49: astore 10
    //   51: aconst_null
    //   52: astore 7
    //   54: aconst_null
    //   55: astore 12
    //   57: aconst_null
    //   58: astore 13
    //   60: aconst_null
    //   61: astore 4
    //   63: aconst_null
    //   64: astore 11
    //   66: new 71	java/io/FileInputStream
    //   69: dup
    //   70: aload 14
    //   72: invokespecial 74	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: astore 9
    //   77: aload 13
    //   79: astore 7
    //   81: aload 12
    //   83: astore 4
    //   85: aload 9
    //   87: aload 8
    //   89: invokestatic 78	com/android/launcher2/XmlBackup:decryptStream	(Ljava/io/InputStream;Ljavax/crypto/spec/SecretKeySpec;)Ljava/io/InputStream;
    //   92: astore 8
    //   94: aload 8
    //   96: astore 4
    //   98: invokestatic 84	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   101: invokevirtual 88	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   104: astore 7
    //   106: aload 8
    //   108: astore 4
    //   110: aload 7
    //   112: aload 8
    //   114: ldc 90
    //   116: invokeinterface 96 3 0
    //   121: aload 8
    //   123: astore 4
    //   125: aload_1
    //   126: invokevirtual 102	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   129: checkcast 104	com/android/launcher2/LauncherApplication
    //   132: invokevirtual 108	com/android/launcher2/LauncherApplication:getLauncherProvider	()Lcom/android/launcher2/LauncherProvider;
    //   135: aload 7
    //   137: aload_2
    //   138: invokevirtual 114	com/android/launcher2/LauncherProvider:restoreHomeScreenDB	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)I
    //   141: pop
    //   142: aload 8
    //   144: astore 4
    //   146: aload_1
    //   147: new 116	android/content/Intent
    //   150: dup
    //   151: ldc 118
    //   153: invokespecial 119	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   156: invokevirtual 123	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   159: aload 8
    //   161: astore 7
    //   163: aload 8
    //   165: astore 4
    //   167: aload 8
    //   169: invokevirtual 128	java/io/InputStream:close	()V
    //   172: aload_0
    //   173: aload 8
    //   175: invokespecial 131	com/android/launcher2/XmlBackup:close	(Ljava/io/InputStream;)V
    //   178: aload_0
    //   179: aload 9
    //   181: invokespecial 131	com/android/launcher2/XmlBackup:close	(Ljava/io/InputStream;)V
    //   184: iconst_0
    //   185: putstatic 136	com/android/launcher2/Launcher:isHomescreenRestoring	Z
    //   188: new 116	android/content/Intent
    //   191: dup
    //   192: ldc 27
    //   194: invokespecial 119	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   197: astore_2
    //   198: aload_2
    //   199: ldc -118
    //   201: iload 6
    //   203: invokevirtual 142	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   206: pop
    //   207: aload_2
    //   208: ldc -112
    //   210: iload 5
    //   212: invokevirtual 142	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   215: pop
    //   216: aload_2
    //   217: ldc -110
    //   219: aload 14
    //   221: invokevirtual 150	java/io/File:length	()J
    //   224: l2i
    //   225: invokevirtual 142	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   228: pop
    //   229: aload_2
    //   230: ldc -104
    //   232: aload_3
    //   233: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   236: pop
    //   237: aload_1
    //   238: aload_2
    //   239: invokevirtual 123	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   242: return
    //   243: astore 4
    //   245: aload 4
    //   247: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   250: goto -202 -> 48
    //   253: astore_2
    //   254: iconst_1
    //   255: istore 6
    //   257: iconst_1
    //   258: istore 5
    //   260: aload 8
    //   262: astore 7
    //   264: aload 8
    //   266: astore 4
    //   268: ldc 30
    //   270: new 53	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   277: ldc -96
    //   279: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_2
    //   283: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 169	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   292: pop
    //   293: goto -134 -> 159
    //   296: astore 4
    //   298: aload 9
    //   300: astore_2
    //   301: aload 7
    //   303: astore 8
    //   305: aload 4
    //   307: astore 9
    //   309: iconst_1
    //   310: istore 6
    //   312: iconst_2
    //   313: istore 5
    //   315: aload_2
    //   316: astore 4
    //   318: aload 8
    //   320: astore 7
    //   322: ldc 30
    //   324: new 53	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   331: ldc -85
    //   333: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload 9
    //   338: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 169	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   347: pop
    //   348: aload_0
    //   349: aload 8
    //   351: invokespecial 131	com/android/launcher2/XmlBackup:close	(Ljava/io/InputStream;)V
    //   354: aload_0
    //   355: aload_2
    //   356: invokespecial 131	com/android/launcher2/XmlBackup:close	(Ljava/io/InputStream;)V
    //   359: goto -175 -> 184
    //   362: astore_2
    //   363: aload 4
    //   365: astore_1
    //   366: aload_0
    //   367: aload 7
    //   369: invokespecial 131	com/android/launcher2/XmlBackup:close	(Ljava/io/InputStream;)V
    //   372: aload_0
    //   373: aload_1
    //   374: invokespecial 131	com/android/launcher2/XmlBackup:close	(Ljava/io/InputStream;)V
    //   377: aload_2
    //   378: athrow
    //   379: astore_2
    //   380: aload 9
    //   382: astore_1
    //   383: aload 4
    //   385: astore 7
    //   387: goto -21 -> 366
    //   390: astore 9
    //   392: aload 11
    //   394: astore_2
    //   395: aload 10
    //   397: astore 8
    //   399: goto -90 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	XmlBackup
    //   0	402	1	paramContext	Context
    //   0	402	2	paramString1	String
    //   0	402	3	paramString2	String
    //   0	402	4	paramString3	String
    //   32	282	5	i	int
    //   29	282	6	j	int
    //   52	334	7	localObject1	Object
    //   35	363	8	localObject2	Object
    //   75	306	9	localObject3	Object
    //   390	1	9	localException	Exception
    //   49	347	10	localObject4	Object
    //   64	329	11	localObject5	Object
    //   55	27	12	localObject6	Object
    //   58	20	13	localObject7	Object
    //   26	194	14	localFile	File
    // Exception table:
    //   from	to	target	type
    //   37	44	243	java/lang/Exception
    //   98	106	253	java/lang/Exception
    //   110	121	253	java/lang/Exception
    //   125	142	253	java/lang/Exception
    //   146	159	253	java/lang/Exception
    //   85	94	296	java/lang/Exception
    //   167	172	296	java/lang/Exception
    //   268	293	296	java/lang/Exception
    //   66	77	362	finally
    //   322	348	362	finally
    //   85	94	379	finally
    //   98	106	379	finally
    //   110	121	379	finally
    //   125	142	379	finally
    //   146	159	379	finally
    //   167	172	379	finally
    //   268	293	379	finally
    //   66	77	390	java/lang/Exception
  }
  
  public static SecretKeySpec StreamCrypt(String paramString)
    throws Exception
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
    localMessageDigest.update(paramString.getBytes("UTF-8"));
    paramString = new byte[16];
    System.arraycopy(localMessageDigest.digest(), 0, paramString, 0, paramString.length);
    cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    return new SecretKeySpec(paramString, "AES");
  }
  
  /* Error */
  private void XmlGenerator(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 51	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 6
    //   10: aload 6
    //   12: invokevirtual 226	java/io/File:exists	()Z
    //   15: ifne +9 -> 24
    //   18: aload 6
    //   20: invokevirtual 229	java/io/File:mkdirs	()Z
    //   23: pop
    //   24: new 51	java/io/File
    //   27: dup
    //   28: new 53	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   35: aload_2
    //   36: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 15
    //   41: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore 17
    //   52: aload 17
    //   54: invokevirtual 226	java/io/File:exists	()Z
    //   57: ifne +9 -> 66
    //   60: aload 17
    //   62: invokevirtual 232	java/io/File:createNewFile	()Z
    //   65: pop
    //   66: new 8	com/android/launcher2/XmlBackup$Result
    //   69: dup
    //   70: aconst_null
    //   71: invokespecial 235	com/android/launcher2/XmlBackup$Result:<init>	(Lcom/android/launcher2/XmlBackup$1;)V
    //   74: astore 18
    //   76: aconst_null
    //   77: astore 9
    //   79: aload 4
    //   81: invokestatic 69	com/android/launcher2/XmlBackup:StreamCrypt	(Ljava/lang/String;)Ljavax/crypto/spec/SecretKeySpec;
    //   84: astore 4
    //   86: aload 4
    //   88: astore 9
    //   90: aconst_null
    //   91: astore 10
    //   93: aconst_null
    //   94: astore 14
    //   96: aconst_null
    //   97: astore 11
    //   99: aconst_null
    //   100: astore 8
    //   102: aconst_null
    //   103: astore 7
    //   105: aconst_null
    //   106: astore 15
    //   108: aconst_null
    //   109: astore 13
    //   111: aconst_null
    //   112: astore 16
    //   114: aconst_null
    //   115: astore 12
    //   117: aload 16
    //   119: astore 6
    //   121: aload 7
    //   123: astore 4
    //   125: new 237	java/io/StringWriter
    //   128: dup
    //   129: invokespecial 238	java/io/StringWriter:<init>	()V
    //   132: astore 19
    //   134: aload 16
    //   136: astore 6
    //   138: aload 7
    //   140: astore 4
    //   142: new 240	java/io/FileOutputStream
    //   145: dup
    //   146: aload 17
    //   148: invokespecial 241	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   151: astore 7
    //   153: aload 15
    //   155: astore 4
    //   157: aload 14
    //   159: astore 6
    //   161: aload 7
    //   163: aload 9
    //   165: invokestatic 245	com/android/launcher2/XmlBackup:encryptStream	(Ljava/io/OutputStream;Ljavax/crypto/spec/SecretKeySpec;)Ljava/io/OutputStream;
    //   168: astore 9
    //   170: aload 9
    //   172: astore 4
    //   174: aload 9
    //   176: astore 6
    //   178: aload 9
    //   180: astore 8
    //   182: invokestatic 251	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   185: astore 10
    //   187: aload 10
    //   189: ifnonnull +23 -> 212
    //   192: aload 9
    //   194: astore 4
    //   196: aload 9
    //   198: astore 6
    //   200: aload 9
    //   202: astore 8
    //   204: ldc 30
    //   206: ldc -3
    //   208: invokestatic 256	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   211: pop
    //   212: aload 9
    //   214: astore 8
    //   216: aload 10
    //   218: aload 9
    //   220: ldc -75
    //   222: invokeinterface 262 3 0
    //   227: aload 9
    //   229: astore 8
    //   231: aload 10
    //   233: ldc -75
    //   235: iconst_1
    //   236: invokestatic 268	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   239: invokeinterface 272 3 0
    //   244: aload 9
    //   246: astore 8
    //   248: aload 10
    //   250: aconst_null
    //   251: ldc_w 274
    //   254: invokeinterface 278 3 0
    //   259: pop
    //   260: aload 9
    //   262: astore 8
    //   264: aload 10
    //   266: aload_1
    //   267: ldc_w 280
    //   270: iconst_0
    //   271: invokevirtual 284	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   274: ldc_w 286
    //   277: iconst_m1
    //   278: invokeinterface 292 3 0
    //   283: invokestatic 297	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   286: invokeinterface 301 2 0
    //   291: pop
    //   292: aload 9
    //   294: astore 8
    //   296: aload 10
    //   298: aconst_null
    //   299: ldc_w 274
    //   302: invokeinterface 304 3 0
    //   307: pop
    //   308: aload 9
    //   310: astore 8
    //   312: aload 10
    //   314: aconst_null
    //   315: ldc_w 306
    //   318: invokeinterface 278 3 0
    //   323: pop
    //   324: aload 9
    //   326: astore 8
    //   328: aload 10
    //   330: aload_1
    //   331: ldc_w 280
    //   334: iconst_0
    //   335: invokevirtual 284	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   338: ldc_w 308
    //   341: iconst_m1
    //   342: invokeinterface 292 3 0
    //   347: invokestatic 297	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   350: invokeinterface 301 2 0
    //   355: pop
    //   356: aload 9
    //   358: astore 8
    //   360: aload 10
    //   362: aconst_null
    //   363: ldc_w 306
    //   366: invokeinterface 304 3 0
    //   371: pop
    //   372: aload 9
    //   374: astore 8
    //   376: aload_0
    //   377: aload_1
    //   378: aload 10
    //   380: aload_2
    //   381: aload 18
    //   383: invokespecial 312	com/android/launcher2/XmlBackup:makeHomeTag	(Landroid/content/Context;Lorg/xmlpull/v1/XmlSerializer;Ljava/lang/String;Lcom/android/launcher2/XmlBackup$Result;)V
    //   386: aload 9
    //   388: astore 8
    //   390: aload_0
    //   391: aload_1
    //   392: aload 10
    //   394: aload_2
    //   395: invokespecial 316	com/android/launcher2/XmlBackup:makeHotseatTag	(Landroid/content/Context;Lorg/xmlpull/v1/XmlSerializer;Ljava/lang/String;)V
    //   398: aload 9
    //   400: astore 8
    //   402: aload 10
    //   404: invokeinterface 319 1 0
    //   409: aload 9
    //   411: astore 8
    //   413: aload 10
    //   415: invokeinterface 322 1 0
    //   420: aload 9
    //   422: astore 4
    //   424: aload 9
    //   426: astore 6
    //   428: aload 9
    //   430: astore 8
    //   432: new 324	java/io/BufferedInputStream
    //   435: dup
    //   436: new 326	java/io/ByteArrayInputStream
    //   439: dup
    //   440: aload 19
    //   442: invokevirtual 327	java/io/StringWriter:toString	()Ljava/lang/String;
    //   445: ldc -75
    //   447: invokevirtual 187	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   450: invokespecial 329	java/io/ByteArrayInputStream:<init>	([B)V
    //   453: invokespecial 331	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   456: astore_2
    //   457: aload 9
    //   459: astore 4
    //   461: aload 9
    //   463: astore 6
    //   465: aload 9
    //   467: astore 8
    //   469: sipush 1024
    //   472: newarray <illegal type>
    //   474: astore 10
    //   476: aload 9
    //   478: astore 4
    //   480: aload 9
    //   482: astore 6
    //   484: aload 9
    //   486: astore 8
    //   488: aload_2
    //   489: aload 10
    //   491: iconst_0
    //   492: sipush 1024
    //   495: invokevirtual 335	java/io/BufferedInputStream:read	([BII)I
    //   498: istore 5
    //   500: iload 5
    //   502: iconst_m1
    //   503: if_icmpeq +459 -> 962
    //   506: aload 9
    //   508: astore 4
    //   510: aload 9
    //   512: astore 6
    //   514: aload 9
    //   516: astore 8
    //   518: aload 9
    //   520: aload 10
    //   522: iconst_0
    //   523: iload 5
    //   525: invokevirtual 341	java/io/OutputStream:write	([BII)V
    //   528: goto -52 -> 476
    //   531: astore 8
    //   533: aload 7
    //   535: astore_2
    //   536: aload 4
    //   538: astore 7
    //   540: aload_2
    //   541: astore 6
    //   543: aload 7
    //   545: astore 4
    //   547: aload 8
    //   549: invokevirtual 342	java/lang/RuntimeException:printStackTrace	()V
    //   552: aload_2
    //   553: astore 6
    //   555: aload 7
    //   557: astore 4
    //   559: aload 18
    //   561: iconst_1
    //   562: putfield 346	com/android/launcher2/XmlBackup$Result:result	I
    //   565: aload_2
    //   566: astore 6
    //   568: aload 7
    //   570: astore 4
    //   572: aload 18
    //   574: iconst_2
    //   575: putfield 349	com/android/launcher2/XmlBackup$Result:err_code	I
    //   578: aload_2
    //   579: astore 6
    //   581: aload 7
    //   583: astore 4
    //   585: ldc 30
    //   587: ldc_w 351
    //   590: invokestatic 169	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   593: pop
    //   594: aload_0
    //   595: aload 7
    //   597: invokespecial 354	com/android/launcher2/XmlBackup:close	(Ljava/io/OutputStream;)V
    //   600: aload_0
    //   601: aload_2
    //   602: invokespecial 354	com/android/launcher2/XmlBackup:close	(Ljava/io/OutputStream;)V
    //   605: new 116	android/content/Intent
    //   608: dup
    //   609: ldc 24
    //   611: invokespecial 119	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   614: astore_2
    //   615: aload_2
    //   616: ldc -118
    //   618: aload 18
    //   620: getfield 346	com/android/launcher2/XmlBackup$Result:result	I
    //   623: invokevirtual 142	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   626: pop
    //   627: aload_2
    //   628: ldc -112
    //   630: aload 18
    //   632: getfield 349	com/android/launcher2/XmlBackup$Result:err_code	I
    //   635: invokevirtual 142	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   638: pop
    //   639: aload_2
    //   640: ldc -110
    //   642: aload 17
    //   644: invokevirtual 150	java/io/File:length	()J
    //   647: l2i
    //   648: invokevirtual 142	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   651: pop
    //   652: aload_2
    //   653: ldc -104
    //   655: aload_3
    //   656: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   659: pop
    //   660: aload_1
    //   661: aload_2
    //   662: invokevirtual 123	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   665: return
    //   666: astore 6
    //   668: aload 6
    //   670: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   673: goto -607 -> 66
    //   676: astore 4
    //   678: aload 4
    //   680: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   683: goto -593 -> 90
    //   686: astore_2
    //   687: aload 9
    //   689: astore 4
    //   691: aload 9
    //   693: astore 6
    //   695: aload 9
    //   697: astore 8
    //   699: aload_2
    //   700: invokevirtual 342	java/lang/RuntimeException:printStackTrace	()V
    //   703: aload 9
    //   705: astore 4
    //   707: aload 9
    //   709: astore 6
    //   711: aload 9
    //   713: astore 8
    //   715: aload 18
    //   717: iconst_1
    //   718: putfield 346	com/android/launcher2/XmlBackup$Result:result	I
    //   721: aload 9
    //   723: astore 4
    //   725: aload 9
    //   727: astore 6
    //   729: aload 9
    //   731: astore 8
    //   733: aload 18
    //   735: iconst_1
    //   736: putfield 349	com/android/launcher2/XmlBackup$Result:err_code	I
    //   739: aload 9
    //   741: astore 4
    //   743: aload 9
    //   745: astore 6
    //   747: aload 9
    //   749: astore 8
    //   751: ldc 30
    //   753: ldc_w 351
    //   756: invokestatic 169	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   759: pop
    //   760: goto -340 -> 420
    //   763: astore 8
    //   765: aload 7
    //   767: astore_2
    //   768: aload 6
    //   770: astore 7
    //   772: aload_2
    //   773: astore 6
    //   775: aload 7
    //   777: astore 4
    //   779: aload 8
    //   781: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   784: aload_2
    //   785: astore 6
    //   787: aload 7
    //   789: astore 4
    //   791: aload 18
    //   793: iconst_1
    //   794: putfield 346	com/android/launcher2/XmlBackup$Result:result	I
    //   797: aload_2
    //   798: astore 6
    //   800: aload 7
    //   802: astore 4
    //   804: aload 18
    //   806: iconst_2
    //   807: putfield 349	com/android/launcher2/XmlBackup$Result:err_code	I
    //   810: aload_2
    //   811: astore 6
    //   813: aload 7
    //   815: astore 4
    //   817: ldc 30
    //   819: ldc_w 357
    //   822: invokestatic 169	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   825: pop
    //   826: aload_0
    //   827: aload 7
    //   829: invokespecial 354	com/android/launcher2/XmlBackup:close	(Ljava/io/OutputStream;)V
    //   832: aload_0
    //   833: aload_2
    //   834: invokespecial 354	com/android/launcher2/XmlBackup:close	(Ljava/io/OutputStream;)V
    //   837: goto -232 -> 605
    //   840: astore_2
    //   841: aload 9
    //   843: astore 4
    //   845: aload 9
    //   847: astore 6
    //   849: aload 9
    //   851: astore 8
    //   853: ldc 30
    //   855: new 53	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   862: ldc_w 359
    //   865: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload_2
    //   869: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   872: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: invokestatic 169	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   878: pop
    //   879: aload 9
    //   881: astore 4
    //   883: aload 9
    //   885: astore 6
    //   887: aload 9
    //   889: astore 8
    //   891: aload 18
    //   893: iconst_1
    //   894: putfield 346	com/android/launcher2/XmlBackup$Result:result	I
    //   897: aload 9
    //   899: astore 4
    //   901: aload 9
    //   903: astore 6
    //   905: aload 9
    //   907: astore 8
    //   909: aload 18
    //   911: iconst_1
    //   912: putfield 349	com/android/launcher2/XmlBackup$Result:err_code	I
    //   915: aload 9
    //   917: astore 4
    //   919: aload 9
    //   921: astore 6
    //   923: aload 9
    //   925: astore 8
    //   927: ldc 30
    //   929: ldc_w 361
    //   932: invokestatic 169	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   935: pop
    //   936: goto -516 -> 420
    //   939: astore_1
    //   940: aload 8
    //   942: astore 4
    //   944: aload 7
    //   946: astore 6
    //   948: aload_0
    //   949: aload 4
    //   951: invokespecial 354	com/android/launcher2/XmlBackup:close	(Ljava/io/OutputStream;)V
    //   954: aload_0
    //   955: aload 6
    //   957: invokespecial 354	com/android/launcher2/XmlBackup:close	(Ljava/io/OutputStream;)V
    //   960: aload_1
    //   961: athrow
    //   962: aload 9
    //   964: astore 4
    //   966: aload 9
    //   968: astore 6
    //   970: aload 9
    //   972: astore 8
    //   974: aload 9
    //   976: invokevirtual 362	java/io/OutputStream:close	()V
    //   979: aload_0
    //   980: aload 9
    //   982: invokespecial 354	com/android/launcher2/XmlBackup:close	(Ljava/io/OutputStream;)V
    //   985: aload_0
    //   986: aload 7
    //   988: invokespecial 354	com/android/launcher2/XmlBackup:close	(Ljava/io/OutputStream;)V
    //   991: goto -386 -> 605
    //   994: astore_1
    //   995: goto -47 -> 948
    //   998: astore 8
    //   1000: aload 13
    //   1002: astore_2
    //   1003: aload 11
    //   1005: astore 7
    //   1007: goto -235 -> 772
    //   1010: astore 8
    //   1012: aload 12
    //   1014: astore_2
    //   1015: aload 10
    //   1017: astore 7
    //   1019: goto -479 -> 540
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1022	0	this	XmlBackup
    //   0	1022	1	paramContext	Context
    //   0	1022	2	paramString1	String
    //   0	1022	3	paramString2	String
    //   0	1022	4	paramString3	String
    //   498	26	5	i	int
    //   8	572	6	localObject1	Object
    //   666	3	6	localIOException	IOException
    //   693	276	6	localObject2	Object
    //   103	915	7	localObject3	Object
    //   100	417	8	localObject4	Object
    //   531	17	8	localRuntimeException1	RuntimeException
    //   697	53	8	localObject5	Object
    //   763	17	8	localException1	Exception
    //   851	122	8	localObject6	Object
    //   998	1	8	localException2	Exception
    //   1010	1	8	localRuntimeException2	RuntimeException
    //   77	904	9	localObject7	Object
    //   91	925	10	localObject8	Object
    //   97	907	11	localObject9	Object
    //   115	898	12	localObject10	Object
    //   109	892	13	localObject11	Object
    //   94	64	14	localObject12	Object
    //   106	48	15	localObject13	Object
    //   112	23	16	localObject14	Object
    //   50	593	17	localFile	File
    //   74	836	18	localResult	Result
    //   132	309	19	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   161	170	531	java/lang/RuntimeException
    //   182	187	531	java/lang/RuntimeException
    //   204	212	531	java/lang/RuntimeException
    //   432	457	531	java/lang/RuntimeException
    //   469	476	531	java/lang/RuntimeException
    //   488	500	531	java/lang/RuntimeException
    //   518	528	531	java/lang/RuntimeException
    //   699	703	531	java/lang/RuntimeException
    //   715	721	531	java/lang/RuntimeException
    //   733	739	531	java/lang/RuntimeException
    //   751	760	531	java/lang/RuntimeException
    //   853	879	531	java/lang/RuntimeException
    //   891	897	531	java/lang/RuntimeException
    //   909	915	531	java/lang/RuntimeException
    //   927	936	531	java/lang/RuntimeException
    //   974	979	531	java/lang/RuntimeException
    //   60	66	666	java/io/IOException
    //   79	86	676	java/lang/Exception
    //   216	227	686	java/lang/RuntimeException
    //   231	244	686	java/lang/RuntimeException
    //   248	260	686	java/lang/RuntimeException
    //   264	292	686	java/lang/RuntimeException
    //   296	308	686	java/lang/RuntimeException
    //   312	324	686	java/lang/RuntimeException
    //   328	356	686	java/lang/RuntimeException
    //   360	372	686	java/lang/RuntimeException
    //   376	386	686	java/lang/RuntimeException
    //   390	398	686	java/lang/RuntimeException
    //   402	409	686	java/lang/RuntimeException
    //   413	420	686	java/lang/RuntimeException
    //   161	170	763	java/lang/Exception
    //   182	187	763	java/lang/Exception
    //   204	212	763	java/lang/Exception
    //   432	457	763	java/lang/Exception
    //   469	476	763	java/lang/Exception
    //   488	500	763	java/lang/Exception
    //   518	528	763	java/lang/Exception
    //   699	703	763	java/lang/Exception
    //   715	721	763	java/lang/Exception
    //   733	739	763	java/lang/Exception
    //   751	760	763	java/lang/Exception
    //   853	879	763	java/lang/Exception
    //   891	897	763	java/lang/Exception
    //   909	915	763	java/lang/Exception
    //   927	936	763	java/lang/Exception
    //   974	979	763	java/lang/Exception
    //   216	227	840	java/lang/Exception
    //   231	244	840	java/lang/Exception
    //   248	260	840	java/lang/Exception
    //   264	292	840	java/lang/Exception
    //   296	308	840	java/lang/Exception
    //   312	324	840	java/lang/Exception
    //   328	356	840	java/lang/Exception
    //   360	372	840	java/lang/Exception
    //   376	386	840	java/lang/Exception
    //   390	398	840	java/lang/Exception
    //   402	409	840	java/lang/Exception
    //   413	420	840	java/lang/Exception
    //   161	170	939	finally
    //   182	187	939	finally
    //   204	212	939	finally
    //   216	227	939	finally
    //   231	244	939	finally
    //   248	260	939	finally
    //   264	292	939	finally
    //   296	308	939	finally
    //   312	324	939	finally
    //   328	356	939	finally
    //   360	372	939	finally
    //   376	386	939	finally
    //   390	398	939	finally
    //   402	409	939	finally
    //   413	420	939	finally
    //   432	457	939	finally
    //   469	476	939	finally
    //   488	500	939	finally
    //   518	528	939	finally
    //   699	703	939	finally
    //   715	721	939	finally
    //   733	739	939	finally
    //   751	760	939	finally
    //   853	879	939	finally
    //   891	897	939	finally
    //   909	915	939	finally
    //   927	936	939	finally
    //   974	979	939	finally
    //   125	134	994	finally
    //   142	153	994	finally
    //   547	552	994	finally
    //   559	565	994	finally
    //   572	578	994	finally
    //   585	594	994	finally
    //   779	784	994	finally
    //   791	797	994	finally
    //   804	810	994	finally
    //   817	826	994	finally
    //   125	134	998	java/lang/Exception
    //   142	153	998	java/lang/Exception
    //   125	134	1010	java/lang/RuntimeException
    //   142	153	1010	java/lang/RuntimeException
  }
  
  private void close(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
  }
  
  private void close(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream)
    {
      paramOutputStream.printStackTrace();
    }
  }
  
  private boolean createBackupShortcutIcon(String paramString1, String paramString2, Bitmap paramBitmap)
    throws FileNotFoundException, IOException
  {
    paramString1 = paramString1 + "/" + paramString2 + ".jpg";
    if (paramBitmap != null)
    {
      deleteFile(paramString1);
      saveBitmap(paramString1, paramBitmap);
      return true;
    }
    return false;
  }
  
  public static InputStream decryptStream(InputStream paramInputStream, SecretKeySpec paramSecretKeySpec)
    throws Exception
  {
    Object localObject = new byte[cipher.getBlockSize()];
    paramInputStream.read((byte[])localObject);
    localObject = new IvParameterSpec((byte[])localObject);
    cipher.init(2, paramSecretKeySpec, (AlgorithmParameterSpec)localObject);
    return new CipherInputStream(paramInputStream, cipher);
  }
  
  private void deleteFile(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static OutputStream encryptStream(OutputStream paramOutputStream, SecretKeySpec paramSecretKeySpec)
    throws Exception
  {
    byte[] arrayOfByte = new byte[cipher.getBlockSize()];
    new SecureRandom().nextBytes(arrayOfByte);
    IvParameterSpec localIvParameterSpec = new IvParameterSpec(arrayOfByte);
    paramOutputStream.write(arrayOfByte);
    cipher.init(1, paramSecretKeySpec, localIvParameterSpec);
    return new CipherOutputStream(paramOutputStream, cipher);
  }
  
  /* Error */
  private void makeFolderTag(Context paramContext, XmlSerializer paramXmlSerializer, int paramInt, String paramString)
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 424	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 430	com/android/launcher2/LauncherSettings$Favorites:CONTENT_URI	Landroid/net/Uri;
    //   7: aconst_null
    //   8: new 53	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 432
    //   18: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_3
    //   22: invokestatic 434	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   25: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 440	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 11
    //   38: aload 11
    //   40: invokeinterface 445 1 0
    //   45: ifeq +390 -> 435
    //   48: aconst_null
    //   49: astore 7
    //   51: aload 11
    //   53: aload 11
    //   55: ldc_w 447
    //   58: invokeinterface 451 2 0
    //   63: invokeinterface 454 2 0
    //   68: istore_3
    //   69: iload_3
    //   70: tableswitch	default:+388->458, 0:+344->414, 1:+352->422
    //   92: aload 7
    //   94: ifnull -56 -> 38
    //   97: aload_2
    //   98: aconst_null
    //   99: aload 7
    //   101: invokeinterface 278 3 0
    //   106: pop
    //   107: aload 11
    //   109: aload 11
    //   111: ldc_w 456
    //   114: invokeinterface 451 2 0
    //   119: invokeinterface 459 2 0
    //   124: astore 12
    //   126: aload 11
    //   128: aload 11
    //   130: ldc_w 461
    //   133: invokeinterface 451 2 0
    //   138: invokeinterface 454 2 0
    //   143: istore 5
    //   145: aload 11
    //   147: ldc_w 463
    //   150: invokeinterface 451 2 0
    //   155: istore 6
    //   157: aload 11
    //   159: aload 11
    //   161: ldc_w 465
    //   164: invokeinterface 451 2 0
    //   169: invokeinterface 459 2 0
    //   174: astore 13
    //   176: aconst_null
    //   177: astore 8
    //   179: aconst_null
    //   180: astore 9
    //   182: aconst_null
    //   183: astore 10
    //   185: aload 12
    //   187: ifnull +18 -> 205
    //   190: aload 12
    //   192: iconst_0
    //   193: invokestatic 468	android/content/Intent:parseUri	(Ljava/lang/String;I)Landroid/content/Intent;
    //   196: astore 8
    //   198: aload 8
    //   200: invokevirtual 472	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   203: astore 8
    //   205: aload 8
    //   207: ifnull +17 -> 224
    //   210: aload 8
    //   212: invokevirtual 477	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   215: astore 9
    //   217: aload 8
    //   219: invokevirtual 480	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   222: astore 10
    //   224: aload 11
    //   226: aload 11
    //   228: ldc_w 482
    //   231: invokeinterface 451 2 0
    //   236: invokeinterface 454 2 0
    //   241: invokestatic 434	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   244: astore 8
    //   246: aload 9
    //   248: ifnull +16 -> 264
    //   251: aload_2
    //   252: aconst_null
    //   253: ldc_w 484
    //   256: aload 9
    //   258: invokeinterface 488 4 0
    //   263: pop
    //   264: aload 10
    //   266: ifnull +16 -> 282
    //   269: aload_2
    //   270: aconst_null
    //   271: ldc_w 490
    //   274: aload 10
    //   276: invokeinterface 488 4 0
    //   281: pop
    //   282: aload 8
    //   284: ifnull +16 -> 300
    //   287: aload_2
    //   288: aconst_null
    //   289: ldc_w 482
    //   292: aload 8
    //   294: invokeinterface 488 4 0
    //   299: pop
    //   300: aload 13
    //   302: ifnull +16 -> 318
    //   305: aload_2
    //   306: aconst_null
    //   307: ldc_w 465
    //   310: aload 13
    //   312: invokeinterface 488 4 0
    //   317: pop
    //   318: iload_3
    //   319: iconst_1
    //   320: if_icmpne +56 -> 376
    //   323: aload_2
    //   324: aconst_null
    //   325: ldc_w 492
    //   328: aload 12
    //   330: invokeinterface 488 4 0
    //   335: pop
    //   336: iload 5
    //   338: invokestatic 297	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   341: astore 8
    //   343: aload_0
    //   344: aload 4
    //   346: aload 8
    //   348: aload_0
    //   349: aload 11
    //   351: iload 6
    //   353: aload_1
    //   354: invokevirtual 496	com/android/launcher2/XmlBackup:getIconFromCursor	(Landroid/database/Cursor;ILandroid/content/Context;)Landroid/graphics/Bitmap;
    //   357: invokespecial 498	com/android/launcher2/XmlBackup:createBackupShortcutIcon	(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;)Z
    //   360: ifeq +16 -> 376
    //   363: aload_2
    //   364: aconst_null
    //   365: ldc_w 463
    //   368: aload 8
    //   370: invokeinterface 488 4 0
    //   375: pop
    //   376: aload_2
    //   377: aconst_null
    //   378: aload 7
    //   380: invokeinterface 304 3 0
    //   385: pop
    //   386: goto -348 -> 38
    //   389: astore_1
    //   390: aload 11
    //   392: ifnull +20 -> 412
    //   395: aload 11
    //   397: invokeinterface 501 1 0
    //   402: ifne +10 -> 412
    //   405: aload 11
    //   407: invokeinterface 502 1 0
    //   412: aload_1
    //   413: athrow
    //   414: ldc_w 504
    //   417: astore 7
    //   419: goto -327 -> 92
    //   422: ldc_w 506
    //   425: astore 7
    //   427: goto -335 -> 92
    //   430: astore 7
    //   432: goto -394 -> 38
    //   435: aload 11
    //   437: ifnull +20 -> 457
    //   440: aload 11
    //   442: invokeinterface 501 1 0
    //   447: ifne +10 -> 457
    //   450: aload 11
    //   452: invokeinterface 502 1 0
    //   457: return
    //   458: goto -366 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	this	XmlBackup
    //   0	461	1	paramContext	Context
    //   0	461	2	paramXmlSerializer	XmlSerializer
    //   0	461	3	paramInt	int
    //   0	461	4	paramString	String
    //   143	194	5	i	int
    //   155	197	6	j	int
    //   49	377	7	str1	String
    //   430	1	7	localURISyntaxException	URISyntaxException
    //   177	192	8	localObject	Object
    //   180	77	9	str2	String
    //   183	92	10	str3	String
    //   36	415	11	localCursor	Cursor
    //   124	205	12	str4	String
    //   174	137	13	str5	String
    // Exception table:
    //   from	to	target	type
    //   38	48	389	finally
    //   51	69	389	finally
    //   97	176	389	finally
    //   190	198	389	finally
    //   198	205	389	finally
    //   210	224	389	finally
    //   224	246	389	finally
    //   251	264	389	finally
    //   269	282	389	finally
    //   287	300	389	finally
    //   305	318	389	finally
    //   323	376	389	finally
    //   376	386	389	finally
    //   190	198	430	java/net/URISyntaxException
  }
  
  private void makeHomeTag(Context paramContext, XmlSerializer paramXmlSerializer, String paramString, Result paramResult)
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
    Cursor localCursor = paramContext.getContentResolver().query(LauncherSettings.Favorites.CONTENT_URI, null, "container=" + String.valueOf(-100), null, null);
    if (localCursor == null) {}
    label115:
    int i;
    int j;
    String str8;
    String str1;
    int k;
    int m;
    Object localObject2;
    try
    {
      paramResult.result = 1;
      paramResult.err_code = 1;
      Log.d("HomeScreenXmlBackup", "fail to open Favorites cursor");
      return;
    }
    finally
    {
      String str3;
      String str4;
      String str5;
      String str6;
      String str7;
      if ((localCursor == null) || (localCursor.isClosed())) {
        break label655;
      }
      localCursor.close();
    }
    if (localCursor.moveToFirst())
    {
      paramXmlSerializer.startTag(null, "home");
      i = localCursor.getInt(localCursor.getColumnIndexOrThrow("_id"));
      j = localCursor.getInt(localCursor.getColumnIndexOrThrow("itemType"));
      str3 = String.valueOf(localCursor.getInt(localCursor.getColumnIndexOrThrow("screen")));
      str4 = String.valueOf(localCursor.getInt(localCursor.getColumnIndexOrThrow("cellX")));
      str5 = String.valueOf(localCursor.getInt(localCursor.getColumnIndexOrThrow("cellY")));
      str6 = String.valueOf(localCursor.getInt(localCursor.getColumnIndexOrThrow("spanX")));
      str7 = String.valueOf(localCursor.getInt(localCursor.getColumnIndexOrThrow("spanY")));
      str8 = localCursor.getString(localCursor.getColumnIndexOrThrow("intent"));
      str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("title"));
      k = localCursor.getInt(localCursor.getColumnIndexOrThrow("appWidgetId"));
      m = localCursor.getColumnIndexOrThrow("icon");
      localObject2 = null;
      if (str8 == null) {}
    }
    for (;;)
    {
      try
      {
        paramResult = Intent.parseUri(str8, 0);
        localObject2 = paramResult.getComponent();
        paramResult = null;
        localObject1 = null;
        if (localObject2 == null) {
          break label842;
        }
        paramResult = ((ComponentName)localObject2).getClassName();
        localObject1 = ((ComponentName)localObject2).getPackageName();
      }
      catch (URISyntaxException paramResult)
      {
        label655:
        continue;
        str2 = "favorite";
        localObject2 = paramResult;
        paramResult = str2;
        continue;
        str2 = "appwidget";
        localAppWidgetProviderInfo = localAppWidgetManager.getAppWidgetInfo(k);
        localObject2 = paramResult;
        paramResult = str2;
        if (localAppWidgetProviderInfo == null) {
          continue;
        }
        localObject2 = localAppWidgetProviderInfo.provider.getClassName();
        Object localObject1 = localAppWidgetProviderInfo.provider.getPackageName();
        str1 = localAppWidgetProviderInfo.label;
        paramResult = str2;
        continue;
        if (j != 1) {
          continue;
        }
        paramXmlSerializer.attribute(null, "uri", str8);
        localObject1 = Integer.toString(i);
        if (!createBackupShortcutIcon(paramString, (String)localObject1, getIconFromCursor(localCursor, m, paramContext))) {
          continue;
        }
        paramXmlSerializer.attribute(null, "icon", (String)localObject1);
        continue;
        if (j != 2) {
          continue;
        }
        makeFolderTag(paramContext, paramXmlSerializer, i, paramString);
        continue;
      }
      if (paramResult != null)
      {
        paramXmlSerializer.startTag(null, paramResult);
        if (localObject2 != null) {
          paramXmlSerializer.attribute(null, "className", (String)localObject2);
        }
        if (localObject1 != null) {
          paramXmlSerializer.attribute(null, "packageName", (String)localObject1);
        }
        if (str3 != null) {
          paramXmlSerializer.attribute(null, "screen", str3);
        }
        if (str1 != null) {
          paramXmlSerializer.attribute(null, "title", str1);
        }
        if (str4 != null) {
          paramXmlSerializer.attribute(null, "x", str4);
        }
        if (str5 != null) {
          paramXmlSerializer.attribute(null, "y", str5);
        }
        if (str6 != null) {
          paramXmlSerializer.attribute(null, "spanX", str6);
        }
        if (str7 != null) {
          paramXmlSerializer.attribute(null, "spanY", str7);
        }
        if ((j == 900) && (str8 == null)) {}
      }
      try
      {
        localObject1 = Intent.parseUri(str8, 0);
        localObject1 = ((Intent)localObject1).getStringExtra("com.samsung.sec.android.SAMSUNG_WIDGET.themename");
        if (localObject1 != null) {
          paramXmlSerializer.attribute(null, "themeName", (String)localObject1);
        }
        paramXmlSerializer.endTag(null, paramResult);
      }
      catch (URISyntaxException paramResult)
      {
        String str2;
        AppWidgetProviderInfo localAppWidgetProviderInfo;
        continue;
      }
      if (localCursor.moveToNext()) {
        break label115;
      }
      paramXmlSerializer.endTag(null, "home");
      localCursor.close();
      break;
      paramResult.result = 1;
      paramResult.err_code = 3;
      Log.e("HomeScreenXmlBackup", "There's no logs");
      continue;
      label842:
      str2 = null;
      switch (j)
      {
      case 0: 
      case 4: 
      default: 
        localObject2 = paramResult;
        paramResult = str2;
        break;
      case 1: 
        str2 = "shortcut";
        localObject2 = paramResult;
        paramResult = str2;
        break;
      case 900: 
      case 901: 
        str2 = "sactivitywidget";
        localObject2 = paramResult;
        paramResult = str2;
        break;
      case 2: 
        str2 = "folder";
        localObject2 = paramResult;
        paramResult = str2;
      }
    }
  }
  
  private void makeHotseatTag(Context paramContext, XmlSerializer paramXmlSerializer, String paramString)
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    Cursor localCursor = paramContext.getContentResolver().query(LauncherSettings.Favorites.CONTENT_URI, null, "container=" + String.valueOf(-101), null, null);
    for (;;)
    {
      int j;
      String str1;
      try
      {
        int i;
        String str4;
        String str5;
        String str6;
        int k;
        Object localObject;
        if (localCursor.moveToFirst())
        {
          paramXmlSerializer.startTag(null, "hotseat");
          i = localCursor.getInt(localCursor.getColumnIndexOrThrow("_id"));
          j = localCursor.getInt(localCursor.getColumnIndexOrThrow("itemType"));
          str4 = String.valueOf(localCursor.getInt(localCursor.getColumnIndexOrThrow("screen")));
          str5 = localCursor.getString(localCursor.getColumnIndexOrThrow("intent"));
          str6 = localCursor.getString(localCursor.getColumnIndexOrThrow("title"));
          k = localCursor.getColumnIndexOrThrow("icon");
          localObject = null;
          if (str5 == null) {}
        }
        try
        {
          localObject = Intent.parseUri(str5, 0);
          localObject = ((Intent)localObject).getComponent();
          str2 = null;
          str3 = null;
          if (localObject == null) {
            break label476;
          }
          str2 = ((ComponentName)localObject).getClassName();
          str3 = ((ComponentName)localObject).getPackageName();
        }
        catch (URISyntaxException localURISyntaxException)
        {
          String str2;
          String str3;
          continue;
          str1 = "favorite";
          continue;
          if (j != 2) {
            continue;
          }
          makeFolderTag(paramContext, paramXmlSerializer, i, paramString);
          continue;
        }
        if (localObject != null)
        {
          paramXmlSerializer.startTag(null, (String)localObject);
          if (str2 != null) {
            paramXmlSerializer.attribute(null, "className", str2);
          }
          if (str3 != null) {
            paramXmlSerializer.attribute(null, "packageName", str3);
          }
          if (str4 != null) {
            paramXmlSerializer.attribute(null, "screen", str4);
          }
          if (str6 != null) {
            paramXmlSerializer.attribute(null, "title", str6);
          }
          if (j == 1)
          {
            paramXmlSerializer.attribute(null, "uri", str5);
            str2 = Integer.toString(i);
            if (createBackupShortcutIcon(paramString, str2, getIconFromCursor(localCursor, k, paramContext))) {
              paramXmlSerializer.attribute(null, "icon", str2);
            }
            paramXmlSerializer.endTag(null, (String)localObject);
          }
        }
        else
        {
          if (localCursor.moveToNext()) {
            continue;
          }
          paramXmlSerializer.endTag(null, "hotseat");
          return;
        }
        str1 = null;
      }
      finally
      {
        if ((localCursor != null) && (!localCursor.isClosed())) {
          localCursor.close();
        }
      }
      label476:
      switch (j)
      {
      case 0: 
      default: 
        break;
      case 1: 
        str1 = "shortcut";
        break;
      case 2: 
        str1 = "folder";
      }
    }
  }
  
  public static void saveBitmap(String paramString, Bitmap paramBitmap)
    throws FileNotFoundException, IOException
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.getParentFile().mkdirs();
    }
    for (;;)
    {
      paramString = new FileOutputStream(paramString);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, paramString);
      paramString.close();
      paramString.flush();
      return;
      paramString.delete();
    }
  }
  
  protected Bitmap getIconFromCursor(Cursor paramCursor, int paramInt, Context paramContext)
  {
    paramCursor = paramCursor.getBlob(paramInt);
    try
    {
      paramCursor = Utilities.createIconBitmap(BitmapFactory.decodeByteArray(paramCursor, 0, paramCursor.length), paramContext);
      return paramCursor;
    }
    catch (Exception paramCursor) {}
    return null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    if (str1 != null)
    {
      String str2 = paramIntent.getStringExtra("SAVE_PATH");
      String str3 = paramIntent.getStringExtra("SOURCE");
      String str4 = paramIntent.getStringExtra("SESSION_KEY");
      int i = paramIntent.getIntExtra("ACTION", 0);
      if (str1.equals("com.sec.android.intent.action.REQUEST_BACKUP_HOMESCREEN"))
      {
        if (DEBUGGABLE) {
          Log.d("HomeScreenXmlBackup", "onReceive REQUEST_BACKUP_HOMESCREEN");
        }
        if (i == 0) {
          XmlGenerator(paramContext, str2, str3, str4);
        }
      }
      do
      {
        do
        {
          return;
        } while (!str1.equals("com.sec.android.intent.action.REQUEST_RESTORE_HOMESCREEN"));
        if (DEBUGGABLE) {
          Log.d("HomeScreenXmlBackup", "onReceive REQUEST_RESTORE_HOMESCREEN");
        }
      } while (i != 0);
      RestoreLogs(paramContext, str2, str3, str4);
      return;
    }
    Log.e("HomeScreenXmlBackup", "onReceive Action value is null");
  }
  
  private static class Result
  {
    public int err_code = 0;
    public int result = 0;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/XmlBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */