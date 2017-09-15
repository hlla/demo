package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;

public class SecurityImage
  extends LinearLayout
{
  private h oGr;
  public String uXf;
  public String uXg;
  public int uXi;
  EditText vdA;
  b vdB;
  ProgressBar vdx;
  ImageView vdy;
  Button vdz;
  
  public SecurityImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1849788727296L, 13782);
    this.uXf = null;
    this.uXg = null;
    this.uXi = 0;
    this.vdx = null;
    this.vdy = null;
    this.vdz = null;
    this.vdA = null;
    this.oGr = null;
    GMTrace.o(1849788727296L, 13782);
  }
  
  private void kC(boolean paramBoolean)
  {
    int j = 0;
    GMTrace.i(1850325598208L, 13786);
    Object localObject = this.vdy;
    if (paramBoolean)
    {
      i = 255;
      ((ImageView)localObject).setAlpha(i);
      localObject = this.vdy;
      if (!paramBoolean) {
        break label85;
      }
    }
    label85:
    for (int i = 0;; i = -5592406)
    {
      ((ImageView)localObject).setBackgroundColor(i);
      localObject = this.vdx;
      i = j;
      if (paramBoolean) {
        i = 4;
      }
      ((ProgressBar)localObject).setVisibility(i);
      GMTrace.o(1850325598208L, 13786);
      return;
      i = 40;
      break;
    }
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    GMTrace.i(1849922945024L, 13783);
    kC(true);
    this.uXf = paramString1;
    this.uXg = paramString2;
    this.uXi = paramInt;
    Bitmap localBitmap = d.bd(paramArrayOfByte);
    if (localBitmap != null)
    {
      v.i("MicroMsg.SecurityImage", "dkwt setSecImg sid:%s key:%s imgBuf:%d [%d %d]", new Object[] { paramString1, paramString2, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) });
      this.uXf = paramString1;
      this.uXg = paramString2;
      this.uXi = paramInt;
      if (localBitmap != null)
      {
        this.vdy.setImageBitmap(localBitmap);
        GMTrace.o(1849922945024L, 13783);
        return;
      }
      v.e("MicroMsg.SecurityImage", "setSecImg failed, decode failed");
      GMTrace.o(1849922945024L, 13783);
      return;
    }
    if (paramArrayOfByte == null) {}
    for (paramInt = -1;; paramInt = paramArrayOfByte.length)
    {
      v.e("MicroMsg.SecurityImage", "dkwt setSecImg ERROR sid:%s key:%s imgBuf:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
      GMTrace.o(1849922945024L, 13783);
      return;
    }
  }
  
  public final String bRp()
  {
    GMTrace.i(1850057162752L, 13784);
    if (this.vdA == null)
    {
      GMTrace.o(1850057162752L, 13784);
      return "";
    }
    String str = this.vdA.getText().toString().trim();
    GMTrace.o(1850057162752L, 13784);
    return str;
  }
  
  public final void dismiss()
  {
    GMTrace.i(1850191380480L, 13785);
    if (this.oGr != null)
    {
      this.oGr.dismiss();
      this.oGr = null;
    }
    GMTrace.o(1850191380480L, 13785);
  }
  
  public static final class a
  {
    public static SecurityImage a(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString1, String paramString2, final DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener, DialogInterface.OnDismissListener paramOnDismissListener, SecurityImage.b paramb)
    {
      GMTrace.i(1851936210944L, 13798);
      SecurityImage localSecurityImage = (SecurityImage)View.inflate(paramContext, a.h.heA, null);
      if (localSecurityImage.vdB != null) {
        localSecurityImage.vdB.vdE = null;
      }
      localSecurityImage.vdB = paramb;
      localSecurityImage.vdB.vdE = localSecurityImage;
      localSecurityImage.vdx = ((ProgressBar)localSecurityImage.findViewById(a.g.hcK));
      localSecurityImage.vdy = ((ImageView)localSecurityImage.findViewById(a.g.hbW));
      localSecurityImage.vdz = ((Button)localSecurityImage.findViewById(a.g.hbU));
      localSecurityImage.vdA = ((EditText)localSecurityImage.findViewById(a.g.hbV));
      localSecurityImage.vdz.setOnClickListener(new SecurityImage.1(localSecurityImage));
      localSecurityImage.a(paramInt2, paramArrayOfByte, paramString1, paramString2);
      paramContext = new h.a(paramContext);
      paramContext.zR(paramInt1);
      paramContext.zU(a.k.dGo).a(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(1846970155008L, 13761);
          paramOnClickListener.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
          GMTrace.o(1846970155008L, 13761);
        }
      });
      paramContext.d(paramOnCancelListener);
      paramContext.db(localSecurityImage);
      paramContext.kH(true);
      SecurityImage.a(localSecurityImage, paramContext.WD());
      SecurityImage.c(localSecurityImage).setOnDismissListener(paramOnDismissListener);
      SecurityImage.c(localSecurityImage).show();
      GMTrace.o(1851936210944L, 13798);
      return localSecurityImage;
    }
  }
  
  public static abstract class b
  {
    public SecurityImage vdE;
    
    public b()
    {
      GMTrace.i(1844956889088L, 13746);
      GMTrace.o(1844956889088L, 13746);
    }
    
    public abstract void bQy();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/applet/SecurityImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */