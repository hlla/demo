package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.os.b;

public final class c
{
  public static Cursor a(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString, b paramb)
  {
    Object localObject = null;
    if (paramb != null) {}
    try
    {
      localObject = paramb.a();
      paramContentResolver = paramContentResolver.query(paramUri, paramArrayOfString, null, null, null, (CancellationSignal)localObject);
      return paramContentResolver;
    }
    catch (Exception paramContentResolver)
    {
      if ((paramContentResolver instanceof android.os.OperationCanceledException)) {
        throw new android.support.v4.os.OperationCanceledException();
      }
      throw paramContentResolver;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */