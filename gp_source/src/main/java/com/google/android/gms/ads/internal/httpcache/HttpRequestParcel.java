package com.google.android.gms.ads.internal.httpcache;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.volley.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@com.google.android.gms.ads.internal.q.a.a
public class HttpRequestParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new b();
  private final String[] a;
  private final String[] b;
  private final String c;
  
  HttpRequestParcel(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.c = paramString;
    this.a = paramArrayOfString1;
    this.b = paramArrayOfString2;
  }
  
  public static HttpRequestParcel a(n paramn)
  {
    Object localObject = paramn.f();
    int i = ((Map)localObject).size();
    String[] arrayOfString1 = new String[i];
    String[] arrayOfString2 = new String[i];
    localObject = ((Map)localObject).entrySet().iterator();
    i = 0;
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      arrayOfString1[i] = ((String)localEntry.getKey());
      arrayOfString2[i] = ((String)localEntry.getValue());
      i += 1;
    }
    return new HttpRequestParcel(paramn.ac_(), arrayOfString1, arrayOfString2);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 1, this.c);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.a);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.b);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/httpcache/HttpRequestParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */