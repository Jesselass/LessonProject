package jsoupExample;

import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Dell-SSD on 21.06.2017.
 */
public class TestJsoup {
    @Test
    public void azaza() throws IOException{
        OkHttpClient okHttpClient = new OkHttpClient.Builder().cookieJar(new DefaultCookieStorage())
                .addInterceptor(new UserAgentInterceptor("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")).build();

        okHttpClient.newCall(new Request.Builder().url("http://kismia.com").build()).execute().body().string();


        RequestBody requestBody = new FormBody.Builder()
                .add("email","gendolf2008@gmail.com")
                .add("password","qi2d1g").build();
        Request request = new Request.Builder().post(requestBody).url("https://kismia.com/sign/in").build();
        System.out.println(okHttpClient.newCall(request).execute().body().string());
        for (Cookie cookie: DefaultCookieStorage.cookies ) {
            System.out.println(cookie.name());
        }


        //System.out.println(document.body());
        //Elements select = document.select("img");
        //Element element = select.get(0);
        //System.out.println(element.text());
        //for (Element elem : select  ) {
          //  System.out.println(elem.attr("[src]"));
        //}

    }
}
