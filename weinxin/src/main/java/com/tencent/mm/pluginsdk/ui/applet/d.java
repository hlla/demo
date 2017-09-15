package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.bi.g;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.PasterEditText;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.h.a.a;
import com.tencent.mm.ui.base.h.a.b;
import com.tencent.mm.ui.base.h.a.c;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.r;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class d
  implements k
{
  public static View O(Context paramContext, int paramInt)
  {
    GMTrace.i(956301312000L, 7125);
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    GMTrace.o(956301312000L, 7125);
    return paramContext;
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, int paramInt, String paramString, boolean paramBoolean, k.a parama)
  {
    GMTrace.i(17953500168192L, 133764);
    paraml = a(paraml, paramInt, paramString, paramBoolean, "", parama);
    GMTrace.o(17953500168192L, 133764);
    return paraml;
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, int paramInt, String paramString1, boolean paramBoolean, String paramString2, k.a parama)
  {
    GMTrace.i(17953634385920L, 133765);
    h.a locala = new h.a(paraml.uRz);
    Object localObject = paraml.uRz.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bf.f(((String)localObject).split(","));
      a(paraml.uRz, locala, localObject);
    }
    locala.kG(true);
    if (paramInt == R.k.dsU) {
      localObject = paraml.uRz.getResources().getString(R.l.dHf);
    }
    for (;;)
    {
      locala.N((String)localObject + paramString1).kH(false).kI(false);
      if (paramBoolean) {
        locala.SX(paraml.uRz.getString(R.l.dXb));
      }
      paramString1 = locala.WD();
      a(paraml.uRz, paramString1, paramString2, null, parama, parama);
      paramString1.show();
      GMTrace.o(17953634385920L, 133765);
      return paramString1;
      if (paramInt == R.k.dsW) {
        localObject = paraml.uRz.getResources().getString(R.l.dHA);
      } else if (paramInt == R.k.dth) {
        localObject = paraml.uRz.getResources().getString(R.l.dIP);
      } else {
        localObject = paraml.uRz.getResources().getString(R.l.dDe);
      }
    }
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, String paramString1, View paramView, String paramString2, k.b paramb)
  {
    GMTrace.i(17954439692288L, 133771);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      v.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      GMTrace.o(17954439692288L, 133771);
      return null;
    }
    h.a locala = new h.a(paraml.uRz);
    locala.kH(false);
    locala.kI(false);
    a(locala, paraml.uRz, paramString1);
    if (!bf.mA(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramString1 = paraml.uRz.getResources().getString(R.l.dXe);
    }
    locala.SY(paramString1).a(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(942074232832L, 7019);
        if (this.sKD != null) {
          this.sKD.fe(true);
        }
        GMTrace.o(942074232832L, 7019);
      }
    });
    locala.zV(R.l.dGk).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(966367641600L, 7200);
        if (this.sKD != null) {
          this.sKD.fe(false);
        }
        GMTrace.o(966367641600L, 7200);
      }
    });
    locala.db(paramView);
    paramString1 = locala.WD();
    paramString1.zP(paraml.uRz.getResources().getColor(R.e.aWt));
    paramString1.show();
    GMTrace.o(17954439692288L, 133771);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, String paramString1, String paramString2, String paramString3, k.a parama)
  {
    GMTrace.i(17953365950464L, 133763);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      v.e("MicroMsg.MMConfirmDialog", "showDialogItem4 fail, title message both are empty");
      GMTrace.o(17953365950464L, 133763);
      return null;
    }
    View localView = O(paraml.uRz, R.i.cZe);
    h.a locala = new h.a(paraml.uRz);
    locala.kH(false);
    locala.kI(false);
    if (localView != null)
    {
      EditText localEditText = (EditText)localView.findViewById(R.h.bEw);
      if (localEditText != null)
      {
        localEditText.setVisibility(0);
        localEditText.setHint(bf.mz(paramString2));
      }
    }
    a(paraml, locala, parama, localView, paramString3);
    if (!bf.mA(null)) {
      a(locala, paraml.uRz, null);
    }
    ((TextView)localView.findViewById(R.h.bEy)).setVisibility(8);
    paramString2 = (TextView)localView.findViewById(R.h.bEv);
    paramString2.setText(com.tencent.mm.pluginsdk.ui.d.h.b(paraml.uRz, paramString1, paramString2.getTextSize()));
    ((TextView)localView.findViewById(R.h.bEs)).setVisibility(8);
    int i = BackwardSupportUtil.b.a(paraml.uRz, 120.0F);
    paraml = (CdnImageView)localView.findViewById(R.h.bEx);
    if (paraml != null)
    {
      if (bf.mA(null)) {
        break label273;
      }
      a.b.a(paraml, null);
    }
    for (;;)
    {
      locala.db(localView);
      paraml = locala.WD();
      paraml.show();
      GMTrace.o(17953365950464L, 133763);
      return paraml;
      label273:
      if (!bf.mA(null)) {
        paraml.L(null, i, i);
      } else {
        paraml.setVisibility(8);
      }
    }
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, String paramString1, String paramString2, String paramString3, k.a parama1, k.a parama2)
  {
    GMTrace.i(17954037039104L, 133768);
    h.a locala = new h.a(paraml.uRz);
    locala.a(com.tencent.mm.compatible.f.a.decodeResource(paraml.uRz.getResources(), R.k.dwp), false, 3);
    locala.kH(false);
    locala.kI(false);
    locala.bRC();
    locala.vgH.vdR = paramString1;
    locala.zT(17);
    paramString1 = locala.WD();
    a(paraml.uRz, paramString1, paramString3, paramString2, parama2, parama1);
    paramString1.zQ(paraml.uRz.getResources().getColor(R.e.aUd));
    paramString1.show();
    GMTrace.o(17954037039104L, 133768);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, k.a parama)
  {
    GMTrace.i(17952426426368L, 133756);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      v.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      GMTrace.o(17952426426368L, 133756);
      return null;
    }
    View localView = View.inflate(paraml.uRz, R.i.cZd, null);
    h.a locala = new h.a(paraml.uRz);
    locala.kH(false);
    locala.kI(false);
    a(locala, paraml.uRz, paramString1);
    if (localView != null)
    {
      paramString1 = (EditText)localView.findViewById(R.h.bEw);
      if (paramString1 != null) {
        paramString1.setVisibility(0);
      }
      paramString1.setText(paramString4);
    }
    a(paraml, locala, parama, localView, paramString5);
    paramString1 = (TextView)localView.findViewById(R.h.bEv);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.d.h.b(paraml.uRz, paramString3, paramString1.getTextSize()));
    localView.findViewById(R.h.bEs).setVisibility(8);
    int i = BackwardSupportUtil.b.a(paraml.uRz, 120.0F);
    paraml = (CdnImageView)localView.findViewById(R.h.bEx);
    if (paraml != null) {
      paraml.L(paramString2, i, i);
    }
    locala.db(localView);
    paraml = locala.WD();
    paraml.show();
    GMTrace.o(17952426426368L, 133756);
    return paraml;
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, k.a parama)
  {
    GMTrace.i(17952023773184L, 133753);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      v.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      GMTrace.o(17952023773184L, 133753);
      return null;
    }
    paramString4 = View.inflate(paraml.uRz, R.i.cZd, null);
    h.a locala = new h.a(paraml.uRz);
    locala.kH(false);
    locala.kI(false);
    a(locala, paraml.uRz, paramString1);
    l(paramString4, paramBoolean);
    a(paraml, locala, parama, paramString4, paramString5);
    paramString1 = (TextView)paramString4.findViewById(R.h.bEv);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.d.h.b(paraml.uRz, paramString3, paramString1.getTextSize()));
    paramString4.findViewById(R.h.bEs).setVisibility(8);
    int i = BackwardSupportUtil.b.a(paraml.uRz, 120.0F);
    paraml = (CdnImageView)paramString4.findViewById(R.h.bEx);
    if (paraml != null) {
      paraml.L(paramString2, i, i);
    }
    locala.db(paramString4);
    paraml = locala.WD();
    paraml.show();
    GMTrace.o(17952023773184L, 133753);
    return paraml;
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, String paramString1, String paramString2, boolean paramBoolean, String paramString3, k.a parama)
  {
    GMTrace.i(17952157990912L, 133754);
    paraml = a(paraml, paramString1, paramString2, paramBoolean, paramString3, parama, paraml.uRz.getResources().getString(R.l.dIM));
    GMTrace.o(17952157990912L, 133754);
    return paraml;
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, String paramString1, String paramString2, boolean paramBoolean, String paramString3, k.a parama, String paramString4)
  {
    GMTrace.i(17952292208640L, 133755);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      v.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      GMTrace.o(17952292208640L, 133755);
      return null;
    }
    paramString2 = new h.a(paraml.uRz);
    Object localObject = paraml.uRz.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bf.f(((String)localObject).split(","));
      a(paraml.uRz, paramString2, localObject);
    }
    paramString2.kG(true);
    paramString2.N(paramString4 + paramString1).kH(false).kI(false);
    if (paramBoolean) {
      paramString2.SX(paraml.uRz.getString(R.l.dXb));
    }
    paramString1 = paramString2.WD();
    a(paraml.uRz, paramString1, paramString3, null, parama, parama);
    paramString1.show();
    GMTrace.o(17952292208640L, 133755);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, String paramString, boolean paramBoolean, int paramInt, k.a parama)
  {
    GMTrace.i(17953768603648L, 133766);
    paraml = a(paraml, paramString, paramBoolean, paramInt, "", parama);
    GMTrace.o(17953768603648L, 133766);
    return paraml;
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, String paramString1, boolean paramBoolean, int paramInt, String paramString2, k.a parama)
  {
    GMTrace.i(17953902821376L, 133767);
    h.a locala = new h.a(paraml.uRz);
    Object localObject = paraml.uRz.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null) {}
    for (localObject = bf.f(((String)localObject).split(","));; localObject = null)
    {
      a(paraml.uRz, locala, localObject);
      locala.kG(true);
      switch (paramInt)
      {
      default: 
        localObject = paraml.uRz.getResources().getString(R.l.dDe);
      }
      for (;;)
      {
        locala.N((String)localObject + paramString1).kH(false).kI(false);
        if (paramBoolean) {
          locala.SX(paraml.uRz.getString(R.l.dXb));
        }
        paramString1 = locala.WD();
        a(paraml.uRz, paramString1, paramString2, null, parama, parama);
        paramString1.show();
        GMTrace.o(17953902821376L, 133767);
        return paramString1;
        localObject = paraml.uRz.getResources().getString(R.l.dIP);
        continue;
        localObject = paraml.uRz.getResources().getString(R.l.dHA);
      }
    }
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, String paramString, boolean paramBoolean, k.a parama)
  {
    GMTrace.i(17952560644096L, 133757);
    paraml = a(paraml, paramString, paramBoolean, "", parama);
    GMTrace.o(17952560644096L, 133757);
    return paraml;
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, String paramString1, boolean paramBoolean, String paramString2, k.a parama)
  {
    GMTrace.i(17952694861824L, 133758);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      v.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
      GMTrace.o(17952694861824L, 133758);
      return null;
    }
    h.a locala = new h.a(paraml.uRz);
    Object localObject = paraml.uRz.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bf.f(((String)localObject).split(","));
      a(paraml.uRz, locala, localObject);
    }
    locala.kG(true);
    locala.N(paramString1).kH(false).kI(false);
    if (paramBoolean) {
      locala.SX(paraml.uRz.getString(R.l.dXb));
    }
    paramString1 = locala.WD();
    a(paraml.uRz, paramString1, paramString2, null, parama, parama);
    paramString1.show();
    GMTrace.o(17952694861824L, 133758);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, byte[] paramArrayOfByte, boolean paramBoolean, k.a parama)
  {
    GMTrace.i(17953097515008L, 133761);
    paraml = a(paraml, paramArrayOfByte, paramBoolean, "", parama);
    GMTrace.o(17953097515008L, 133761);
    return paraml;
  }
  
  public static com.tencent.mm.ui.base.h a(l paraml, byte[] paramArrayOfByte, boolean paramBoolean, String paramString, k.a parama)
  {
    GMTrace.i(17953231732736L, 133762);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      v.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
      GMTrace.o(17953231732736L, 133762);
      return null;
    }
    h.a locala = new h.a(paraml.uRz);
    Object localObject = paraml.uRz.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bf.f(((String)localObject).split(","));
      a(paraml.uRz, locala, localObject);
    }
    locala.kG(true);
    locala.kH(false).kI(false);
    if (paramBoolean) {
      locala.SX(paraml.uRz.getString(R.l.dXb));
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      if (paramArrayOfByte != null)
      {
        locala.a(paramArrayOfByte, true, 3);
        a(locala, paramArrayOfByte);
        locala.kG(false);
      }
    }
    paramArrayOfByte = locala.WD();
    a(paraml.uRz, paramArrayOfByte, paramString, null, parama, parama);
    paramArrayOfByte.show();
    GMTrace.o(17953231732736L, 133762);
    return paramArrayOfByte;
  }
  
  public static com.tencent.mm.ui.base.o a(l paraml, long paramLong, String paramString1, String paramString2, String paramString3, k.a parama)
  {
    GMTrace.i(17954305474560L, 133770);
    final View localView = O(paraml.uRz, R.i.cZh);
    final com.tencent.mm.ui.base.o localo = cL(localView);
    a(localView, parama, localo);
    if (bf.mA(paramString1))
    {
      v.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      GMTrace.o(17954305474560L, 133770);
      return null;
    }
    a(localView, R.h.bEy, paramString1, false, 0);
    NoMeasuredTextView localNoMeasuredTextView = (NoMeasuredTextView)localView.findViewById(R.h.bEv);
    localNoMeasuredTextView.vng = true;
    localNoMeasuredTextView.H(paraml.uRz.getResources().getDimension(R.f.aWD) * com.tencent.mm.bg.a.dI(paraml.uRz));
    localNoMeasuredTextView.setTextColor(com.tencent.mm.bg.a.S(paraml.uRz, R.e.aVo));
    Object localObject = w.DJ().aa(paramLong);
    String str1;
    if (((com.tencent.mm.modelbiz.a.c)localObject).DV())
    {
      paramString1 = ((com.tencent.mm.modelbiz.a.c)localObject).field_chatName;
      str1 = ((com.tencent.mm.modelbiz.a.c)localObject).field_headImageUrl;
      localObject = ((com.tencent.mm.modelbiz.a.c)localObject).field_brandUserName;
      String str2 = paramString1;
      if (paramString1 == null) {
        str2 = paramString2;
      }
      if (bf.mA(str2)) {
        break label412;
      }
      localNoMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(paraml.uRz, str2, localNoMeasuredTextView.gm.getTextSize()));
    }
    for (;;)
    {
      a(localView, R.h.bEt, null, true, 8);
      paramString1 = (Button)localView.findViewById(R.h.bEo);
      if (!bf.mA(paramString3)) {
        paramString1.setText(paramString3);
      }
      paramString1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(945698111488L, 7046);
          if (this.sKE != null) {
            this.sKE.a(true, d.cM(localView), d.cN(localView));
          }
          localo.dismiss();
          localo.setFocusable(false);
          localo.setTouchable(false);
          GMTrace.o(945698111488L, 7046);
        }
      });
      paramString1 = new c.a();
      paramString1.hIw = com.tencent.mm.modelbiz.a.e.iA((String)localObject);
      paramString1.hIt = true;
      paramString1.hIP = true;
      paramString1.hII = R.k.ber;
      paramString1 = paramString1.Hh();
      if (!bf.mA(str1)) {
        com.tencent.mm.ah.n.GX().a(str1, (ImageView)localView.findViewById(R.h.bEx), paramString1);
      }
      a(paraml, localo);
      GMTrace.o(17954305474560L, 133770);
      return localo;
      localObject = w.DL().iE(((com.tencent.mm.modelbiz.a.c)localObject).field_bizChatServId);
      if (localObject != null)
      {
        paramString1 = ((com.tencent.mm.modelbiz.a.j)localObject).field_userName;
        str1 = ((com.tencent.mm.modelbiz.a.j)localObject).field_headImageUrl;
        localObject = ((com.tencent.mm.modelbiz.a.j)localObject).field_brandUserName;
        break;
      }
      v.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
      GMTrace.o(17954305474560L, 133770);
      return null;
      label412:
      localNoMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(paraml.uRz, paramString2, localNoMeasuredTextView.gm.getTextSize()));
    }
  }
  
  public static void a(Context paramContext, h.a parama, final Object paramObject)
  {
    GMTrace.i(953482739712L, 7104);
    if (paramObject != null) {
      if ((paramObject instanceof String)) {
        paramObject = bf.f(((String)paramObject).split(","));
      }
    }
    for (;;)
    {
      if (bf.bV((List)paramObject))
      {
        GMTrace.o(953482739712L, 7104);
        return;
        if ((paramObject instanceof List)) {
          paramObject = (List)paramObject;
        }
      }
      else
      {
        if (((List)paramObject).size() == 1)
        {
          paramObject = (String)((List)paramObject).get(0);
          int i = com.tencent.mm.bg.a.fromDPToPix(paramContext, (int)(20.0F * com.tencent.mm.bg.a.dI(paramContext)));
          Object localObject1 = paramContext.getString(R.l.eLB);
          parama.M(g.bKx().b(paramContext, ((String)localObject1).toString(), i));
          localObject1 = com.tencent.mm.u.n.eK((String)paramObject);
          i = com.tencent.mm.bg.a.fromDPToPix(paramContext, (int)(14.0F * com.tencent.mm.bg.a.dI(paramContext)));
          if (com.tencent.mm.u.o.dH((String)paramObject))
          {
            Object localObject2 = paramContext.getString(R.l.eQg, new Object[] { Integer.valueOf(com.tencent.mm.u.j.eC((String)paramObject)) });
            localObject1 = (String)localObject1 + (String)localObject2;
            localObject1 = g.bKx().b(paramContext, ((String)localObject1).toString(), i);
            localObject2 = r.eC(paramContext).inflate(R.i.cZY, null);
            GridView localGridView = (GridView)((View)localObject2).findViewById(R.h.byW);
            final ArrayList localArrayList = new ArrayList();
            final List localList = com.tencent.mm.u.j.eA((String)paramObject);
            parama.a((String)paramObject, (CharSequence)localObject1, Boolean.valueOf(true), new h.a.b()
            {
              public final void bEL()
              {
                GMTrace.i(957911924736L, 7137);
                bf.cV(this.sKA);
                if ((localArrayList.size() == 0) && (!bf.mA(paramObject)))
                {
                  ArrayList localArrayList = localArrayList;
                  Object localObject = localList;
                  if (!bf.bV((List)localObject))
                  {
                    localObject = ((List)localObject).iterator();
                    while (((Iterator)localObject).hasNext()) {
                      localArrayList.add(com.tencent.mm.u.n.eK((String)((Iterator)localObject).next()));
                    }
                  }
                }
                GMTrace.o(957911924736L, 7137);
              }
            });
            localGridView.setAdapter(new h(paramContext, localList, localArrayList));
            localGridView.setSelector(new ColorDrawable(paramContext.getResources().getColor(R.e.transparent)));
            if (localList != null)
            {
              if (localList.size() <= 16) {
                break label397;
              }
              localGridView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.mm.bg.a.T(paramContext, R.f.aWV)));
              localGridView.setPadding(com.tencent.mm.bg.a.T(paramContext, R.f.aWU), 0, com.tencent.mm.bg.a.T(paramContext, R.f.aWU), 0);
            }
            for (;;)
            {
              parama.vgH.veq = ((View)localObject2);
              GMTrace.o(953482739712L, 7104);
              return;
              label397:
              localGridView.setPadding(0, 0, 0, com.tencent.mm.bg.a.T(paramContext, R.f.aWT));
            }
          }
          parama.a((String)paramObject, g.bKx().b(paramContext, ((String)localObject1).toString(), i), Boolean.valueOf(false), null);
          GMTrace.o(953482739712L, 7104);
          return;
        }
        parama.vgH.vdW = ((List)paramObject);
        parama.SV(paramContext.getString(R.l.eBt));
        GMTrace.o(953482739712L, 7104);
        return;
      }
      paramObject = null;
    }
  }
  
  public static void a(Context paramContext, final com.tencent.mm.ui.base.h paramh, String paramString1, String paramString2, k.a parama1, k.a parama2)
  {
    GMTrace.i(17951889555456L, 133752);
    String str;
    if (!bf.mA(paramString1))
    {
      str = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      str = paramContext.getResources().getString(R.l.dXe);
    }
    if (!bf.mA(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramString1 = paramContext.getResources().getString(R.l.dGk);
    }
    paramh.a(str, true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(941805797376L, 7017);
        if (this.sKG != null) {
          this.sKG.a(true, paramh.bRA(), paramh.bRB());
        }
        GMTrace.o(941805797376L, 7017);
      }
    });
    paramh.b(paramString1, true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(947040288768L, 7056);
        if (this.sKI != null) {
          this.sKI.a(false, null, 0);
        }
        GMTrace.o(947040288768L, 7056);
      }
    });
    GMTrace.o(17951889555456L, 133752);
  }
  
  private static void a(View paramView, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    GMTrace.i(957106618368L, 7131);
    paramView = (TextView)paramView.findViewById(paramInt1);
    if (paramView != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((!paramBoolean) || (!bf.mA(paramString))) {
        break;
      }
      paramView.setVisibility(paramInt2);
      GMTrace.o(957106618368L, 7131);
      return;
    }
    paramView.setText(paramString);
    GMTrace.o(957106618368L, 7131);
  }
  
  static void a(final View paramView, k.a parama, final com.tencent.mm.ui.base.o paramo)
  {
    GMTrace.i(17954708127744L, 133773);
    ((Button)paramView.findViewById(R.h.bEo)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(967307165696L, 7207);
        if (this.sKE != null) {
          this.sKE.a(true, d.cM(paramView), d.cN(paramView));
        }
        paramo.dismiss();
        paramo.setFocusable(false);
        paramo.setTouchable(false);
        GMTrace.o(967307165696L, 7207);
      }
    });
    paramView = (Button)paramView.findViewById(R.h.bEp);
    if (paramView != null) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(947711377408L, 7061);
          if (this.sKE != null) {
            this.sKE.a(false, null, 0);
          }
          paramo.dismiss();
          paramo.setFocusable(false);
          paramo.setTouchable(false);
          GMTrace.o(947711377408L, 7061);
        }
      });
    }
    GMTrace.o(17954708127744L, 133773);
  }
  
  private static void a(h.a parama, Context paramContext, String paramString)
  {
    GMTrace.i(956703965184L, 7128);
    parama.SV(paramString);
    int i = paramContext.getResources().getColor(R.e.aVo);
    parama.vgH.sFy = i;
    parama.vgH.ves = 2;
    GMTrace.o(956703965184L, 7128);
  }
  
  public static void a(h.a parama, Bitmap paramBitmap)
  {
    GMTrace.i(957375053824L, 7133);
    parama.a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(942611103744L, 7023);
        if ((this.ogn == null) || (this.ogn.isRecycled()))
        {
          GMTrace.o(942611103744L, 7023);
          return;
        }
        GMTrace.o(942611103744L, 7023);
      }
    });
    GMTrace.o(957375053824L, 7133);
  }
  
  public static void a(l paraml, h.a parama, k.a parama1, final View paramView, String paramString)
  {
    GMTrace.i(17954573910016L, 133772);
    String str;
    if (!bf.mA(paramString))
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = paraml.uRz.getResources().getString(R.l.dXe);
    }
    parama.SY(str).a(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(958448795648L, 7141);
        if (this.sKE != null) {
          this.sKE.a(true, d.cM(paramView), d.cN(paramView));
        }
        GMTrace.o(958448795648L, 7141);
      }
    });
    parama.zV(R.l.dGk).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(965830770688L, 7196);
        if (this.sKE != null) {
          this.sKE.a(false, null, 0);
        }
        GMTrace.o(965830770688L, 7196);
      }
    });
    GMTrace.o(17954573910016L, 133772);
  }
  
  static void a(l paraml, com.tencent.mm.ui.base.o paramo)
  {
    GMTrace.i(957240836096L, 7132);
    try
    {
      if (!paraml.uRz.isFinishing())
      {
        paramo.setInputMethodMode(1);
        paramo.setSoftInputMode(16);
        paramo.setFocusable(true);
        paramo.setTouchable(true);
        paramo.showAtLocation(paraml.uRz.getWindow().getDecorView(), 17, 0, 0);
      }
      GMTrace.o(957240836096L, 7132);
      return;
    }
    catch (Exception paraml)
    {
      v.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", new Object[] { paraml.getMessage() });
      v.printErrStackTrace("MicroMsg.MMConfirmDialog", paraml, "", new Object[0]);
      GMTrace.o(957240836096L, 7132);
    }
  }
  
  public static com.tencent.mm.ui.base.h b(l paraml, String paramString, boolean paramBoolean, k.a parama)
  {
    GMTrace.i(17952829079552L, 133759);
    paraml = b(paraml, paramString, paramBoolean, "", parama);
    GMTrace.o(17952829079552L, 133759);
    return paraml;
  }
  
  public static com.tencent.mm.ui.base.h b(l paraml, String paramString1, boolean paramBoolean, String paramString2, k.a parama)
  {
    GMTrace.i(17952963297280L, 133760);
    if ((paramString1 == null) || (!com.tencent.mm.a.e.aO(paramString1)))
    {
      v.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
      GMTrace.o(17952963297280L, 133760);
      return null;
    }
    h.a locala = new h.a(paraml.uRz);
    Object localObject = paraml.uRz.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bf.f(((String)localObject).split(","));
      a(paraml.uRz, locala, localObject);
    }
    locala.kG(true);
    locala.kH(false).kI(false);
    if (paramBoolean) {
      locala.SX(paraml.uRz.getString(R.l.dXb));
    }
    if (!bf.mA(paramString1))
    {
      paramString1 = com.tencent.mm.sdk.platformtools.d.Pf(paramString1);
      if (paramString1 != null)
      {
        locala.a(paramString1, true, 3);
        a(locala, paramString1);
        locala.kG(false);
      }
    }
    paramString1 = locala.WD();
    a(paraml.uRz, paramString1, paramString2, null, parama, parama);
    paramString1.show();
    GMTrace.o(17952963297280L, 133760);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.base.o b(l paraml, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, k.a parama)
  {
    GMTrace.i(17954171256832L, 133769);
    final View localView = O(paraml.uRz, R.i.cZh);
    final com.tencent.mm.ui.base.o localo = cL(localView);
    a(localView, parama, localo);
    if (bf.mA(paramString2))
    {
      v.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      GMTrace.o(17954171256832L, 133769);
      return null;
    }
    a(localView, R.h.bEy, paramString2, false, 0);
    paramString2 = (NoMeasuredTextView)localView.findViewById(R.h.bEv);
    paramString2.vng = true;
    paramString2.H(paraml.uRz.getResources().getDimension(R.f.aWD) * com.tencent.mm.bg.a.dI(paraml.uRz));
    paramString2.setTextColor(com.tencent.mm.bg.a.S(paraml.uRz, R.e.aVo));
    if (!bf.mA(paramString1)) {
      paramString2.setText(com.tencent.mm.pluginsdk.ui.d.h.b(paraml.uRz, com.tencent.mm.u.n.eK(paramString1), paramString2.gm.getTextSize()));
    }
    for (;;)
    {
      a(localView, R.h.bEt, paramString4, true, 8);
      paramString2 = (Button)localView.findViewById(R.h.bEo);
      if (!bf.mA(paramString5)) {
        paramString2.setText(paramString5);
      }
      paramString2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(961804238848L, 7166);
          if (this.sKE != null) {
            this.sKE.a(true, d.cM(localView), d.cN(localView));
          }
          localo.dismiss();
          localo.setFocusable(false);
          localo.setTouchable(false);
          GMTrace.o(961804238848L, 7166);
        }
      });
      if (!bf.mA(paramString1)) {
        a.b.a((ImageView)localView.findViewById(R.h.bEx), paramString1);
      }
      a(paraml, localo);
      GMTrace.o(17954171256832L, 133769);
      return localo;
      paramString2.setText(com.tencent.mm.pluginsdk.ui.d.h.b(paraml.uRz, paramString3, paramString2.gm.getTextSize()));
    }
  }
  
  static com.tencent.mm.ui.base.o cL(View paramView)
  {
    GMTrace.i(956435529728L, 7126);
    paramView = new com.tencent.mm.ui.base.o(paramView, -1, -1);
    GMTrace.o(956435529728L, 7126);
    return paramView;
  }
  
  public static String cM(View paramView)
  {
    GMTrace.i(16011772297216L, 119297);
    paramView = (EditText)paramView.findViewById(R.h.bEw);
    if (paramView == null)
    {
      GMTrace.o(16011772297216L, 119297);
      return null;
    }
    paramView = paramView.getText().toString();
    GMTrace.o(16011772297216L, 119297);
    return paramView;
  }
  
  public static int cN(View paramView)
  {
    GMTrace.i(16011906514944L, 119298);
    paramView = (EditText)paramView.findViewById(R.h.bEw);
    if ((paramView instanceof PasterEditText))
    {
      int i = ((PasterEditText)paramView).bkb();
      GMTrace.o(16011906514944L, 119298);
      return i;
    }
    GMTrace.o(16011906514944L, 119298);
    return 0;
  }
  
  public static void l(View paramView, boolean paramBoolean)
  {
    GMTrace.i(956972400640L, 7130);
    if (paramView != null)
    {
      paramView = (EditText)paramView.findViewById(R.h.bEw);
      if (paramView != null) {
        if (!paramBoolean) {
          break label49;
        }
      }
    }
    label49:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      GMTrace.o(956972400640L, 7130);
      return;
    }
  }
  
  public static final class a
  {
    public DialogInterface.OnDismissListener jqA;
    public Context mContext;
    public com.tencent.mm.ui.base.h oGr;
    public final h.a sKJ;
    public String sKK;
    
    public a(Context paramContext)
    {
      GMTrace.i(963414851584L, 7178);
      this.sKK = null;
      this.mContext = paramContext;
      this.sKJ = new h.a(this.mContext);
      this.sKJ.kH(false);
      this.sKJ.kI(false);
      paramContext = this.sKJ;
      h.a.c local1 = new h.a.c()
      {
        public final CharSequence a(CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
        {
          GMTrace.i(967038730240L, 7205);
          paramAnonymousCharSequence = g.bKx().d(d.a.this.mContext, paramAnonymousCharSequence, paramAnonymousFloat);
          GMTrace.o(967038730240L, 7205);
          return paramAnonymousCharSequence;
        }
      };
      paramContext.vgH.vec = local1;
      GMTrace.o(963414851584L, 7178);
    }
    
    public final a MN(String paramString)
    {
      GMTrace.i(963817504768L, 7181);
      int i = com.tencent.mm.bg.a.fromDPToPix(this.mContext, (int)(14.0F * com.tencent.mm.bg.a.dI(this.mContext)));
      if (!bf.mA(paramString))
      {
        paramString = g.bKx().b(this.mContext, paramString.toString(), i);
        this.sKJ.N(paramString);
      }
      GMTrace.o(963817504768L, 7181);
      return this;
    }
    
    public final a MO(String paramString)
    {
      GMTrace.i(963951722496L, 7182);
      this.sKJ.vgH.fKq = paramString;
      GMTrace.o(963951722496L, 7182);
      return this;
    }
    
    public final a MP(String paramString)
    {
      GMTrace.i(964354375680L, 7185);
      Object localObject = this.mContext;
      h.a locala = this.sKJ;
      localObject = r.eC((Context)localObject).inflate(R.i.dik, null);
      MMGIFImageView localMMGIFImageView = (MMGIFImageView)((View)localObject).findViewById(R.h.bJk);
      if (localMMGIFImageView == null)
      {
        v.e("MicroMsg.MMConfirmDialog", "Error , emoji imageView is null !!");
        this.sKJ.kG(false);
        GMTrace.o(964354375680L, 7185);
        return this;
      }
      com.tencent.mm.storage.a.c localc = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(paramString);
      if (paramString.indexOf(File.separatorChar) != -1)
      {
        label107:
        if ((localc == null) || ((localc.field_reserved4 & com.tencent.mm.storage.a.c.uJy) != com.tencent.mm.storage.a.c.uJy)) {
          break label206;
        }
        localMMGIFImageView.h(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().g(localc), "");
      }
      for (;;)
      {
        locala.db((View)localObject);
        locala.zT(1);
        break;
        com.tencent.mm.pluginsdk.c.d locald = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr();
        ap.yY();
        com.tencent.mm.u.c.xi();
        paramString = locald.bP("", paramString);
        break label107;
        label206:
        localMMGIFImageView.yh(paramString);
      }
    }
    
    public final a MQ(String paramString)
    {
      GMTrace.i(964757028864L, 7188);
      this.sKJ.SX(paramString);
      GMTrace.o(964757028864L, 7188);
      return this;
    }
    
    public final a a(Bitmap paramBitmap, int paramInt)
    {
      GMTrace.i(964220157952L, 7184);
      this.sKJ.a(paramBitmap, true, paramInt);
      this.sKJ.kG(false);
      this.sKJ.a(new d.8(paramBitmap));
      GMTrace.o(964220157952L, 7184);
      return this;
    }
    
    public final a a(k.a parama)
    {
      GMTrace.i(17951486902272L, 133749);
      this.oGr = this.sKJ.WD();
      if (this.jqA != null) {
        this.oGr.setOnDismissListener(this.jqA);
      }
      d.a(this.mContext, this.oGr, this.sKK, null, parama, parama);
      GMTrace.o(17951486902272L, 133749);
      return this;
    }
    
    public final a a(h.a.a parama)
    {
      GMTrace.i(964488593408L, 7186);
      this.sKJ.vgH.veb = parama;
      GMTrace.o(964488593408L, 7186);
      return this;
    }
    
    public final a bEM()
    {
      GMTrace.i(963683287040L, 7180);
      this.sKJ.vgH.vet = 2;
      GMTrace.o(963683287040L, 7180);
      return this;
    }
    
    public final a bEN()
    {
      GMTrace.i(964085940224L, 7183);
      this.sKJ.vgH.vew = 8;
      GMTrace.o(964085940224L, 7183);
      return this;
    }
    
    public final a bEO()
    {
      GMTrace.i(17951352684544L, 133748);
      this.sKJ.kG(false);
      GMTrace.o(17951352684544L, 133748);
      return this;
    }
    
    public final a bs(Object paramObject)
    {
      GMTrace.i(963549069312L, 7179);
      d.a(this.mContext, this.sKJ, paramObject);
      this.sKJ.kG(true);
      GMTrace.o(963549069312L, 7179);
      return this;
    }
    
    public final a c(Boolean paramBoolean)
    {
      GMTrace.i(964622811136L, 7187);
      h.a locala = this.sKJ;
      boolean bool = paramBoolean.booleanValue();
      locala.vgH.vdU = bool;
      if (paramBoolean.booleanValue()) {
        this.sKJ.SX(this.mContext.getString(R.l.dXb));
      }
      GMTrace.o(964622811136L, 7187);
      return this;
    }
    
    public final a cO(View paramView)
    {
      GMTrace.i(17951218466816L, 133747);
      this.sKJ.db(paramView);
      GMTrace.o(17951218466816L, 133747);
      return this;
    }
    
    public final a xk(int paramInt)
    {
      GMTrace.i(964891246592L, 7189);
      this.sKK = this.mContext.getResources().getString(paramInt);
      GMTrace.o(964891246592L, 7189);
      return this;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/applet/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */