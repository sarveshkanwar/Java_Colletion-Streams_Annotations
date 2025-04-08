package week4_assignment6.Annotations.Level3.Problem2;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class ExpensiveService {
    private static final Map<Integer, Long> cache = new HashMap<>();

    @CacheResult
    public long fibonacci(int n) {
        System.out.println("Computing fibonacci(" + n + ")...");

        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public long cachedFibonacci(int n) throws Exception {
        Method method = this.getClass().getMethod("fibonacci", int.class);
        if (method.isAnnotationPresent(CacheResult.class)) {
            if (cache.containsKey(n)) {
                System.out.println("Returning cached result for: " + n);
                return cache.get(n);
            } else {
                long result = fibonacci(n);
                cache.put(n, result);
                return result;
            }
        } else {
            return fibonacci(n);
        }
    }
}


public class CacheSystem {
    public static void main(String[] args) throws Exception {
        ExpensiveService service = new ExpensiveService();

        System.out.println("Result 1: " + service.cachedFibonacci(30));
        System.out.println("------------------------------");
        System.out.println("Result 2: " + service.cachedFibonacci(30)); // Should use cache
        System.out.println("------------------------------");
        System.out.println("Result 3: " + service.cachedFibonacci(28)); // New computation
    }
}
