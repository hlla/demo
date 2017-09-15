package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.widget.e;
import java.io.File;

public class ContactRemarkImagePreviewUI
  extends MMActivity
{
  private MMGestureGallery kjS;
  private String username;
  private View vUF;
  private String vUG;
  private boolean vUH;
  private boolean vUI;
  private a vUJ;
  
  public ContactRemarkImagePreviewUI()
  {
    GMTrace.i(1784290476032L, 13294);
    GMTrace.o(1784290476032L, 13294);
  }
  
  private void lt(boolean paramBoolean)
  {
    GMTrace.i(1785095782400L, 13300);
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("response_delete", true);
      setResult(-1, localIntent);
    }
    finish();
    GMTrace.o(1785095782400L, 13300);
  }
  
  protected final void KD()
  {
    GMTrace.i(1784961564672L, 13299);
    this.vUF = findViewById(R.h.bGm);
    this.kjS = ((MMGestureGallery)findViewById(R.h.bSk));
    zd(R.l.eBd);
    this.kjS.setVerticalFadingEdgeEnabled(false);
    this.kjS.setHorizontalFadingEdgeEnabled(false);
    com.tencent.mm.sdk.platformtools.k.bB(this.kjS);
    this.vUJ = new a();
    this.vUJ.imagePath = this.vUG;
    this.kjS.setAdapter(this.vUJ);
    this.kjS.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(1788182790144L, 13323);
        if (!ContactRemarkImagePreviewUI.this.bPN())
        {
          ContactRemarkImagePreviewUI.this.bPM();
          GMTrace.o(1788182790144L, 13323);
          return;
        }
        ContactRemarkImagePreviewUI.this.uRf.bPW();
        GMTrace.o(1788182790144L, 13323);
      }
    });
    a(0, R.k.dsI, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(1739461754880L, 12960);
        paramAnonymousMenuItem = new e(ContactRemarkImagePreviewUI.this, e.wsK, false);
        paramAnonymousMenuItem.qHD = new n.c()
        {
          public final void a(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            GMTrace.i(1745233117184L, 13003);
            if (!ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this)) {
              paramAnonymous2l.e(0, ContactRemarkImagePreviewUI.this.getString(R.l.dGt));
            }
            paramAnonymous2l.e(1, ContactRemarkImagePreviewUI.this.getString(R.l.eOe));
            if (d.Jr("favorite")) {
              paramAnonymous2l.e(2, ContactRemarkImagePreviewUI.this.getString(R.l.eFS));
            }
            GMTrace.o(1745233117184L, 13003);
          }
        };
        paramAnonymousMenuItem.qHE = new n.d()
        {
          public final void c(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            GMTrace.i(1740803932160L, 12970);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              GMTrace.o(1740803932160L, 12970);
              return;
              if (!ContactRemarkImagePreviewUI.b(ContactRemarkImagePreviewUI.this))
              {
                ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, true);
                GMTrace.o(1740803932160L, 12970);
                return;
              }
              new File(ContactRemarkImagePreviewUI.c(ContactRemarkImagePreviewUI.this)).delete();
              ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, true);
              GMTrace.o(1740803932160L, 12970);
              return;
              com.tencent.mm.pluginsdk.ui.tools.k.h(ContactRemarkImagePreviewUI.c(ContactRemarkImagePreviewUI.this), ContactRemarkImagePreviewUI.this);
              GMTrace.o(1740803932160L, 12970);
              return;
              ContactRemarkImagePreviewUI.d(ContactRemarkImagePreviewUI.this);
            }
          }
        };
        paramAnonymousMenuItem.byZ();
        GMTrace.o(1739461754880L, 12960);
        return true;
      }
    });
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(1707517935616L, 12722);
        ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, false);
        GMTrace.o(1707517935616L, 12722);
        return false;
      }
    });
    GMTrace.o(1784961564672L, 13299);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(1784827346944L, 13298);
    int i = R.i.cZw;
    GMTrace.o(1784827346944L, 13298);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1784424693760L, 13295);
    super.onCreate(paramBundle);
    this.username = getIntent().getStringExtra("Contact_User");
    this.vUG = getIntent().getStringExtra("remark_image_path");
    this.vUH = getIntent().getBooleanExtra("view_temp_remark_image", false);
    this.vUI = getIntent().getBooleanExtra("view_only", false);
    if (bf.mA(this.username))
    {
      finish();
      GMTrace.o(1784424693760L, 13295);
      return;
    }
    KD();
    GMTrace.o(1784424693760L, 13295);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(1784693129216L, 13297);
    super.onDestroy();
    GMTrace.o(1784693129216L, 13297);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(1785230000128L, 13301);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      lt(false);
      GMTrace.o(1785230000128L, 13301);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(1785230000128L, 13301);
    return bool;
  }
  
  protected void onPause()
  {
    GMTrace.i(1784558911488L, 13296);
    super.onPause();
    GMTrace.o(1784558911488L, 13296);
  }
  
  final class a
    extends BaseAdapter
  {
    String imagePath;
    
    a()
    {
      GMTrace.i(1820529262592L, 13564);
      GMTrace.o(1820529262592L, 13564);
    }
    
    public final int getCount()
    {
      GMTrace.i(1820663480320L, 13565);
      GMTrace.o(1820663480320L, 13565);
      return 1;
    }
    
    public final Object getItem(int paramInt)
    {
      GMTrace.i(1820797698048L, 13566);
      String str = this.imagePath;
      GMTrace.o(1820797698048L, 13566);
      return str;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(1820931915776L, 13567);
      long l = paramInt;
      GMTrace.o(1820931915776L, 13567);
      return l;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(1821066133504L, 13568);
      paramView = View.inflate(ContactRemarkImagePreviewUI.this, R.i.cZx, null);
      paramViewGroup = (MultiTouchImageView)paramView.findViewById(R.h.Kd);
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      Bitmap localBitmap = BackwardSupportUtil.b.c(this.imagePath, a.getDensity(ContactRemarkImagePreviewUI.this));
      int i;
      Matrix localMatrix;
      if (localBitmap != null)
      {
        paramInt = ContactRemarkImagePreviewUI.e(ContactRemarkImagePreviewUI.this).getWidth();
        i = ContactRemarkImagePreviewUI.e(ContactRemarkImagePreviewUI.this).getHeight();
        localMatrix = new Matrix();
        localMatrix.reset();
        f1 = localBitmap.getWidth() / localBitmap.getHeight();
        f2 = localBitmap.getHeight() / localBitmap.getWidth();
        v.v("MicroMsg.ImagePreviewUI", "whDiv is " + f1 + " hwDiv is " + f2);
        if ((f2 < 2.0F) || (localBitmap.getHeight() < 480)) {
          break label328;
        }
        f1 = localBitmap.getWidth() / paramInt;
        f2 = paramInt / localBitmap.getWidth();
        if (f1 <= 1.0D) {
          break label300;
        }
        localMatrix.postScale(f2, f2);
        localBitmap.getHeight();
        localMatrix.postTranslate((paramInt - f2 * localBitmap.getWidth()) / 2.0F, 0.0F);
      }
      for (;;)
      {
        paramViewGroup.setImageMatrix(localMatrix);
        paramViewGroup.dZ(localBitmap.getWidth(), localBitmap.getHeight());
        paramViewGroup.setImageBitmap(localBitmap);
        GMTrace.o(1821066133504L, 13568);
        return paramView;
        label300:
        localMatrix.postScale(1.0F, 1.0F);
        localMatrix.postTranslate((paramInt - localBitmap.getWidth()) / 2, 0.0F);
        continue;
        label328:
        if ((f1 < 2.0F) || (localBitmap.getWidth() < 480)) {
          break;
        }
        f1 = localBitmap.getHeight() / 480.0F;
        f2 = 480.0F / localBitmap.getHeight();
        if (f1 > 1.0D)
        {
          localMatrix.postScale(f1, f2);
          localMatrix.postTranslate(0.0F, (i - 480) / 2);
        }
        else
        {
          localMatrix.postScale(1.0F, 1.0F);
          f1 = (i - localBitmap.getHeight()) / 2;
          v.d("MicroMsg.ImagePreviewUI", " offsety " + f1);
          localMatrix.postTranslate(0.0F, f1);
        }
      }
      float f1 = paramInt / localBitmap.getWidth();
      float f2 = i / localBitmap.getHeight();
      label491:
      float f3;
      if (f1 < f2)
      {
        f2 = localBitmap.getWidth() / paramInt;
        f3 = localBitmap.getHeight() / i;
        if (f2 <= f3) {
          break label585;
        }
        label522:
        if (f2 <= 1.0D) {
          break label592;
        }
        localMatrix.postScale(f1, f1);
      }
      for (;;)
      {
        localMatrix.postTranslate((paramInt - localBitmap.getWidth() * f1) / 2.0F, (i - f1 * localBitmap.getHeight()) / 2.0F);
        break;
        f1 = f2;
        break label491;
        label585:
        f2 = f3;
        break label522;
        label592:
        f1 = 1.0F;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/ContactRemarkImagePreviewUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */