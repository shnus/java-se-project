import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Nusrat on 2/11/2017.
 */
@Path("/login")
public class MyJersey {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        return "Hello from Jersey";
    }
}