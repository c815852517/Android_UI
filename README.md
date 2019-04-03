# 实验三——Android UI组件
## 实验环境
Android Studio 3.2
## 设置主活动
设置四个button跳转至不同的活动：

```
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button button_1=(Button)findViewById(R.id.button1);
    button_1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //在按钮响应函数中添加如下两句话就ok了
            Intent intent=new Intent(com.example.acer.android_ui.MainActivity.this,ListviewActivity.class);
            startActivity(intent);
        }
    });
    Button button_2=(Button)findViewById(R.id.button2);
    button_2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //在按钮响应函数中添加如下两句话就ok了
            Intent intent=new Intent(com.example.acer.android_ui.MainActivity.this,AlertdialogActivity.class);
            startActivity(intent);
        }
    });
    Button button_3=(Button)findViewById(R.id.button3);
    button_3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //在按钮响应函数中添加如下两句话就ok了
            Intent intent=new Intent(com.example.acer.android_ui.MainActivity.this,XmlMenuActivity.class);
            startActivity(intent);
        }
    });
    Button button_4=(Button)findViewById(R.id.button4);
    button_4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //在按钮响应函数中添加如下两句话就ok了
            Intent intent=new Intent(com.example.acer.android_ui.MainActivity.this,ActionModeActivity.class);
            startActivity(intent);
        }
    });
}
```
### 实验结果
![](https://github.com/c815852517/Android_UI/blob/master/app/src/main.png)
## 一、Android ListView的用法
实验重要源码：
```
public class ListviewActivity extends AppCompatActivity {
    //initialize view's
    ListView simpleListView;
    String[] animalName={"Lion","Tiger","Monkey","Dog","Cat","Elephant"};//animal names array
    int[] animalImages={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};//animal images array
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        simpleListView = (ListView) findViewById(R.id.simpleListView);

        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for (int i=0;i<animalName.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("name",animalName[i]);
            hashMap.put("image",animalImages[i]+"");
            arrayList.add(hashMap);//add the hashmap into arrayList
        }

        String[] from={"name","image"};//string array
        int[] to={R.id.name,R.id.img};//int array of views id's
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.activity_listview,from,to);//Create object and set the parameters for simpleAdapter
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView

        //perform listView item click event
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),animalName[i],Toast.LENGTH_LONG).show();//show the selected image in toast according to position
            }
        });
    }
}

```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    <ListView
        android:id="@+id/simpleListView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:divider="#000"
        android:dividerHeight="2sp"
        android:listSelector="#600"
        >
    </ListView>
    <ImageView
        android:id="@+id/img"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:padding="5dp"
        android:layout_alignParentRight="true"
        android:layout_marginRight="10dp" />

    <TextView
        android:id="@+id/name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="10dp"
        android:textColor="#000" />
</RelativeLayout>
```

### 实验结果
![](https://github.com/c815852517/Android_UI/blob/master/app/src/1.png)
## 二、创建自定义布局的AlertDialog
实验重要源码：
AlertDialogActivity.java:
```
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity);
    Button bn=(Button)findViewById(R.id.clickme);

    LayoutInflater inflater=AlertdialogActivity.this.getLayoutInflater();
    View v= inflater.inflate(R.layout.activity_alertdialog,null,false);
    Context context=AlertdialogActivity.this;
    AlertDialog.Builder builder=new AlertDialog.Builder(context);
    //创建AlterDialog对象
    builder.setView(v);
    //输入文本
    builder.setCancelable(false);
    final AlertDialog alertDialog=builder.create();
    //创建对象
    bn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            alertDialog.show();
        }
    });

    v.findViewById(R.id.cancle).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(AlertdialogActivity.this,"cancle",Toast.LENGTH_LONG).show();
            alertDialog.dismiss();
        }
    });
    v.findViewById(R.id.signin).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(AlertdialogActivity.this,"Sign in",Toast.LENGTH_LONG).show();
            alertDialog.dismiss();
        }
    });
}

```
activity_alertdialog.xml:
```
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="50dp"
            android:textColor="#fff"
            android:gravity="center"
            android:background="@drawable/header_logo"
            android:paddingTop="20dp"
            android:paddingBottom="20dp"/>
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:layout_marginTop="10dp">
        <EditText

            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Username"
            android:layout_marginLeft="5dp"
            android:layout_marginRight="5dp"/>
        <EditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Password"
            android:inputType="textPassword"
            android:layout_marginLeft="5dp"
            android:layout_marginRight="5dp"/>
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="10dp">

        <Button
            android:id="@+id/cancle"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="Cancel"
            android:textColor="#000" />
        <Button
            android:id="@+id/signin"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Sign in"
            android:textColor="#000"
            android:gravity="center"
            android:layout_weight="1"/>
    </LinearLayout>

</LinearLayout>

```
### 实验结果
![](https://github.com/c815852517/Android_UI/blob/master/app/src/2.png)
## 三、使用XML自定义菜单
实验重要源码：
XmlMenuActivity.java:
```
public class XmlMenuActivity extends AppCompatActivity {

    private final int size=110;
    private final int common=111;
    private final int color=112;
    private TextView textId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_menu);
        textId=(TextView)findViewById(R.id.textid);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,size,1,"字体大小");
        menu.add(1,common,2,"普通菜单项");
        menu.add(1,color,3,"字体颜色");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case size:
                final AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("设置字体大小");
                builder.setSingleChoiceItems(new String[]{"10号字体","16号字体","20号字体"},-1,new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:textId.setTextSize(10);
                                dialogInterface.dismiss();
                                break;
                            case 1:textId.setTextSize(16);
                                dialogInterface.dismiss();
                                break;
                            case 2:textId.setTextSize(20);
                                dialogInterface.dismiss();
                                break;
                        }
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.show();
                break;
            case common:
                Toast.makeText(this,"你点击了普通菜单项", Toast.LENGTH_LONG).show();
                break;
            case color:
                final AlertDialog.Builder builder2=new AlertDialog.Builder(this);
                builder2.setTitle("设置字体颜色");
                builder2.setSingleChoiceItems(new String[]{"红色","黑色"},-1,new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:textId.setTextColor(Color.RED);
                                dialogInterface.dismiss();
                                break;
                            case 1:textId.setTextColor(Color.BLACK);
                                dialogInterface.dismiss();
                                break;
                        }
                    }
                });
                builder2.setNegativeButton("取消",null);
                builder2.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

```
activity_xml_menu.xml:

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".XmlMenuActivity">
    <TextView
        android:id="@+id/textid"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="用于测试的内容!" />

</android.support.constraint.ConstraintLayout>
```
### 实验结果
![](https://github.com/c815852517/Android_UI/blob/master/app/src/3.1.jpg)
![](https://github.com/c815852517/Android_UI/blob/master/app/src/3.2.jpg)
![](https://github.com/c815852517/Android_UI/blob/master/app/src/3.3.jpg)
![](https://github.com/c815852517/Android_UI/blob/master/app/src/3.4.jpg)
## 四、创建上下文操作模式(ActionMode)的上下文菜单
实验重要源码：

```
public class ActionModeActivity extends ListActivity {

    private String[] data = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten"};
    private SelectionAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionmode_main);

        mAdapter = new SelectionAdapter(this,
                R.layout.activity_action_mode, R.id.textView1, data);
        setListAdapter(mAdapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        getListView().setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            private int nr = 0;

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // TODO Auto-generated method stub
                mAdapter.clearSelection();
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub

                nr = 0;
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu_item, menu);
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // TODO Auto-generated method stub
                switch (item.getItemId()) {

                    case R.id.item_delete:
                        nr = 0;
                        mAdapter.clearSelection();
                        mode.finish();
                }
                return false;
            }

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                // TODO Auto-generated method stub
                if (checked) {
                    nr++;
                    mAdapter.setNewSelection(position, checked);
                } else {
                    nr--;
                    mAdapter.removeSelection(position);
                }
                mode.setTitle(nr + "selected");

            }
        });

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int position, long arg3) {
                // TODO Auto-generated method stub

                getListView().setItemChecked(position, !mAdapter.isPositionChecked(position));
                return false;
            }
        });
    }

    private class SelectionAdapter extends ArrayAdapter<String> {

        private HashMap<Integer, Boolean> mSelection = new HashMap<Integer, Boolean>();

        public SelectionAdapter(Context context, int resource,
                                int textViewResourceId, String[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        public void setNewSelection(int position, boolean value) {
            mSelection.put(position, value);
            notifyDataSetChanged();
        }

        public boolean isPositionChecked(int position) {
            Boolean result = mSelection.get(position);
            return result == null ? false : result;
        }

        public Set<Integer> getCurrentCheckedPosition() {
            return mSelection.keySet();
        }

        public void removeSelection(int position) {
            mSelection.remove(position);
            notifyDataSetChanged();
        }

        public void clearSelection() {
            mSelection = new HashMap<Integer, Boolean>();
            notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = super.getView(position, convertView, parent);//let the adapter handle setting up the row views
            v.setBackgroundColor(getResources().getColor(android.R.color.background_light)); //default color

            if (mSelection.get(position) != null) {
                v.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));// this is a selected position so make it red
            }
            return v;
        }
    }

```
activity_action_mode.xml:

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:layout_gravity="center_vertical"
    android:padding="5dp"
    android:background="@android:color/background_light" >

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@mipmap/ic_launcher" />

    <TextView
        android:id="@+id/textView1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="17sp"
        android:layout_marginLeft="10dp"
        android:text="Test"
        android:textStyle="bold" />

</LinearLayout>
```
### 实验结果
![](https://github.com/c815852517/Android_UI/blob/master/app/src/4.png)

