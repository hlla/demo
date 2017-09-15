package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.c.a;
import com.google.android.gms.wearable.c.c;
import com.google.android.gms.wearable.c.d;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.h;
import java.io.IOException;
import java.io.InputStream;

public final class bg
  implements com.google.android.gms.wearable.c
{
  public final e<h> a(com.google.android.gms.common.api.c paramc)
  {
    paramc.a(new aw(paramc) {});
  }
  
  public final e<c.d> a(com.google.android.gms.common.api.c paramc, final Asset paramAsset)
  {
    if (paramAsset == null) {
      throw new IllegalArgumentException("asset is null");
    }
    if (paramAsset.aFG == null) {
      throw new IllegalArgumentException("invalid asset");
    }
    if (paramAsset.aFF != null) {
      throw new IllegalArgumentException("invalid asset");
    }
    paramc.a(new aw(paramc) {});
  }
  
  public final e<c.a> a(com.google.android.gms.common.api.c paramc, final PutDataRequest paramPutDataRequest)
  {
    paramc.a(new aw(paramc) {});
  }
  
  public final e<c.c> b(com.google.android.gms.common.api.c paramc, final Uri paramUri)
  {
    paramc.a(new aw(paramc) {});
  }
  
  public static final class a
    implements c.a
  {
    private final Status aFq;
    private final f aHW;
    
    public a(Status paramStatus, f paramf)
    {
      this.aFq = paramStatus;
      this.aHW = paramf;
    }
    
    public final Status jv()
    {
      return this.aFq;
    }
  }
  
  public static final class b
    implements c.c
  {
    private final Status aFq;
    private final int aHX;
    
    public b(Status paramStatus, int paramInt)
    {
      this.aFq = paramStatus;
      this.aHX = paramInt;
    }
    
    public final Status jv()
    {
      return this.aFq;
    }
  }
  
  public static final class c
    implements c.d
  {
    private final Status aFq;
    private volatile ParcelFileDescriptor aHY;
    private volatile InputStream aHZ;
    private volatile boolean mClosed = false;
    
    public c(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.aFq = paramStatus;
      this.aHY = paramParcelFileDescriptor;
    }
    
    public final InputStream getInputStream()
    {
      if (this.mClosed) {
        throw new IllegalStateException("Cannot access the input stream after release().");
      }
      if (this.aHY == null) {
        return null;
      }
      if (this.aHZ == null) {
        this.aHZ = new ParcelFileDescriptor.AutoCloseInputStream(this.aHY);
      }
      return this.aHZ;
    }
    
    public final Status jv()
    {
      return this.aFq;
    }
    
    public final void release()
    {
      if (this.aHY == null) {
        return;
      }
      if (this.mClosed) {
        throw new IllegalStateException("releasing an already released result.");
      }
      try
      {
        if (this.aHZ != null) {
          this.aHZ.close();
        }
        for (;;)
        {
          this.mClosed = true;
          this.aHY = null;
          this.aHZ = null;
          return;
          this.aHY.close();
        }
        return;
      }
      catch (IOException localIOException) {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */