package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.a.e;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.s.a.a;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.d;
import com.tencent.mm.u.d.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class h
  extends a
  implements s.a, ai.a, d.a
{
  private d iWx;
  private HashMap<String, i.a> vPL;
  private boolean vPM;
  
  public h(b paramb)
  {
    super(paramb);
    GMTrace.i(2431085707264L, 18113);
    this.vPM = false;
    this.vPM = false;
    this.vPL = new HashMap();
    o.KW().a(this, Looper.getMainLooper());
    this.iWx = new d();
    GMTrace.o(2431085707264L, 18113);
  }
  
  private void a(r paramr, j paramj)
  {
    GMTrace.i(2431622578176L, 18117);
    if (paramr == null)
    {
      GMTrace.o(2431622578176L, 18117);
      return;
    }
    com.tencent.mm.modelvideo.t.lG(paramr.getFileName());
    paramj.bXm().vRh.setVisibility(0);
    paramj.bXm().vRh.setProgress(com.tencent.mm.modelvideo.t.f(paramr));
    o.KW().a(this, Looper.getMainLooper());
    GMTrace.o(2431622578176L, 18117);
  }
  
  private void a(au paramau, final j paramj)
  {
    GMTrace.i(2431756795904L, 18118);
    if (this.vPM)
    {
      GMTrace.o(2431756795904L, 18118);
      return;
    }
    paramj.bXm().vRi.setVisibility(8);
    o.KW();
    String str = s.lw(paramau.field_imgPath);
    if (paramau.bMj())
    {
      Toast.makeText(this.vNV.vNW, R.l.faa, 0).show();
      GMTrace.o(2431756795904L, 18118);
      return;
    }
    if ((str == null) || (!e.aO(str)))
    {
      Toast.makeText(this.vNV.vNW, R.l.faa, 0).show();
      GMTrace.o(2431756795904L, 18118);
      return;
    }
    this.vNV.vNW.uRf.uRz.getWindow().addFlags(128);
    Boolean localBoolean = (Boolean)paramj.vRc.get(str);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ((View)paramj.bXm().vRe).setTag(str);
      paramj.bXm().vRg.setVisibility(8);
      paramj.bXm().vRe.stop();
      if (this.vNV.vNW.eS(paramau.field_msgId) != 3) {
        break label377;
      }
      paramj.bXm().vRe.bQ(true);
      paramj.bXm().vRe.setVideoPath(str);
      if (paramj.bXm().vRe.i(this.vNV.vNW.uRf.uRz, false)) {
        break label393;
      }
      paramj.bXm().vRg.setVisibility(0);
      paramj.bXm().vRg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2465848098816L, 18372);
          paramj.bXm().vRe.i(h.this.vNV.vNW.uRf.uRz, true);
          GMTrace.o(2465848098816L, 18372);
        }
      });
      ((View)paramj.bXm().vRe).setVisibility(8);
      paramj.bXm().vRf.setVisibility(0);
    }
    for (;;)
    {
      v.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
      this.iWx.a(this);
      ((View)paramj.bXm().vRe).setVisibility(0);
      GMTrace.o(2431756795904L, 18118);
      return;
      label377:
      paramj.bXm().vRe.bQ(false);
      break;
      label393:
      ((View)paramj.bXm().vRe).setVisibility(0);
      paramj.bXm().vRf.setVisibility(8);
    }
  }
  
  private static void a(j paramj, boolean paramBoolean)
  {
    GMTrace.i(2431891013632L, 18119);
    if (paramj == null)
    {
      GMTrace.o(2431891013632L, 18119);
      return;
    }
    paramj.bXm().vRh.setVisibility(8);
    if (paramBoolean)
    {
      paramj.bXm().vRf.setVisibility(8);
      ((View)paramj.bXm().vRe).setVisibility(0);
      GMTrace.o(2431891013632L, 18119);
      return;
    }
    paramj.bXm().vRf.setVisibility(0);
    ((View)paramj.bXm().vRe).setVisibility(8);
    GMTrace.o(2431891013632L, 18119);
  }
  
  private boolean a(i.a parama)
  {
    GMTrace.i(2432159449088L, 18121);
    if (parama == null)
    {
      GMTrace.o(2432159449088L, 18121);
      return false;
    }
    o.KW().a(this);
    if (this.vNV.vNW.bWV() == parama.pos)
    {
      parama = Bf(parama.pos);
      if (parama != null) {
        parama.bXm().vRh.setVisibility(8);
      }
      GMTrace.o(2432159449088L, 18121);
      return true;
    }
    this.vNV.Bo(parama.pos);
    GMTrace.o(2432159449088L, 18121);
    return false;
  }
  
  public final void Bw(int paramInt)
  {
    GMTrace.i(2431488360448L, 18116);
    au localau = this.vNV.Bh(paramInt);
    j localj = Bf(paramInt);
    if ((localau == null) || (localj == null))
    {
      GMTrace.o(2431488360448L, 18116);
      return;
    }
    r localr = com.tencent.mm.modelvideo.t.lI(localau.field_imgPath);
    if (localr != null)
    {
      if (localau.field_isSend == 0)
      {
        if ((localr.status == 113) || (localr.status == 111) || (localr.status == 112))
        {
          a(localr, localj);
          GMTrace.o(2431488360448L, 18116);
          return;
        }
        if (localr.status == 198)
        {
          a(localr, localj);
          GMTrace.o(2431488360448L, 18116);
          return;
        }
      }
      a(localau, localj);
    }
    GMTrace.o(2431488360448L, 18116);
  }
  
  public final void a(s.a.a parama)
  {
    GMTrace.i(2432427884544L, 18123);
    Object localObject = parama.fyw;
    if ((u.mA((String)localObject)) || (this.vPL == null))
    {
      GMTrace.o(2432427884544L, 18123);
      return;
    }
    parama = (i.a)this.vPL.get(localObject);
    if (parama == null)
    {
      GMTrace.o(2432427884544L, 18123);
      return;
    }
    au localau = parama.fCQ;
    if ((localau == null) || (localau.field_imgPath == null) || (!localau.field_imgPath.equals(localObject)))
    {
      GMTrace.o(2432427884544L, 18123);
      return;
    }
    localObject = com.tencent.mm.modelvideo.t.lI(localau.field_imgPath);
    if (localObject == null)
    {
      GMTrace.o(2432427884544L, 18123);
      return;
    }
    if ((localau.bMj()) || (((r)localObject).status == 198))
    {
      if (a(parama)) {
        Toast.makeText(this.vNV.vNW, R.l.faa, 0).show();
      }
      GMTrace.o(2432427884544L, 18123);
      return;
    }
    int i = com.tencent.mm.modelvideo.t.f((r)localObject);
    localObject = Bf(parama.pos);
    if ((this.vNV.vNW.bWV() == parama.pos) && (localObject != null))
    {
      ((j)localObject).bXm().vRh.setVisibility(0);
      ((j)localObject).bXm().vRh.setProgress(i);
    }
    while (i < ((j)localObject).bXn().vRh.wtn)
    {
      GMTrace.o(2432427884544L, 18123);
      return;
      if (localObject == null)
      {
        GMTrace.o(2432427884544L, 18123);
        return;
      }
    }
    if (a(parama)) {
      a(localau, (j)localObject);
    }
    GMTrace.o(2432427884544L, 18123);
  }
  
  public final boolean a(j paramj, au paramau, int paramInt)
  {
    GMTrace.i(2431219924992L, 18114);
    super.a(paramj, paramau, paramInt);
    o.KW();
    Object localObject1 = BackwardSupportUtil.b.c(s.lx(paramau.field_imgPath), 1.0F);
    if (this.vPL != null) {
      this.vPL.put(paramau.field_imgPath, new i.a(paramau, paramInt));
    }
    a(paramj, false);
    ((View)paramj.bXm().vRe).setVisibility(8);
    paramj.bXm().vRf.setImageBitmap((Bitmap)localObject1);
    paramj.bXm().vRf.setVisibility(0);
    paramj.bXm().vRi.setVisibility(8);
    localObject1 = com.tencent.mm.modelvideo.t.lI(paramau.field_imgPath);
    paramj.vRi.setTag(localObject1);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label208;
      }
      paramj.lJf.setVisibility(8);
    }
    for (;;)
    {
      if ((paramj.bXm().vRe instanceof VideoSightView)) {
        m.a(paramj.lJf, (VideoSightView)paramj.bXm().vRe);
      }
      GMTrace.o(2431219924992L, 18114);
      return true;
      localObject2 = ((r)localObject1).iae;
      break;
      label208:
      if (u.mA(((bdq)localObject2).hjt))
      {
        v.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
        localObject1 = ((bdq)localObject2).hjw;
        localObject2 = ((bdq)localObject2).hjx;
        if ((!bf.mA((String)localObject1)) && (!bf.mA((String)localObject2)))
        {
          paramj.lJf.setText((CharSequence)localObject1);
          paramj.lJf.setVisibility(0);
          paramj.lJf.setTag(paramau);
        }
        else
        {
          paramj.lJf.setVisibility(8);
        }
      }
      else
      {
        paramj.lJf.setVisibility(0);
        paramj.lJf.setText(this.vNV.vNW.getString(R.l.eWC, new Object[] { Integer.valueOf(((bdq)localObject2).txr) }));
        Object localObject3 = this.vNV.vNW.getString(R.l.eWC);
        localObject1 = localObject3;
        if (((bdq)localObject2).txr / 60 > 0) {
          localObject1 = (String)localObject3 + this.vNV.vNW.getString(R.l.eWE, new Object[] { Integer.valueOf(((bdq)localObject2).txr / 60) });
        }
        localObject3 = localObject1;
        if (((bdq)localObject2).txr % 60 > 0) {
          localObject3 = (String)localObject1 + this.vNV.vNW.getString(R.l.eWF, new Object[] { Integer.valueOf(((bdq)localObject2).txr % 60) });
        }
        localObject1 = (String)localObject3 + this.vNV.vNW.getString(R.l.eWD);
        paramj.lJf.setText((CharSequence)localObject1);
        paramj.lJf.setTag(paramau);
      }
    }
  }
  
  public final void bWI()
  {
    GMTrace.i(2431354142720L, 18115);
    SparseArray localSparseArray = this.vNV.vlX;
    int i = 0;
    while (i < localSparseArray.size())
    {
      int j = localSparseArray.keyAt(i);
      if ((localSparseArray.get(j) != null) && (((View)localSparseArray.get(j)).getTag() != null))
      {
        j localj = (j)((View)localSparseArray.get(j)).getTag();
        if ((localj.vRd != null) && (localj.bXm().vRd.getVisibility() == 0))
        {
          localj.bXm().vRe.a(null);
          if ((((View)localj.bXm().vRe).getVisibility() == 0) && (localj != null))
          {
            a(localj, false);
            if (localj.bXm().vRe != null) {
              localj.bXm().vRe.stop();
            }
            v.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
            this.iWx.aS(false);
            this.vNV.vNW.uRf.uRz.getWindow().clearFlags(128);
          }
        }
      }
      i += 1;
    }
    GMTrace.o(2431354142720L, 18115);
  }
  
  public final void detach()
  {
    GMTrace.i(2432293666816L, 18122);
    bWI();
    this.vNV.vNW.uRf.uRz.getWindow().clearFlags(128);
    this.vPM = true;
    super.detach();
    this.vPL.clear();
    this.vPL = null;
    o.KW().a(this);
    v.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
    this.iWx.aS(true);
    GMTrace.o(2432293666816L, 18122);
  }
  
  public final boolean oQ()
  {
    GMTrace.i(2432025231360L, 18120);
    if (this.vNV == null)
    {
      GMTrace.o(2432025231360L, 18120);
      return false;
    }
    j localj = this.vNV.bWB();
    if (localj == null)
    {
      GMTrace.o(2432025231360L, 18120);
      return false;
    }
    if (localj.vRd == null)
    {
      GMTrace.o(2432025231360L, 18120);
      return false;
    }
    if (localj.bXm().vRd.getVisibility() != 0)
    {
      GMTrace.o(2432025231360L, 18120);
      return false;
    }
    a(localj, true);
    GMTrace.o(2432025231360L, 18120);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */