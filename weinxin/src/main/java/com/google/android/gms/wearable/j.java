package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import com.google.android.gms.c.au;
import com.google.android.gms.c.au.a;
import com.google.android.gms.c.av;
import com.google.android.gms.c.bd;
import com.google.android.gms.c.be;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class j
{
  public final i aFP;
  private final Uri apg;
  
  public j(f paramf)
  {
    this.apg = paramf.getUri();
    this.aFP = a((f)paramf.jO());
  }
  
  private static i a(f paramf)
  {
    if ((paramf.getData() == null) && (paramf.mD().size() > 0)) {
      throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
    }
    if (paramf.getData() == null) {
      return new i();
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      j = paramf.mD().size();
      i = 0;
    }
    catch (bd localbd)
    {
      for (;;)
      {
        int j;
        int i;
        new StringBuilder("Unable to parse datamap from dataItem. uri=").append(paramf.getUri()).append(", data=").append(Base64.encodeToString(paramf.getData(), 0));
        throw new IllegalStateException("Unable to parse datamap from dataItem.  uri=" + paramf.getUri(), localbd);
        localbd.add(Asset.ar(((g)localObject).getId()));
        i += 1;
      }
      Object localObject = paramf.getData();
      i locali = au.a(new au.a((av)be.a(new av(), (byte[])localObject, localObject.length), localbd));
      return locali;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;) {}
    }
    if (i < j)
    {
      localObject = (g)paramf.mD().get(Integer.toString(i));
      if (localObject == null) {
        throw new IllegalStateException("Cannot find DataItemAsset referenced in data at " + i + " for " + paramf);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */