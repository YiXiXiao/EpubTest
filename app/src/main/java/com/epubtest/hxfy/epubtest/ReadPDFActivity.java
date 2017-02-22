/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.epubtest.hxfy.epubtest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import java.io.File;

import butterknife.Bind;

public class ReadPDFActivity extends AppCompatActivity {

    private LinearLayout llPdfRoot;

    public static void start(Context context, String filePath) {
        Intent intent = new Intent(context, ReadPDFActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.fromFile(new File(filePath)));
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_pdf);
        llPdfRoot = (LinearLayout) findViewById(R.id.llPdfRoot);
        initToolBar();
        initDatas();

    }

    private int startX = 0;
    private int startY = 0;

    public void initToolBar() {
//        String filePath = Uri.decode(getIntent().getDataString().replace("file://", ""));
//        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.lastIndexOf("."));
//        mCommonToolbar.setTitle(fileName);
//        mCommonToolbar.setNavigationIcon(R.drawable.ab_back);
    }

    public void initDatas() {
//        if (Intent.ACTION_VIEW.equals(getIntent().getAction())) {
//            String filePath = Uri.decode(getIntent().getDataString().replace("file://", ""));

            PDFViewPager pdfViewPager = new PDFViewPager(this, "/storage/emulated/0/test3.pdf");
            llPdfRoot.addView(pdfViewPager);
//        }
    }

}
