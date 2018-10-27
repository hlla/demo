package com.google.android.finsky.dn.a.a;

import com.google.android.finsky.utils.FinskyLog;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class g
{
  public static com.google.android.play.b.a.c a(com.google.android.gms.phenotype.core.c paramc, boolean paramBoolean)
  {
    Object localObject2 = null;
    com.google.wireless.android.a.b.a.a.a locala;
    Object localObject1;
    int i;
    if (paramc != null)
    {
      locala = new com.google.wireless.android.a.b.a.a.a();
      if (paramc != null)
      {
        localObject1 = paramc.j;
        Object localObject3;
        int k;
        int j;
        if ((!com.google.android.gms.clearcut.a.a.a.a((int[])localObject1)) || (!com.google.android.gms.clearcut.a.a.a.a(null)))
        {
          localObject3 = new com.google.f.a.b.a();
          ((com.google.f.a.b.a)localObject3).a = new int[com.google.android.gms.clearcut.a.a.a.b((int[])localObject1) + com.google.android.gms.clearcut.a.a.a.b(null)];
          if (localObject1 != null)
          {
            k = localObject1.length;
            j = 0;
            i = 0;
            while (j < k)
            {
              int m = localObject1[j];
              ((com.google.f.a.b.a)localObject3).a[i] = m;
              j += 1;
              i += 1;
            }
          }
          locala.a = com.google.protobuf.nano.g.a((com.google.protobuf.nano.g)localObject3);
        }
        if (paramc != null)
        {
          i = Math.max(1, com.google.android.gms.clearcut.a.a.a.a(paramc.b)) + com.google.android.gms.clearcut.a.a.a.a(paramc.e) + com.google.android.gms.clearcut.a.a.a.a(paramc.h) + com.google.android.gms.clearcut.a.a.a.a(paramc.c) + com.google.android.gms.clearcut.a.a.a.a(paramc.g);
          label171:
          localObject1 = new ArrayList(i);
          if (paramc != null)
          {
            localObject3 = paramc.d;
            if ((localObject3 != null) && (localObject3.length != 0)) {
              ((List)localObject1).add(localObject3);
            }
            localObject3 = paramc.b;
            if (localObject3 != null)
            {
              j = localObject3.length;
              i = 0;
              if (i < j)
              {
                Object localObject4 = localObject3[i];
                if (localObject4 == null) {}
                for (;;)
                {
                  i += 1;
                  break;
                  if (localObject4.length != 0) {
                    ((List)localObject1).add(localObject4);
                  }
                }
              }
            }
            locala.c = paramBoolean;
            if (paramBoolean)
            {
              localObject3 = paramc.e;
              if (localObject3 != null) {
                Collections.addAll((Collection)localObject1, (Object[])localObject3);
              }
            }
            localObject3 = paramc.h;
            if (localObject3 != null) {
              Collections.addAll((Collection)localObject1, (Object[])localObject3);
            }
            localObject3 = paramc.c;
            if (localObject3 != null) {
              Collections.addAll((Collection)localObject1, (Object[])localObject3);
            }
            paramc = paramc.g;
            if (paramc != null) {
              Collections.addAll((Collection)localObject1, paramc);
            }
          }
          locala.b = new byte[((List)localObject1).size()][];
          k = ((List)localObject1).size();
          j = 0;
          i = 0;
          while (i < k)
          {
            paramc = (byte[])((List)localObject1).get(i);
            locala.b[j] = paramc;
            j += 1;
            i += 1;
          }
        }
      }
    }
    for (paramc = locala;; paramc = null)
    {
      localObject1 = localObject2;
      if (paramc != null) {}
      try
      {
        localObject1 = com.google.android.play.b.a.c.a(com.google.protobuf.nano.g.a(paramc));
        return (com.google.android.play.b.a.c)localObject1;
      }
      catch (InvalidProtocolBufferNanoException paramc)
      {
        FinskyLog.b(paramc, "Error converting ExperimentTokens.", new Object[0]);
      }
      i = 0;
      break label171;
      localObject1 = null;
      break;
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */