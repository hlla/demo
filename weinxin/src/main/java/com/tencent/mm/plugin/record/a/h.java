package com.tencent.mm.plugin.record.a;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.aa.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.n;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends f<g>
{
  private h.a hGp;
  
  public h()
  {
    GMTrace.i(7514179502080L, 55985);
    this.hGp = new h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, final keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(7519279775744L, 56023);
        v.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, startRet[%d], mediaId[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if (paramAnonymouskeep_ProgressInfo != null) {
          v.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, mediaid[%s], totallen[%d], offset[%d]", new Object[] { paramAnonymouskeep_ProgressInfo.mediaId, Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_toltalLength), Integer.valueOf(paramAnonymouskeep_ProgressInfo.field_finishedLength) });
        }
        if ((paramAnonymousInt == 44530) || (paramAnonymousInt == 44531))
        {
          h.this.aWu();
          GMTrace.o(7519279775744L, 56023);
          return 0;
        }
        final g localg = s.aWy().Dm(paramAnonymousString);
        if (localg == null)
        {
          v.w("MicroMsg.RecordMsgCDNService", "onCdnCallback info null, mediaId[%s]", new Object[] { paramAnonymousString });
          h.this.aWu();
          GMTrace.o(7519279775744L, 56023);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          v.w("MicroMsg.RecordMsgCDNService", "tran fail, startRet[%d], mediaId[%s], type[%d]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Integer.valueOf(localg.field_type) });
          if (-5103059 == paramAnonymousInt)
          {
            localg.field_status = 4;
            localg.field_errCode = paramAnonymousInt;
            s.aWy().b(localg, new String[] { "localId" });
          }
        }
        for (;;)
        {
          h.this.aWu();
          label297:
          do
          {
            for (;;)
            {
              GMTrace.o(7519279775744L, 56023);
              return 0;
              localg.field_status = 3;
              break;
              if (paramAnonymouskeep_ProgressInfo == null) {
                break label297;
              }
              localg.field_offset = paramAnonymouskeep_ProgressInfo.field_finishedLength;
              localg.field_totalLen = paramAnonymouskeep_ProgressInfo.field_toltalLength;
              localg.field_status = 1;
              s.aWy().b(localg, new String[] { "localId" });
            }
          } while (paramAnonymouskeep_SceneResult == null);
          v.i("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload attach by cdn, retCode:%d isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", new Object[] { Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode), Integer.valueOf(paramAnonymouskeep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymouskeep_SceneResult.field_exist_whencheck), bf.Qi(paramAnonymouskeep_SceneResult.field_aesKey), paramAnonymouskeep_SceneResult.field_filemd5 });
          if (paramAnonymouskeep_SceneResult.field_retCode < 0) {
            break label765;
          }
          localg.field_status = 2;
          if (1 == localg.field_type)
          {
            paramAnonymousString = localg.field_path + ".temp";
            paramAnonymouskeep_SceneResult = localg.field_path;
            if ((bf.mA(paramAnonymousString)) || (bf.mA(paramAnonymouskeep_SceneResult))) {
              v.w("MicroMsg.RecordMsgCDNService", "do rename and copy file, but path error");
            }
            for (;;)
            {
              s.aWy().a(localg, new String[] { "localId" });
              break;
              paramAnonymouskeep_ProgressInfo = new File(paramAnonymousString);
              paramAnonymouskeep_SceneResult = new File(paramAnonymouskeep_SceneResult);
              if (paramAnonymouskeep_ProgressInfo.exists()) {
                v.v("MicroMsg.RecordMsgCDNService", "rename file suc:%b, old:%s, new:%s", new Object[] { Boolean.valueOf(paramAnonymouskeep_ProgressInfo.renameTo(paramAnonymouskeep_SceneResult)), paramAnonymousString, paramAnonymouskeep_SceneResult });
              }
            }
          }
          v.i("MicroMsg.RecordMsgCDNService", "transfer done, mediaid=%s, md5=%s", new Object[] { paramAnonymouskeep_SceneResult.mediaId, paramAnonymousString });
          v.d("MicroMsg.RecordMsgCDNService", "transfer done, completeInfo=%s", new Object[] { paramAnonymouskeep_SceneResult });
          v.d("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload field_aesKey[%s], field_fileId[%s]", new Object[] { paramAnonymouskeep_SceneResult.field_aesKey, paramAnonymouskeep_SceneResult.field_fileId });
          if (paramAnonymouskeep_SceneResult.isUploadBySafeCDNWithMD5())
          {
            v.i("MicroMsg.RecordMsgCDNService", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s], newmd5[%s]", new Object[] { Boolean.valueOf(paramAnonymouskeep_SceneResult.field_upload_by_safecdn), Integer.valueOf(paramAnonymouskeep_SceneResult.field_UploadHitCacheType), Integer.valueOf(paramAnonymouskeep_SceneResult.field_filecrc), paramAnonymouskeep_SceneResult.field_aesKey, paramAnonymouskeep_SceneResult.field_mp4identifymd5 });
            ap.vd().a(new aa(paramAnonymouskeep_SceneResult.field_fileId, paramAnonymouskeep_SceneResult.field_filemd5, paramAnonymouskeep_SceneResult.field_mp4identifymd5, paramAnonymouskeep_SceneResult.field_filecrc, new aa.a()
            {
              public final void H(String paramAnonymous2String, int paramAnonymous2Int1, int paramAnonymous2Int2)
              {
                GMTrace.i(7501294600192L, 55889);
                v.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 callback [%d, %d], [%s]", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
                if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
                {
                  v.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 MM_ERR_GET_AESKEY_FAILED old status[%d, %d, %d]", new Object[] { Integer.valueOf(localg.field_status), Integer.valueOf(localg.field_offset), Integer.valueOf(localg.field_totalLen) });
                  localg.field_offset = 0;
                  localg.field_totalLen = 0;
                  localg.field_status = 0;
                  s.aWy().b(localg, new String[] { "localId" });
                  h.this.a(localg, false);
                  GMTrace.o(7501294600192L, 55889);
                  return;
                }
                localg.field_cdnKey = paramAnonymous2String;
                localg.field_cdnUrl = paramAnonymouskeep_SceneResult.field_fileId;
                s.aWy().b(localg, new String[] { "localId" });
                h.this.aWu();
                GMTrace.o(7501294600192L, 55889);
              }
            }), 0);
            GMTrace.o(7519279775744L, 56023);
            return 0;
          }
          localg.field_cdnKey = paramAnonymouskeep_SceneResult.field_aesKey;
          localg.field_cdnUrl = paramAnonymouskeep_SceneResult.field_fileId;
          s.aWy().b(localg, new String[] { "localId" });
        }
        label765:
        v.e("MicroMsg.RecordMsgCDNService", "transfer error, mediaid=%s, retCode:%d", new Object[] { paramAnonymouskeep_SceneResult.mediaId, Integer.valueOf(paramAnonymouskeep_SceneResult.field_retCode) });
        if (-5103059 == paramAnonymouskeep_SceneResult.field_retCode) {}
        for (localg.field_status = 4;; localg.field_status = 3)
        {
          localg.field_errCode = paramAnonymouskeep_SceneResult.field_retCode;
          s.aWy().b(localg, new String[] { "localId" });
          break;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(7519413993472L, 56024);
        GMTrace.o(7519413993472L, 56024);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(7519548211200L, 56025);
        GMTrace.o(7519548211200L, 56025);
        return null;
      }
    };
    GMTrace.o(7514179502080L, 55985);
  }
  
  public final void a(g paramg, boolean paramBoolean)
  {
    GMTrace.i(7514447937536L, 55987);
    v.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, md5:%s, mediaId:%s, jobType[%d], jobStatus[%s]", new Object[] { paramg.field_dataId, paramg.field_mediaId, Integer.valueOf(paramg.field_type), Integer.valueOf(paramg.field_status) });
    com.tencent.mm.modelcdntran.h localh = new com.tencent.mm.modelcdntran.h();
    localh.hyM = this.hGp;
    localh.field_mediaId = paramg.field_mediaId;
    if (2 == paramg.field_type)
    {
      localh.fZA = true;
      localh.field_priority = b.hxs;
      localh.field_needStorage = false;
      localh.field_totalLen = paramg.field_totalLen;
      localh.field_aesKey = paramg.field_cdnKey;
      localh.field_fileId = paramg.field_cdnUrl;
      localh.hyM = this.hGp;
      localh.field_fullpath = paramg.field_path;
      localh.field_fileType = paramg.field_fileType;
      localh.field_talker = paramg.field_toUser;
      localh.field_force_aeskeycdn = false;
      localh.field_trysafecdn = true;
      localh.field_enable_hitcheck = paramBoolean;
      v.i("MicroMsg.RecordMsgCDNService", "summersafecdn doJob TYPE_UPLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b]", new Object[] { Boolean.valueOf(localh.field_force_aeskeycdn), Integer.valueOf(localh.field_fileType), localh.field_aesKey, localh.field_fileId, Boolean.valueOf(localh.field_force_aeskeycdn), Boolean.valueOf(localh.field_trysafecdn), Boolean.valueOf(localh.field_enable_hitcheck) });
      com.tencent.mm.modelcdntran.g.Em().b(localh);
    }
    for (;;)
    {
      v.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, isSend:%B totallen:%d, aseKey:%s, url[%s], fullPath[%s], fileType[%d], enable_hitcheck[%b], force_aeskeycdn[%b]", new Object[] { Boolean.valueOf(localh.fZA), Integer.valueOf(localh.field_totalLen), localh.field_aesKey, localh.field_fileId, localh.field_fullpath, Integer.valueOf(localh.field_fileType), Boolean.valueOf(localh.field_enable_hitcheck), Boolean.valueOf(localh.field_force_aeskeycdn) });
      GMTrace.o(7514447937536L, 55987);
      return;
      localh.fZA = false;
      localh.field_priority = b.hxt;
      localh.field_needStorage = false;
      localh.field_totalLen = paramg.field_totalLen;
      localh.field_aesKey = paramg.field_cdnKey;
      localh.field_fileId = paramg.field_cdnUrl;
      localh.hyM = this.hGp;
      localh.field_fullpath = (paramg.field_path + ".temp");
      localh.field_fileType = paramg.field_fileType;
      com.tencent.mm.modelcdntran.g.Em().b(localh, -1);
    }
  }
  
  protected final List<g> aWt()
  {
    GMTrace.i(7514313719808L, 55986);
    Object localObject = s.aWy();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((i)localObject).gUp.a("SELECT * FROM RecordCDNInfo WHERE status != 3 AND status != 4 AND status != 2", null, 2);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        g localg = new g();
        localg.b((Cursor)localObject);
        localLinkedList.add(localg);
      }
      ((Cursor)localObject).close();
    }
    v.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    v.d("MicroMsg.RecordMsgCDNService", "get to do jobs, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    GMTrace.o(7514313719808L, 55986);
    return localLinkedList;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/record/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */