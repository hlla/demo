package ct;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public final class cs
  implements Parcelable, TencentLocation
{
  public static final cs a = new cs(-1);
  public co b;
  public int c;
  private int d;
  private String e;
  public cm f;
  public final Bundle g = new Bundle();
  public String h = "network";
  public Location i;
  private final long j;
  public long k;
  private int l;
  
  static
  {
    new Parcelable.Creator() {};
  }
  
  public cs(int paramInt)
  {
    this.c = paramInt;
    this.j = SystemClock.elapsedRealtime();
    this.k = System.currentTimeMillis();
  }
  
  /* Error */
  public cs(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 44	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 46	android/os/Bundle
    //   8: dup
    //   9: invokespecial 47	android/os/Bundle:<init>	()V
    //   12: putfield 49	ct/cs:g	Landroid/os/Bundle;
    //   15: aload_0
    //   16: ldc 51
    //   18: putfield 53	ct/cs:h	Ljava/lang/String;
    //   21: aload_0
    //   22: invokestatic 61	android/os/SystemClock:elapsedRealtime	()J
    //   25: putfield 63	ct/cs:j	J
    //   28: aload_0
    //   29: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   32: putfield 70	ct/cs:k	J
    //   35: new 77	org/json/JSONObject
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 79	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_0
    //   45: new 81	ct/co
    //   48: dup
    //   49: aload_1
    //   50: ldc 83
    //   52: invokevirtual 87	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   55: invokespecial 90	ct/co:<init>	(Lorg/json/JSONObject;)V
    //   58: putfield 92	ct/cs:b	Lct/co;
    //   61: aload_0
    //   62: aload_1
    //   63: ldc 94
    //   65: invokevirtual 98	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: putfield 100	ct/cs:e	Ljava/lang/String;
    //   71: aload_0
    //   72: aload_1
    //   73: ldc 102
    //   75: iconst_0
    //   76: invokevirtual 106	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   79: putfield 108	ct/cs:d	I
    //   82: aload_0
    //   83: aload_1
    //   84: ldc 110
    //   86: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   89: invokevirtual 114	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   92: putfield 70	ct/cs:k	J
    //   95: aload_1
    //   96: ldc 116
    //   98: invokevirtual 98	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_2
    //   102: aload_2
    //   103: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifne +47 -> 153
    //   109: aload_0
    //   110: getfield 49	ct/cs:g	Landroid/os/Bundle;
    //   113: ldc 116
    //   115: aload_2
    //   116: ldc 124
    //   118: invokevirtual 130	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   121: iconst_0
    //   122: aaload
    //   123: invokestatic 136	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   126: invokevirtual 140	java/lang/Integer:intValue	()I
    //   129: invokevirtual 144	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   132: ldc -110
    //   134: new 148	java/lang/StringBuilder
    //   137: dup
    //   138: ldc -106
    //   140: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: aload_2
    //   144: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 164	ct/b$a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_1
    //   154: ldc -90
    //   156: invokevirtual 169	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   159: astore_2
    //   160: aload_2
    //   161: ifnull +75 -> 236
    //   164: aload_0
    //   165: new 171	ct/cm
    //   168: dup
    //   169: aload_2
    //   170: invokespecial 172	ct/cm:<init>	(Lorg/json/JSONObject;)V
    //   173: putfield 174	ct/cs:f	Lct/cm;
    //   176: aload_0
    //   177: getfield 174	ct/cs:f	Lct/cm;
    //   180: ifnull +30 -> 210
    //   183: aload_0
    //   184: getfield 174	ct/cs:f	Lct/cm;
    //   187: getfield 177	ct/cm:c	Lct/cq;
    //   190: ifnull +20 -> 210
    //   193: aload_0
    //   194: getfield 49	ct/cs:g	Landroid/os/Bundle;
    //   197: aload_0
    //   198: getfield 174	ct/cs:f	Lct/cm;
    //   201: getfield 177	ct/cm:c	Lct/cq;
    //   204: getfield 181	ct/cq:l	Landroid/os/Bundle;
    //   207: invokevirtual 185	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   210: return
    //   211: astore_1
    //   212: aload_1
    //   213: athrow
    //   214: astore_2
    //   215: ldc -110
    //   217: ldc -69
    //   219: invokestatic 164	ct/b$a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: goto -69 -> 153
    //   225: astore_1
    //   226: ldc -110
    //   228: ldc -67
    //   230: aload_1
    //   231: invokestatic 192	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   234: aload_1
    //   235: athrow
    //   236: aload_1
    //   237: ldc -62
    //   239: invokevirtual 169	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   242: astore_1
    //   243: aload_1
    //   244: ifnull -68 -> 176
    //   247: aload_1
    //   248: ldc -60
    //   250: invokevirtual 200	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   253: ifeq -77 -> 176
    //   256: aload_0
    //   257: new 171	ct/cm
    //   260: dup
    //   261: aload_1
    //   262: ldc -60
    //   264: invokevirtual 169	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   267: invokespecial 172	ct/cm:<init>	(Lorg/json/JSONObject;)V
    //   270: putfield 174	ct/cs:f	Lct/cm;
    //   273: goto -97 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	cs
    //   0	276	1	paramString	String
    //   101	69	2	localObject	Object
    //   214	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   44	61	211	org/json/JSONException
    //   95	153	214	java/lang/Exception
    //   164	176	225	org/json/JSONException
  }
  
  public static cs a(cs paramcs, int paramInt)
  {
    paramcs.l = paramInt;
    return paramcs;
  }
  
  public static cs a(cs paramcs, cg paramcg)
  {
    int i1;
    int m;
    if ((paramcs != null) && (paramcg != null) && (paramcs.e != null))
    {
      String str = paramcs.e;
      int n = 0;
      i1 = paramcg.f;
      m = n;
      if (str != null)
      {
        m = n;
        if (str.split(",").length > 1) {
          m = Integer.parseInt(str.split(",")[1]);
        }
      }
      paramcg = paramcs.b;
      if (paramcg == null) {}
    }
    try
    {
      paramcg.d = ((float)e.r(paramcg.d, m, i1));
      return paramcs;
    }
    catch (UnsatisfiedLinkError paramcg) {}
    return paramcs;
  }
  
  public static void a(cs paramcs)
  {
    if (paramcs == a) {
      throw new JSONException("location failed");
    }
  }
  
  public final void a(Location paramLocation)
  {
    if ((paramLocation != null) && (this.b != null))
    {
      double d2 = paramLocation.getLatitude();
      double d1 = paramLocation.getLongitude();
      d2 = Math.round(d2 * 1000000.0D) / 1000000.0D;
      d1 = Math.round(d1 * 1000000.0D) / 1000000.0D;
      this.b.a = d2;
      this.b.b = d1;
      this.b.c = paramLocation.getAltitude();
      this.b.d = paramLocation.getAccuracy();
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final float getAccuracy()
  {
    if (this.b != null) {
      return this.b.d;
    }
    return 0.0F;
  }
  
  public final String getAddress()
  {
    if (this.c == 5) {
      return this.g.getString("addrdesp.name");
    }
    if (this.b != null) {
      return this.b.f;
    }
    return "";
  }
  
  public final double getAltitude()
  {
    if (this.b != null) {
      return this.b.c;
    }
    return 0.0D;
  }
  
  public final Integer getAreaStat()
  {
    if (this.f != null) {
      return Integer.valueOf(this.f.a);
    }
    return null;
  }
  
  public final float getBearing()
  {
    if (this.i == null) {
      return 0.0F;
    }
    return this.i.getBearing();
  }
  
  public final String getCity()
  {
    if (this.f != null) {
      return this.f.c.f;
    }
    return "";
  }
  
  public final String getCityCode()
  {
    if (this.f != null) {
      return this.f.c.d;
    }
    return "";
  }
  
  public final int getCoordinateType()
  {
    return this.l;
  }
  
  public final double getDirection()
  {
    if (this.g != null) {
      return this.g.getDouble("direction");
    }
    return NaN.0D;
  }
  
  public final String getDistrict()
  {
    if (this.f != null) {
      return this.f.c.g;
    }
    return "";
  }
  
  public final long getElapsedRealtime()
  {
    return this.j;
  }
  
  public final Bundle getExtra()
  {
    return this.g;
  }
  
  public final double getLatitude()
  {
    if (this.b != null) {
      return this.b.a;
    }
    return 0.0D;
  }
  
  public final double getLongitude()
  {
    if (this.b != null) {
      return this.b.b;
    }
    return 0.0D;
  }
  
  public final String getName()
  {
    if (this.c == 5) {
      return this.g.getString("addrdesp.name");
    }
    if (this.b != null) {
      return this.b.e;
    }
    return "";
  }
  
  public final String getNation()
  {
    if (this.f != null) {
      return this.f.c.b;
    }
    return "";
  }
  
  public final List<TencentPoi> getPoiList()
  {
    if (this.f != null) {
      return new ArrayList(this.f.b);
    }
    return Collections.emptyList();
  }
  
  public final String getProvider()
  {
    return this.h;
  }
  
  public final String getProvince()
  {
    if (this.f != null) {
      return this.f.c.e;
    }
    return "";
  }
  
  public final int getRssi()
  {
    if (this.i == null) {}
    Bundle localBundle;
    do
    {
      return 0;
      localBundle = this.i.getExtras();
    } while (localBundle == null);
    return localBundle.getInt("rssi", 0);
  }
  
  public final float getSpeed()
  {
    if (this.i == null) {
      return 0.0F;
    }
    return this.i.getSpeed();
  }
  
  public final String getStreet()
  {
    if (this.f != null) {
      return this.f.c.j;
    }
    return "";
  }
  
  public final String getStreetNo()
  {
    if (this.f != null) {
      return this.f.c.k;
    }
    return "";
  }
  
  public final long getTime()
  {
    return this.k;
  }
  
  public final String getTown()
  {
    if (this.f != null) {
      return this.f.c.h;
    }
    return "";
  }
  
  public final String getVillage()
  {
    if (this.f != null) {
      return this.f.c.i;
    }
    return "";
  }
  
  public final int isMockGps()
  {
    return this.d;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TxLocation{");
    localStringBuilder.append("level=").append(this.c).append(",");
    localStringBuilder.append("name=").append(getName()).append(",");
    localStringBuilder.append("address=").append(getAddress()).append(",");
    localStringBuilder.append("provider=").append(getProvider()).append(",");
    localStringBuilder.append("latitude=").append(getLatitude()).append(",");
    localStringBuilder.append("longitude=").append(getLongitude()).append(",");
    localStringBuilder.append("altitude=").append(getAltitude()).append(",");
    localStringBuilder.append("accuracy=").append(getAccuracy()).append(",");
    localStringBuilder.append("cityCode=").append(getCityCode()).append(",");
    localStringBuilder.append("areaStat=").append(getAreaStat()).append(",");
    localStringBuilder.append("nation=").append(getNation()).append(",");
    localStringBuilder.append("province=").append(getProvince()).append(",");
    localStringBuilder.append("city=").append(getCity()).append(",");
    localStringBuilder.append("district=").append(getDistrict()).append(",");
    localStringBuilder.append("street=").append(getStreet()).append(",");
    localStringBuilder.append("streetNo=").append(getStreetNo()).append(",");
    localStringBuilder.append("town=").append(getTown()).append(",");
    localStringBuilder.append("village=").append(getVillage()).append(",");
    localStringBuilder.append("bearing=").append(getBearing()).append(",");
    localStringBuilder.append("time=").append(getTime()).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = getPoiList().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeString(getProvider());
    paramParcel.writeDouble(getLatitude());
    paramParcel.writeDouble(getLongitude());
    paramParcel.writeDouble(getAccuracy());
    paramParcel.writeDouble(getAltitude());
    paramParcel.writeString(getAddress());
    paramParcel.writeString(getNation());
    paramParcel.writeString(getProvince());
    paramParcel.writeString(getCity());
    paramParcel.writeString(getDistrict());
    paramParcel.writeString(getStreet());
    paramParcel.writeString(getStreetNo());
    if (this.f != null) {}
    for (String str = this.f.c.d;; str = "")
    {
      paramParcel.writeString(str);
      paramParcel.writeString(getName());
      paramParcel.writeLong(this.k);
      paramParcel.writeBundle(this.g);
      return;
    }
  }
  
  public static final class a
  {
    public String a;
    public cs b;
    public int c;
    public String d = "network";
    private Location e;
    
    public final a a(Location paramLocation)
    {
      this.e = new Location(paramLocation);
      return this;
    }
    
    public final cs a()
    {
      if (this.a != null) {}
      for (;;)
      {
        try
        {
          cs localcs1 = new cs(this.a);
          localcs1.c = this.c;
          localcs1.h = this.d;
          localcs1.i = this.e;
          TencentExtraKeys.setRawGps(localcs1, this.e);
          return localcs1;
        }
        catch (JSONException localJSONException)
        {
          b.a.a("TxLocation", "build: ", localJSONException);
          return cs.a;
        }
        cs localcs2 = cs.c(this.b);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */