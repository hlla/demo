package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider
  extends ContentProvider
{
  private static final String[] a = { "_display_name", "_size" };
  private static final File b = new File("/");
  private static HashMap d = new HashMap();
  private f c;
  
  public static Uri a(Context paramContext, String paramString, File paramFile)
  {
    return a(paramContext, paramString).a(paramFile);
  }
  
  private static f a(Context paramContext, String paramString)
  {
    for (;;)
    {
      Object localObject2;
      int i;
      synchronized (d)
      {
        localObject2 = (f)d.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null) {}
        try
        {
          localObject2 = new g(paramString);
          localXmlResourceParser = paramContext.getPackageManager().resolveContentProvider(paramString, 128).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
          if (localXmlResourceParser == null) {
            break label435;
          }
        }
        catch (IOException paramContext)
        {
          try
          {
            XmlResourceParser localXmlResourceParser;
            String str1;
            boolean bool;
            localObject3 = ((File)localObject1).getCanonicalFile();
            ((g)localObject2).a.put(str1, localObject3);
          }
          catch (IOException paramContext)
          {
            Object localObject3;
            String str2;
            paramString = new StringBuilder();
            paramString.append("Failed to resolve canonical path for ");
            paramString.append(localObject1);
            throw new IllegalArgumentException(paramString.toString(), paramContext);
          }
          paramContext = paramContext;
          throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
          paramContext = finally;
          throw paramContext;
          str2 = new String[] { localObject3 }[i];
          if (str2 == null) {
            break label498;
          }
          localObject1 = new File((File)localObject1, str2);
          break label491;
          if (!"files-path".equals(localObject1)) {
            break label267;
          }
          localObject1 = paramContext.getFilesDir();
          continue;
          if (!"cache-path".equals(localObject1)) {
            break label286;
          }
          localObject1 = paramContext.getCacheDir();
          continue;
          if (!"external-path".equals(localObject1)) {
            break label304;
          }
          localObject1 = Environment.getExternalStorageDirectory();
          continue;
          if (!"external-files-path".equals(localObject1)) {
            break label335;
          }
          localObject1 = d.a(paramContext);
          if (localObject1.length <= 0) {
            break label501;
          }
          localObject1 = localObject1[0];
          continue;
          if (!"external-cache-path".equals(localObject1)) {
            break label366;
          }
          localObject1 = d.b(paramContext);
          if (localObject1.length <= 0) {
            break label507;
          }
          localObject1 = localObject1[0];
          continue;
          if (Build.VERSION.SDK_INT < 21) {
            break label417;
          }
          if (!"external-media-path".equals(localObject1)) {
            break label411;
          }
          localObject1 = paramContext.getExternalMediaDirs();
          if (localObject1.length <= 0) {
            break label405;
          }
          localObject1 = localObject1[0];
          continue;
          localObject1 = null;
          continue;
          localObject1 = null;
          continue;
          localObject1 = null;
          continue;
        }
        catch (XmlPullParserException paramContext)
        {
          throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
        }
        i = localXmlResourceParser.next();
        if (i == 1)
        {
          d.put(paramString, localObject2);
          localObject1 = localObject2;
          return (f)localObject1;
        }
        if (i != 2) {
          continue;
        }
        localObject1 = localXmlResourceParser.getName();
        str1 = localXmlResourceParser.getAttributeValue(null, "name");
        localObject3 = localXmlResourceParser.getAttributeValue(null, "path");
        if ("root-path".equals(localObject1))
        {
          localObject1 = b;
          if (localObject1 == null) {
            continue;
          }
          i = 0;
          if (i > 0)
          {
            bool = TextUtils.isEmpty(str1);
            if (bool) {
              break label445;
            }
          }
        }
      }
      label267:
      label286:
      label304:
      label335:
      label366:
      label405:
      label411:
      label417:
      label435:
      throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
      label445:
      throw new IllegalArgumentException("Name must not be empty");
      label491:
      label498:
      for (;;)
      {
        i += 1;
        break;
      }
      label501:
      Object localObject1 = null;
      continue;
      label507:
      localObject1 = null;
    }
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (paramProviderInfo.exported) {
      throw new SecurityException("Provider must not be exported");
    }
    if (!paramProviderInfo.grantUriPermissions) {
      throw new SecurityException("Provider must grant uri permissions");
    }
    this.c = a(paramContext, paramProviderInfo.authority);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public String getType(Uri paramUri)
  {
    paramUri = this.c.a(paramUri);
    int i = paramUri.getName().lastIndexOf('.');
    if (i >= 0)
    {
      paramUri = paramUri.getName().substring(i + 1);
      String str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
      paramUri = str;
      if (str != null) {}
    }
    else
    {
      paramUri = "application/octet-stream";
    }
    return paramUri;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate()
  {
    com.google.d.a.a.a.a.a.d.a(this);
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    int j = 738197504;
    paramUri = this.c.a(paramUri);
    int i;
    if (!"r".equals(paramString))
    {
      i = j;
      if (!"w".equals(paramString))
      {
        i = j;
        if (!"wt".equals(paramString))
        {
          if ("wa".equals(paramString)) {
            break label99;
          }
          if ("rw".equals(paramString)) {
            break label92;
          }
          if (!"rwt".equals(paramString)) {
            break label113;
          }
          i = 1006632960;
        }
      }
    }
    for (;;)
    {
      return ParcelFileDescriptor.open(paramUri, i);
      label92:
      i = 939524096;
      continue;
      label99:
      i = 704643072;
      continue;
      i = 268435456;
    }
    label113:
    paramUri = new StringBuilder();
    paramUri.append("Invalid mode: ");
    paramUri.append(paramString);
    throw new IllegalArgumentException(paramUri.toString());
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = this.c.a(paramUri);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = a;
    }
    int m = paramUri.length;
    paramArrayOfString2 = new String[m];
    paramArrayOfString1 = new Object[m];
    int j = 0;
    int i = 0;
    if (j < m)
    {
      paramString2 = paramUri[j];
      int k;
      if ("_display_name".equals(paramString2))
      {
        paramArrayOfString2[i] = "_display_name";
        k = i + 1;
        paramArrayOfString1[i] = paramString1.getName();
        i = k;
      }
      for (;;)
      {
        j += 1;
        break;
        if ("_size".equals(paramString2))
        {
          paramArrayOfString2[i] = "_size";
          k = i + 1;
          paramArrayOfString1[i] = Long.valueOf(paramString1.length());
          i = k;
        }
      }
    }
    paramUri = new String[i];
    System.arraycopy(paramArrayOfString2, 0, paramUri, 0, i);
    paramString1 = new Object[i];
    System.arraycopy(paramArrayOfString1, 0, paramString1, 0, i);
    paramUri = new MatrixCursor(paramUri, 1);
    paramUri.addRow(paramString1);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/FileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */