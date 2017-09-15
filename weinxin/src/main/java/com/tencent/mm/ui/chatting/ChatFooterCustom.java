package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.dq;
import com.tencent.mm.e.a.lf;
import com.tencent.mm.e.a.lf.a;
import com.tencent.mm.e.a.lg;
import com.tencent.mm.e.a.lg.a;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo.b;
import com.tencent.mm.modelbiz.i;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.w;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.q;
import com.tencent.mm.y.d.a;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class ChatFooterCustom
  extends LinearLayout
  implements View.OnClickListener, bp.a
{
  x fOB;
  private String jgK;
  private LinearLayout kXu;
  private Object por;
  ChatFooter.d sNw;
  private q uSF;
  private b vyA;
  private List<String> vyB;
  private final String vyC;
  private final String vyD;
  private i vyE;
  private ImageView vyt;
  ImageView vyu;
  y vyv;
  En_5b8fbb1e.a.b vyw;
  private int vyx;
  private ay vyy;
  private a vyz;
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(2137819971584L, 15928);
    GMTrace.o(2137819971584L, 15928);
  }
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(2137954189312L, 15929);
    this.kXu = null;
    this.vyt = null;
    this.vyu = null;
    this.vyv = null;
    this.sNw = null;
    this.vyw = null;
    this.vyx = 0;
    this.vyB = new LinkedList();
    this.vyC = "qrcode";
    this.vyD = "barcode";
    this.por = new Object();
    GMTrace.o(2137954189312L, 15929);
  }
  
  private boolean a(i parami)
  {
    GMTrace.i(17918603558912L, 133504);
    if (parami == null)
    {
      GMTrace.o(17918603558912L, 133504);
      return false;
    }
    String str = parami.id + parami.arH;
    parami = this.por;
    for (int i = 0;; i = -1) {
      try
      {
        while (i < this.vyB.size())
        {
          if (((String)this.vyB.get(i)).equals(str))
          {
            if (i >= 0)
            {
              this.vyB.remove(i);
              v.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", new Object[] { str, Integer.valueOf(this.vyB.size()) });
              GMTrace.o(17918603558912L, 133504);
              return true;
            }
          }
          else
          {
            i += 1;
            continue;
          }
          v.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", new Object[] { str, Integer.valueOf(this.vyB.size()) });
          GMTrace.o(17918603558912L, 133504);
          return false;
        }
      }
      finally {}
    }
  }
  
  private void b(i parami)
  {
    GMTrace.i(17918737776640L, 133505);
    com.tencent.mm.plugin.report.service.g.oSF.i(10809, new Object[] { this.jgK, Integer.valueOf(parami.id), parami.arH, i.hvs, "" });
    GMTrace.o(17918737776640L, 133505);
  }
  
  private boolean bE(Object paramObject)
  {
    GMTrace.i(2139430584320L, 15940);
    if (!(paramObject instanceof lf))
    {
      v.e("ChatCustomFooter", "send current location data type error!");
      GMTrace.o(2139430584320L, 15940);
      return true;
    }
    Object localObject = (lf)paramObject;
    double d1 = ((lf)localObject).fRK.lat;
    double d2 = ((lf)localObject).fRK.lng;
    int i = ((lf)localObject).fRK.fNU;
    paramObject = ((lf)localObject).fRK.label;
    String str = ((lf)localObject).fRK.fRN;
    v.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i), paramObject, str });
    if ((this.vyE == null) || (this.vyE.hvw != 105))
    {
      v.e("ChatCustomFooter", "cache lost or location type is not correct");
      GMTrace.o(2139430584320L, 15940);
      return true;
    }
    this.vyE.state = i.hvu;
    localObject = this.vyE;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("x", String.valueOf(d1));
      localJSONObject.put("y", String.valueOf(d2));
      localJSONObject.put("scale", i);
      localJSONObject.put("label", paramObject);
      localJSONObject.put("poiname", str);
      paramObject = new JSONObject();
      ((JSONObject)paramObject).put("location", localJSONObject);
      ((i)localObject).content = ((JSONObject)paramObject).toString();
      v.v("MicroMsg.BizMenuItem", ((i)localObject).content);
      if (a(this.vyE))
      {
        d(this.vyE);
        c(this.vyE);
      }
      GMTrace.o(2139430584320L, 15940);
      return true;
    }
    catch (JSONException paramObject)
    {
      for (;;)
      {
        v.e("MicroMsg.BizMenuItem", ((JSONException)paramObject).toString());
      }
    }
  }
  
  private boolean bF(Object paramObject)
  {
    GMTrace.i(2139564802048L, 15941);
    if (!(paramObject instanceof lg))
    {
      v.e("ChatCustomFooter", "send current location data type error!");
      GMTrace.o(2139564802048L, 15941);
      return false;
    }
    Object localObject = (lg)paramObject;
    if ((this.vyE == null) || ((this.vyE.hvw != 100) && (this.vyE.hvw != 101)))
    {
      v.e("ChatCustomFooter", "null pointer in cache or type error");
      GMTrace.o(2139564802048L, 15941);
      return false;
    }
    switch (((lg)localObject).fRO.fRQ)
    {
    default: 
      paramObject = "";
    }
    for (;;)
    {
      String str = ((lg)localObject).fRO.scanResult;
      v.i("ChatCustomFooter", "scan type: %s , scan result:%s", new Object[] { paramObject, str });
      this.vyE.state = i.hvu;
      localObject = this.vyE;
      v.v("MicroMsg.BizMenuItem", "type is %s , result is %s", new Object[] { paramObject, str });
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("scan_type", paramObject);
        localJSONObject.put("scan_result", str);
        paramObject = new JSONObject();
        ((JSONObject)paramObject).put("scan_code", localJSONObject);
        ((i)localObject).content = ((JSONObject)paramObject).toString();
        v.v("MicroMsg.BizMenuItem", "content: %s", new Object[] { ((i)localObject).content });
        if (a(this.vyE))
        {
          d(this.vyE);
          c(this.vyE);
        }
        GMTrace.o(2139564802048L, 15941);
        return true;
        paramObject = "qrcode";
        continue;
        paramObject = "barcode";
      }
      catch (JSONException paramObject)
      {
        for (;;)
        {
          v.e("MicroMsg.BizMenuItem", ((JSONException)paramObject).toString());
        }
      }
    }
  }
  
  private void bTJ()
  {
    GMTrace.i(2138356842496L, 15932);
    if ((this.uSF != null) && (this.fOB != null) && (!u.mA(this.jgK))) {
      k.b(this.uSF, 9, this.jgK, this.fOB.field_username);
    }
    GMTrace.o(2138356842496L, 15932);
  }
  
  private void bTK()
  {
    GMTrace.i(2138491060224L, 15933);
    File localFile = new File(e.gSp);
    if ((!localFile.exists()) && (!localFile.mkdir()))
    {
      Toast.makeText((Activity)getContext(), getContext().getString(R.l.dVA), 1).show();
      GMTrace.o(2138491060224L, 15933);
      return;
    }
    if ((this.uSF != null) && (!k.a(this.uSF, e.gSp, "microMsg." + System.currentTimeMillis() + ".jpg"))) {
      Toast.makeText((Activity)getContext(), getContext().getString(R.l.eQv), 1).show();
    }
    GMTrace.o(2138491060224L, 15933);
  }
  
  private void bTM()
  {
    GMTrace.i(2140101672960L, 15945);
    v.i("ChatCustomFooter", "switch footer");
    if (this.sNw != null)
    {
      this.vyv.bTO();
      this.sNw.jE(true);
    }
    GMTrace.o(2140101672960L, 15945);
  }
  
  private void bTN()
  {
    GMTrace.i(2140235890688L, 15946);
    if (this.fOB == null)
    {
      GMTrace.o(2140235890688L, 15946);
      return;
    }
    if (this.fOB.gkz == 1)
    {
      ap.yY();
      com.tencent.mm.u.c.wW().Rp(this.fOB.field_username);
    }
    GMTrace.o(2140235890688L, 15946);
  }
  
  private void c(i parami)
  {
    GMTrace.i(17918871994368L, 133506);
    com.tencent.mm.plugin.report.service.g.oSF.i(10809, new Object[] { this.jgK, Integer.valueOf(parami.id), parami.arH, i.hvu, parami.content });
    GMTrace.o(17918871994368L, 133506);
  }
  
  private void d(i parami)
  {
    GMTrace.i(17919006212096L, 133507);
    v.i("ChatCustomFooter", parami.getInfo());
    parami = new com.tencent.mm.modelbiz.p(this.jgK, 1, parami.getInfo());
    ap.vd().a(parami, 0);
    GMTrace.o(17919006212096L, 133507);
  }
  
  public final void a(q paramq, BizInfo.ExtInfo.b paramb, String paramString)
  {
    GMTrace.i(2138088407040L, 15930);
    if ((paramb == null) || (paramb.huO == null) || (paramString == null)) {
      throw new IllegalArgumentException(" menuInfo or username is null ! ");
    }
    this.vyx = Math.min(paramb.huO.size(), 6);
    v.i("ChatCustomFooter", "setMenus, count:" + this.vyx);
    if (this.vyx <= 0) {
      throw new IllegalArgumentException(" mTabCount is invalid ! ");
    }
    int i;
    label131:
    FrameLayout localFrameLayout;
    TextView localTextView;
    ImageView localImageView;
    if (this.vyx > 3)
    {
      this.vyt.setVisibility(0);
      this.kXu.setWeightSum(Math.min(this.vyx, 3));
      i = 0;
      if (i >= 6) {
        break label359;
      }
      localFrameLayout = (FrameLayout)this.kXu.getChildAt(i);
      localTextView = (TextView)localFrameLayout.getChildAt(0).findViewById(R.h.bAs);
      localFrameLayout.getChildAt(0).findViewById(R.h.bAr).setVisibility(8);
      localImageView = (ImageView)localFrameLayout.getChildAt(1);
      localImageView.setVisibility(8);
      if (i >= this.vyx) {
        break label300;
      }
      i locali = (i)paramb.huO.get(i);
      localFrameLayout.setTag(locali);
      localTextView.setText(h.a(getContext(), locali.name));
      if (locali.type == 0) {
        localImageView.setVisibility(0);
      }
      localFrameLayout.setOnClickListener(this);
      localFrameLayout.setVisibility(0);
    }
    for (;;)
    {
      i += 1;
      break label131;
      this.vyt.setVisibility(8);
      break;
      label300:
      if ((i >= 3) && (this.vyx > 3))
      {
        localFrameLayout.setTag(null);
        localTextView.setText("");
        localImageView.setVisibility(8);
        localFrameLayout.setOnClickListener(null);
        localFrameLayout.setVisibility(0);
      }
      else
      {
        localFrameLayout.setVisibility(8);
      }
    }
    label359:
    this.uSF = paramq;
    this.jgK = paramString;
    if (this.vyz != null) {
      com.tencent.mm.sdk.b.a.uql.c(this.vyz);
    }
    if (this.vyA != null) {
      com.tencent.mm.sdk.b.a.uql.c(this.vyA);
    }
    this.vyz = new a((byte)0);
    this.vyA = new b((byte)0);
    com.tencent.mm.sdk.b.a.uql.b(this.vyz);
    com.tencent.mm.sdk.b.a.uql.b(this.vyA);
    GMTrace.o(2138088407040L, 15930);
  }
  
  public final void a(d.a parama)
  {
    GMTrace.i(2139967455232L, 15944);
    parama = com.tencent.mm.platformtools.n.a(parama.hsc.tdz);
    v.i("ChatCustomFooter", "SysCmdMsgExtension:" + parama);
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = XmlPullParserFactory.newInstance();
        ((XmlPullParserFactory)localObject).setNamespaceAware(true);
        localObject = ((XmlPullParserFactory)localObject).newPullParser();
        ((XmlPullParser)localObject).setInput(new StringReader(parama));
        i = ((XmlPullParser)localObject).getEventType();
      }
      catch (Exception parama)
      {
        v.printErrStackTrace("ChatCustomFooter", parama, "", new Object[0]);
        GMTrace.o(2139967455232L, 15944);
        return;
      }
      int i = ((XmlPullParser)localObject).next();
      break label207;
      parama = ((XmlPullParser)localObject).getName();
      if ("sysmsg".equals(parama))
      {
        if ("type".equals(((XmlPullParser)localObject).getAttributeName(0))) {
          ((XmlPullParser)localObject).getAttributeValue(0);
        }
      }
      else if ("username".equals(parama))
      {
        ((XmlPullParser)localObject).nextText();
      }
      else if ("data".equals(parama))
      {
        ((XmlPullParser)localObject).nextText();
        label207:
        while (i == 1)
        {
          GMTrace.o(2139967455232L, 15944);
          return;
        }
        switch (i)
        {
        }
      }
    }
  }
  
  public final void bTL()
  {
    GMTrace.i(2138625277952L, 15934);
    if (this.vyv != null) {
      this.vyv.bTO();
    }
    GMTrace.o(2138625277952L, 15934);
  }
  
  public final void bkh()
  {
    GMTrace.i(2138222624768L, 15931);
    if (this.vyz != null) {
      com.tencent.mm.sdk.b.a.uql.c(this.vyz);
    }
    if (this.vyA != null) {
      com.tencent.mm.sdk.b.a.uql.c(this.vyA);
    }
    GMTrace.o(2138222624768L, 15931);
  }
  
  public final boolean h(int paramInt, Object paramObject)
  {
    GMTrace.i(2139296366592L, 15939);
    if (paramObject == null)
    {
      v.e("ChatCustomFooter", "returned data is null, maybe serve for UI");
      GMTrace.o(2139296366592L, 15939);
      return true;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        GMTrace.o(2139296366592L, 15939);
        return true;
        paramInt = 1001;
        continue;
        paramInt = 1002;
      }
    }
    v.i("ChatCustomFooter", "return from camera");
    if (!(paramObject instanceof Intent))
    {
      v.e("ChatCustomFooter", "type error");
      GMTrace.o(2139296366592L, 15939);
      return true;
    }
    paramObject = ((Intent)paramObject).getStringExtra("CropImage_OutputPath");
    if (paramObject == null)
    {
      v.e("ChatCustomFooter", "return null path");
      GMTrace.o(2139296366592L, 15939);
      return true;
    }
    Object localObject = new File((String)paramObject);
    if ((((File)localObject).exists()) && (((File)localObject).isFile()))
    {
      v.i("ChatCustomFooter", "%s retrieved!", new Object[] { paramObject });
      paramObject = com.tencent.mm.a.g.f((File)localObject);
      v.i("ChatCustomFooter", "MD5 is %s", new Object[] { paramObject });
      if ((this.vyE == null) || ((this.vyE.hvw != 102) && (this.vyE.hvw != 103)))
      {
        v.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
        GMTrace.o(2139296366592L, 15939);
        return true;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramObject);
      this.vyE.state = i.hvu;
      this.vyE.e((ArrayList)localObject);
      if (a(this.vyE))
      {
        d(this.vyE);
        c(this.vyE);
      }
    }
    for (;;)
    {
      GMTrace.o(2139296366592L, 15939);
      return true;
      v.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[] { paramObject });
    }
    v.i("ChatCustomFooter", "return from albumn");
    if (!(paramObject instanceof Intent))
    {
      v.e("ChatCustomFooter", "type error");
      GMTrace.o(2139296366592L, 15939);
      return true;
    }
    localObject = ((Intent)paramObject).getStringArrayListExtra("CropImage_OutputPath_List");
    paramObject = new ArrayList();
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        v.i("ChatCustomFooter", "retrieving bitmap path %s", new Object[] { str });
        if (str != null)
        {
          File localFile = new File(str);
          if ((localFile.exists()) && (localFile.isFile()))
          {
            v.i("ChatCustomFooter", "%s retrieved!", new Object[] { str });
            str = com.tencent.mm.a.g.f(localFile);
            ((ArrayList)paramObject).add(str);
            v.i("ChatCustomFooter", "MD5 is %s", new Object[] { str });
          }
        }
        else
        {
          v.e("ChatCustomFooter", "no file contained!");
          continue;
        }
        v.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[] { str });
      }
      if ((this.vyE == null) || ((this.vyE.hvw != 104) && (this.vyE.hvw != 103) && (this.vyE.hvw != 102)))
      {
        v.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
        GMTrace.o(2139296366592L, 15939);
        return true;
      }
      this.vyE.state = i.hvu;
      this.vyE.e((ArrayList)paramObject);
      if (a(this.vyE))
      {
        d(this.vyE);
        c(this.vyE);
      }
    }
    GMTrace.o(2139296366592L, 15939);
    return true;
    v.i("ChatCustomFooter", "send current");
    bE(paramObject);
    GMTrace.o(2139296366592L, 15939);
    return true;
    v.i("ChatCustomFooter", "send selected");
    bE(paramObject);
    GMTrace.o(2139296366592L, 15939);
    return true;
    v.i("ChatCustomFooter", "send qrcode wait msg");
    if (!bF(paramObject))
    {
      GMTrace.o(2139296366592L, 15939);
      return true;
    }
    this.vyw.bVZ();
    GMTrace.o(2139296366592L, 15939);
    return true;
    v.i("ChatCustomFooter", "send qrcode direct");
    bF(paramObject);
    GMTrace.o(2139296366592L, 15939);
    return true;
  }
  
  public final void j(ViewGroup paramViewGroup)
  {
    GMTrace.i(2139833237504L, 15943);
    this.kXu = ((LinearLayout)findViewById(R.h.bAq));
    this.vyu = ((ImageView)findViewById(R.h.bAu));
    this.vyu.setVisibility(0);
    this.vyu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2252039258112L, 16779);
        ChatFooterCustom.c(ChatFooterCustom.this);
        GMTrace.o(2252039258112L, 16779);
      }
    });
    this.vyt = ((ImageView)findViewById(R.h.bAp));
    this.vyt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2162784468992L, 16114);
        ChatFooterCustom.d(ChatFooterCustom.this).bTO();
        paramAnonymousView = (ImageView)paramAnonymousView;
        int j;
        if (paramAnonymousView.getTag() == null)
        {
          paramAnonymousView.setTag(new Object());
          paramAnonymousView.setImageResource(R.g.bhd);
          i = 0;
          if (i < ChatFooterCustom.e(ChatFooterCustom.this))
          {
            paramAnonymousView = ChatFooterCustom.f(ChatFooterCustom.this).getChildAt(i);
            if (i >= 3) {}
            for (j = 0;; j = 8)
            {
              paramAnonymousView.setVisibility(j);
              i += 1;
              break;
            }
          }
          GMTrace.o(2162784468992L, 16114);
          return;
        }
        paramAnonymousView.setTag(null);
        paramAnonymousView.setImageResource(R.g.bhc);
        int i = 0;
        if (i < ChatFooterCustom.e(ChatFooterCustom.this))
        {
          paramAnonymousView = ChatFooterCustom.f(ChatFooterCustom.this).getChildAt(i);
          if (i < 3) {}
          for (j = 0;; j = 8)
          {
            paramAnonymousView.setVisibility(j);
            i += 1;
            break;
          }
        }
        GMTrace.o(2162784468992L, 16114);
      }
    });
    this.vyv = new y(getContext(), paramViewGroup);
    this.vyv.vyG = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(2209358020608L, 16461);
        ChatFooterCustom.this.onClick(paramAnonymousView);
        GMTrace.o(2209358020608L, 16461);
      }
    };
    GMTrace.o(2139833237504L, 15943);
  }
  
  public void onClick(View arg1)
  {
    label100:
    Object localObject4;
    for (;;)
    {
      Object localObject1;
      try
      {
        GMTrace.i(2138759495680L, 15935);
        localObject1 = ???.getTag();
        if (!(localObject1 instanceof i))
        {
          GMTrace.o(2138759495680L, 15935);
          return;
        }
        f.xO(8);
        localObject1 = (i)localObject1;
        ((i)localObject1).content = "";
        switch (((i)localObject1).type)
        {
        case 0: 
          GMTrace.o(2138759495680L, 15935);
          continue;
          localObject4 = new int[2];
        }
      }
      finally {}
      ???.getLocationOnScreen((int[])localObject4);
      v.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", new Object[] { Integer.valueOf(localObject4[0]), Integer.valueOf(localObject4[1]), Integer.valueOf(???.getWidth()) });
      Object localObject5 = this.vyv;
      int i = localObject4[0] + ???.getWidth() / 2;
      int j = localObject4[1];
      if (!((y)localObject5).isShowing())
      {
        ((y)localObject5).a((i)localObject1, i, j, false);
        GMTrace.o(2138759495680L, 15935);
      }
      else
      {
        ((y)localObject5).bTO();
        if ((localObject1 != null) && ((((y)localObject5).vyM.id != ((i)localObject1).id) || (!((y)localObject5).vyM.arH.equals(((i)localObject1).arH)))) {
          ((y)localObject5).a((i)localObject1, i, j, false);
        }
        GMTrace.o(2138759495680L, 15935);
        continue;
        v.i("ChatCustomFooter", "start webview url");
        bTN();
        this.vyv.bTO();
        ((i)localObject1).state = i.hvs;
        b((i)localObject1);
        d((i)localObject1);
        if ((!l.a.szU.b(getContext(), ((i)localObject1).value, new Object[0])) && (!s.a(((i)localObject1).fZv, getContext(), this.uSF, this.jgK)))
        {
          ??? = new Intent();
          ???.putExtra("KPublisherId", "custom_menu");
          ???.putExtra("pre_username", this.jgK);
          ???.putExtra("prePublishId", "custom_menu");
          ???.putExtra("preUsername", this.jgK);
          ???.putExtra("preChatName", this.jgK);
          ???.putExtra("preChatTYPE", com.tencent.mm.u.p.G(this.jgK, this.jgK));
          ???.putExtra("rawUrl", ((i)localObject1).value);
          ???.putExtra("geta8key_username", this.jgK);
          ???.putExtra("from_scence", 1);
          d.b(getContext(), "webview", ".ui.tools.WebViewUI", ???);
          GMTrace.o(2138759495680L, 15935);
          continue;
          v.i("ChatCustomFooter", "switch to input");
          this.vyv.bTO();
          bTM();
          ((i)localObject1).state = i.hvs;
          b((i)localObject1);
          d((i)localObject1);
          GMTrace.o(2138759495680L, 15935);
          continue;
          v.i("ChatCustomFooter", "get latest message");
          bTN();
          this.vyv.bTO();
          ((i)localObject1).state = i.hvs;
          b((i)localObject1);
          d((i)localObject1);
          this.vyw.bVZ();
          GMTrace.o(2138759495680L, 15935);
          continue;
          bTN();
          this.vyv.bTO();
          ((i)localObject1).state = i.hvs;
          b((i)localObject1);
          d((i)localObject1);
          bool = TextUtils.isEmpty(((i)localObject1).value);
          if (!bool)
          {
            try
            {
              ??? = new JSONObject(((i)localObject1).value);
              localObject1 = new pr();
              ((pr)localObject1).fWr.userName = ???.optString("userName");
              ((pr)localObject1).fWr.fWt = ???.optString("pagePath");
              ((pr)localObject1).fWr.fWu = 0;
              ((pr)localObject1).fWr.fWv = ???.optInt("version");
              ((pr)localObject1).fWr.scene = 1035;
              ((pr)localObject1).fWr.fCE = this.jgK;
              com.tencent.mm.sdk.b.a.uql.m((b)localObject1);
              GMTrace.o(2138759495680L, 15935);
            }
            catch (JSONException ???)
            {
              GMTrace.o(2138759495680L, 15935);
            }
            continue;
            v.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
            bTN();
            this.vyv.bTO();
            ((i)localObject1).state = i.hvt;
            localObject4 = ((i)localObject1).id + ((i)localObject1).arH;
            synchronized (this.por)
            {
              this.vyB.add(localObject4);
              v.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", new Object[] { localObject4, Integer.valueOf(this.vyB.size()) });
              com.tencent.mm.plugin.report.service.g.oSF.i(10809, new Object[] { this.jgK, Integer.valueOf(((i)localObject1).id), ((i)localObject1).arH, i.hvt, "" });
              this.vyE = ((i)localObject1);
              switch (((i)localObject1).hvw)
              {
              case 100: 
                ??? = new Intent();
                ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                ???.putExtra("key_is_finish_on_scanned", true);
                ???.putExtra("key_is_hide_right_btn", true);
                if ((com.tencent.mm.n.a.aI(getContext())) || (com.tencent.mm.n.a.aH(getContext()))) {
                  continue;
                }
                d.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
                GMTrace.o(2138759495680L, 15935);
              }
            }
            ??? = new Intent();
            ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
            ???.putExtra("key_is_finish_on_scanned", false);
            ???.putExtra("key_is_hide_right_btn", true);
            if ((!com.tencent.mm.n.a.aI(getContext())) && (!com.tencent.mm.n.a.aH(getContext())))
            {
              d.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
              GMTrace.o(2138759495680L, 15935);
              continue;
              bTK();
              GMTrace.o(2138759495680L, 15935);
              continue;
              ap.yY();
              if (!com.tencent.mm.u.c.isSDCardAvailable())
              {
                com.tencent.mm.ui.base.s.eP(getContext());
                GMTrace.o(2138759495680L, 15935);
              }
              else
              {
                ??? = getContext().getString(R.l.dTe);
                localObject3 = getContext().getString(R.l.dTd);
                localObject4 = getContext();
                localObject5 = new g.c()
                {
                  public final void hp(int paramAnonymousInt)
                  {
                    GMTrace.i(2219961221120L, 16540);
                    switch (paramAnonymousInt)
                    {
                    }
                    for (;;)
                    {
                      GMTrace.o(2219961221120L, 16540);
                      return;
                      ChatFooterCustom.a(ChatFooterCustom.this);
                      GMTrace.o(2219961221120L, 16540);
                      return;
                      ChatFooterCustom.b(ChatFooterCustom.this);
                    }
                  }
                };
                com.tencent.mm.ui.base.g.a((Context)localObject4, null, new String[] { ???, localObject3 }, null, (g.c)localObject5);
                GMTrace.o(2138759495680L, 15935);
                continue;
                bTJ();
                GMTrace.o(2138759495680L, 15935);
              }
            }
          }
        }
      }
    }
    Object localObject3 = new Intent();
    ((Intent)localObject3).putExtra("map_view_type", 0);
    ??? = new StringBuilder("getSender ");
    if (this.vyy == null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject4 = ???.append(bool).append(" ");
      if (this.vyy == null)
      {
        ??? = m.xL();
        label1423:
        v.i("ChatCustomFooter", ???);
        if (this.vyy != null) {
          break label1535;
        }
        ??? = m.xL();
        label1448:
        ((Intent)localObject3).putExtra("map_sender_name", ???);
        if (this.fOB != null) {
          break label1546;
        }
      }
      label1535:
      label1546:
      for (??? = null;; ??? = this.fOB.field_username)
      {
        ((Intent)localObject3).putExtra("map_talker_name", ???);
        ((Intent)localObject3).putExtra("view_type_key", 1);
        ((Intent)localObject3).putExtra("key_get_location_type", 1);
        d.b(getContext(), "location", ".ui.RedirectUI", (Intent)localObject3);
        GMTrace.o(2138759495680L, 15935);
        break;
        ??? = this.vyy.name;
        break label1423;
        ??? = this.vyy.name;
        break label1448;
      }
      ??? = new dq();
      ???.fHq.op = 1;
      ???.fHq.userName = this.fOB.field_username;
      ???.fHq.context = getContext();
      com.tencent.mm.sdk.b.a.uql.m(???);
      GMTrace.o(2138759495680L, 15935);
      break;
      ??? = new dq();
      ???.fHq.op = 2;
      ???.fHq.userName = this.fOB.field_username;
      ???.fHq.context = getContext();
      com.tencent.mm.sdk.b.a.uql.m(???);
      break label100;
      break label100;
      break label100;
    }
  }
  
  private final class a
    extends com.tencent.mm.sdk.b.c<lf>
  {
    private a()
    {
      GMTrace.i(2208015843328L, 16451);
      this.uqt = lf.class.getName().hashCode();
      GMTrace.o(2208015843328L, 16451);
    }
  }
  
  private final class b
    extends com.tencent.mm.sdk.b.c<lg>
  {
    private b()
    {
      GMTrace.i(2282775117824L, 17008);
      this.uqt = lg.class.getName().hashCode();
      GMTrace.o(2282775117824L, 17008);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ChatFooterCustom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */