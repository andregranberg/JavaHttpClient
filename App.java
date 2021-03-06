import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class App
{
  public static void main( String[] args ) throws Exception
  {
    HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://alpha-vantage.p.rapidapi.com/query?function=GLOBAL_QUOTE&symbol=TSLA"))
		.header("x-rapidapi-key", "key_goes_here")
		.header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());
  }
}
