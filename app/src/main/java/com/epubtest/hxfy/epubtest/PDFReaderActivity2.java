package com.epubtest.hxfy.epubtest;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;


public class PDFReaderActivity2 extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener, OnDrawListener, OnErrorListener, OnPageScrollListener {

    private PDFView pdfview;
    private SharedPreferences pdfReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfreader2);

        pdfReader = this.getSharedPreferences("PDFReader", Context.MODE_PRIVATE);

        pdfview = (PDFView) findViewById(R.id.pdfView);
        pdfview.fromAsset("test4.pdf")
                .defaultPage(pdfReader.getInt("pages",0))
                .onPageChange(this)
                .swipeHorizontal(false)
                .enableAnnotationRendering(true)
                .scrollHandle(null)
                .onLoad(this)
                .onDraw(this)
                .enableSwipe(true)
                .onError(this)
                .enableDoubletap(true)
                .onPageScroll(this)
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

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onPageScrolled(int page, float positionOffset) {
        //读取百分比
    }
}
