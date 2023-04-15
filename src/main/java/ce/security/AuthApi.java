package ce.security;

import ce.config.OtherConfig;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@CrossOrigin("*")
@RestController
public class AuthApi {

  private OtherConfig other;

  @GetMapping("/api/v1/public/")
  public String getPublic() {
    return "public pong";
  }

  @GetMapping("/api/v1/private/")
  public String getPrivate() {
    val others = other.getSecret1() + other.getSecret2();
    return "private pong (" + others + ")";
  }
}
