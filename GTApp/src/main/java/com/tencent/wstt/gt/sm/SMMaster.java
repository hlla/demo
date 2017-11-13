package com.tencent.wstt.gt.sm;

import android.content.Context;
import android.text.TextUtils;

import com.tencent.wstt.gt.R;
import com.tencent.wstt.gt.actors.BaseActor;
import com.tencent.wstt.gt.actors.PackageActor;
import com.tencent.wstt.gt.api.utils.Env;
import com.tencent.wstt.gt.helper.RootChecker;
import com.tencent.wstt.gt.internal.GTMemoryDaemonHelper;
import com.tencent.wstt.gt.log.GTGWInternal;
import com.tencent.wstt.gt.log.GWSaveEntry;
import com.tencent.wstt.gt.manager.OpUIManager;
import com.tencent.wstt.gt.utils.Const;
import com.tencent.wstt.gt.utils.FileUtil;
import com.tencent.wstt.gt.utils.StringUtil;

import java.io.File;
import java.util.concurrent.ExecutorService;

/**
 * Created by ChenGong on 23/10/2017
 */

public class SMMaster extends BaseActor {
    private PackageActor packageActor;
    private boolean rooted;
    private ToggleServiceTask orderedTask;

    public SMMaster(Context mContext) {
        super(mContext);
        initialize();
    }

    @Override
    public void initialize() {
        super.initialize();
        ProcessActor processActor = new ProcessActor(mContext);
        packageActor = new PackageActor(mContext);
        orderedTask = new ToggleServiceTask(processActor, mContext, mExecutor);
        packageActor.setFinishTask(new Runnable() {
            @Override
            public void run() {
                rooted = RootChecker.check();
                if (!rooted) {
                    SMMaster.this.toast(mContext, "SM needs Root!!!");
                } else {
                    orderedTask.run();
                }
            }
        });
    }

    public void toggleSMServiceStatus(boolean start) {
        toast(mContext, (start ? "Starting " : "Ending ") + "inspect SM of:" + Const.PKG_NAME);
        orderedTask.start = start;
        if (start) {
            packageActor.act();
        } else {
            if (rooted) {
                orderedTask.run();
            }
        }
    }

    class ToggleServiceTask implements Runnable {
        boolean start;
        ProcessActor processActor;
        Context ctx;
        ExecutorService executorService;

        public ToggleServiceTask(ProcessActor processActor, Context ctx, ExecutorService executorService) {
            this.processActor = processActor;
            this.ctx = ctx;
            this.executorService = executorService;
        }

        @Override
        public void run() {
            if (start) {
                if (!GTMemoryDaemonHelper.startGWOrProfValid()) {
                    return;
                }
            } else {
                save2Local(ctx, executorService);
            }
            OpUIManager.gw_running = start;
            processActor.toggleSMServiceStatus(start);
        }

        void save2Local(Context ctx, ExecutorService executorService) {
            OpUIManager.list_change = true;
            String path2 = Env.CUR_APP_VER;
            String path1 = Env.CUR_APP_NAME;
            String testDesc = StringUtil.getCurrentLocalDateTimeStamp() + "_tag_" +
                    (TextUtils.isEmpty(Const.FILE_TAG) ? "" : Const.FILE_TAG);
            System.out.println("SM" + testDesc);
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    // 先判断保存路径参数是否完整
                    String path3 = StringUtil.notEmptyAOrB(Const.FOLDER_TAG
                            , StringUtil.notEmptyAOrB(GTGWInternal.getLastSaveFolder(), ""));
                    if (TextUtils.isEmpty(path3)) {
                        path3 = StringUtil.notEmptyAOrB(path3, ctx.getResources().getString(R
                                .string.gw_root_folder_clear));
                        File path = new File(path3);
                        if (!path.exists()) {
                            FileUtil.createDir(path);
                            GTGWInternal.setLastSaveFolder(path.toString());
                        }
                    }
                    System.out.println("PATH::" + path3);

                    GWSaveEntry saveEntry = new GWSaveEntry(path1, path2, path3, testDesc);
                    String keyToDeleteHistoryData = "SM:" + Const.PKG_NAME;
                    GTGWInternal.saveAllEnableGWData(saveEntry, keyToDeleteHistoryData);
                }
            });
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        packageActor.dispose();
    }
}
