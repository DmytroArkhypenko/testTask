import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class GetPage {

    public static final Document getPage() throws IOException {
        String url = "https://www.aboutyou.de/maenner/bekleidung";

        //this way unfortunately we can get only first preloaded 16 items of the market page as i haven't found the soulution without using Selenium to load full page
        final Document page = Jsoup.connect(url)
                             .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36")
                             .timeout(60000)
                             .maxBodySize(0)
                             .get();
        return page;
    }
}
