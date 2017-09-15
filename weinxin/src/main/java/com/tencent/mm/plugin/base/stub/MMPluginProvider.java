package com.tencent.mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class MMPluginProvider
  extends ContentProvider
{
  private static final UriMatcher jNp;
  private c jNo;
  
  static
  {
    GMTrace.i(12841012690944L, 95673);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    jNp = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.sdk.plugin.provider", "sharedpref", 2);
    GMTrace.o(12841012690944L, 95673);
  }
  
  public MMPluginProvider()
  {
    GMTrace.i(12840073166848L, 95666);
    this.jNo = new c();
    GMTrace.o(12840073166848L, 95666);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(12840610037760L, 95670);
    v.v("MicroMsg.MMPluginProvider", "plugin delete" + paramUri);
    switch (jNp.match(paramUri))
    {
    default: 
      v.e("MicroMsg.MMPluginProvider", "Unknown URI " + paramUri);
      GMTrace.o(12840610037760L, 95670);
      return 0;
    }
    int i = c.acz();
    GMTrace.o(12840610037760L, 95670);
    return i;
  }
  
  public String getType(Uri paramUri)
  {
    GMTrace.i(12840207384576L, 95667);
    switch (jNp.match(paramUri))
    {
    default: 
      GMTrace.o(12840207384576L, 95667);
      return null;
    }
    GMTrace.o(12840207384576L, 95667);
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    GMTrace.i(12840475820032L, 95669);
    v.v("MicroMsg.MMPluginProvider", "plugin insert" + paramUri);
    switch (jNp.match(paramUri))
    {
    default: 
      v.e("MicroMsg.MMPluginProvider", "Unknown URI " + paramUri);
      GMTrace.o(12840475820032L, 95669);
      return null;
    }
    paramUri = c.acy();
    GMTrace.o(12840475820032L, 95669);
    return paramUri;
  }
  
  public boolean onCreate()
  {
    GMTrace.i(12840341602304L, 95668);
    this.jNo.bI(getContext());
    GMTrace.o(12840341602304L, 95668);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    GMTrace.i(12840744255488L, 95671);
    v.i("MicroMsg.MMPluginProvider", "plugin query" + paramUri);
    switch (jNp.match(paramUri))
    {
    default: 
      v.e("MicroMsg.MMPluginProvider", "Unknown URI " + paramUri);
      GMTrace.o(12840744255488L, 95671);
      return null;
    }
    paramUri = c.a(paramArrayOfString1, paramArrayOfString2);
    GMTrace.o(12840744255488L, 95671);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(12840878473216L, 95672);
    v.d("MicroMsg.MMPluginProvider", "plugin update" + paramUri);
    switch (jNp.match(paramUri))
    {
    default: 
      v.e("MicroMsg.MMPluginProvider", "Unknown URI " + paramUri);
      GMTrace.o(12840878473216L, 95672);
      return 0;
    }
    int i = c.acA();
    GMTrace.o(12840878473216L, 95672);
    return i;
  }
  
  protected static abstract class a
  {
    private Context context;
    
    protected a()
    {
      GMTrace.i(12842757521408L, 95686);
      this.context = null;
      GMTrace.o(12842757521408L, 95686);
    }
    
    public boolean bI(Context paramContext)
    {
      GMTrace.i(12842891739136L, 95687);
      this.context = paramContext;
      GMTrace.o(12842891739136L, 95687);
      return true;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/base/stub/MMPluginProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */