package ce.security;

public class UnauthorizedException extends RuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = 6097891314058648947L;

  public UnauthorizedException() {
    super("Unauthorized.");
  }
}
