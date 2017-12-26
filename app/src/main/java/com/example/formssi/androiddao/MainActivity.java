package com.example.formssi.androiddao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.dao.DaoSupportFactory;
import org.dao.IDaoSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoSupportFactory.initDao("daoName");

        IDaoSupport<TestBean> daoSupport = DaoSupportFactory.get().getDao(TestBean.class);


        daoSupport.insert(new TestBean("zhangsan", 18));

        daoSupport.insert(new TestBean("lisi", 18));

        daoSupport.delete("name = ?", "lisi");

        List<TestBean> datas = daoSupport.querySupport().selection("name = ?").selectionArgs("lisi").query();

    }
}
