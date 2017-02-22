package com.epubtest.hxfy.epubtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.folioreader.activity.FolioActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_epub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FolioActivity.class);
                intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_TYPE, FolioActivity.EpubSourceType.RAW);
                intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_PATH, R.raw.test2);
                startActivity(intent);
            }
        });

        findViewById(R.id.bt_pdf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PDFReaderActivity.class);
                intent.putExtra("path", R.raw.test3);
                startActivity(intent);
            }
        });

        findViewById(R.id.bt_pdf2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReadPDFActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt_pdf4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PDFReaderActivity2.class);
                startActivity(intent);
            }
        });



    }
}
