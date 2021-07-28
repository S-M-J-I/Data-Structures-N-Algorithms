package graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * ---------------- Webcrawler----------------
 *      -> Vertex is root links and the links that are present in the webpage source
 *      -> If the link is not visited
 *      -> add to a list of visited websites
 *      -> then add to queue
 * */


class Webcrawler{
//    queue to store websites
    private Queue<String> queue;
//    list to check is website is visited or not
    private List<String> discoveredWebsites;

    Webcrawler(){
        this.queue = new LinkedList<>();
        this.discoveredWebsites = new ArrayList<>();
    }


    public void discoverWeb(String root){
        this.queue.add(root);
        this.discoveredWebsites.add(root);

        while (!queue.isEmpty()){
//            dequeue string
            String presentWebsite = queue.remove();
//            convert into html
            String rawHTML = readURL(presentWebsite);

//            look for anything that has this regex, an http:// or www.
            String regex = "https://(\\w+\\.)*(\\w+)";
//            compile the regex
            Pattern pattern = Pattern.compile(regex);
//            matcher will store the regex which will be searched for and found
            Matcher matcher = pattern.matcher(rawHTML);

//            while the matcher finds the regex
            while (matcher.find()){
//                it will group the url with regex
                String actualURL = matcher.group();

//                and if the actualURL has not been visited yet,
                while (!discoveredWebsites.contains(actualURL)){
//                    add it to the discovered websites
                    discoveredWebsites.add(actualURL);
//                    print it
                    System.out.println("Website has been found : " + actualURL);
//                    add it to the vertex queue
                    queue.add(actualURL);
                }
            }

        }
    }


//    read the url
    private String readURL(String vertex){

        // Empty raw html
        String rawHTML = "";

//        in a try-catch block,
        try{

//            read the vertex url
            URL url = new URL(vertex);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));


            String s = "";
//            while there is still something to read from the webpage,
            while ((s = in.readLine()) != null){
//                append it to the raw html
                rawHTML += s;
            }

//            close the buffered reader
            in.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return rawHTML;

    }

}

public class WebcrawlerApp {

    public static void main(String[] args) {

//        create a webcrawler
        Webcrawler webcrawler = new Webcrawler();
        webcrawler.discoverWeb("https://www.bbc.com/");

    }

}
