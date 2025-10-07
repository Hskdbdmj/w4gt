package com.example.maktabatnihad;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class PdfActivity extends AppCompatActivity {
    PDFView pdfView;
    Button nextBtn, prevBtn;
    TextView footer;
    int currentPage = 0;
    int totalPages = 0;
    String type, name, assetFileName;
    File pdfFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        pdfView = findViewById(R.id.pdfView);
        nextBtn = findViewById(R.id.btnNext);
        prevBtn = findViewById(R.id.btnPrev);
        footer = findViewById(R.id.footer);

        type = getIntent().getStringExtra("type");
        name = getIntent().getStringExtra("name");
        assetFileName = PDFLinks.getAssetName(type, name);
        totalPages = PDFLinks.getPages(type, name);

        if(assetFileName == null){
            Toast.makeText(this, "لا يوجد الملف محلياً، رجاءً ضع ملفات الـ PDF في مجلد assets/ واسمها كما في README", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        // copy asset to cache and display
        try {
            InputStream is = getAssets().open(assetFileName);
            pdfFile = new File(getCacheDir(), assetFileName);
            FileOutputStream fos = new FileOutputStream(pdfFile);
            byte[] buffer = new byte[4096];
            int len;
            while ((len = is.read(buffer)) > 0) fos.write(buffer, 0, len);
            fos.close();
            is.close();
        } catch (Exception e){
            Toast.makeText(this, "خطأ أثناء قراءة الملف: " + e.getMessage(), Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        displayPage(currentPage);

        nextBtn.setOnClickListener(v -> {
            if(currentPage < totalPages - 1) {
                currentPage++;
                displayPage(currentPage);
            }
        });

        prevBtn.setOnClickListener(v -> {
            if(currentPage > 0) {
                currentPage--;
                displayPage(currentPage);
            }
        });
    }

    private void displayPage(int pageIndex){
        if(pdfFile == null || !pdfFile.exists()) return;
        pdfView.fromFile(pdfFile)
                .defaultPage(pageIndex)
                .enableSwipe(false)
                .load();
        footer.setText("© المطور: نهاد خالد | صفحة " + (pageIndex+1) + " / " + totalPages);
    }
}
