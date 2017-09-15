package com.tencent.mm.modelbiz;

import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.b;
import com.tencent.mm.protocal.c.gp;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.x.c;
import com.tencent.mm.x.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public a()
  {
    GMTrace.i(4542330568704L, 33843);
    GMTrace.o(4542330568704L, 33843);
  }
  
  public static boolean Cy()
  {
    GMTrace.i(4542599004160L, 33845);
    Object localObject = com.tencent.mm.kernel.h.vI().vr().get(w.a.uzF, null);
    if ((localObject == null) || (!(localObject instanceof Integer))) {
      v.i("MicroMsg.BizAttrRenovator", "openFlag is null.");
    }
    for (int i = 1;; i = ((Integer)localObject).intValue())
    {
      v.i("MicroMsg.BizAttrRenovator", "openFlag is %d.", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break;
      }
      GMTrace.o(4542599004160L, 33845);
      return true;
    }
    GMTrace.o(4542599004160L, 33845);
    return false;
  }
  
  public static boolean a(x paramx, BizInfo paramBizInfo, List<gp> paramList)
  {
    GMTrace.i(4542867439616L, 33847);
    if ((paramx == null) || (paramList == null) || (paramList.size() == 0))
    {
      v.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed.");
      GMTrace.o(4542867439616L, 33847);
      return false;
    }
    String str1 = paramx.field_username;
    if (!paramx.bKU())
    {
      v.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact is not a biz contact.(username : %s)", new Object[] { str1 });
      GMTrace.o(4542867439616L, 33847);
      return false;
    }
    BizInfo localBizInfo = paramBizInfo;
    if (paramBizInfo == null) {
      localBizInfo = w.DH().hO(str1);
    }
    if (localBizInfo == null)
    {
      v.i("MicroMsg.BizAttrRenovator", "BizInfo is null.(username : %s)", new Object[] { str1 });
      GMTrace.o(4542867439616L, 33847);
      return false;
    }
    com.tencent.mm.x.h localh = com.tencent.mm.x.n.Bm().hs(str1);
    long l1;
    int i;
    int j;
    gp localgp;
    try
    {
      if (bf.mA(localBizInfo.field_extInfo)) {}
      for (paramBizInfo = new JSONObject();; paramBizInfo = new JSONObject(localBizInfo.field_extInfo))
      {
        l1 = -1L;
        l2 = paramx.field_type;
        paramList = paramList.iterator();
        i = 0;
        j = 0;
        for (;;)
        {
          if (!paramList.hasNext()) {
            break label707;
          }
          localgp = (gp)paramList.next();
          if (localgp != null) {
            break;
          }
          v.w("MicroMsg.BizAttrRenovator", "keyValue is null.");
        }
      }
    }
    catch (Exception paramBizInfo)
    {
      String str2;
      for (;;)
      {
        v.e("MicroMsg.BizAttrRenovator", "create Json object from extInfo error. %s.", new Object[] { paramBizInfo });
        paramBizInfo = new JSONObject();
        continue;
        str2 = localgp.tiY;
        v.i("MicroMsg.BizAttrRenovator", "[BizAttr] UpdateInfoList key = %s, value = %s", new Object[] { str2, localgp.oSl });
        String str3 = localgp.oSl;
        if (!"UserName".equals(str2))
        {
          if ("NickName".equals(str2)) {
            paramx.bR(str3);
          }
        }
        else
        {
          label324:
          k = 1;
          label327:
          if ((k == 0) && (!b(paramBizInfo, str2, localgp.oSl)))
          {
            str3 = localgp.oSl;
            if (!"BrandInfo".equals(str2)) {
              break label512;
            }
            localBizInfo.field_brandInfo = str3;
          }
        }
        label370:
        for (int k = 1;; k = 0)
        {
          if (k == 0) {
            break label567;
          }
          i += 1;
          break;
          if ("Alias".equals(str2))
          {
            paramx.bO(str3);
            break label324;
          }
          if ("PYInitial".equals(str2))
          {
            paramx.bS(str3);
            break label324;
          }
          if ("QuanPin".equals(str2))
          {
            paramx.bT(str3);
            break label324;
          }
          if ("VerifyFlag".equals(str2))
          {
            paramx.de(bf.getInt(str3, paramx.field_verifyFlag));
            break label324;
          }
          if ("VerifyInfo".equals(str2))
          {
            paramx.cj(str3);
            break label324;
          }
          if ("Signature".equals(str2))
          {
            paramx.ce(str3);
            break label324;
          }
          k = 0;
          break label327;
          label512:
          if ("BrandIconURL".equals(str2))
          {
            localBizInfo.field_brandIconURL = str3;
            break label370;
          }
          if ("BrandFlag".equals(str2))
          {
            localBizInfo.field_brandFlag = bf.getInt(str3, localBizInfo.field_brandFlag);
            break label370;
          }
        }
        label567:
        str3 = localgp.oSl;
        if ("BigHeadImgUrl".equals(str2)) {
          if (localh != null) {
            localh.hrk = str3;
          }
        }
        label597:
        for (k = 1;; k = 0)
        {
          if (k == 0) {
            break label647;
          }
          i += 1;
          j = 1;
          break;
          if ("SmallHeadImgUrl".equals(str2))
          {
            if (localh == null) {
              break label597;
            }
            localh.hrj = str3;
            break label597;
          }
        }
        label647:
        if (!"BitMask".equals(str2)) {
          break;
        }
        l1 = bf.getLong(localgp.oSl, l1);
        i += 1;
      }
      if (!"BitVal".equals(str2)) {
        break label918;
      }
    }
    long l2 = bf.getLong(localgp.oSl, l2);
    i += 1;
    label707:
    label918:
    for (;;)
    {
      break;
      if (i == 0)
      {
        v.i("MicroMsg.BizAttrRenovator", "None attribute has been updated.");
        GMTrace.o(4542867439616L, 33847);
        return false;
      }
      localBizInfo.field_extInfo = paramBizInfo.toString();
      if ((localh != null) && (j != 0))
      {
        com.tencent.mm.x.n.Bm().a(localh);
        com.tencent.mm.x.n.Bl();
        com.tencent.mm.x.d.s(str1, false);
        com.tencent.mm.x.n.Bl();
        com.tencent.mm.x.d.s(str1, true);
        com.tencent.mm.x.n.Bz().hf(str1);
        paramBizInfo = w.DP();
        if (!bf.mA(str1))
        {
          v.d("MicroMsg.BrandLogic", "remove cache by brandKey : %s", new Object[] { str1 });
          paramBizInfo = (WeakReference)paramBizInfo.hvK.remove(str1);
          if (paramBizInfo != null)
          {
            paramBizInfo = (Bitmap)paramBizInfo.get();
            if (paramBizInfo != null) {
              paramBizInfo.isRecycled();
            }
          }
        }
      }
      paramx.setType(paramx.field_type | (int)(l1 & l2));
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().a(str1, paramx);
      w.DH().e(localBizInfo);
      v.i("MicroMsg.BizAttrRenovator", "Update bizInfo attributes successfully.");
      GMTrace.o(4542867439616L, 33847);
      return true;
    }
  }
  
  static boolean b(BizInfo paramBizInfo)
  {
    GMTrace.i(4542464786432L, 33844);
    if (paramBizInfo == null)
    {
      v.i("MicroMsg.BizAttrRenovator", "BizInfo is null.");
      GMTrace.o(4542464786432L, 33844);
      return false;
    }
    if (!Cy())
    {
      GMTrace.o(4542464786432L, 33844);
      return false;
    }
    int j = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getInt("MMBizAttrSyncFreq", -1);
    int i = j;
    if (j == -1)
    {
      v.i("MicroMsg.BizAttrRenovator", "MMBizAttrSyncFreq is null.");
      i = 3600;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramBizInfo.field_incrementUpdateTime;
    v.i("MicroMsg.BizAttrRenovator", "currentMS(%d), lastUpdateTime(%d), freq(%d), version(%s).", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), paramBizInfo.field_attrSyncVersion });
    if (l1 - l2 >= i * 1000)
    {
      GMTrace.o(4542464786432L, 33844);
      return true;
    }
    GMTrace.o(4542464786432L, 33844);
    return false;
  }
  
  private static boolean b(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    GMTrace.i(4543001657344L, 33848);
    try
    {
      if ("IsShowHeadImgInMsg".equals(paramString1)) {
        paramJSONObject.put(paramString1, paramString2);
      }
      for (;;)
      {
        GMTrace.o(4543001657344L, 33848);
        return true;
        if (!"IsHideInputToolbarInMsg".equals(paramString1)) {
          break;
        }
        paramJSONObject.put(paramString1, paramString2);
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        v.e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs failed, key(%s) value(%s), exception : %s.", new Object[] { paramString1, paramString2, paramJSONObject });
        continue;
        if (!"IsAgreeProtocol".equals(paramString1)) {
          if ("InteractiveMode".equals(paramString1)) {
            paramJSONObject.put(paramString1, bf.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("CanReceiveSpeexVoice".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if ("ConnectorMsgType".equals(paramString1)) {
            paramJSONObject.put(paramString1, bf.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("ReportLocationType".equals(paramString1)) {
            paramJSONObject.put(paramString1, bf.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("AudioPlayType".equals(paramString1)) {
            paramJSONObject.put(paramString1, bf.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("IsShowMember".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if ("ConferenceContactExpireTime".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if (!"VerifyMsg2Remark".equals(paramString1)) {
            if ("VerifyContactPromptTitle".equals(paramString1)) {
              paramJSONObject.put(paramString1, paramString2);
            } else if (!"IsSubscribeStat".equals(paramString1)) {
              if ("ScanQRCodeType".equals(paramString1)) {
                paramJSONObject.put(paramString1, bf.getInt(paramString2, paramJSONObject.optInt(paramString1)));
              } else if ("ServiceType".equals(paramString1)) {
                paramJSONObject.put(paramString1, bf.getInt(paramString2, paramJSONObject.optInt(paramString1)));
              } else if (!"NeedShowUserAddrObtaining".equals(paramString1)) {
                if ("SupportEmoticonLinkPrefix".equals(paramString1)) {
                  paramJSONObject.put(paramString1, paramString2);
                } else if ("FunctionFlag".equals(paramString1)) {
                  paramJSONObject.put(paramString1, bf.getInt(paramString2, paramJSONObject.optInt(paramString1)));
                } else if ("NotifyManage".equals(paramString1)) {
                  paramJSONObject.put(paramString1, paramString2);
                } else if ("ServicePhone".equals(paramString1)) {
                  paramJSONObject.put(paramString1, paramString2);
                } else if ("IsTrademarkProtection".equals(paramString1)) {
                  paramJSONObject.put(paramString1, paramString2);
                } else if (!"CanReceiveLongVideo".equals(paramString1)) {
                  if ("TrademarkUrl".equals(paramString1)) {
                    paramJSONObject.put(paramString1, paramString2);
                  } else if ("TrademarkName".equals(paramString1)) {
                    paramJSONObject.put(paramString1, paramString2);
                  } else if ("MMBizMenu".equals(paramString1)) {
                    paramJSONObject.put(paramString1, paramString2);
                  } else if ("VerifySource".equals(paramString1)) {
                    paramJSONObject.put(paramString1, paramString2);
                  } else if (!"MMBizTabbar".equals(paramString1)) {
                    if ("PayShowInfo".equals(paramString1)) {
                      paramJSONObject.put(paramString1, paramString2);
                    } else if ("HardwareBizInfo".equals(paramString1)) {
                      paramJSONObject.put(paramString1, paramString2);
                    } else if ("EnterpriseBizInfo".equals(paramString1)) {
                      paramJSONObject.put(paramString1, paramString2);
                    } else if (!"MainPage".equals(paramString1)) {
                      if ("RegisterSource".equals(paramString1)) {
                        paramJSONObject.put(paramString1, paramString2);
                      } else if (!"IBeaconBizInfo".equals(paramString1)) {
                        if ("WxaAppInfo".equals(paramString1))
                        {
                          paramJSONObject.put(paramString1, paramString2);
                        }
                        else if ("WxaAppVersionInfo".equals(paramString1))
                        {
                          paramJSONObject.put(paramString1, paramString2);
                        }
                        else if ("WXAppType".equals(paramString1))
                        {
                          paramJSONObject.put(paramString1, paramString2);
                        }
                        else
                        {
                          if (!"BindWxaInfo".equals(paramString1)) {
                            break;
                          }
                          paramJSONObject.put(paramString1, paramString2);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      GMTrace.o(4543001657344L, 33848);
    }
    return false;
  }
  
  public final boolean hB(final String paramString)
  {
    GMTrace.i(18486344548352L, 137734);
    if (bf.mA(paramString))
    {
      v.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is null or nil.");
      GMTrace.o(18486344548352L, 137734);
      return false;
    }
    v.d("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes");
    BizInfo localBizInfo = w.DH().hO(paramString);
    if (!b(localBizInfo))
    {
      v.i("MicroMsg.BizAttrRenovator", "do not need to update biz attrs now.");
      GMTrace.o(18486344548352L, 137734);
      return false;
    }
    final WeakReference localWeakReference = new WeakReference(null);
    com.tencent.mm.kernel.h.vH().gXs.a(new o(paramString, localBizInfo.field_attrSyncVersion, new o.a() {}), 0);
    GMTrace.o(18486344548352L, 137734);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */