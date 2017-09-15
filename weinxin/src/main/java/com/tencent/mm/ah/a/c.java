package com.tencent.mm.ah.a;

import android.view.View;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import java.lang.ref.WeakReference;

public final class c
{
  public WeakReference<ImageView> hHT;
  public int height;
  private String url;
  public int width;
  
  public c(ImageView paramImageView, String paramString)
  {
    GMTrace.i(13728728743936L, 102287);
    this.width = 0;
    this.height = 0;
    this.url = "";
    this.hHT = new WeakReference(paramImageView);
    this.url = paramString;
    GMTrace.o(13728728743936L, 102287);
  }
  
  public final ImageView Bf()
  {
    GMTrace.i(13728862961664L, 102288);
    if (this.hHT != null)
    {
      ImageView localImageView = (ImageView)this.hHT.get();
      if (localImageView != null)
      {
        GMTrace.o(13728862961664L, 102288);
        return localImageView;
      }
    }
    GMTrace.o(13728862961664L, 102288);
    return null;
  }
  
  public final int Hf()
  {
    GMTrace.i(13728997179392L, 102289);
    View localView = null;
    if (this.hHT != null) {
      localView = (View)this.hHT.get();
    }
    if (localView == null)
    {
      i = super.hashCode();
      GMTrace.o(13728997179392L, 102289);
      return i;
    }
    int i = localView.hashCode();
    GMTrace.o(13728997179392L, 102289);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */