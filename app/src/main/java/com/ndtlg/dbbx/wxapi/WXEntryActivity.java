package com.ndtlg.dbbx.wxapi;

import com.umeng.socialize.weixin.view.WXCallbackActivity;

public class WXEntryActivity extends WXCallbackActivity {
//	private String code;
//	private IWXAPI api;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
////		api = WXAPIFactory.createWXAPI(WXEntryActivity.this, Constants.APP_ID);
//		api.handleIntent(getIntent(), WXEntryActivity.this);
//	}
//
//	// @Override
//	// protected void onNewIntent(Intent intent) {
//	// super.onNewIntent(intent);
//	// handleIntent(intent);
//	// }
//
//	private void handleIntent(Intent intent) {
//		SendAuth.Resp resp = new SendAuth.Resp(intent.getExtras());
//		if (resp.errCode == BaseResp.ErrCode.ERR_OK) {
//			code = ((SendAuth.Resp) resp).code;
//			Intent in = new Intent();
//			in.setAction("weixinCode");
//			in.putExtra("code", code);
//			sendBroadcast(in);
//		}
//		this.finish();
//	}
//
//	/**
//	 * 分享成功
//	 */
//	public void getShareSuccess() {
//		try {
//			F.mCallBackShareJieKou.goReturnDo(F.ShareId);
//		} catch (Exception e) {
//		}
//		finish();
//	}
//
//	@Override
//	public void onReq(BaseReq arg0) {
//
//	}
//
//	@Override
//	public void onResp(BaseResp resp) {
//		switch (resp.errCode) {
//		case BaseResp.ErrCode.ERR_OK:
//			if (F.isShare == 2) {
//				Toast.makeText(this, "分享成功", Toast.LENGTH_LONG).show();
//				getShareSuccess();
//			}
//
//			break;
//		case BaseResp.ErrCode.ERR_USER_CANCEL:
//			Toast.makeText(this, "分享取消", Toast.LENGTH_LONG).show();
//			finish();
//			break;
//		case BaseResp.ErrCode.ERR_AUTH_DENIED:
//			Toast.makeText(this, "分享被拒绝", Toast.LENGTH_LONG).show();
//			finish();
//			break;
//		default:
//			Toast.makeText(this, "分享返回", Toast.LENGTH_LONG).show();
//			break;
//		}
//
//	}

}
