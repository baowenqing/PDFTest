package com.example.admin.pdf2;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;

import java.io.File;

public class PdfViewerActivity extends AppCompatActivity implements OnPageChangeListener {


    private PDFView pdf;
    private TextView tvPage;
    private String pdfName = "111.pdf";
    int position = 0;
    int pageCount = -1;
    private PDFView.Configurator configurator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
        pdf = (PDFView) findViewById(R.id.pdfView);
        tvPage = (TextView) findViewById(R.id.tv_page);


        Button shang = (Button) findViewById(R.id.shang);
        Button xia = (Button) findViewById(R.id.xia);
        shang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                cheakCount(position);
            }
        });

        xia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                cheakCount(position);
            }
        });

        //Asserts资源查看
        configurator = pdf.fromFile(new File(Environment.getExternalStorageDirectory(), pdfName));

        configurator.defaultPage(position)
                .enableSwipe(true)
                .swipeHorizontal(true)
                .onPageChange(this)
                .load();
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        position = page;
        this.pageCount = pageCount;
        tvPage.setText((page+1) + "/" + pageCount);
    }


    void cheakCount(int position) {
        if (position > pageCount-1) {
            Toast.makeText(this, "没有更多了！", Toast.LENGTH_SHORT).show();
        } else if (position < 1) {
            Toast.makeText(this, "错误啦！", Toast.LENGTH_SHORT).show();
        } else {
            pdf.jumpTo(position);
        }
    }

}