import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Dell-SSD on 14.06.2017.
 */
public class TestHttp {
    OkHttpClient okHttpClient = new OkHttpClient();

    @Test
    public void alalal() throws IOException {
        Request request = new Request.Builder().url("http://www.whoishostingthis.com/tools/user-agent").build();
        Response response = okHttpClient.newCall(request).execute();


        System.out.println("     Code    ");
        System.out.println(response.code());


        System.out.println("    Headers   ");
        System.out.println(response.headers());


        System.out.println("     Body    ");
        System.out.println(response.body().string());

    }
}
