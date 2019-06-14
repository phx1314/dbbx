package com.ab.http;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.ab.util.AbAppUtil;
import com.ab.util.HttpResponseListener;
import com.ab.util.HttpResponseListenerSon;
import com.mdx.framework.config.BaseConfig;
import com.mdx.framework.log.MLog;
import com.mdx.framework.utility.Helper;

import java.io.File;


public class HttpUtil {
    public static AbHttpUtil client = null;
    public static final int TIMEOUT = 50 * 1000;
    public static AbRequestParams params;

    public static void loadUrl(Context context, String methodMode,
                               String methodName, AbHttpResponseListener responseListener, Object... mparams) {
        if (context == null) {
            return;
        }
        if (null == client) {
            client = AbHttpUtil.getInstance(context);
        }
        if (!AbAppUtil.isNetworkAvailable(context)) {
            Helper.toast("无可用网络，请检查网络连接", context);
            return;
        }
        client.setTimeout(TIMEOUT);
        String url;
        if (methodName.startsWith("http:")) {
            url = methodName;
        } else {
            url = BaseConfig.getUri() + "/" + methodName;
        }
        MLog.D(url);
        if (mparams.length > 0) {
            params = new AbRequestParams();
        } else {
            params = null;
        }
        for (int i = 0; i < mparams.length; i++) {
            if (mparams[i] instanceof Object[]) {
                for (int j = 0; j < ((Object[]) mparams[i]).length; j++) {
                    if (((Object[]) mparams[i]).length > j + 1 && ((Object[]) mparams[i])[j + 1] != null) {
                        if (((Object[]) mparams[i])[j + 1] instanceof File) {
                            params.put(((Object[]) mparams[i])[j].toString(), (File) ((Object[]) mparams[i])[j + 1]);
//                            params.put(((Object[]) mparams[i])[j].toString(), "ss", AbFileUtil.File2byte((File) ((Object[]) mparams[i])[j + 1]));
                        } else {
                            params.put(((Object[]) mparams[i])[j].toString(), ((Object[]) mparams[i])[j + 1].toString());
                        }
                    }
                    j++;
                }
            } else {
                if (mparams.length > i + 1 && mparams[i + 1] != null) {
                    if (mparams[i + 1] instanceof File) {
                        params.put(mparams[i].toString(), (File) mparams[i + 1]);
//                        params.put(mparams[i].toString(), "ss", AbFileUtil.File2byte((File) mparams[i + 1]));
                    } else {
                        params.put(mparams[i].toString(), mparams[i + 1].toString());
                    }
                }
                i++;
            }
        }
        if (methodMode.equals("POST")) {
            client.post(url, params, responseListener);
        } else if (methodMode.equals("GET")) {
            client.get(url, params, responseListener);
        }
    }

    public static void loadNoCookie(Context context, String methodMode,
                                    String methodName, AbHttpResponseListener responseListener, boolean noCookie, Object... mparams) {
        if (context == null) {
            return;
        }
        if (null == client) {
            client = AbHttpUtil.getInstance(context);
        }
        if (!AbAppUtil.isNetworkAvailable(context)) {
            Helper.toast("无可用网络，请检查网络连接", context);
            return;
        }
        client.setTimeout(TIMEOUT);
        String url;
        if (methodName.startsWith("http:")) {
            url = methodName;
        } else {
            url = BaseConfig.getUri() + "/" + methodName;
        }
        MLog.D(url);
        if (mparams.length > 0) {
            params = new AbRequestParams();
        } else {
            params = null;
        }
        for (int i = 0; i < mparams.length; i++) {
            if (mparams[i] instanceof Object[]) {
                for (int j = 0; j < ((Object[]) mparams[i]).length; j++) {
                    if (((Object[]) mparams[i]).length > j + 1 && ((Object[]) mparams[i])[j + 1] != null) {
                        if (((Object[]) mparams[i])[j + 1] instanceof File) {
                            params.put(((Object[]) mparams[i])[j].toString(), (File) ((Object[]) mparams[i])[j + 1]);
                        } else {
                            params.put(((Object[]) mparams[i])[j].toString(), ((Object[]) mparams[i])[j + 1].toString());
                        }
                    }
                    j++;
                }
            } else {
                if (mparams.length > i + 1 && mparams[i + 1] != null) {
                    if (mparams[i + 1] instanceof File) {
                        params.put(mparams[i].toString(), (File) mparams[i + 1]);
                    } else {
                        params.put(mparams[i].toString(), mparams[i + 1].toString());
                    }
                }
                i++;
            }
        }
        client.post(url, params, responseListener, noCookie);
    }

