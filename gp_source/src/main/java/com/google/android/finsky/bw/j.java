package com.google.android.finsky.bw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.android.volley.b;
import com.google.android.play.image.v;
import com.google.android.play.image.y;
import com.google.android.play.utils.e;

final class j
  extends AsyncTask
{
  j(i parami, y paramy, v paramv) {}
  
  private final Bitmap a()
  {
    Bitmap localBitmap = null;
    Object localObject3 = this.a.a.a(this.c.c());
    ??? = localBitmap;
    if (localObject3 != null)
    {
      ??? = localBitmap;
      if (!((b)localObject3).a())
      {
        localObject3 = ((b)localObject3).b;
        ??? = localBitmap;
        if (localObject3 == null) {}
      }
    }
    synchronized (i.b)
    {
      int i = localObject3.length;
      localBitmap = BitmapFactory.decodeByteArray((byte[])localObject3, 0, i);
      if (((Boolean)com.google.android.play.utils.b.j.h.b()).booleanValue())
      {
        ??? = e.a(localBitmap, this.c.c(), i >> 10);
        return (Bitmap)???;
      }
      return localBitmap;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */