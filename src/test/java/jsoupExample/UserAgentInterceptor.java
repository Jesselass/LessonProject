package jsoupExample;


        import okhttp3.Interceptor;
        import okhttp3.Request;
        import okhttp3.Response;

        import java.io.IOException;

/**
 * Created by lolik on 25.01.17.
 */
public class UserAgentInterceptor implements Interceptor {

    private final String userAgent;

    public UserAgentInterceptor(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request requestWithUserAgent = originalRequest.newBuilder()
                .header("User-Agent", userAgent)
                .build();
        return chain.proceed(requestWithUserAgent);
    }
}


