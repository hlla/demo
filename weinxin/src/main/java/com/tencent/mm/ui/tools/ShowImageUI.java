package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dd.b;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import java.util.LinkedList;
import java.util.List;

public class ShowImageUI
  extends MMActivity
{
  private MMGestureGallery kjS;
  private boolean wmt;
  private a wmu;
  private boolean wmv;
  
  public ShowImageUI()
  {
    GMTrace.i(1914481672192L, 14264);
    GMTrace.o(1914481672192L, 14264);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(1914615889920L, 14265);
    int i = R.i.dop;
    GMTrace.o(1914615889920L, 14265);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1914750107648L, 14266);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_title");
    if (!bf.mA(paramBundle)) {
      qL(paramBundle);
    }
    this.wmt = getIntent().getBooleanExtra("key_favorite", false);
    this.wmv = getIntent().getBooleanExtra("show_menu", true);
    this.kjS = ((MMGestureGallery)findViewById(R.h.bSk));
    this.kjS.setVerticalFadingEdgeEnabled(false);
    this.kjS.setHorizontalFadingEdgeEnabled(false);
    this.wmu = new a((byte)0);
    this.wmu.imagePath = getIntent().getStringExtra("key_image_path");
    this.kjS.setAdapter(this.wmu);
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2052054843392L, 15289);
        ShowImageUI.this.finish();
        GMTrace.o(2052054843392L, 15289);
        return true;
      }
    });
    if (this.wmv) {
      a(0, R.k.dyn, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2009642041344L, 14973);
          paramAnonymousMenuItem = new LinkedList();
          LinkedList localLinkedList = new LinkedList();
          if ((ShowImageUI.a(ShowImageUI.this)) && (com.tencent.mm.bb.d.Jr("favorite")))
          {
            localLinkedList.add(Integer.valueOf(0));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(R.l.eLD));
            localLinkedList.add(Integer.valueOf(1));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(R.l.eFS));
            localLinkedList.add(Integer.valueOf(2));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(R.l.eOe));
          }
          for (;;)
          {
            dd localdd = new dd();
            localdd.fGN.fGD = ShowImageUI.this.getIntent().getLongExtra("key_message_id", -1L);
            com.tencent.mm.sdk.b.a.uql.m(localdd);
            if (localdd.fGO.fGl)
            {
              localLinkedList.add(Integer.valueOf(3));
              paramAnonymousMenuItem.add(ShowImageUI.this.getString(R.l.dUm));
            }
            g.a(ShowImageUI.this, "", paramAnonymousMenuItem, localLinkedList, "", false, new g.d()
            {
              public final void bN(int paramAnonymous2Int1, int paramAnonymous2Int2)
              {
                GMTrace.i(1959713046528L, 14601);
                switch (paramAnonymous2Int2)
                {
                }
                for (;;)
                {
                  GMTrace.o(1959713046528L, 14601);
                  return;
                  ShowImageUI.b(ShowImageUI.this);
                  GMTrace.o(1959713046528L, 14601);
                  return;
                  ShowImageUI localShowImageUI = ShowImageUI.this;
                  cb localcb = new cb();
                  long l = localShowImageUI.getIntent().getLongExtra("key_message_id", -1L);
                  if (-1L == l)
                  {
                    v.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
                    com.tencent.mm.pluginsdk.model.e.a(localcb, localShowImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), localShowImageUI.getIntent().getStringExtra("key_image_path"));
                  }
                  for (;;)
                  {
                    localcb.fFr.activity = localShowImageUI;
                    com.tencent.mm.sdk.b.a.uql.m(localcb);
                    GMTrace.o(1959713046528L, 14601);
                    return;
                    com.tencent.mm.pluginsdk.model.e.a(localcb, l);
                  }
                  ShowImageUI.c(ShowImageUI.this);
                  GMTrace.o(1959713046528L, 14601);
                  return;
                  ShowImageUI.d(ShowImageUI.this);
                }
              }
            });
            GMTrace.o(2009642041344L, 14973);
            return true;
            localLinkedList.add(Integer.valueOf(0));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(R.l.eLD));
            localLinkedList.add(Integer.valueOf(2));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(R.l.eOe));
          }
        }
      });
    }
    GMTrace.o(1914750107648L, 14266);
  }
  
  private final class a
    extends BaseAdapter
  {
    String imagePath;
    
    private a()
    {
      GMTrace.i(1991522648064L, 14838);
      GMTrace.o(1991522648064L, 14838);
    }
    
    public final int getCount()
    {
      GMTrace.i(1991656865792L, 14839);
      GMTrace.o(1991656865792L, 14839);
      return 1;
    }
    
    public final Object getItem(int paramInt)
    {
      GMTrace.i(1991791083520L, 14840);
      GMTrace.o(1991791083520L, 14840);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(1991925301248L, 14841);
      long l = paramInt;
      GMTrace.o(1991925301248L, 14841);
      return l;
    }
    
    public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(1992059518976L, 14842);
      if (o.Pi(this.imagePath))
      {
        localObject = paramViewGroup.getContext();
        paramViewGroup = this.imagePath;
        new com.tencent.mm.plugin.gif.d(paramViewGroup);
        if ((paramView == null) || (!(paramView instanceof MMGIFImageView))) {}
        for (paramView = new MMGIFImageView((Context)localObject);; paramView = (MMGIFImageView)paramView)
        {
          paramView.cs(paramViewGroup, paramViewGroup);
          paramView.a(paramViewGroup, new com.tencent.mm.plugin.gif.e()
          {
            public final void invalidate()
            {
              GMTrace.i(1958236651520L, 14590);
              paramView.invalidate();
              GMTrace.o(1958236651520L, 14590);
            }
          });
          if ((paramView.getDrawable() != null) && ((paramView.getDrawable() instanceof com.tencent.mm.plugin.gif.a))) {
            ((com.tencent.mm.plugin.gif.a)paramView.getDrawable()).stop();
          }
          if ((paramView.getDrawable() != null) && ((paramView.getDrawable() instanceof com.tencent.mm.plugin.gif.a))) {
            ((com.tencent.mm.plugin.gif.a)paramView.getDrawable()).start();
          }
          GMTrace.o(1992059518976L, 14842);
          return paramView;
        }
      }
      Object localObject = j.mu(this.imagePath);
      if (localObject == null)
      {
        v.w("MicroMsg.ShowImageUI", "get image fail");
        if (paramView != null)
        {
          localObject = paramView;
          if (!(paramView instanceof MultiTouchImageView)) {}
        }
        else
        {
          localObject = View.inflate(paramViewGroup.getContext(), R.i.doq, null);
        }
        ((ImageView)((View)localObject).findViewById(R.h.bWO)).setImageResource(R.k.dws);
        ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
        GMTrace.o(1992059518976L, 14842);
        return (View)localObject;
      }
      paramViewGroup = paramViewGroup.getContext();
      if ((paramView == null) || (!(paramView instanceof MultiTouchImageView))) {
        paramView = new MultiTouchImageView(paramViewGroup, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      for (;;)
      {
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramView.setImageBitmap((Bitmap)localObject);
        paramView.vmw = true;
        GMTrace.o(1992059518976L, 14842);
        return paramView;
        paramView = (MultiTouchImageView)paramView;
        paramView.dZ(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/ShowImageUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */