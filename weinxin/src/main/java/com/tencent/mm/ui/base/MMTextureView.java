package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;

@TargetApi(14)
public class MMTextureView
  extends TextureView
{
  private Field vlr;
  
  public MMTextureView(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(3366851706880L, 25085);
    GMTrace.o(3366851706880L, 25085);
  }
  
  public MMTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(3366717489152L, 25084);
    GMTrace.o(3366717489152L, 25084);
  }
  
  public MMTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(3366583271424L, 25083);
    GMTrace.o(3366583271424L, 25083);
  }
  
  public final void bSr()
  {
    GMTrace.i(3367120142336L, 25087);
    if (d.ep(16))
    {
      v.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      GMTrace.o(3367120142336L, 25087);
      return;
    }
    if (d.eq(20))
    {
      v.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      GMTrace.o(3367120142336L, 25087);
      return;
    }
    if (p.gRb.gQu == 2)
    {
      v.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
      GMTrace.o(3367120142336L, 25087);
      return;
    }
    v.i("MicroMsg.MMTextureView", "detect texture problem, sly");
    try
    {
      if (this.vlr == null)
      {
        this.vlr = TextureView.class.getDeclaredField("mSurface");
        this.vlr.setAccessible(true);
      }
      SurfaceTexture localSurfaceTexture = (SurfaceTexture)this.vlr.get(this);
      if (localSurfaceTexture != null) {
        if (!(localSurfaceTexture instanceof r))
        {
          r localr = new r();
          localr.lzC = localSurfaceTexture;
          this.vlr.set(this, localr);
          v.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
          GMTrace.o(3367120142336L, 25087);
          return;
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      v.printErrStackTrace("MicroMsg.MMTextureView", localNoSuchFieldException, "", new Object[0]);
      v.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
      GMTrace.o(3367120142336L, 25087);
      return;
      v.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
      GMTrace.o(3367120142336L, 25087);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      v.printErrStackTrace("MicroMsg.MMTextureView", localIllegalArgumentException, "", new Object[0]);
      v.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
      GMTrace.o(3367120142336L, 25087);
      return;
      v.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
      GMTrace.o(3367120142336L, 25087);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      v.printErrStackTrace("MicroMsg.MMTextureView", localIllegalAccessException, "", new Object[0]);
      v.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
      GMTrace.o(3367120142336L, 25087);
    }
  }
  
  @TargetApi(14)
  public void onDetachedFromWindow()
  {
    GMTrace.i(3366985924608L, 25086);
    try
    {
      super.onDetachedFromWindow();
      GMTrace.o(3366985924608L, 25086);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.MMTextureView", localException, "unkown error", new Object[0]);
      GMTrace.o(3366985924608L, 25086);
    }
  }
  
  @TargetApi(16)
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    GMTrace.i(3367254360064L, 25088);
    super.setSurfaceTexture(paramSurfaceTexture);
    bSr();
    GMTrace.o(3367254360064L, 25088);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/MMTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */