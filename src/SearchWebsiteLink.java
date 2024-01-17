import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SearchWebsiteLink {

    public static void main(String[] args) throws IOException {
        WebsiteContentReader readContent= new WebsiteContentReader();

        URL url = new URL("https://www.kodeco.com/");
        String findWord ="lion";
        Scanner input = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();

        ArrayList<String> traversedAl = new ArrayList<>();
        ArrayList<String> pendingAl = new ArrayList<>();

        boolean finding = false;
        while (input.hasNext() && !finding && traversedAl.size()<100) {
            String TemStingBuffer=input.next();
            sb.append(input.next());
            //System.out.print(input.next());
            if(TemStingBuffer.contains("href=\"https:") )//&& links.size()<10)
            {
                // System.out.println("TemStingBuffer  "+TemStingBuffer);
                if(!pendingAl.contains(getSubSting(TemStingBuffer)))
                {
                    pendingAl.add( getSubSting(TemStingBuffer));
                }
                for (String hrefList:pendingAl) {
                    System.out.println("hrefList "+hrefList);
                }
     //    System.out.println("initial pendingAl "+pendingAl.size());
                for(int i = 0; i<pendingAl.size();i++){
                    String test= readContent.getFullSting(getSubSting(TemStingBuffer),findWord);
//                    System.out.println("test "+test);
                    if(test!=null && test.contains(findWord)){
                        System.out.println("findWord  "+findWord );
                        System.out.println("getting link "+getSubSting(TemStingBuffer));
                        finding = true;
                        //   pendingAl.get(i).
                    }else{
                        traversedAl.add(getSubSting(TemStingBuffer));
                        pendingAl.remove(i);
                    }
                }

            }

        }
        if(!finding){
            System.out.println(findWord +" not found");
        }
        System.out.println("pendingAl.size() "+pendingAl.size() +" traversedAl "+traversedAl.size());

    }
    public static String getSubSting(String link) {

        int firstQuoteIndex = link.indexOf("\"");
        int secondQuoteIndex = link.indexOf("\"", firstQuoteIndex + 1);
        String result="";
        if (firstQuoteIndex != -1 && secondQuoteIndex != -1) {
            result = link.substring(firstQuoteIndex + 1, secondQuoteIndex);
            //System.out.println("Substring between quotes: " + result);
        } else {
            System.out.println("Double quotes not found.");
        }
        return result;
    }
}
