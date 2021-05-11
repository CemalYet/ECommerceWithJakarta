package ejb;


import jakarta.ejb.Lock;
import jakarta.ejb.LockType;
import jakarta.ejb.Singleton;


@Singleton
public class GetHits {
    private int hits;

    @Lock(LockType.WRITE)
    public int getHits() {
        return hits++;
    }
}
