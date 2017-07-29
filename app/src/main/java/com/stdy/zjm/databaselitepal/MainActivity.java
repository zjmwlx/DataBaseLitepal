package com.stdy.zjm.databaselitepal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnCreatDataBase;
    private Button btnAddData;
    private Button btnUpdata;
    private Button btnDelete;
    private Button btnFindData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCreatDataBase = (Button) findViewById(R.id.btn_creatDataBase);
        btnAddData = (Button) findViewById(R.id.btn_addData);
        btnUpdata = (Button) findViewById(R.id.btn_Updata);
        btnDelete = (Button) findViewById(R.id.btn_Delete);
        btnFindData = (Button) findViewById(R.id.btn_FindData);


        btnAddData.setOnClickListener(this);
        btnCreatDataBase.setOnClickListener(this);
        btnUpdata.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnFindData.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_creatDataBase:
                Connector.getDatabase();
                break;
            case R.id.btn_addData:
                Book book = new Book();
                book.setAuthor("zhangjm");
                book.setBookName("傻逼是怎么炼成的");
                book.setId(1);
                book.setPages(500);
                book.setPrice(300);
                book.setPress("天朝出版社");
                book.save();
                break;
            case R.id.btn_Updata:
                book = new Book();
                book.setAuthor("zhangjm");
                book.setBookName("《傻逼论》");
                book.setId(1);
                book.setPages(5);
                book.setPrice(3);
                book.setPress("天朝人民出版社");
                book.updateAll();
                break;
            case R.id.btn_Delete:
                DataSupport.deleteAll(Book.class);
                break;
            case R.id.btn_FindData:
                List<Book>  books = DataSupport.findAll(Book.class);
                for (Book book1:books){
                    Log.i("zjm","book name is"+book1.getBookName());
                    Log.i("zjm","book author is"+book1.getAuthor());
                    Log.i("zjm","book pages is"+book1.getPages());
                    Log.i("zjm","book press is"+book1.getPress());
                    Log.i("zjm","book price is"+book1.getPrice());
                    Log.i("zjm","book id is"+book1.getId());
                }

        }
    }
}
