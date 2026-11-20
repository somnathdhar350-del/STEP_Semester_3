
import java.time.LocalDate;
import java.util.*;

abstract class SubscriptionPlan {
    protected String subscriberName;
    protected LocalDate startDate;

    public SubscriptionPlan(String subscriberName, LocalDate startDate) {
        this.subscriberName = subscriberName;
        this.startDate = startDate;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<SubscriptionPlan> plans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());
            switch (type) {
                case "BASIC":
                    plans.add(new BasicPlan(name, startDate));
                    break;
                case "STANDARD":
                    plans.add(new StandardPlan(name, startDate));
                    break;
                case "PREMIUM":
                    plans.add(new PremiumPlan(name, startDate));
                    break;
            }
        }

        for (SubscriptionPlan plan : plans) {
            System.out.println(plan.getSubscriberName() + ": " + plan.calculateRenewalDate());
        }
        sc.close();
    }
}