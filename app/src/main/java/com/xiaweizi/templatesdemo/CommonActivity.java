package com.xiaweizi.templatesdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class CommonActivity extends AppCompatActivity {

    private static final int MSG_UPDATE = 122;

    private TextView mTvCount;
    private MyHandler mHandler;
    private Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        mTvCount = findViewById(R.id.tv_count);
        mHandler = new MyHandler(this);
        mHandler.sendEmptyMessage(MSG_UPDATE);
    }

    static class MyHandler extends Handler {
        WeakReference<CommonActivity> mActivity;

        MyHandler(CommonActivity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            CommonActivity theActivity = mActivity.get();
            if (theActivity == null || theActivity.isFinishing()) {
                return;
            }
            switch (msg.what) {
                case MSG_UPDATE:
                    theActivity.count += 1;
                    theActivity.mHandler.sendEmptyMessageDelayed(MSG_UPDATE, 50);
                    theActivity.mTvCount.setText(theActivity.count + "");
                    break;
                default:
                    break;
            }
        }
    }


}
