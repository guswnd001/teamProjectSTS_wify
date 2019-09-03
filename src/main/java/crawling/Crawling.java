package crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.Crawling_product;



public class Crawling {
	public static void main(String[] args) {
        String url = "http://category.gmarket.co.kr/listview/List.aspx?gdmc_cd=200001065&ecp_gdlc=&ecp_gdmc=";
        Document doc = null;
        Map<Object, Object> crawlingMap = new HashMap<Object, Object>();
        
        List title = new ArrayList();
        List price = new ArrayList();
        List brand = new ArrayList();
        List<Crawling_product> product = new ArrayList<Crawling_product>();
        
        int index = 0;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 주요 뉴스로 나오는 태그를 찾아서 가져오도록 한다.;
        Elements element = doc.select("div.wrap li");
        // 1. 헤더 부분의 제목을 가져온다.
//        String title = element.select("div#powerClick.item_type").text().substring(0, 4);
        System.out.println("============================================================");
//        System.out.println(title);
           for(int i = 0 ; i < element.select("span.title").size() ; i++) {
              if(element.select("span.title").get(i).text().startsWith("[") == true) {
                product.add(new Crawling_product(element.select("span.title").get(i).text(),
                						element.select("div.price_info a").get(i).text().substring(0,element.select("div.price_info a").get(i).text().length()-1),
                						element.select("span.title").get(i).text().split("]")[0].substring(1)));              
              }else {
                 continue;
              }
           }
           
           
           for(int i = 0 ; i < product.size() ; i++) {
              System.out.println("/상품명: " + product.get(i).getTitle() + " /가격: " + product.get(i).getPrice() + " /상표: " + product.get(i).getBrand());
           }   
           
       System.out.println("============================================================");          
//           for(Element titleEl : element.select("span.title")) {
//              if(titleEl.text().startsWith("[") == true)
//              title.add(titleEl.text());
//           }
//
//           for(Element priceEl : element.select("div.price_info a")) {
//              
//              price.add(priceEl.text());
//              
//           }
//           for(Element brandEl : element.select("span.brand")) {
//              brand.add(brandEl.text());
//           }
        
//        System.out.println(product.size());
//
//        for(int i = 0 ; i < title.size() ; i++) {
//           crawlingMap.put(product.get(i).getTitle(), product.get(i).getPrice());
//        }
//        
//        for(int i = 0 ; i < title.size() ; i++) {
//           crawlingMap.put(product.get(i).getTitle(), product.get(i).getPrice());
//        }

//        System.out.println("map값============================================================");
//        for ( Object key : crawlingMap.keySet() ) {
//            System.out.println("상품 : " + key +" / 가격 : " + crawlingMap.get(key));
//            System.out.println("\n");
//       
//        }
    }


}
