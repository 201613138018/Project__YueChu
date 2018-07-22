package com.example.yuechu.page_my;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.yuechu.R;

import java.util.ArrayList;

public class MenuActivity extends Activity {

    ArrayList<Material> menu = new ArrayList<Material>();
    ArrayList<String> step_str = new ArrayList<String>();
    ArrayList<String> steppic_str = new ArrayList<String>();
    Menu Menu;
    boolean tag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button write = (Button) findViewById(R.id.Write);
        ImageButton returnbtn = (ImageButton) findViewById(R.id.ImageButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.Write:
                        JumptoInsert();
                        break;
                    case R.id.ImageButton:
                        finish();
                        break;
                }
            }
        };

        write.setOnClickListener(listener);
        returnbtn.setOnClickListener(listener);
        if(tag){
            Uri uri2 = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + getResources().getResourcePackageName(R.drawable.pipixia) + "/"
                    + getResources().getResourceTypeName(R.drawable.pipixia) + "/"
                    + getResources().getResourceEntryName(R.drawable.pipixia));
            Material material2=new Material("油焖皮皮虾",uri2.toString());
            menu.add(material2);

            Uri uri3 = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + getResources().getResourcePackageName(R.drawable.niurou) + "/"
                    + getResources().getResourceTypeName(R.drawable.niurou) + "/"
                    + getResources().getResourceEntryName(R.drawable.niurou));
            Material material3=new Material("法式牛排",uri3.toString());
            menu.add(material3);

            Uri uri4 = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + getResources().getResourcePackageName(R.drawable.tiandian) + "/"
                    + getResources().getResourceTypeName(R.drawable.tiandian) + "/"
                    + getResources().getResourceEntryName(R.drawable.tiandian));
            Material material4=new Material("宫廷甜点",uri4.toString());
            menu.add(material4);
        }

        MenuAdapter menuAdapter = new MenuAdapter(MenuActivity.this, R.layout.menuitem, menu);
        ListView menulistView = (ListView) findViewById(R.id.Menulistview);
        menulistView.setAdapter(menuAdapter);


        menuAdapter.setOnItemClickListener(new MenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Material material, int position) {
                Intent intent2 = new Intent(MenuActivity.this, DisplayActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("Menu", Menu);
                intent2.putExtras(bundle2);
                startActivity(intent2);
            }
        });
    }

    //    跳转到新建菜谱界面
    public void JumptoInsert() {
        Intent intent = new Intent(MenuActivity.this, InsertMenuActivity.class);
        startActivityForResult(intent, 100);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                Menu = (Menu) bundle.getSerializable("Menu");
                Material menu1 = new Material(Menu.getStep_list().get(0), Menu.getSteppic_list().get(0));
                menu.add(menu1);
                tag=false;
                onCreate(null);
            }
        }
    }
}
