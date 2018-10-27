package com.google.android.finsky.dm;

import android.text.TextUtils;
import com.google.android.finsky.utils.FinskyLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public final class a
  implements b
{
  private final String a;
  private final File b;
  
  public a(File paramFile, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("A dataStoreId must be specified");
    }
    this.b = paramFile;
    this.a = paramString;
  }
  
  public final Map a()
  {
    HashMap localHashMap = new HashMap();
    File[] arrayOfFile = this.b.listFiles();
    int j;
    int i;
    if (arrayOfFile != null)
    {
      j = arrayOfFile.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        String str1 = localFile.getName();
        Object localObject2;
        for (;;)
        {
          try
          {
            if (!str1.startsWith(this.a)) {
              break label303;
            }
            localObject2 = new FileInputStream(localFile);
            localObject1 = new ObjectInputStream((InputStream)localObject2);
            String str2 = str1.replace(this.a, "");
            localObject1 = new JSONObject(((ObjectInputStream)localObject1).readUTF());
            ((FileInputStream)localObject2).close();
            localObject2 = new HashMap();
            localIterator = ((JSONObject)localObject1).keys();
          }
          catch (IOException localIOException)
          {
            Object localObject1;
            Iterator localIterator;
            String str3;
            FinskyLog.c("IOException when reading file '%s'. Deleting.", new Object[] { str1 });
            if (localFile.delete()) {
              break label303;
            }
            FinskyLog.d("Attempt to delete '%s' failed!", new Object[] { str1 });
            break label303;
            ((Map)localObject2).put(str3, null);
            continue;
          }
          catch (JSONException localJSONException)
          {
            FinskyLog.d("JSONException when reading file '%s'. Deleting. error=[%s]", new Object[] { str1, localJSONException.toString() });
            if (localFile.delete()) {
              break label303;
            }
          }
          if (!localIterator.hasNext()) {
            break label287;
          }
          str3 = (String)localIterator.next();
          if (((JSONObject)localObject1).isNull(str3)) {
            continue;
          }
          ((Map)localObject2).put(str3, ((JSONObject)localObject1).getString(str3));
        }
        FinskyLog.d("Attempt to delete '%s' failed!", new Object[] { str1 });
        break label303;
        label287:
        localHashMap.put(localJSONException, localObject2);
      }
      else
      {
        return localHashMap;
      }
      label303:
      i += 1;
    }
  }
  
  public final void a(String paramString)
  {
    File localFile = this.b;
    String str1 = String.valueOf(this.a);
    String str2 = String.valueOf(paramString);
    if (str2.length() == 0) {}
    for (str1 = new String(str1);; str1 = str1.concat(str2))
    {
      if (!new File(localFile, str1).delete()) {
        FinskyLog.d("Attempt to delete '%s' failed!", new Object[] { paramString });
      }
      return;
    }
  }
  
  /* Error */
  public final void a(String paramString, Map paramMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 31	com/google/android/finsky/dm/a:b	Ljava/io/File;
    //   10: astore 6
    //   12: aload_0
    //   13: getfield 33	com/google/android/finsky/dm/a:a	Ljava/lang/String;
    //   16: invokestatic 135	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   19: astore_3
    //   20: aload_1
    //   21: invokestatic 135	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   24: astore 7
    //   26: aload 7
    //   28: invokevirtual 139	java/lang/String:length	()I
    //   31: ifne +67 -> 98
    //   34: new 54	java/lang/String
    //   37: dup
    //   38: aload_3
    //   39: invokespecial 140	java/lang/String:<init>	(Ljava/lang/String;)V
    //   42: astore_3
    //   43: new 148	java/io/FileOutputStream
    //   46: dup
    //   47: new 44	java/io/File
    //   50: dup
    //   51: aload 6
    //   53: aload_3
    //   54: invokespecial 142	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   57: invokespecial 149	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   60: astore_3
    //   61: new 151	java/io/ObjectOutputStream
    //   64: dup
    //   65: aload_3
    //   66: invokespecial 154	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   69: astore 5
    //   71: aload 5
    //   73: new 76	org/json/JSONObject
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 157	org/json/JSONObject:<init>	(Ljava/util/Map;)V
    //   81: invokevirtual 158	org/json/JSONObject:toString	()Ljava/lang/String;
    //   84: invokevirtual 161	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   87: aload 5
    //   89: invokevirtual 164	java/io/ObjectOutputStream:flush	()V
    //   92: aload 5
    //   94: invokevirtual 165	java/io/ObjectOutputStream:close	()V
    //   97: return
    //   98: aload_3
    //   99: aload 7
    //   101: invokevirtual 145	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore_3
    //   105: goto -62 -> 43
    //   108: astore 5
    //   110: aconst_null
    //   111: astore_3
    //   112: aload 4
    //   114: astore_2
    //   115: aload 5
    //   117: astore 4
    //   119: ldc -89
    //   121: iconst_2
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_1
    //   128: aastore
    //   129: dup
    //   130: iconst_1
    //   131: aload 4
    //   133: aastore
    //   134: invokestatic 118	com/google/android/finsky/utils/FinskyLog:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload_3
    //   138: ifnull +115 -> 253
    //   141: aload_3
    //   142: invokevirtual 165	java/io/ObjectOutputStream:close	()V
    //   145: return
    //   146: astore_2
    //   147: ldc -87
    //   149: iconst_2
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload_1
    //   156: aastore
    //   157: dup
    //   158: iconst_1
    //   159: aload_2
    //   160: aastore
    //   161: invokestatic 118	com/google/android/finsky/utils/FinskyLog:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: return
    //   165: astore 4
    //   167: aconst_null
    //   168: astore_3
    //   169: aload 5
    //   171: astore_2
    //   172: aload_3
    //   173: ifnull +89 -> 262
    //   176: aload_3
    //   177: invokevirtual 165	java/io/ObjectOutputStream:close	()V
    //   180: aload 4
    //   182: athrow
    //   183: astore 4
    //   185: aconst_null
    //   186: astore 5
    //   188: aload_3
    //   189: astore_2
    //   190: aload 5
    //   192: astore_3
    //   193: goto -74 -> 119
    //   196: astore 4
    //   198: aconst_null
    //   199: astore 5
    //   201: aload_3
    //   202: astore_2
    //   203: aload 5
    //   205: astore_3
    //   206: goto -34 -> 172
    //   209: astore 4
    //   211: aload_3
    //   212: astore_2
    //   213: aload 5
    //   215: astore_3
    //   216: goto -97 -> 119
    //   219: astore 4
    //   221: aload_3
    //   222: astore_2
    //   223: aload 5
    //   225: astore_3
    //   226: goto -54 -> 172
    //   229: astore_2
    //   230: ldc -87
    //   232: iconst_2
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: aload_1
    //   239: aastore
    //   240: dup
    //   241: iconst_1
    //   242: aload_2
    //   243: aastore
    //   244: invokestatic 118	com/google/android/finsky/utils/FinskyLog:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: return
    //   248: astore 4
    //   250: goto -78 -> 172
    //   253: aload_2
    //   254: ifnull -157 -> 97
    //   257: aload_2
    //   258: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   261: return
    //   262: aload_2
    //   263: ifnull -83 -> 180
    //   266: aload_2
    //   267: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   270: goto -90 -> 180
    //   273: astore_2
    //   274: ldc -87
    //   276: iconst_2
    //   277: anewarray 4	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: aload_1
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload_2
    //   287: aastore
    //   288: invokestatic 118	com/google/android/finsky/utils/FinskyLog:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: goto -111 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	a
    //   0	294	1	paramString	String
    //   0	294	2	paramMap	Map
    //   19	207	3	localObject1	Object
    //   4	128	4	localIOException1	IOException
    //   165	16	4	localObject2	Object
    //   183	1	4	localIOException2	IOException
    //   196	1	4	localObject3	Object
    //   209	1	4	localIOException3	IOException
    //   219	1	4	localObject4	Object
    //   248	1	4	localObject5	Object
    //   1	92	5	localObjectOutputStream	java.io.ObjectOutputStream
    //   108	62	5	localIOException4	IOException
    //   186	38	5	localObject6	Object
    //   10	42	6	localFile	File
    //   24	76	7	str	String
    // Exception table:
    //   from	to	target	type
    //   6	43	108	java/io/IOException
    //   43	61	108	java/io/IOException
    //   98	105	108	java/io/IOException
    //   141	145	146	java/io/IOException
    //   257	261	146	java/io/IOException
    //   6	43	165	finally
    //   43	61	165	finally
    //   98	105	165	finally
    //   61	71	183	java/io/IOException
    //   61	71	196	finally
    //   71	92	209	java/io/IOException
    //   71	92	219	finally
    //   92	97	229	java/io/IOException
    //   119	137	248	finally
    //   176	180	273	java/io/IOException
    //   266	270	273	java/io/IOException
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dm/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */