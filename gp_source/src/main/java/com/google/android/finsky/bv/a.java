package com.google.android.finsky.bv;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.finsky.bh.b;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.bu;
import com.google.android.finsky.ds.a.cp;
import com.google.android.finsky.frameworkviews.j;
import com.google.android.finsky.frameworkviews.l;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private final b a;
  
  public a(b paramb)
  {
    this.a = paramb;
  }
  
  public final l a(Document paramDocument, Context paramContext)
  {
    l locall = new l();
    ArrayList localArrayList = new ArrayList();
    cp[] arrayOfcp = paramDocument.dd();
    int j = arrayOfcp.length;
    int i = 0;
    if (i < j)
    {
      cp localcp = arrayOfcp[i];
      j localj = new j();
      localj.h = localcp.h;
      localj.b = localcp.a;
      if (localcp.e == 0) {}
      for (Object localObject = localcp.c;; localObject = null)
      {
        if (localObject != null)
        {
          localj.f = this.a.a(paramContext, paramDocument);
          if (TextUtils.isEmpty(localj.f))
          {
            i += 1;
            break;
          }
          localj.b = localj.f;
        }
        for (;;)
        {
          bu localbu = localcp.d;
          if (localbu != null) {}
          for (localObject = localbu.g;; localObject = null)
          {
            localj.c = ((String)localObject);
            boolean bool;
            if (localbu != null) {
              if (localbu.h) {
                bool = true;
              }
            }
            for (;;)
            {
              localj.g = bool;
              localj.e = localcp.f;
              if (localcp.c() != null)
              {
                localj.a = 2;
                localj.d = true;
              }
              label266:
              for (;;)
              {
                localArrayList.add(localj);
                break;
                if (localcp.e == 2) {}
                for (localObject = localcp.b;; localObject = null)
                {
                  if (localObject == null) {
                    break label266;
                  }
                  localj.a = 1;
                  localj.d = true;
                  break;
                }
              }
              bool = false;
              continue;
              bool = false;
            }
          }
          localj.f = localcp.g;
        }
      }
    }
    locall.a = ((j[])localArrayList.toArray(new j[localArrayList.size()]));
    return locall;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bv/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */