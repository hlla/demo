package com.google.android.finsky.da.a;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.finsky.cv.b;
import com.google.android.finsky.cv.c;
import com.google.android.finsky.cv.h;
import com.google.android.finsky.ds.a.bu;
import com.google.android.finsky.notification.g;
import com.google.android.finsky.notification.m;
import com.google.android.finsky.notification.n;
import com.google.android.finsky.utils.FinskyLog;
import com.google.protobuf.nano.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class aa
{
  static com.google.android.finsky.cv.a a(com.google.android.finsky.notification.a parama)
  {
    com.google.android.finsky.cv.a locala = new com.google.android.finsky.cv.a();
    String str = parama.c;
    if (str == null) {
      throw new NullPointerException();
    }
    locala.a |= 0x1;
    locala.d = str;
    int i = parama.a;
    locala.a |= 0x2;
    locala.b = i;
    locala.c = a(parama.b);
    return locala;
  }
  
  static com.google.android.finsky.cv.e a(m paramm)
  {
    com.google.android.finsky.cv.e locale = new com.google.android.finsky.cv.e();
    Object localObject1 = paramm.d;
    if (localObject1 != null)
    {
      locale.a |= 0x1;
      locale.d = ((String)localObject1);
      localObject1 = paramm.a;
      if (localObject1 == null) {}
      for (;;)
      {
        localObject1 = paramm.c;
        ArrayList localArrayList1 = new ArrayList();
        Iterator localIterator = ((Bundle)localObject1).keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (String)localIterator.next();
          c localc = new c();
          if (localObject2 == null) {
            break label561;
          }
          localc.a |= 0x1;
          localc.e = ((String)localObject2);
          switch (paramm.a((String)localObject2))
          {
          default: 
            FinskyLog.e("Unknown ExtraType: %d", new Object[] { Integer.valueOf(paramm.a((String)localObject2)) });
            break;
          case 5: 
            localObject2 = ((Bundle)localObject1).getByteArray((String)localObject2);
            if (localObject2 == null) {
              break label569;
            }
            localc.g = -1;
            localc.g = 1;
            localc.c = ((byte[])localObject2);
            localArrayList1.add(localc);
            break;
          case 4: 
            h localh = new h();
            ArrayList localArrayList2 = ((Bundle)localObject1).getStringArrayList((String)localObject2);
            localh.a = ((String[])((Bundle)localObject1).getStringArrayList((String)localObject2).toArray(new String[localArrayList2.size()]));
            localc.g = -1;
            localc.g = 4;
            localc.h = localh;
            localArrayList1.add(localc);
            break;
          case 3: 
            localObject2 = ((Bundle)localObject1).getString((String)localObject2, "");
            if (localObject2 == null) {
              break label577;
            }
            localc.g = -1;
            localc.g = 0;
            localc.i = ((String)localObject2);
            localArrayList1.add(localc);
            break;
          case 2: 
            long l = ((Bundle)localObject1).getLong((String)localObject2);
            localc.g = -1;
            localc.g = 2;
            localc.f = l;
            localArrayList1.add(localc);
            break;
          case 1: 
            int i = ((Bundle)localObject1).getInt((String)localObject2);
            localc.g = -1;
            localc.g = 5;
            localc.d = i;
            localArrayList1.add(localc);
            break;
          case 0: 
            boolean bool = ((Bundle)localObject1).getBoolean((String)localObject2);
            localc.g = -1;
            localc.g = 3;
            localc.b = bool;
            localArrayList1.add(localc);
          }
        }
        locale.c = ((c[])localArrayList1.toArray(new c[localArrayList1.size()]));
        return locale;
        localObject1 = ((Uri)localObject1).toString();
        if (localObject1 == null) {
          break label585;
        }
        locale.a |= 0x2;
        locale.b = ((String)localObject1);
      }
    }
    throw new NullPointerException();
    label561:
    throw new NullPointerException();
    label569:
    throw new NullPointerException();
    label577:
    throw new NullPointerException();
    label585:
    throw new NullPointerException();
  }
  
  private static com.google.android.finsky.notification.a a(com.google.android.finsky.cv.a parama)
  {
    return new com.google.android.finsky.notification.a(parama.d, parama.b, a(parama.c));
  }
  
  static com.google.android.finsky.notification.d a(b paramb)
  {
    int j = 0;
    com.google.android.finsky.notification.e locale = com.google.android.finsky.notification.d.a(paramb.h, paramb.n, paramb.g, paramb.m);
    Object localObject = locale.a(paramb.i);
    if (paramb.d == 1) {}
    for (int i = 0;; i = 1)
    {
      ((com.google.android.finsky.notification.e)localObject).a(i);
      if (!paramb.b()) {}
      for (;;)
      {
        localObject = paramb.f;
        if (localObject == null) {}
        int k;
        for (;;)
        {
          localObject = paramb.c;
          if (localObject != null) {
            locale.a(a((com.google.android.finsky.cv.e)localObject));
          }
          localObject = paramb.e;
          if (localObject != null) {
            locale.b(a((com.google.android.finsky.cv.e)localObject));
          }
          localObject = paramb.j;
          if (localObject != null) {
            locale.a(a((com.google.android.finsky.cv.a)localObject));
          }
          localObject = paramb.k;
          if (localObject != null) {
            locale.b(a((com.google.android.finsky.cv.a)localObject));
          }
          if ((paramb.b & 0x80) != 0) {
            locale.b(paramb.o);
          }
          if ((paramb.b & 0x100) != 0) {
            locale.a(paramb.l);
          }
          return locale.a();
          k = ((com.google.android.finsky.cv.d)localObject).d;
          if (k != 0) {
            break;
          }
          i = j;
          if (k == 0) {
            i = ((com.google.android.finsky.cv.d)localObject).a;
          }
          localObject = g.a(i);
          locale.a((g)localObject);
        }
        if (k != 1)
        {
          if (k == 2) {}
          for (localObject = ((com.google.android.finsky.cv.d)localObject).c;; localObject = "")
          {
            localObject = g.a((String)localObject);
            break;
          }
        }
        if (k == 1) {}
        for (localObject = ((com.google.android.finsky.cv.d)localObject).b;; localObject = null)
        {
          localObject = g.a((bu)localObject);
          break;
        }
        locale.a(paramb.a);
      }
    }
  }
  
  private static m a(com.google.android.finsky.cv.e parame)
  {
    n localn = m.b(parame.d);
    if ((parame.a & 0x2) != 0) {
      localn.a = Uri.parse(parame.b);
    }
    c[] arrayOfc = parame.c;
    int k = arrayOfc.length;
    int i = 0;
    if (i < k)
    {
      parame = arrayOfc[i];
      int j = parame.g;
      boolean bool;
      if (j == 3)
      {
        str = parame.e;
        if (j == 3)
        {
          bool = parame.b;
          label79:
          localn.a(str, bool);
        }
      }
      do
      {
        i += 1;
        break;
        bool = false;
        break label79;
        if (j == 0)
        {
          str = parame.e;
          if (j != 0) {}
          for (parame = "";; parame = parame.i)
          {
            localn.a(str, parame);
            break;
          }
        }
        if (j == 1)
        {
          str = parame.e;
          if (j == 1) {}
          for (parame = parame.c;; parame = j.b)
          {
            localn.a(str, parame);
            break;
          }
        }
        if (j == 2)
        {
          str = parame.e;
          if (j == 2) {}
          for (long l = parame.f;; l = 0L)
          {
            localn.c.putLong(str, l);
            localn.b.put(str, Integer.valueOf(2));
            break;
          }
        }
        if (j == 5)
        {
          str = parame.e;
          if (j == 5) {}
          for (j = parame.d;; j = 0)
          {
            localn.a(str, j);
            break;
          }
        }
      } while (j != 4);
      String str = parame.e;
      if (j == 4) {}
      for (parame = parame.h;; parame = null)
      {
        localn.a(str, new ArrayList(Arrays.asList(parame.a)));
        break;
      }
    }
    return localn.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/da/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */