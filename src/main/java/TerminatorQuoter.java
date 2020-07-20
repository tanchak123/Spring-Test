import javax.annotation.PostConstruct;
import test.InjectRandomInxt;
import test.Profiling;

@Profiling
public class TerminatorQuoter implements Quoter {
    @InjectRandomInxt(min = 2, max = 10)
    private int repeat;
    private String message;

    public TerminatorQuoter() {
        System.out.println(repeat);
        System.out.println(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void initMethod() {
        System.out.println("Ya init method");
    }

    @Override
    @PostConstruct
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }

    public void destroyMethod() {
        System.out.println("Ya destroy method");
    }
}