    public static void loadUrl(Context context, String methodMode,
                               String methodName, AbHttpResponseListener responseListener, AbRequestParams params) {
        if (context == null) {
            return;
        }
        if (null == client) {
            client = AbHttpUtil.getInstance(context);
        }
        if (!AbAppUtil.isNetworkAvailable(context)) {
            Helper.toast("无可用网络，请检查网络连接", context);
            return;
        }
        client.setTimeout(TIMEOUT);
        String url;
        if (methodName.startsWith("http:")) {
            url = methodName;
        } else {
            url = BaseConfig.getUri() + "/" + methodName;
        }
        MLog.D(url);
        HttpUtil.params = params;
        if (methodMode.equals("POST")) {
            client.post(url, params, responseListener);
        } else if (methodMode.equals("GET")) {
            client.get(url, params, responseListener);
        }
    }

    public static void downLoadFile(Context context,
                                    String url,
                                    AbFileHttpResponseListener responseListener) {
        if (context == null) {
            return;
        }
        if (null == client) {
            client = AbHttpUtil.getInstance(context);
        }
        if (!AbAppUtil.isNetworkAvailable(context)) {
            Toast.makeText(context, "无可用网络，请检查网络连接", Toast.LENGTH_SHORT).show();
            return;
        }
        client.setTimeout(TIMEOUT);
        client.get(url, new AbRequestParams(), responseListener, false);
    }

    public static void loadJsonUrl(Context context,
                                   String methodName, String json,
                                   AbStringHttpResponseListener responseListener) {
        if (context == null) {
            return;
        }
        if (null == client) {
            client = AbHttpUtil.getInstance(context);
        }
        if (!AbAppUtil.isNetworkAvailable(context)) {
            Toast.makeText(context, "无可用网络，请检查网络连接", Toast.LENGTH_SHORT).show();
            return;
        }
        client.setTimeout(TIMEOUT);
        String url;
        if (methodName.startsWith("http:")) {
            url = methodName;
        } else {
            url = BaseConfig.getUri() + "/" + methodName;
        }
        Log.i("i", url);
        client.postJson(url, json, responseListener);
    }

    public static void loadUrlPost(Context context, HttpResponseListenerSon mHttpResponseListenerSon, String methodName, Object... mparams) {
        HttpUtil.loadUrl(context, "POST", methodName, new HttpResponseListener(context, mHttpResponseListenerSon, methodName, true), mparams);
    }


    public static void updateApk(final Activity context, final String url) {
//        F.yShoure(context, "版本更新", "检查到新版本，是否更新", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                final ProgressDialog mProgressDialog = new ProgressDialog(context);
//                mProgressDialog.setMessage(Frame.CONTEXT.getResources().getString(R.string.app_name) + "更新下载中...");
//                mProgressDialog.setMax(100);
//                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//                HttpUtil.downLoadFile(context, url, new AbFileHttpResponseListener() {
//                    @Override
//                    public void onStart() {
//                        mProgressDialog.show();
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        mProgressDialog.dismiss();
//                        installApk(getFile(), context);
//                    }
//
//                    @Override
//                    public void onFailure(int statusCode, String content, Throwable error) {
//                        mProgressDialog.dismiss();
//                        Helper.toast("下载失败" + content, context);
//                    }
//
//                    @Override
//                    public void onProgress(final long bytesWritten, final long totalSize) {
//                        super.onProgress(bytesWritten, totalSize);
//                        mProgressDialog.setProgress((int) (bytesWritten * 100 / totalSize));
//                        Log.i("jindu", (int) (bytesWritten * 100 / totalSize) + "");
//                    }
//                });
//            }
//        });

    }


    public static class DownloadCompleteReceiver extends BroadcastReceiver {
        private DownloadManager manager;

        @Override
        public void onReceive(Context context, Intent intent) {
            manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
            if (intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
                //通过downloadId去查询下载的文件名
                long downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(downloadId);
                Cursor myDownload = manager.query(query);
                if (myDownload.moveToFirst()) {
                    int fileNameIdx = myDownload.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME);
                    String fileName = myDownload.getString(fileNameIdx);
                    installAPK(fileName, context);
                }
            }
        }

        //安装APK
        private void installAPK(String filePath, Context context) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//广播里面操作需要加上这句，存在于一个独立的栈里
            intent.setDataAndType(Uri.fromFile(new File(filePath)), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }

    /**
     * 安装APK文件
     */
    public static void installApk(File apkfile, Context context) {
        if (!apkfile.exists()) {
            return;
        }
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setDataAndType(Uri.parse("file://" + apkfile.toString()), "application/vnd.android.package-archive");
        context.startActivity(i);
    }
}
