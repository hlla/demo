package com.google.android.gms.ads.internal.mediation.client;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.c;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.MediationServerParameters.MappingException;
import com.google.ads.mediation.l;
import com.google.ads.mediation.p;
import com.google.android.gms.ads.g;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.a.ac;
import com.google.android.gms.dynamic.e;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class ad
  extends f
{
  private final com.google.ads.mediation.k a;
  private final com.google.ads.mediation.q b;
  
  public ad(com.google.ads.mediation.k paramk, com.google.ads.mediation.q paramq)
  {
    this.a = paramk;
    this.b = paramq;
  }
  
  private final MediationServerParameters a(String paramString)
  {
    if (paramString == null) {}
    label718:
    label728:
    label731:
    label738:
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int i;
      Object localObject4;
      Object localObject6;
      try
      {
        paramString = new HashMap(0);
        localObject1 = (MediationServerParameters)this.a.c().newInstance();
        localObject2 = new HashMap();
        localObject3 = localObject1.getClass().getFields();
        int j = localObject3.length;
        i = 0;
        if (i < j)
        {
          localObject4 = localObject3[i];
          localObject6 = (p)((Field)localObject4).getAnnotation(p.class);
          if (localObject6 == null) {
            break label731;
          }
          ((Map)localObject2).put(((p)localObject6).a(), localObject4);
        }
      }
      finally
      {
        com.google.android.gms.ads.internal.util.client.k.c("", paramString);
      }
      if (((Map)localObject2).isEmpty()) {
        com.google.android.gms.ads.internal.util.client.k.e("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
      }
      paramString = paramString.entrySet().iterator();
      if (paramString.hasNext())
      {
        localObject3 = (Map.Entry)paramString.next();
        localObject4 = (Field)((Map)localObject2).remove(((Map.Entry)localObject3).getKey());
        if (localObject4 == null) {}
      }
      for (;;)
      {
        try
        {
          ((Field)localObject4).set(localObject1, ((Map.Entry)localObject3).getValue());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localObject3 = (String)((Map.Entry)localObject3).getKey();
          Object localObject5 = new StringBuilder(String.valueOf(localObject3).length() + 49);
          ((StringBuilder)localObject5).append("Server option \"");
          ((StringBuilder)localObject5).append((String)localObject3);
          ((StringBuilder)localObject5).append("\" could not be set: Illegal Access");
          com.google.android.gms.ads.internal.util.client.k.e(((StringBuilder)localObject5).toString());
          break;
          localObject5 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (String)((Map.Entry)localObject3).getValue();
          localObject6 = new StringBuilder(String.valueOf(localObject5).length() + 31 + String.valueOf(localObject3).length());
          ((StringBuilder)localObject6).append("Unexpected server option: ");
          ((StringBuilder)localObject6).append((String)localObject5);
          ((StringBuilder)localObject6).append(" = \"");
          ((StringBuilder)localObject6).append((String)localObject3);
          ((StringBuilder)localObject6).append("\"");
          com.google.android.gms.ads.internal.util.client.k.b(((StringBuilder)localObject6).toString());
          break;
          localObject3 = new StringBuilder();
          localObject2 = ((Map)localObject2).values().iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject5 = (Field)((Iterator)localObject2).next();
            if (!((p)((Field)localObject5).getAnnotation(p.class)).b()) {
              continue;
            }
            paramString = String.valueOf(((p)((Field)localObject5).getAnnotation(p.class)).a());
            if (paramString.length() == 0)
            {
              paramString = new String("Required server option missing: ");
              com.google.android.gms.ads.internal.util.client.k.e(paramString);
              if (((StringBuilder)localObject3).length() > 0) {
                ((StringBuilder)localObject3).append(", ");
              }
              ((StringBuilder)localObject3).append(((p)((Field)localObject5).getAnnotation(p.class)).a());
              continue;
            }
            paramString = "Required server option missing: ".concat(paramString);
            continue;
          }
          if (((StringBuilder)localObject3).length() <= 0) {
            break label728;
          }
          paramString = String.valueOf(((StringBuilder)localObject3).toString());
          if (paramString.length() != 0) {
            break label718;
          }
          paramString = new String("Required server option(s) missing: ");
          throw new MediationServerParameters.MappingException(paramString);
          localObject1 = new JSONObject(paramString);
          paramString = new HashMap(((JSONObject)localObject1).length());
          localObject2 = ((JSONObject)localObject1).keys();
          if (!((Iterator)localObject2).hasNext()) {
            break label738;
          }
          localObject3 = (String)((Iterator)localObject2).next();
          paramString.put(localObject3, ((JSONObject)localObject1).getString((String)localObject3));
          continue;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localObject3 = (String)((Map.Entry)localObject3).getKey();
          StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject3).length() + 43);
          localStringBuilder.append("Server option \"");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append("\" could not be set: Bad Type");
          com.google.android.gms.ads.internal.util.client.k.e(localStringBuilder.toString());
        }
        break;
        paramString = "Required server option(s) missing: ".concat(paramString);
      }
      return (MediationServerParameters)localObject1;
      i += 1;
    }
  }
  
  private static boolean a(AdRequestParcel paramAdRequestParcel)
  {
    if (!paramAdRequestParcel.i) {
      paramAdRequestParcel = u.h.a;
    }
    return com.google.android.gms.ads.internal.util.client.a.a();
  }
  
  /* Error */
  public final com.google.android.gms.ads.internal.j.a a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/google/android/gms/ads/internal/mediation/client/ad:a	Lcom/google/ads/mediation/k;
    //   4: astore_1
    //   5: aload_1
    //   6: instanceof 217
    //   9: ifne +43 -> 52
    //   12: aload_1
    //   13: invokevirtual 49	java/lang/Object:getClass	()Ljava/lang/Class;
    //   16: invokevirtual 220	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   19: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 136	java/lang/String:length	()I
    //   27: ifne +42 -> 69
    //   30: new 126	java/lang/String
    //   33: dup
    //   34: ldc -34
    //   36: invokespecial 170	java/lang/String:<init>	(Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokestatic 90	com/google/android/gms/ads/internal/util/client/k:e	(Ljava/lang/String;)V
    //   44: new 79	android/os/RemoteException
    //   47: dup
    //   48: invokespecial 80	android/os/RemoteException:<init>	()V
    //   51: athrow
    //   52: aload_1
    //   53: checkcast 217	com/google/ads/mediation/l
    //   56: invokeinterface 226 1 0
    //   61: pop
    //   62: aconst_null
    //   63: invokestatic 231	com/google/android/gms/dynamic/e:a	(Ljava/lang/Object;)Lcom/google/android/gms/ads/internal/j/a;
    //   66: astore_1
    //   67: aload_1
    //   68: areturn
    //   69: ldc -34
    //   71: aload_1
    //   72: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   75: astore_1
    //   76: goto -36 -> 40
    //   79: astore_1
    //   80: ldc 72
    //   82: aload_1
    //   83: invokestatic 77	com/google/android/gms/ads/internal/util/client/k:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: new 79	android/os/RemoteException
    //   89: dup
    //   90: invokespecial 80	android/os/RemoteException:<init>	()V
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	ad
    //   4	72	1	localObject	Object
    //   79	4	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   52	67	79	finally
  }
  
  public final void a(AdRequestParcel paramAdRequestParcel, String paramString) {}
  
  public final void a(AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2) {}
  
  public final void a(com.google.android.gms.ads.internal.j.a parama) {}
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, AdRequestParcel paramAdRequestParcel, String paramString, h paramh)
  {
    a(parama, paramAdRequestParcel, paramString, null, paramh);
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, AdRequestParcel paramAdRequestParcel, String paramString1, com.google.android.gms.ads.internal.reward.mediation.client.a parama1, String paramString2) {}
  
  /* Error */
  public final void a(com.google.android.gms.ads.internal.j.a parama, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, h paramh)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/google/android/gms/ads/internal/mediation/client/ad:a	Lcom/google/ads/mediation/k;
    //   4: astore 4
    //   6: aload 4
    //   8: instanceof 241
    //   11: ifne +44 -> 55
    //   14: aload 4
    //   16: invokevirtual 49	java/lang/Object:getClass	()Ljava/lang/Class;
    //   19: invokevirtual 220	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   22: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 136	java/lang/String:length	()I
    //   30: ifne +91 -> 121
    //   33: new 126	java/lang/String
    //   36: dup
    //   37: ldc -13
    //   39: invokespecial 170	java/lang/String:<init>	(Ljava/lang/String;)V
    //   42: astore_1
    //   43: aload_1
    //   44: invokestatic 90	com/google/android/gms/ads/internal/util/client/k:e	(Ljava/lang/String;)V
    //   47: new 79	android/os/RemoteException
    //   50: dup
    //   51: invokespecial 80	android/os/RemoteException:<init>	()V
    //   54: athrow
    //   55: ldc -11
    //   57: invokestatic 156	com/google/android/gms/ads/internal/util/client/k:b	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 16	com/google/android/gms/ads/internal/mediation/client/ad:a	Lcom/google/ads/mediation/k;
    //   64: checkcast 241	com/google/ads/mediation/n
    //   67: astore 4
    //   69: new 247	com/google/android/gms/ads/internal/mediation/client/ae
    //   72: dup
    //   73: aload 5
    //   75: invokespecial 250	com/google/android/gms/ads/internal/mediation/client/ae:<init>	(Lcom/google/android/gms/ads/internal/mediation/client/h;)V
    //   78: astore 5
    //   80: aload_1
    //   81: invokestatic 253	com/google/android/gms/dynamic/e:a	(Lcom/google/android/gms/ads/internal/j/a;)Ljava/lang/Object;
    //   84: pop
    //   85: aload_2
    //   86: getfield 257	com/google/android/gms/ads/internal/client/AdRequestParcel:s	I
    //   89: istore 6
    //   91: aload_0
    //   92: aload_3
    //   93: invokespecial 259	com/google/android/gms/ads/internal/mediation/client/ad:a	(Ljava/lang/String;)Lcom/google/ads/mediation/MediationServerParameters;
    //   96: pop
    //   97: aload_2
    //   98: invokestatic 261	com/google/android/gms/ads/internal/mediation/client/ad:a	(Lcom/google/android/gms/ads/internal/client/AdRequestParcel;)Z
    //   101: pop
    //   102: aload_2
    //   103: invokestatic 266	com/google/android/gms/ads/internal/mediation/client/ah:a	(Lcom/google/android/gms/ads/internal/client/AdRequestParcel;)Lcom/google/ads/mediation/j;
    //   106: pop
    //   107: aload 4
    //   109: aload 5
    //   111: aload_0
    //   112: getfield 18	com/google/android/gms/ads/internal/mediation/client/ad:b	Lcom/google/ads/mediation/q;
    //   115: invokeinterface 269 3 0
    //   120: return
    //   121: ldc -13
    //   123: aload_1
    //   124: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore_1
    //   128: goto -85 -> 43
    //   131: astore_1
    //   132: ldc 72
    //   134: aload_1
    //   135: invokestatic 77	com/google/android/gms/ads/internal/util/client/k:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   138: new 79	android/os/RemoteException
    //   141: dup
    //   142: invokespecial 80	android/os/RemoteException:<init>	()V
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	ad
    //   0	146	1	parama	com.google.android.gms.ads.internal.j.a
    //   0	146	2	paramAdRequestParcel	AdRequestParcel
    //   0	146	3	paramString1	String
    //   0	146	4	paramString2	String
    //   0	146	5	paramh	h
    //   89	1	6	i	int
    // Exception table:
    //   from	to	target	type
    //   60	120	131	finally
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, h paramh, NativeAdOptionsParcel paramNativeAdOptionsParcel, List paramList) {}
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString, h paramh)
  {
    a(parama, paramAdSizeParcel, paramAdRequestParcel, paramString, null, paramh);
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, h paramh)
  {
    int i = 0;
    paramString2 = this.a;
    if (!(paramString2 instanceof l))
    {
      parama = String.valueOf(paramString2.getClass().getCanonicalName());
      if (parama.length() == 0)
      {
        parama = new String("Not a MediationBannerAdapter: ");
        com.google.android.gms.ads.internal.util.client.k.e(parama);
        throw new RemoteException();
      }
    }
    else
    {
      com.google.android.gms.ads.internal.util.client.k.b("Requesting banner ad from adapter.");
    }
    for (;;)
    {
      try
      {
        paramString2 = (l)this.a;
        paramh = new ae(paramh);
        e.a(parama);
        int j = paramAdRequestParcel.s;
        a(paramString1);
        parama = c.f;
        paramString1 = c.a;
        c localc1 = c.d;
        c localc2 = c.b;
        c localc3 = c.c;
        c localc4 = c.e;
        if (i < 6)
        {
          g localg = new c[] { parama, paramString1, localc1, localc2, localc3, localc4 }[i].g;
          if ((localg.c != paramAdSizeParcel.i) || (localg.b != paramAdSizeParcel.b)) {
            break label282;
          }
          a(paramAdRequestParcel);
          ah.a(paramAdRequestParcel);
          paramString2.a(paramh, this.b);
          return;
        }
        new c(com.google.android.gms.ads.h.a(paramAdSizeParcel.i, paramAdSizeParcel.b, paramAdSizeParcel.a));
        continue;
        parama = "Not a MediationBannerAdapter: ".concat(parama);
      }
      finally
      {
        com.google.android.gms.ads.internal.util.client.k.c("", parama);
      }
      break;
      label282:
      i += 1;
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, com.google.android.gms.ads.internal.reward.mediation.client.a parama1, List paramList) {}
  
  public final void a(boolean paramBoolean) {}
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/google/android/gms/ads/internal/mediation/client/ad:a	Lcom/google/ads/mediation/k;
    //   4: astore_1
    //   5: aload_1
    //   6: instanceof 241
    //   9: ifne +43 -> 52
    //   12: aload_1
    //   13: invokevirtual 49	java/lang/Object:getClass	()Ljava/lang/Class;
    //   16: invokevirtual 220	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   19: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 136	java/lang/String:length	()I
    //   27: ifne +44 -> 71
    //   30: new 126	java/lang/String
    //   33: dup
    //   34: ldc -13
    //   36: invokespecial 170	java/lang/String:<init>	(Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokestatic 90	com/google/android/gms/ads/internal/util/client/k:e	(Ljava/lang/String;)V
    //   44: new 79	android/os/RemoteException
    //   47: dup
    //   48: invokespecial 80	android/os/RemoteException:<init>	()V
    //   51: athrow
    //   52: ldc_w 325
    //   55: invokestatic 156	com/google/android/gms/ads/internal/util/client/k:b	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 16	com/google/android/gms/ads/internal/mediation/client/ad:a	Lcom/google/ads/mediation/k;
    //   62: checkcast 241	com/google/ads/mediation/n
    //   65: invokeinterface 327 1 0
    //   70: return
    //   71: ldc -13
    //   73: aload_1
    //   74: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_1
    //   78: goto -38 -> 40
    //   81: astore_1
    //   82: ldc 72
    //   84: aload_1
    //   85: invokestatic 77	com/google/android/gms/ads/internal/util/client/k:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   88: new 79	android/os/RemoteException
    //   91: dup
    //   92: invokespecial 80	android/os/RemoteException:<init>	()V
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	ad
    //   4	74	1	localObject	Object
    //   81	4	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   58	70	81	finally
  }
  
  public final void c()
  {
    try
    {
      this.a.a();
      return;
    }
    finally
    {
      com.google.android.gms.ads.internal.util.client.k.c("", localThrowable);
    }
  }
  
  public final void d()
  {
    throw new RemoteException();
  }
  
  public final void e()
  {
    throw new RemoteException();
  }
  
  public final void f() {}
  
  public final boolean g()
  {
    return true;
  }
  
  public final n h()
  {
    return null;
  }
  
  public final q i()
  {
    return null;
  }
  
  public final Bundle j()
  {
    return new Bundle();
  }
  
  public final Bundle k()
  {
    return new Bundle();
  }
  
  public final Bundle l()
  {
    return new Bundle();
  }
  
  public final boolean m()
  {
    return false;
  }
  
  public final ac n()
  {
    return null;
  }
  
  public final bo o()
  {
    return null;
  }
  
  public final t p()
  {
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/client/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */