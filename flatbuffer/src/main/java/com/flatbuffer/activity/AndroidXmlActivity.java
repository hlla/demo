package com.flatbuffer.activity;//package com.flatbuffer.activity;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.os.Environment;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.ListView;
//import android.widget.SimpleAdapter;
//import android.widget.Toast;
//
//import com.iteye.androidtaost.model.Person;
//import com.iteye.androidtaost.service.ParseService;
//import com.iteye.androidtoast.resolver.Dom;
//import com.iteye.androidtoast.resolver.Pull;
//import com.iteye.androidtoast.resolver.Sax;
//
//public class AndroidXmlActivity extends Activity implements OnClickListener{
//
//
//	private ListView mListView;
//	FileInputStream fis=null;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        findViewById(R.id.sax).setOnClickListener(this);
//        findViewById(R.id.dom).setOnClickListener(this);
//        findViewById(R.id.pull).setOnClickListener(this);
//
//        mListView = (ListView) findViewById(R.id.persons_listview);
//    }
//
//	@Override
//	public void onClick(View v) {
//
//		ParseService ps=null;
//		List<Person> persons=null;
//		Person p=null;
//		try {
//			if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
//				File newFile =new File(Environment.getExternalStorageDirectory(),"persons.xml");
//				fis=new FileInputStream(newFile);
//			}else {
//				Toast.makeText(this, "SD������������", 1);
//				return;
//			}
//		} catch (FileNotFoundException e) {
//			Toast.makeText(this, "�ļ�������", 1);
//			e.printStackTrace();
//		}
//		int id=v.getId();
//		if(id==R.id.sax){
//			ps=new Sax();
//			p=new Person(4,"lilei",54);
//		}else if(id==R.id.dom){
//			ps=new Dom();
//			p=new Person(5,"jack",32);
//		}else if(id==R.id.pull){
//			ps=new Pull();
//			p=new Person(6,"Lucy",14);
//		}
//		persons=ps.doParse(fis);
//		persons.add(p);
//		refreshListView(persons);
//	}
//	/**
//	 * ˢ���б���ͼ
//	 */
//	private void refreshListView(List<Person> persons){
//		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
//		Map<String,Object> map=null;
//		for(Person p:persons){
//			map=new HashMap<String,Object>();
//			map.put("id", p.id);
//			map.put("name", p.name);
//			map.put("age", p.age);
//			data.add(map);
//		}
//		//����������
//		SimpleAdapter sa=new SimpleAdapter(this,
//				 						   data,
//				 						   R.layout.person_listview_item,
//				 						   new String[]{"id","name","age"},
//				 						   new int[]{R.id.id_textview,R.id.name_textview,R.id.age_textview});
//		mListView.setAdapter(sa);
//	}
//}