package com.alleyz.data.xml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alleyz.layout.R;

import org.json.JSONArray;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Mr on 2015/12/25.
 */
public class SimpleXmlActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim_xml);
        tv = (TextView) findViewById(R.id.tvXml);
         findViewById(R.id.btnXml).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            InputStream is = getAssets().open("test.xml");
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=factory.newDocumentBuilder();
            Document doc=documentBuilder.parse(is);
            Element root=doc.getDocumentElement();
            NodeList nl=root.getElementsByTagName("UserInfo");
            List<Map<String,String>> userInfoList=new ArrayList<>();
            for(int i=0;i<nl.getLength();i++){
                Node infoNode=nl.item(i);
                Map<String,String> map=new HashMap<>();
                Element userInfo=(Element)infoNode;
                String id=userInfo.getAttribute("id");
                map.put("id",id);
                NodeList nodeList=infoNode.getChildNodes();
                for(int j=0;j<nodeList.getLength();j++){
                    Node node=nodeList.item(j);
                    if(node instanceof Element) {
                        Log.i("", node.getNodeName());
                        map.put(node.getNodeName(), node.getTextContent());
                    }
                }
                userInfoList.add(map);
            }
            String json= JSON.toJSONString(userInfoList);
            tv.setText(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
