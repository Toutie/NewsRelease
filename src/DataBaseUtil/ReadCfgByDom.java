package DataBaseUtil;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadCfgByDom {

	private static DocumentBuilderFactory dbFactory =null;
	private static DocumentBuilder db = null;
	private static Document document = null;
	//写成list的形式便于扩展
	private static List<DataBaseCfg> dbCfgs = new ArrayList<DataBaseCfg>();
	
	static{
		try{
			dbFactory = DocumentBuilderFactory.newInstance();
			db = dbFactory.newDocumentBuilder();
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}
	}
	
	public static List<DataBaseCfg> getDbCfg(String fileName) throws Exception{
		//给定URI的内容解析为一个XML文档，并返回Document对象
		document = db.parse(fileName);
		
		NodeList nodeList = document.getElementsByTagName("session-Factory");
		
		//遍历节点
		for(int i=0;i<nodeList.getLength();i++){
			Node cnode = nodeList.item(i);
			NodeList cnodeList = cnode.getChildNodes();
			
			List<String> content = new ArrayList<String>();;
			for(int j=0;j<cnodeList.getLength();j++){
				if(cnodeList.item(j).getNodeType()== Node.ELEMENT_NODE){
					String value = null;
					value = (String)cnodeList.item(j).getFirstChild().getNodeValue();
					if(value.getBytes().length!=0){
						System.out.println(value);
						content.add(value);
					}
				}
			}
			
			
			if(content.size()>0){
				DataBaseCfg dbCfg = new DataBaseCfg();
				dbCfg.setDriver(content.get(0));
				dbCfg.setUrl(content.get(1));
				dbCfg.setUsername(content.get(2));
				dbCfg.setPassword(content.get(3));
				dbCfgs.add(dbCfg);
			}
			
		}
		
		
		return dbCfgs;
	}
	
}
