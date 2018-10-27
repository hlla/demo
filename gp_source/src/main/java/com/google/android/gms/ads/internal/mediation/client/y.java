package com.google.android.gms.ads.internal.mediation.client;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.a.af;
import com.google.android.gms.ads.mediation.g;
import com.google.android.gms.ads.mediation.i;
import com.google.android.gms.ads.mediation.l;
import com.google.android.gms.ads.mediation.m;
import com.google.android.gms.ads.mediation.o;
import com.google.android.gms.ads.mediation.p;
import com.google.android.gms.ads.mediation.r;
import com.google.android.gms.dynamic.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class y
  extends f
{
  private final com.google.android.gms.ads.mediation.b a;
  private z b;
  
  public y(com.google.android.gms.ads.mediation.b paramb)
  {
    this.a = paramb;
  }
  
  private final Bundle a(String paramString1, AdRequestParcel paramAdRequestParcel, String paramString2)
  {
    Object localObject = String.valueOf(paramString1);
    if (((String)localObject).length() == 0) {}
    for (localObject = new String("Server parameters: ");; localObject = "Server parameters: ".concat((String)localObject))
    {
      com.google.android.gms.ads.internal.util.client.k.e((String)localObject);
      try
      {
        localObject = new Bundle();
        if (paramString1 != null)
        {
          paramString1 = new JSONObject(paramString1);
          localObject = new Bundle();
          Iterator localIterator = paramString1.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ((Bundle)localObject).putString(str, paramString1.getString(str));
          }
        }
        if (!(this.a instanceof AdMobAdapter)) {
          break label153;
        }
      }
      finally
      {
        com.google.android.gms.ads.internal.util.client.k.c("", paramString1);
      }
      ((Bundle)localObject).putString("adJson", paramString2);
      if (paramAdRequestParcel != null) {
        ((Bundle)localObject).putInt("tagForChildDirectedTreatment", paramAdRequestParcel.s);
      }
      label153:
      return (Bundle)localObject;
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
    //   1: getfield 16	com/google/android/gms/ads/internal/mediation/client/y:a	Lcom/google/android/gms/ads/mediation/b;
    //   4: astore_1
    //   5: aload_1
    //   6: instanceof 115
    //   9: ifne +43 -> 52
    //   12: aload_1
    //   13: invokevirtual 121	java/lang/Object:getClass	()Ljava/lang/Class;
    //   16: invokevirtual 127	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   19: invokestatic 24	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 28	java/lang/String:length	()I
    //   27: ifne +40 -> 67
    //   30: new 20	java/lang/String
    //   33: dup
    //   34: ldc -127
    //   36: invokespecial 33	java/lang/String:<init>	(Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokestatic 38	com/google/android/gms/ads/internal/util/client/k:e	(Ljava/lang/String;)V
    //   44: new 74	android/os/RemoteException
    //   47: dup
    //   48: invokespecial 75	android/os/RemoteException:<init>	()V
    //   51: athrow
    //   52: aload_1
    //   53: checkcast 115	com/google/android/gms/ads/mediation/d
    //   56: invokeinterface 133 1 0
    //   61: invokestatic 138	com/google/android/gms/dynamic/e:a	(Ljava/lang/Object;)Lcom/google/android/gms/ads/internal/j/a;
    //   64: astore_1
    //   65: aload_1
    //   66: areturn
    //   67: ldc -127
    //   69: aload_1
    //   70: invokevirtual 94	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   73: astore_1
    //   74: goto -34 -> 40
    //   77: astore_1
    //   78: ldc 68
    //   80: aload_1
    //   81: invokestatic 72	com/google/android/gms/ads/internal/util/client/k:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   84: new 74	android/os/RemoteException
    //   87: dup
    //   88: invokespecial 75	android/os/RemoteException:<init>	()V
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	y
    //   4	70	1	localObject	Object
    //   77	4	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   52	65	77	finally
  }
  
  public final void a(AdRequestParcel paramAdRequestParcel, String paramString)
  {
    a(paramAdRequestParcel, paramString, null);
  }
  
  public final void a(AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2)
  {
    Object localObject3 = null;
    Object localObject1 = this.a;
    if (!(localObject1 instanceof com.google.android.gms.ads.f.a.b))
    {
      paramAdRequestParcel = String.valueOf(localObject1.getClass().getCanonicalName());
      if (paramAdRequestParcel.length() != 0) {
        break label214;
      }
      paramAdRequestParcel = new String("Not a MediationRewardedVideoAdAdapter: ");
    }
    for (;;)
    {
      com.google.android.gms.ads.internal.util.client.k.e(paramAdRequestParcel);
      throw new RemoteException();
      com.google.android.gms.ads.internal.util.client.k.b("Requesting rewarded video ad from adapter.");
      try
      {
        com.google.android.gms.ads.f.a.b localb = (com.google.android.gms.ads.f.a.b)this.a;
        localObject1 = paramAdRequestParcel.j;
        if (localObject1 != null) {}
        for (localObject1 = new HashSet((Collection)localObject1);; localObject1 = null)
        {
          long l = paramAdRequestParcel.b;
          if (l != -1L) {}
          for (Object localObject2 = new Date(l);; localObject2 = null)
          {
            localObject2 = new x((Date)localObject2, paramAdRequestParcel.g, (Set)localObject1, paramAdRequestParcel.k, a(paramAdRequestParcel), paramAdRequestParcel.s, paramAdRequestParcel.h);
            Bundle localBundle = paramAdRequestParcel.n;
            localObject1 = localObject3;
            if (localBundle != null) {
              localObject1 = localBundle.getBundle(localb.getClass().getName());
            }
            localb.a((com.google.android.gms.ads.mediation.a)localObject2, a(paramString1, paramAdRequestParcel, paramString2), (Bundle)localObject1);
            return;
          }
        }
        label214:
        paramAdRequestParcel = "Not a MediationRewardedVideoAdAdapter: ".concat(paramAdRequestParcel);
      }
      finally
      {
        com.google.android.gms.ads.internal.util.client.k.c("", paramAdRequestParcel);
      }
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama)
  {
    e.a(parama);
    parama = this.a;
    if ((parama instanceof o)) {
      ((o)parama).a();
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, AdRequestParcel paramAdRequestParcel, String paramString, h paramh)
  {
    a(parama, paramAdRequestParcel, paramString, null, paramh);
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, AdRequestParcel paramAdRequestParcel, String paramString1, com.google.android.gms.ads.internal.reward.mediation.client.a parama1, String paramString2)
  {
    Object localObject = null;
    paramString1 = this.a;
    if (!(paramString1 instanceof com.google.android.gms.ads.f.a.b))
    {
      parama = String.valueOf(paramString1.getClass().getCanonicalName());
      if (parama.length() != 0) {
        break label230;
      }
    }
    label230:
    for (parama = new String("Not a MediationRewardedVideoAdAdapter: ");; parama = "Not a MediationRewardedVideoAdAdapter: ".concat(parama))
    {
      com.google.android.gms.ads.internal.util.client.k.e(parama);
      throw new RemoteException();
      com.google.android.gms.ads.internal.util.client.k.b("Initialize rewarded video adapter.");
      for (;;)
      {
        try
        {
          com.google.android.gms.ads.f.a.b localb = (com.google.android.gms.ads.f.a.b)this.a;
          a(paramString2, paramAdRequestParcel, null);
          if (paramAdRequestParcel == null)
          {
            localb.a((Context)e.a(parama), new com.google.android.gms.ads.internal.reward.mediation.client.d(parama1));
            return;
          }
          paramString1 = paramAdRequestParcel.j;
          if (paramString1 != null)
          {
            paramString1 = new HashSet(paramString1);
            long l = paramAdRequestParcel.b;
            paramString2 = (String)localObject;
            if (l != -1L) {
              paramString2 = new Date(l);
            }
            new x(paramString2, paramAdRequestParcel.g, paramString1, paramAdRequestParcel.k, a(paramAdRequestParcel), paramAdRequestParcel.s, paramAdRequestParcel.h);
            paramAdRequestParcel = paramAdRequestParcel.n;
            if (paramAdRequestParcel != null) {
              paramAdRequestParcel.getBundle(localb.getClass().getName());
            }
          }
          else
          {
            paramString1 = null;
          }
        }
        finally
        {
          com.google.android.gms.ads.internal.util.client.k.c("", parama);
        }
      }
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, h paramh)
  {
    Object localObject1 = this.a;
    if (!(localObject1 instanceof g))
    {
      parama = String.valueOf(localObject1.getClass().getCanonicalName());
      if (parama.length() != 0) {
        break label230;
      }
      parama = new String("Not a MediationInterstitialAdapter: ");
    }
    for (;;)
    {
      com.google.android.gms.ads.internal.util.client.k.e(parama);
      throw new RemoteException();
      com.google.android.gms.ads.internal.util.client.k.b("Requesting interstitial ad from adapter.");
      try
      {
        g localg = (g)this.a;
        localObject1 = paramAdRequestParcel.j;
        if (localObject1 != null) {}
        for (localObject1 = new HashSet((Collection)localObject1);; localObject1 = null)
        {
          long l = paramAdRequestParcel.b;
          if (l != -1L) {}
          for (Object localObject2 = new Date(l);; localObject2 = null)
          {
            localObject2 = new x((Date)localObject2, paramAdRequestParcel.g, (Set)localObject1, paramAdRequestParcel.k, a(paramAdRequestParcel), paramAdRequestParcel.s, paramAdRequestParcel.h);
            localObject1 = paramAdRequestParcel.n;
            if (localObject1 != null) {}
            for (localObject1 = ((Bundle)localObject1).getBundle(localg.getClass().getName());; localObject1 = null)
            {
              localg.a((Context)e.a(parama), new z(paramh), a(paramString1, paramAdRequestParcel, paramString2), (com.google.android.gms.ads.mediation.a)localObject2, (Bundle)localObject1);
              return;
            }
          }
        }
        label230:
        parama = "Not a MediationInterstitialAdapter: ".concat(parama);
      }
      finally
      {
        com.google.android.gms.ads.internal.util.client.k.c("", parama);
      }
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, h paramh, NativeAdOptionsParcel paramNativeAdOptionsParcel, List paramList)
  {
    Object localObject = this.a;
    if (!(localObject instanceof i))
    {
      parama = String.valueOf(localObject.getClass().getCanonicalName());
      if (parama.length() != 0) {
        break label235;
      }
      parama = new String("Not a MediationNativeAdapter: ");
    }
    for (;;)
    {
      com.google.android.gms.ads.internal.util.client.k.e(parama);
      throw new RemoteException();
      try
      {
        i locali = (i)localObject;
        localObject = paramAdRequestParcel.j;
        if (localObject != null) {}
        for (localObject = new HashSet((Collection)localObject);; localObject = null)
        {
          long l = paramAdRequestParcel.b;
          if (l != -1L) {}
          for (Date localDate = new Date(l);; localDate = null)
          {
            paramList = new ac(localDate, paramAdRequestParcel.g, (Set)localObject, paramAdRequestParcel.k, a(paramAdRequestParcel), paramAdRequestParcel.s, paramNativeAdOptionsParcel, paramList, paramAdRequestParcel.h);
            paramNativeAdOptionsParcel = paramAdRequestParcel.n;
            if (paramNativeAdOptionsParcel != null) {}
            for (paramNativeAdOptionsParcel = paramNativeAdOptionsParcel.getBundle(locali.getClass().getName());; paramNativeAdOptionsParcel = null)
            {
              this.b = new z(paramh);
              locali.a((Context)e.a(parama), this.b, a(paramString1, paramAdRequestParcel, paramString2), paramList, paramNativeAdOptionsParcel);
              return;
            }
          }
        }
        label235:
        parama = "Not a MediationNativeAdapter: ".concat(parama);
      }
      finally
      {
        com.google.android.gms.ads.internal.util.client.k.c("", parama);
      }
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString, h paramh)
  {
    a(parama, paramAdSizeParcel, paramAdRequestParcel, paramString, null, paramh);
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, h paramh)
  {
    Object localObject1 = this.a;
    if (!(localObject1 instanceof com.google.android.gms.ads.mediation.d))
    {
      parama = String.valueOf(localObject1.getClass().getCanonicalName());
      if (parama.length() != 0) {
        break label247;
      }
      parama = new String("Not a MediationBannerAdapter: ");
    }
    for (;;)
    {
      com.google.android.gms.ads.internal.util.client.k.e(parama);
      throw new RemoteException();
      com.google.android.gms.ads.internal.util.client.k.b("Requesting banner ad from adapter.");
      try
      {
        com.google.android.gms.ads.mediation.d locald = (com.google.android.gms.ads.mediation.d)this.a;
        localObject1 = paramAdRequestParcel.j;
        if (localObject1 != null) {}
        for (localObject1 = new HashSet((Collection)localObject1);; localObject1 = null)
        {
          long l = paramAdRequestParcel.b;
          if (l != -1L) {}
          for (Object localObject2 = new Date(l);; localObject2 = null)
          {
            localObject2 = new x((Date)localObject2, paramAdRequestParcel.g, (Set)localObject1, paramAdRequestParcel.k, a(paramAdRequestParcel), paramAdRequestParcel.s, paramAdRequestParcel.h);
            localObject1 = paramAdRequestParcel.n;
            if (localObject1 != null) {}
            for (localObject1 = ((Bundle)localObject1).getBundle(locald.getClass().getName());; localObject1 = null)
            {
              locald.a((Context)e.a(parama), new z(paramh), a(paramString1, paramAdRequestParcel, paramString2), com.google.android.gms.ads.h.a(paramAdSizeParcel.i, paramAdSizeParcel.b, paramAdSizeParcel.a), (com.google.android.gms.ads.mediation.a)localObject2, (Bundle)localObject1);
              return;
            }
          }
        }
        label247:
        parama = "Not a MediationBannerAdapter: ".concat(parama);
      }
      finally
      {
        com.google.android.gms.ads.internal.util.client.k.c("", parama);
      }
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, com.google.android.gms.ads.internal.reward.mediation.client.a parama1, List paramList)
  {
    Object localObject = this.a;
    if (!(localObject instanceof com.google.android.gms.ads.f.a.a))
    {
      parama = String.valueOf(localObject.getClass().getCanonicalName());
      if (parama.length() != 0) {
        break label159;
      }
      parama = new String("Not an InitializableMediationRewardedVideoAdAdapter: ");
    }
    label159:
    for (;;)
    {
      com.google.android.gms.ads.internal.util.client.k.e(parama);
      throw new RemoteException();
      com.google.android.gms.ads.internal.util.client.k.b("Initialize rewarded video adapter.");
      try
      {
        localObject = (com.google.android.gms.ads.f.a.a)this.a;
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        for (;;)
        {
          if (!paramList.hasNext())
          {
            e.a(parama);
            new com.google.android.gms.ads.internal.reward.mediation.client.d(parama1);
            ((com.google.android.gms.ads.f.a.a)localObject).d();
            return;
          }
          localArrayList.add(a((String)paramList.next(), null, null));
        }
        parama = "Not an InitializableMediationRewardedVideoAdAdapter: ".concat(parama);
      }
      finally
      {
        com.google.android.gms.ads.internal.util.client.k.e("Could not initialize rewarded video adapter.", parama);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (!(localObject instanceof p))
    {
      localObject = String.valueOf(localObject.getClass().getCanonicalName());
      if (((String)localObject).length() == 0) {}
      for (localObject = new String("Not an OnImmersiveModeUpdatedListener: ");; localObject = "Not an OnImmersiveModeUpdatedListener: ".concat((String)localObject))
      {
        com.google.android.gms.ads.internal.util.client.k.d((String)localObject);
        return;
      }
    }
    try
    {
      ((p)localObject).a(paramBoolean);
      return;
    }
    finally
    {
      com.google.android.gms.ads.internal.util.client.k.c("", localThrowable);
    }
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/google/android/gms/ads/internal/mediation/client/y:a	Lcom/google/android/gms/ads/mediation/b;
    //   4: astore_1
    //   5: aload_1
    //   6: instanceof 228
    //   9: ifne +43 -> 52
    //   12: aload_1
    //   13: invokevirtual 121	java/lang/Object:getClass	()Ljava/lang/Class;
    //   16: invokevirtual 127	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   19: invokestatic 24	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 28	java/lang/String:length	()I
    //   27: ifne +44 -> 71
    //   30: new 20	java/lang/String
    //   33: dup
    //   34: ldc -26
    //   36: invokespecial 33	java/lang/String:<init>	(Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokestatic 38	com/google/android/gms/ads/internal/util/client/k:e	(Ljava/lang/String;)V
    //   44: new 74	android/os/RemoteException
    //   47: dup
    //   48: invokespecial 75	android/os/RemoteException:<init>	()V
    //   51: athrow
    //   52: ldc_w 312
    //   55: invokestatic 150	com/google/android/gms/ads/internal/util/client/k:b	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 16	com/google/android/gms/ads/internal/mediation/client/y:a	Lcom/google/android/gms/ads/mediation/b;
    //   62: checkcast 228	com/google/android/gms/ads/mediation/g
    //   65: invokeinterface 315 1 0
    //   70: return
    //   71: ldc -26
    //   73: aload_1
    //   74: invokevirtual 94	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_1
    //   78: goto -38 -> 40
    //   81: astore_1
    //   82: ldc 68
    //   84: aload_1
    //   85: invokestatic 72	com/google/android/gms/ads/internal/util/client/k:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   88: new 74	android/os/RemoteException
    //   91: dup
    //   92: invokespecial 75	android/os/RemoteException:<init>	()V
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	y
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
    try
    {
      this.a.b();
      return;
    }
    finally
    {
      com.google.android.gms.ads.internal.util.client.k.c("", localThrowable);
    }
  }
  
  public final void e()
  {
    try
    {
      this.a.c();
      return;
    }
    finally
    {
      com.google.android.gms.ads.internal.util.client.k.c("", localThrowable);
    }
  }
  
  /* Error */
  public final void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/google/android/gms/ads/internal/mediation/client/y:a	Lcom/google/android/gms/ads/mediation/b;
    //   4: astore_1
    //   5: aload_1
    //   6: instanceof 144
    //   9: ifne +43 -> 52
    //   12: aload_1
    //   13: invokevirtual 121	java/lang/Object:getClass	()Ljava/lang/Class;
    //   16: invokevirtual 127	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   19: invokestatic 24	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 28	java/lang/String:length	()I
    //   27: ifne +44 -> 71
    //   30: new 20	java/lang/String
    //   33: dup
    //   34: ldc -110
    //   36: invokespecial 33	java/lang/String:<init>	(Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokestatic 38	com/google/android/gms/ads/internal/util/client/k:e	(Ljava/lang/String;)V
    //   44: new 74	android/os/RemoteException
    //   47: dup
    //   48: invokespecial 75	android/os/RemoteException:<init>	()V
    //   51: athrow
    //   52: ldc_w 324
    //   55: invokestatic 150	com/google/android/gms/ads/internal/util/client/k:b	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 16	com/google/android/gms/ads/internal/mediation/client/y:a	Lcom/google/android/gms/ads/mediation/b;
    //   62: checkcast 144	com/google/android/gms/ads/f/a/b
    //   65: invokeinterface 326 1 0
    //   70: return
    //   71: ldc -110
    //   73: aload_1
    //   74: invokevirtual 94	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_1
    //   78: goto -38 -> 40
    //   81: astore_1
    //   82: ldc 68
    //   84: aload_1
    //   85: invokestatic 72	com/google/android/gms/ads/internal/util/client/k:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   88: new 74	android/os/RemoteException
    //   91: dup
    //   92: invokespecial 75	android/os/RemoteException:<init>	()V
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	y
    //   4	74	1	localObject	Object
    //   81	4	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   58	70	81	finally
  }
  
  /* Error */
  public final boolean g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/google/android/gms/ads/internal/mediation/client/y:a	Lcom/google/android/gms/ads/mediation/b;
    //   4: astore_2
    //   5: aload_2
    //   6: instanceof 144
    //   9: ifne +43 -> 52
    //   12: aload_2
    //   13: invokevirtual 121	java/lang/Object:getClass	()Ljava/lang/Class;
    //   16: invokevirtual 127	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   19: invokestatic 24	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   22: astore_2
    //   23: aload_2
    //   24: invokevirtual 28	java/lang/String:length	()I
    //   27: ifne +46 -> 73
    //   30: new 20	java/lang/String
    //   33: dup
    //   34: ldc -110
    //   36: invokespecial 33	java/lang/String:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokestatic 38	com/google/android/gms/ads/internal/util/client/k:e	(Ljava/lang/String;)V
    //   44: new 74	android/os/RemoteException
    //   47: dup
    //   48: invokespecial 75	android/os/RemoteException:<init>	()V
    //   51: athrow
    //   52: ldc_w 328
    //   55: invokestatic 150	com/google/android/gms/ads/internal/util/client/k:b	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 16	com/google/android/gms/ads/internal/mediation/client/y:a	Lcom/google/android/gms/ads/mediation/b;
    //   62: checkcast 144	com/google/android/gms/ads/f/a/b
    //   65: invokeinterface 330 1 0
    //   70: istore_1
    //   71: iload_1
    //   72: ireturn
    //   73: ldc -110
    //   75: aload_2
    //   76: invokevirtual 94	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_2
    //   80: goto -40 -> 40
    //   83: astore_2
    //   84: ldc 68
    //   86: aload_2
    //   87: invokestatic 72	com/google/android/gms/ads/internal/util/client/k:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: new 74	android/os/RemoteException
    //   93: dup
    //   94: invokespecial 75	android/os/RemoteException:<init>	()V
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	y
    //   70	2	1	bool	boolean
    //   4	76	2	localObject	Object
    //   83	4	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   58	71	83	finally
  }
  
  public final n h()
  {
    com.google.android.gms.ads.mediation.k localk = this.b.b;
    if ((localk instanceof l)) {
      return new aa((l)localk);
    }
    return null;
  }
  
  public final q i()
  {
    com.google.android.gms.ads.mediation.k localk = this.b.b;
    if ((localk instanceof m)) {
      return new ab((m)localk);
    }
    return null;
  }
  
  public final Bundle j()
  {
    Object localObject = this.a;
    if (!(localObject instanceof com.google.android.gms.ads.mediation.b.a))
    {
      localObject = String.valueOf(localObject.getClass().getCanonicalName());
      if (((String)localObject).length() == 0) {}
      for (localObject = new String("Not a v2 MediationBannerAdapter: ");; localObject = "Not a v2 MediationBannerAdapter: ".concat((String)localObject))
      {
        com.google.android.gms.ads.internal.util.client.k.e((String)localObject);
        return new Bundle();
      }
    }
    return ((com.google.android.gms.ads.mediation.b.a)localObject).e();
  }
  
  public final Bundle k()
  {
    Object localObject = this.a;
    if (!(localObject instanceof com.google.android.gms.ads.mediation.b.b))
    {
      localObject = String.valueOf(localObject.getClass().getCanonicalName());
      if (((String)localObject).length() == 0) {}
      for (localObject = new String("Not a v2 MediationInterstitialAdapter: ");; localObject = "Not a v2 MediationInterstitialAdapter: ".concat((String)localObject))
      {
        com.google.android.gms.ads.internal.util.client.k.e((String)localObject);
        return new Bundle();
      }
    }
    return ((com.google.android.gms.ads.mediation.b.b)localObject).g();
  }
  
  public final Bundle l()
  {
    return new Bundle();
  }
  
  public final boolean m()
  {
    return this.a instanceof com.google.android.gms.ads.f.a.a;
  }
  
  public final com.google.android.gms.ads.internal.formats.a.ac n()
  {
    com.google.android.gms.ads.formats.n localn = this.b.a;
    if ((localn instanceof af)) {
      return ((af)localn).a;
    }
    return null;
  }
  
  public final bo o()
  {
    Object localObject = this.a;
    if ((localObject instanceof r)) {}
    try
    {
      localObject = ((r)localObject).e();
      return (bo)localObject;
    }
    finally
    {
      com.google.android.gms.ads.internal.util.client.k.c("", localThrowable);
    }
    return null;
    return null;
  }
  
  public final t p()
  {
    com.google.android.gms.ads.mediation.q localq = this.b.c;
    if (localq != null) {
      return new aj(localq);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/client/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */