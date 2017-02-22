package com.epubtest.hxfy.epubtest;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnDrawListener;
import com.joanzapata.pdfview.listener.OnLoadCompleteListener;
import com.joanzapata.pdfview.listener.OnPageChangeListener;


public class PDFReaderActivity extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener, OnDrawListener {

    private PDFView pdfview;
    private SharedPreferences pdfReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfreader);

        pdfReader = this.getSharedPreferences("PDFReader", Context.MODE_PRIVATE);

        pdfview = (PDFView) findViewById(R.id.pdfView);
        pdfview.fromAsset("test4.pdf")
                .defaultPage(pdfReader.getInt("pages",0))
                .onPageChange(this)
                .onLoad(this)
                .onDraw(this)
                .showMinimap(false)
                .swipeVertical(false)
                .enableSwipe(true)
                .load();
    }

    /**
     * 记录当前阅读到哪一页
     * @param page
     * @param pageCount
     */
    @Override
    public void onPageChanged(int page, int pageCount) {
        SharedPreferences.Editor edit = pdfReader.edit();
        edit.putInt("pages",page);
        edit.commit();
    }

    /**
     * 加载完成
     * @param nbPages
     */
    @Override
    public void loadComplete(int nbPages) {

    }

    /**
     * 绘制完成
     * @param canvas
     * @param pageWidth
     * @param pageHeight
     * @param displayedPage
     */
    @Override
    public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {

    }
}
