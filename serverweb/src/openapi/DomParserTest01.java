package openapi;
//컨테이너는 내부에서 무슨 일을 할까?

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParserTest01 {

	public static void main(String[] args) throws Exception {
		//Parser생성기
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//Dom Parser
		DocumentBuilder domparser = factory.newDocumentBuilder();
		
		//Parser의 parse 메소드를 호출하면 xml을 분석해서 Dom객체로 만들어서 반환
		Document document = domparser.parse("src/openapi/dept.xml");
		
		//root 엘리먼트. getDocumentElement하면 엘리먼트가 반환된다.
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName()); 
		
		//dept엘리먼트 추출
		NodeList nodelist =  root.getElementsByTagName("dept");
		//노드리스트 타입으로 데이터 받아내기. 노드리스트는 어레이리스트 같은 것
		System.out.println(nodelist.getLength());
		
		for(int i=0; i<nodelist.getLength();i++) {
			
			Node node = nodelist.item(i);
			System.out.println("노드명: "+node.getNodeName());
		}
	}

}
