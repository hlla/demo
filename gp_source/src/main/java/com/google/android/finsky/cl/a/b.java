package com.google.android.finsky.cl.a;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.bo.c;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.by;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.library.r;

final class b
  extends h
{
  b(a parama)
  {
    super((byte)0);
  }
  
  public final Intent a(Document paramDocument, String paramString)
  {
    int i;
    if (this.a.d.cY().a(12633045L)) {
      if (paramDocument.a.r == 64) {
        i = 1;
      }
    }
    for (;;)
    {
      Object localObject = this.a;
      int j;
      if (((a)localObject).g.a(paramDocument, ((a)localObject).f, 2))
      {
        localObject = this.a;
        if (!((a)localObject).g.a(paramDocument, ((a)localObject).f)) {
          j = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          localObject = (String)d.hw.b();
        }
        for (;;)
        {
          localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject).buildUpon().appendQueryParameter("id", paramDocument.a.f).build());
          ((Intent)localObject).setPackage("com.google.android.apps.books");
          a((Intent)localObject, "authAccount", paramString);
          if (i != 0) {
            ((Intent)localObject).putExtra("android.intent.extra.START_PLAYBACK", true);
          }
          paramString = this.a;
          if (paramString.g.a(paramDocument, paramString.f)) {
            ((Intent)localObject).setFlags(268435456);
          }
          for (;;)
          {
            paramDocument = paramDocument.a.w;
            j = paramDocument.length;
            i = 0;
            for (;;)
            {
              if (i < j)
              {
                paramString = paramDocument[i];
                if ((paramString.a & 0x200) != 0) {
                  ((Intent)localObject).putExtra("offerType", paramString.m);
                }
              }
              else
              {
                ((Intent)localObject).putExtra("books:addToMyEBooks", false);
                return (Intent)localObject;
              }
              i += 1;
            }
            ((Intent)localObject).putExtra("preview", true);
          }
          if (j == 0) {
            localObject = "https://play.google.com/books/ab";
          } else {
            localObject = "https://play.google.com/books/absample";
          }
        }
        j = 0;
        continue;
        j = 0;
      }
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final Intent a(String paramString)
  {
    Intent localIntent = this.a.h.getLaunchIntentForPackage("com.google.android.apps.books");
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setFlags(268435456);
    a(localIntent, "authAccount", paramString);
    return localIntent;
  }
  
  public final String a()
  {
    return "com.google.android.apps.books";
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cl/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */